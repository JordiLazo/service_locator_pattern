package servicelocator;

import implementations.ImplementationB1;
import interfaces.InterfaceB;
import interfaces.InterfaceD;

public class FactoryB1 implements Factory{
    @Override
    public InterfaceB create(ServiceLocator s1) throws LocatorError {
        try{
            InterfaceD d = (InterfaceD) s1.getObject("D");
            return new ImplementationB1(d);
        }catch (ClassCastException ex){
            throw new LocatorError(ex);
        }
    }
}
