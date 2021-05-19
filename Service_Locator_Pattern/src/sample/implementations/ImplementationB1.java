package sample.implementations;
import sample.interfaces.*;

import java.util.Objects;

public class ImplementationB1 implements InterfaceB {
    private InterfaceD d;
    public ImplementationB1(InterfaceD d){
        this.d= d;
    }

    @Override
    public String toString() {
        return "-----ImplementationB1----\n" +
                "d=" + d.toString() +"\n"+
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImplementationB1)) return false;
        ImplementationB1 that = (ImplementationB1) o;
        return d.equals(that.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(d);
    }
}
