package servicelocator;

public interface ServiceLocator {
    //almacena las implementaciones A1,B1,C1,D1 (borrar)
    void setService(String name, Factory factory) throws LocatorError;
    void setConstant(String name, Object vaue) throws LocatorError;
    Object getObject(String name) throws LocatorError;
}
