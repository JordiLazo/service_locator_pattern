package servicelocator2;

import common.LocatorError;

public class SimpleServiceLocator implements ServiceLocator {

    @Override
    public <T> void setService(Class<T> klass, Factory<T> factory) throws LocatorError {

    }

    @Override
    public <T> void setConstant(Class<T> klass, T value) throws LocatorError {

    }

    @Override
    public <T> InterfaceD getObject(Class<T> klass) throws LocatorError {
        return null;
    }
}
