package servicelocator2;

import common.LocatorError;
import mocks.A.FactoryA1v2;
import mocks.B.FactoryB1v2;
import mocks.B.ImplementationB1;
import mocks.B.InterfaceB;
import mocks.C.ImplementationC1;
import mocks.C.InterfaceC;
import mocks.D.ImplementationD1;
import mocks.D.InterfaceD;
import mocks.D.FactoryD1v2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unchecked")
class SimpleServiceLocatortest {

    SimpleServiceLocator ssl;

    @BeforeEach
    void setUp() {
        ssl = new SimpleServiceLocator();
    }


    //Check throws LocatorError when we use setService()
    @Test
    void setServiceTestLocatorError() {

        assertThrows(LocatorError.class, ()-> {
            ssl.setService(String.class, new FactoryA1v2());
            ssl.setService(String.class,new FactoryA1v2());
        });
    }

    //Check throws LocatorError when we use setConstant()
    @Test
    <T> void  setConstantLocatorError() {
        T o= (T) "Obj";
        T o1 = (T) "Obj1";

        assertThrows(LocatorError.class, ()-> {
            ssl.setConstant(Object.class, o);
            ssl.setConstant(Object.class, o1);
        });
    }

    //FactoryA1v2
    @Test
    <T> void setServiceTestFactoryA1v2() throws LocatorError {

        InterfaceD interfaceD = new ImplementationD1(3);
        InterfaceB interfaceB = new ImplementationB1(interfaceD);
        InterfaceC interfaceC = new ImplementationC1("prova");

        ssl.setConstant(InterfaceB.class, interfaceB);
        ssl.setConstant(InterfaceC.class, interfaceC);
        ssl.setService(FactoryA1v2.class, new FactoryA1v2());

        assertNotSame((T) ssl.getObject(FactoryA1v2.class), (T) ssl.getObject(FactoryA1v2.class));

        ssl.setConstant(InterfaceD.class, interfaceD);
        ssl.setService(FactoryB1v2.class, new FactoryB1v2());
        assertNotSame(ssl.getObject(FactoryB1v2.class), ssl.getObject(FactoryB1v2.class));
    }

    //FactoryD1v2
    @Test
    <T> void setServiceTestFactoryD1v2() throws LocatorError {
        Integer integer = 10;

        ssl.setService(FactoryD1v2.class, new FactoryD1v2());
        ssl.setConstant(Integer.class, integer);

        assertNotSame((T) ssl.getObject(FactoryD1v2.class), (T) ssl.getObject(FactoryD1v2.class));

        InterfaceD ID = new ImplementationD1(0);
        ssl.setConstant(InterfaceB.class, new ImplementationB1(ID));
        ssl.setConstant(InterfaceC.class, new ImplementationC1("prova"));
        ssl.setService(FactoryA1v2.class, new FactoryA1v2());

    }


}