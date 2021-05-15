package servicelocator;

public class SimpleServiceLocator implements ServiceLocator{
    @Override
    public void setService(String name, Factory factory) throws LocatorError {
        //almacenar factory
    }

    @Override
    public void setConstant(String name, Object vaue) throws LocatorError {

    }

    @Override
    public Object getObject(String name) throws LocatorError {
        return null;
        //mirar si es constante o servicio
        //return
    }
}
