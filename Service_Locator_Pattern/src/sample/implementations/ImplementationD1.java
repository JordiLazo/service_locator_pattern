package sample.implementations;
import sample.interfaces.*;

import java.util.Objects;

public class ImplementationD1 implements InterfaceD {
    private int i;
    public ImplementationD1(int i){
        this.i = i;
    }

    @Override
    public String toString() {
        return "-----ImplementationD1----\n" +
                "i=" + i +"\n"+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImplementationD1)) return false;
        ImplementationD1 that = (ImplementationD1) o;
        return i == that.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }
}
