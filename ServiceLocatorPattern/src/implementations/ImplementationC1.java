package implementations;
import interfaces.*;

public class ImplementationC1 implements InterfaceC {
    private String s;
    public ImplementationC1(String s){
        this.s = s;
    }

    @Override
    public String toString() {
        return "ImplementationD1{" +
                "s=" + s +
                '}';
    }
}
