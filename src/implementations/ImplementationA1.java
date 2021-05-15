package implementations;
import interfaces.*;

public class ImplementationA1 implements InterfaceA {
    private InterfaceB b;
    private InterfaceC c;
    public ImplementationA1(InterfaceB b, InterfaceC c){
        this.b = b;
        this.c = c;
    }
}
