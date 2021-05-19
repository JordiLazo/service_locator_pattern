package servicelocator2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicelocator.SimpleServiceLocator;

class SimpleServiceLocatortest {

    servicelocator.SimpleServiceLocator sl;
    @BeforeEach
    void setUp() {
        sl= new SimpleServiceLocator();
    }

    @Test
    void setService() {
    }

    @Test
    void setConstant() {
    }

    @Test
    void getObject() {
    }
}