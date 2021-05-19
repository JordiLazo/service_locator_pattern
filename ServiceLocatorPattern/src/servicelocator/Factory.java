package servicelocator;

import common.LocatorError;

public interface Factory {
    Object create(ServiceLocator s1) throws LocatorError;
}
