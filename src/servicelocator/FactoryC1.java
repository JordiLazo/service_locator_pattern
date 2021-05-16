package servicelocator;
import implementations.ImplementationC1;
import interfaces.InterfaceC;

public class FactoryC1 implements Factory{
    @Override
    public InterfaceC create(ServiceLocator s1) throws LocatorError {
        try{
            String s = (String) s1.getObject("C");
            return new ImplementationC1(s);
        }catch (ClassCastException ex){
            throw new LocatorError(ex.getMessage()+"____");
        }
    }
}
