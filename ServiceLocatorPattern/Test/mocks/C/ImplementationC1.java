package mocks.C;

import java.util.Objects;

public class ImplementationC1 implements InterfaceC {
    final String s;

    public ImplementationC1(String s) {
        this.s = s;
    }

    @Override
    public String getString() {
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImplementationC1)) return false;
        ImplementationC1 that = (ImplementationC1) o;
        return Objects.equals(s, that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }

    @Override
    public String toString() {
        return "ImplementationC1{" +
                "s='" + s + '\'' +
                '}';
    }
}
