package sample.implementations;
import sample.interfaces.*;

import java.util.Objects;

public class ImplementationA1 implements InterfaceA {
    private InterfaceB b;
    private InterfaceC c;
    public ImplementationA1(InterfaceB b,InterfaceC c){
        this.b = b;
        this.c = c;
    }
    @Override
    public String toString() {
        return "-----ImplementationA2----\n" +
                "b=" + b.toString() +"\n"+
                "c=" + c.toString() +"\n"+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImplementationA1)) return false;
        ImplementationA1 that = (ImplementationA1) o;
        return b.equals(that.b) && c.equals(that.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(b, c);
    }
}
