package mocks.A;

import mocks.B.InterfaceB;
import mocks.C.InterfaceC;

import java.util.Objects;

public class ImplementationA1 implements InterfaceA{
    final InterfaceB b;
    final InterfaceC c;

    public ImplementationA1(InterfaceB b, InterfaceC c) {
        this.b = b;
        this.c = c;
    }

    @Override
    public InterfaceB getInterfaceB() {
        return b;
    }

    @Override
    public InterfaceC getInterfaceC() {
        return c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImplementationA1)) return false;
        ImplementationA1 that = (ImplementationA1) o;
        return Objects.equals(b, that.b) &&
                Objects.equals(c, that.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(b, c);
    }

    @Override
    public String toString() {
        return "ImplementationA1{" +
                "b=" + b +
                ", c=" + c +
                '}';
    }
}