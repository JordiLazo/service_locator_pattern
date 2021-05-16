package servicelocator;

import implementations.ImplementationD1;
import interfaces.Factory;
import interfaces.InterfaceD;
import interfaces.ServiceLocator;

public class FactoryD1 implements Factory {
    ImplementationD1 implementationD1;
    @Override
    public InterfaceD create(ServiceLocator s1) throws LocatorError {
        try {
            //Integer i = (Integer) s1.getObject("D");
            this.implementationD1 =new ImplementationD1(12);
            return this.implementationD1;
        }catch (ClassCastException ex){
            throw new LocatorError(ex.getMessage());
        }
    }
    @Override
    public String toString() {
        return "FactoryA1{\n" +
                implementationD1.toString() +
                "}";
    }
}
