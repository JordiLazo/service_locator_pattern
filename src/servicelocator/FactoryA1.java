package servicelocator;
import implementations.ImplementationA1;
import interfaces.*;

public class FactoryA1 implements Factory{
    @Override
    public InterfaceA create (ServiceLocator s1) throws LocatorError{
        try{
            InterfaceB b = (InterfaceB) s1.getObject("B");
            InterfaceC c = (InterfaceC) s1.getObject("C");
            return new ImplementationA1(b,c);
        }catch (ClassCastException ex){
            throw new LocatorError(ex);
        }
    }
}
