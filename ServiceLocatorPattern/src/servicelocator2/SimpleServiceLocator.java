package servicelocator2;

import common.LocatorError;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class SimpleServiceLocator implements ServiceLocator {

    private Map<Class<?>, Factory<?>> factories;
    private Map<Class<?>, Object> constants;

    public SimpleServiceLocator(){
        factories = new HashMap<>();
        constants = new HashMap<>();
    }

    public <T> void setService(Class<T> klass, Factory<T> factory) throws LocatorError {
        if (!factories.containsKey(klass))
            factories.put(klass, factory);
        else
            throw new LocatorError("Factory is already registered");
    }

    public <T> void setConstant(Class<T> klass, T value) throws LocatorError {
        if (!constants.containsKey(klass))
            constants.put(klass, value);
        else
            throw new LocatorError("Constant is already registered");
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(Class<T> klass) throws LocatorError {
        if (factories.containsKey(klass) && constants.containsKey(klass))
            throw new LocatorError("Factory and constant are already registered");
        if (constants.containsKey(klass))
            return (T) constants.get(klass);
        else if (factories.containsKey(klass))
            return (T) factories.get(klass).create(this);
        else
            throw new LocatorError("Cant get");
    }

}
