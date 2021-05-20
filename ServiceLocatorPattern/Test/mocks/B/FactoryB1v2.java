package mocks.B;

import common.LocatorError;
import mocks.D.InterfaceD;
import servicelocator2.Factory;
import servicelocator2.ServiceLocator;

public class FactoryB1v2  implements Factory {
    @Override
    public InterfaceB create(ServiceLocator sl) throws LocatorError {
        InterfaceD d = (InterfaceD) sl.getObject(InterfaceD.class);
        return new ImplementationB1(d);
    }
}
