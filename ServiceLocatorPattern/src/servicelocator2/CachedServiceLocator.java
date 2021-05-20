package servicelocator2;
import common.LocatorError;

import java.util.HashMap;

public class CachedServiceLocator implements ServiceLocator {

    HashMap<Class<?>, Factory<?>> dictionary = new HashMap<>();
    HashMap<Class<?>, Object> dictionary_cnt = new HashMap<>();

    @Override
    public <T> void setService(Class<T> klass, Factory<T> factory) throws LocatorError {
        if (!dictionary.containsKey(klass))
            dictionary.put(klass, factory);
        else
            throw new LocatorError("Factory is already registered");
    }

    @Override
    public <T> void setConstant(Class<T> klass, T value) throws LocatorError {
        if (!dictionary_cnt.containsKey(klass))
            dictionary_cnt.put(klass, value);
        else
            throw new LocatorError("Constant is already registered");
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(Class<T> klass) throws LocatorError {
        if (dictionary_cnt.containsKey(klass))
            return (T) dictionary_cnt.get(klass);
        else if(dictionary.containsKey(klass)) {
            dictionary_cnt.put(klass, dictionary.get(klass).create(this));
            return (T) dictionary_cnt.get(klass);
        }else
            throw new LocatorError("Cant get");
    }

}