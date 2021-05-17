package mocks.B;

import mocks.D.InterfaceD;

import java.util.Objects;

public class ImplementationB1 implements InterfaceB {
    final InterfaceD d;
    public ImplementationB1(InterfaceD d) {
        this.d = d;
    }

    @Override
    public InterfaceD getInterfaceD() {
        return d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImplementationB1)) return false;
        ImplementationB1 that = (ImplementationB1) o;
        return Objects.equals(d, that.d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(d);
    }

    @Override
    public String toString() {
        return "ImplementationB1{" +
                "d=" + d +
                '}';
    }
}
