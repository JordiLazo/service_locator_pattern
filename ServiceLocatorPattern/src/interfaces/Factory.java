package interfaces;

import servicelocator.LocatorError;

public interface Factory {
    Object create(ServiceLocator s1) throws LocatorError;
}
