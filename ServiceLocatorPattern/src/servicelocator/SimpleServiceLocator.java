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
            //System.err.println("Added Service with name="+name);
        }else {
            throw new LocatorError("ALready Factory registered to '"+name+"'");
        }
    }

    @Override
    public void setConstant(String name, Object value) throws LocatorError {
        if (!dictionary.containsKey(name)) {
            dictionary.put(name,new Object[]{null,value});
            //System.err.println("Added implemntatiom with name="+name);
        }else{
            throw new LocatorError("A constant is registered to '"+name+"'");
        }
    }

    @Override
    public Object getObject(String name) throws LocatorError {
        if (dictionary.containsKey(name)) {
            Object[] elements = dictionary.get(name);
            //0 -> factory
            //1-> Implemntation
            if (elements[1] != null) {
                //System.err.println("Returning cached implementation named: "+name);
                return elements[1];
            }else{
                //System.err.println("Not found an implementation named: "+name+" creating it");
                Factory factory = (Factory) elements[0];
                return factory.create(this);
            }
        }else{
            throw new LocatorError("Cant get");
        }
    }

}
