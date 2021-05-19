package servicelocator2;
import common.LocatorError;

public interface Factory<T> {
    T create(ServiceLocator s1) throws LocatorError;
}
