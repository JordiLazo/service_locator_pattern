package servicelocator2;

import common.LocatorError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleServiceLocatortest {

    SimpleServiceLocator sl;
    @BeforeEach
    void setUp() {
        sl = new SimpleServiceLocator();
    }

    @Test
    void setService() {
    }

    @Test
    void setConstant() throws LocatorError {

    }

}