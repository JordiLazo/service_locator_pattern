package mocks.D;

import common.LocatorError;
import servicelocator2.Factory;
import servicelocator2.ServiceLocator;

public class FactorD1v2 implements Factory {
    @Override
    public InterfaceD create(ServiceLocator sl) throws LocatorError {
        int i = (int) sl.getObject(Integer.class);
        return new ImplementationD1(i);
    }
}
