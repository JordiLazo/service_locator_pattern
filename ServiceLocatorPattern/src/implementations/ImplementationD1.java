package implementations;
import interfaces.*;

public class ImplementationD1 implements InterfaceD {
    private int i;
    public ImplementationD1(int i){
        this.i = i;
    }

    @Override
    public String toString() {
        return "ImplementationD1{" +
                "i=" + i +
                '}';
    }
}