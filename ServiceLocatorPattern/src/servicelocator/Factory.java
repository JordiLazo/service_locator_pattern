package servicelocator;

import common.LocatorError;

import java.util.HashMap;

public interface Factory {
    Object create(ServiceLocator s1) throws LocatorError;
}
