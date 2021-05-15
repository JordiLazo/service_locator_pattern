package servicelocator;

public class CachedServiceLocator implements ServiceLocator{
    @Override
    public void setService(String name, Factory factory) throws LocatorError {
        //almacenar factory.create (this)
    }

    @Override
    public void setConstant(String name, Object vaue) throws LocatorError {
        //almacenar el objeto
    }

    @Override
    public Object getObject(String name) throws LocatorError {
        return null;
    }
}
