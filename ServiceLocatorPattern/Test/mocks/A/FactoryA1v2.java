package mocks.A;
import common.LocatorError;
import mocks.B.InterfaceB;
import mocks.C.InterfaceC;
import servicelocator2.Factory;
import servicelocator2.ServiceLocator;

public class FactoryA1v2 implements Factory {
    @Override
    public InterfaceA create(ServiceLocator sl) throws LocatorError {
        InterfaceB b = (InterfaceB) sl.getObject(InterfaceB.class);
        InterfaceC c = (InterfaceC) sl.getObject(InterfaceC.class);
        return new ImplementationA1(b, c);
    }
}
