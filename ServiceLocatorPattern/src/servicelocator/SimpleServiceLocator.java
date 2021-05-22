package servicelocator;

import common.LocatorError;

import java.util.HashMap;

public class SimpleServiceLocator implements ServiceLocator{

    public static SimpleServiceLocator INSTANCE;
    public final HashMap<String,Object[]> dictionary;

    public SimpleServiceLocator(){
        this.dictionary=new HashMap<>();
    }

    public static SimpleServiceLocator getInstance() {
        if (INSTANCE == null){
            return new SimpleServiceLocator();
        }
        return INSTANCE;
    }

    @Override
    public void setService(String name, Factory factory) throws LocatorError {
        if (!dictionary.containsKey(name)){
            dictionary.put(name,new Object[]{factory,null});
        }else {
            throw new LocatorError("Already Factory registered to '"+name+"'");
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
                return factory.create(this);
            }
        }else{
            throw new LocatorError("Can't get");
        }
    }

}
