package servicelocator2;

import common.LocatorError;
import mocks.A.FactoryA1v2;
import mocks.B.FactoryB1v2;
import mocks.B.ImplementationB1;
import mocks.B.InterfaceB;
import mocks.C.ImplementationC1;
import mocks.C.InterfaceC;
import mocks.D.FactoryD1v2;
import mocks.D.ImplementationD1;
import mocks.D.InterfaceD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CachedServiceLocatortest {

    CachedServiceLocator csl;

    @BeforeEach
    void setUp() {
        csl = new CachedServiceLocator();
    }


    //Check throws LocatorError when we use setService()
    @Test
    void setServiceTestLocatorError() {

        assertThrows(LocatorError.class, () -> {
            csl.setService(String.class, new FactoryA1v2());
            csl.setService(String.class, new FactoryA1v2());
        });
    }

    //Check throws LocatorError when we use setConstant()
    @Test
    <T> void setConstantLocatorError() {
        T o = (T) "Obj";
        T o1 = (T) "Obj1";

        assertThrows(LocatorError.class, () -> {
            csl.setConstant(Object.class, o);
            csl.setConstant(Object.class, o1);
        });
    }
}