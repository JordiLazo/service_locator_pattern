package mocks.A;
import mocks.B.InterfaceB;
import mocks.C.InterfaceC;
import servicelocator.Factory;
import servicelocator.LocatorError;
import servicelocator.ServiceLocator;

public class FactoryA1 implements Factory {
    ImplementationA1 implementationA1;
    @Override
    public InterfaceA create (ServiceLocator s1) throws LocatorError {
        try{
            InterfaceB b = (InterfaceB) s1.getObject("B");
            InterfaceC c = (InterfaceC) s1.getObject("C");
            this.implementationA1 =new ImplementationA1(b,c);
            return this.implementationA1;
        }catch (ClassCastException ex){

            throw new LocatorError(ex.getMessage());

        }
    }
    @Override
    public String toString() {
        return "FactoryA1{\n" +
                implementationA1.toString() +
                "}";
    }
}
