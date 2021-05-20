package servicelocator2;

import common.LocatorError;
import mocks.A.FactoryA1v2;
import mocks.B.FactoryB1v2;
import mocks.B.ImplementationB1;
import mocks.B.InterfaceB;
import mocks.C.FactoryC1v2;
import mocks.C.ImplementationC1;
import mocks.C.InterfaceC;
import mocks.D.FactoryD1v2;
import mocks.D.ImplementationD1;
import mocks.D.InterfaceD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    //FactoryB1v2
    @Test
    <T> void setServiceTestB1() throws LocatorError {

        csl.setConstant(InterfaceD.class, new ImplementationD1(20));
        csl.setService(FactoryB1v2.class, new FactoryB1v2());

        assertSame(csl.getObject(FactoryB1v2.class), csl.getObject(FactoryB1v2.class));

        T string = (T) "prova";
        Class constantClass = String.class;

        csl.setConstant(constantClass, string);
        csl.setService(FactoryC1v2.class, new FactoryC1v2());
        assertSame(csl.getObject(FactoryC1v2.class), csl.getObject(FactoryC1v2.class));

    }
    //FactoryC1v2
    @Test
    <T> void setServiceTestC1() throws LocatorError {

        T string = (T) "prova";
        Class constantClass = String.class;

        csl.setConstant(constantClass, string);
        csl.setService(FactoryC1v2.class, new FactoryC1v2());

        assertSame(csl.getObject(FactoryC1v2.class), csl.getObject(FactoryC1v2.class));

        Integer integer = 20;

        csl.setConstant(Integer.class, integer);
        csl.setService(FactoryD1v2.class, new FactoryD1v2());
        assertSame(csl.getObject(FactoryD1v2.class), csl.getObject(FactoryD1v2.class));

    }
}