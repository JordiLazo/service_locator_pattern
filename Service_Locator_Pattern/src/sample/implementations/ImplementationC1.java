package sample.implementations;
import sample.interfaces.*;

import java.util.Objects;

public class ImplementationC1 implements InterfaceC {
    private String s;
    public ImplementationC1(String s){
        this.s = s;
    }

    @Override
    public String toString() {
        return "-----ImplementationC1----\n" +
                "c=" + s +"\n"+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImplementationC1)) return false;
        ImplementationC1 that = (ImplementationC1) o;
        return s.equals(that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }
}
