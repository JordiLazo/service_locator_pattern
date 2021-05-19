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
        if (!dictionary.containsKey(klass)) {
            throw new LocatorError("Key is not registered");
        } else {
            Object[] elements = dictionary.get(klass);;
            Factory factory = (Factory) elements[0];
            return factory.create(this);
        }
    }

    private void containsKey(boolean b) throws LocatorError {
        if (b) {
            throw new LocatorError("Key was already registered");
        }
    }



}
