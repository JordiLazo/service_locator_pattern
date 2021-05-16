package servicelocator2;
import implementations.ImplementationB1;
import interfaces.*;

public abstract class FactoryB1 implements Factory<InterfaceB>{
    public InterfaceB create(ServiceLocator s1) throws LocatorError {
        InterfaceD d = s1.getObject(InterfaceD.class);
        return new ImplementationB1(d);
    }
}
