package servicelocator2;
import errors.LocatorError;

public interface Factory<T> {
    T create(ServiceLocator s1) throws LocatorError;
}
