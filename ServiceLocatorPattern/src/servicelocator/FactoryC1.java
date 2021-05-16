package servicelocator;
import implementations.ImplementationC1;
import implementations.ImplementationD1;
import interfaces.Factory;
import interfaces.InterfaceC;
import interfaces.ServiceLocator;

public class FactoryC1 implements Factory {
    ImplementationC1 implementationC1;
    @Override
    public InterfaceC create(ServiceLocator s1) throws LocatorError {
        try{
            //String s = (String) s1.getObject("C");
            this.implementationC1 = new ImplementationC1("FactoryC1");
            return this.implementationC1;
        }catch (ClassCastException ex){
            throw new LocatorError(ex.getMessage());
        }
    }
    @Override
    public String toString() {
        return "FactoryC1{\n" +
                implementationC1.toString() +
                "}";
    }
}
