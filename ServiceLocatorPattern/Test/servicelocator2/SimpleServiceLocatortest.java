package servicelocator2;

import common.LocatorError;
import mocks.A.FactoryA1v2;
import org.junit.jupiter.api.BeforeEach;
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

}