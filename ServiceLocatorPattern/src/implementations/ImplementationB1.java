package implementations;
import interfaces.*;

public class ImplementationB1 implements InterfaceB {
    private InterfaceD d;
    public ImplementationB1(InterfaceD d){
        this.d= d;
    }

    @Override
    public String toString() {
        return "ImplementationB1{" +
                "d=" + d.toString() +
                '}';
    }
}
