package servicelocator;


import common.LocatorError;

import java.util.HashMap;

public class CachedServiceLocator implements ServiceLocator {

    public static CachedServiceLocator INSTANCE;
    public final HashMap<String,Object[]> dictionary;

    public CachedServiceLocator(){
        this.dictionary = new HashMap<>();
    }

    public static CachedServiceLocator getInstance(){
        if (INSTANCE == null){
            return new CachedServiceLocator();
        }
        return INSTANCE;
    }

    @Override
    public void setService(String name, Factory factory) throws LocatorError {
        if (!dictionary.containsKey(name)){
            dictionary.put(name,new Object[]{factory,null});
        }else {
            throw new LocatorError("ALready Factory registered to '"+name+"'");
        }
    }

    @Override
    public void setConstant(String name, Object value) throws LocatorError {
        if (!dictionary.containsKey(name)) {
            dictionary.put(name,new Object[]{null,value});
        }else{
            throw new LocatorError("A constant is registered to '"+name+"'");
        }
    }

    @Override
    public Object getObject(String name) throws LocatorError {
        if (dictionary.containsKey(name)) {
            Object[] elements = dictionary.get(name);
            if (elements[1] != null) {
                return elements[1];
            }else{
                Factory factory = (Factory) elements[0];
                elements[1] =factory.create(this);

                return elements[1];
            }
        }else{
            throw new LocatorError("Cant get");
        }
    }
}
