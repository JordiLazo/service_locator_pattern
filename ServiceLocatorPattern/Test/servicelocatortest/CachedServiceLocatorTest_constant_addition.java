package servicelocatortest;


import mocks.C.ImplementationC1;
import org.junit.jupiter.api.*;
import servicelocator.CachedServiceLocator;
import servicelocator.Factory;
import common.LocatorError;
import servicelocator.ServiceLocator;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


class CachedServiceLocatorTest_constant_addition {
    CachedServiceLocator sl;
    @BeforeEach
    void setUp() {
        sl = new CachedServiceLocator();
    }
    @Test
    void set_and_get_constants(){
        assertDoesNotThrow(()->sl.setConstant("C",new ImplementationC1("test")));
        assertTrue(()-> sl.dictionary.containsKey("C"));
        assertDoesNotThrow(()->sl.getObject("C"));
        assertFalse(()-> sl.dictionary.containsKey("F"));
        assertThrows(LocatorError.class,()-> sl.getObject("F"));
    }
    @Test
    void get_same_cached_instance() throws LocatorError {
        assertDoesNotThrow(()->sl.setService("C",new Factory1()));
        Implementation1 a = (Implementation1) sl.getObject("C");
        Implementation1 b = (Implementation1) sl.getObject("C");
        assertSame(a, sl.getObject("C"));
        assertSame(a,b);
        assertEquals(a, sl.getObject("C"));
    }


    private static class Factory1 implements Factory {
        public Factory1(){

        }
        @Override
        public Object create(ServiceLocator s1) throws LocatorError {
            return new Implementation1(10);
        }


    }
    private static class Implementation1 {
        public int num;
        public Implementation1(int i){
            this.num=i;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Implementation1)) return false;
            Implementation1 that = (Implementation1) o;
            return num == that.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num);
        }
    }

}