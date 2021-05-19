package servicelocator2;
import common.LocatorError;
import servicelocator.ServiceLocator;

public interface Factory<T> {
    T create(ServiceLocator s1) throws LocatorError;
}
