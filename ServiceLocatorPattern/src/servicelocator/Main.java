package servicelocator;

public class Main {
    public static void main(String[] args) throws LocatorError {

        CachedServiceLocator sl= CachedServiceLocator.getInstance();
        sl.setService("A",new FactoryA1());
        sl.setService("B",new FactoryB1());
        sl.setConstant("D",new ImplementationD1(22));
        sl.setConstant("C",new ImplementationC1("Hola"));
        FactoryA1 a1 = new FactoryA1();
        a1.create(sl);

        System.out.println("act:\n"+a1.toString());
    }
}
