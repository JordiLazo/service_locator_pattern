package servicelocator;

public interface ServiceLocator {
    void setService(String name, Factory factory) throws LocatorError;
    void setConstant(String name, Object vaue) throws LocatorError;
    Object getObject(String name) throws LocatorError;
}
