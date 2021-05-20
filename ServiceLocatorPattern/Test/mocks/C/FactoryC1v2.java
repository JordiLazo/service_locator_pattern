package mocks.C;

import common.LocatorError;
import servicelocator2.Factory;
import servicelocator2.ServiceLocator;

public class FactoryC1v2 implements Factory {
    @Override
    public InterfaceC create(ServiceLocator sl) throws LocatorError {
        String s = String.valueOf(sl.getObject(String.class));
        return new ImplementationC1(s);
    }
}