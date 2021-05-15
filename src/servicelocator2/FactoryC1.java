package servicelocator2;

import implementations.ImplementationC1;
import interfaces.InterfaceC;

public abstract class FactoryC1 implements Factory<InterfaceC> {
    public InterfaceC create(ServiceLocator s1) throws LocatorError {
        InterfaceC i = s1.getObject(InterfaceC.class);
        String x = "J";
        return new ImplementationC1(x);
    }
}