package servicelocator;

public interface Factory {
    Object create(ServiceLocator s1) throws LocatorError;
}
