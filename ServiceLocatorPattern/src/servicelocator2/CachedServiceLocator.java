package servicelocator2;
import common.LocatorError;

import java.util.HashMap;

public class CachedServiceLocator implements ServiceLocator {

    HashMap<Class<?>, Factory<?>> dictionary = new HashMap<>();
    HashMap<Class<?>, Object> dictionary_cnt = new HashMap<>();

    @Override
    public <T> void setService(Class<T> klass, Factory<T> factory) throws LocatorError {
        if (!dictionary.containsKey(klass) && !dictionary_cnt.containsKey(klass)) {
            dictionary.put(klass, factory);
            dictionary_cnt.put(klass, null);

        } else {
            throw new LocatorError("A constant is registered to '" + klass.getName() + "'");
        }

    }

    @Override
    public <T> void setConstant(Class<T> klass, T value) throws LocatorError {
        if (!dictionary.containsKey(klass) && !dictionary_cnt.containsKey(klass)) {
            dictionary.put(klass, null);
            dictionary_cnt.put(klass, value);
            //System.err.println("Added implemntatiom with name="+name);
        } else {
            throw new LocatorError("ALready Factory registered to '" + klass.getName() + "'");
        }

    }

    @Override
    public <T> Object getObject(Class<T> klass) throws LocatorError {
        return null;
    }

}