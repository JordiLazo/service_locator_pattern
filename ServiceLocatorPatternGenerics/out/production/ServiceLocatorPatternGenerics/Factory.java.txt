package servicelocator2;
import servicelocator.ServiceLocator;

public interface Factory<T> {
    T create(ServiceLocator s1) throws LocatorError;
}
