package servicelocator2;
import implementations.ImplementationA1;
import interfaces.*;

public class FactoryA1_2 implements Factory<InterfaceA>{
    public InterfaceA create (ServiceLocator s1) throws LocatorError{
        InterfaceB b = s1.getObject(InterfaceB.class);
        InterfaceC c = s1.getObject(InterfaceC.class);
        return new ImplementationA1(b,c);
    }

    @Override
    public InterfaceA create(servicelocator.ServiceLocator s1) throws LocatorError {
        return null;
    }
}
