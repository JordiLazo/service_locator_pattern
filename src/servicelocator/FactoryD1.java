package servicelocator;

import implementations.ImplementationD1;
import interfaces.InterfaceD;

public class FactoryD1 implements Factory{
    @Override
    public InterfaceD create(ServiceLocator s1) throws LocatorError {
        try {
            Integer i = (Integer) s1.getObject("D");
            return new ImplementationD1(i);
        }catch (ClassCastException ex){
            throw new LocatorError("____"+ex.getMessage()+"____");
        }
    }
}
