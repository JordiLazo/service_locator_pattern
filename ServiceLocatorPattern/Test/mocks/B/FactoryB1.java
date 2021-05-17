package mocks.B;

import mocks.D.InterfaceD;
import servicelocator.Factory;
import servicelocator.ServiceLocator;
import servicelocator.LocatorError;

public class FactoryB1 implements Factory {
    ImplementationB1 implementationB1;
    @Override
    public InterfaceB create(ServiceLocator s1) throws LocatorError {
        try{
            InterfaceD d = (InterfaceD) s1.getObject("D");
            this.implementationB1=new ImplementationB1(d);
            return this.implementationB1;
        }catch (ClassCastException ex){
            throw new LocatorError(ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return "FactoryB1{\n" +
                implementationB1.toString() +
                "}";
    }
}
