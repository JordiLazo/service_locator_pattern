package servicelocator2;

import common.LocatorError;

import java.util.HashMap;

public class SimpleServiceLocator implements ServiceLocator{
    public static SimpleServiceLocator INSTANCE;
    public final HashMap<Class<?>, Object[]> dictionary;

    public SimpleServiceLocator(){
        this.dictionary = new HashMap<>();
    }

    public static SimpleServiceLocator getInstance() {
        if (INSTANCE == null){
            return new SimpleServiceLocator();
        }
        return INSTANCE;
    }

    @Override
    public <T> void setService(Class<T> klass, Factory<T> factory) throws LocatorError {
        if (!dictionary.containsKey(klass)){
            dictionary.put(klass,new Object[]{factory,null});
        }else {
            throw new LocatorError("A constant is registered to '"+klass+"'");
        }
    }

    @Override
    public <T> void setConstant(Class<T> klass, T value) throws LocatorError {
        if (!dictionary.containsKey(klass)) {
            dictionary.put(klass,new Object[]{null,value});
        }else{
            throw new LocatorError("ALready Factory registered to '"+klass+"'");
        }
    }

    @Override
    public <T> Object getObject(Class<T> klass) throws LocatorError {
        if (dictionary.containsKey(klass)) {
            Object[] elements = dictionary.get(klass);
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
