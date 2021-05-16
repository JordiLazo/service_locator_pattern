package servicelocator;

import implementations.ImplementationA1;

import java.util.HashMap;

public class CachedServiceLocator implements ServiceLocator{
    private static CachedServiceLocator INSTANCE=null;


    HashMap<String,Object[]> factoriesMap;




    /*main
    //  CSL a = CachedServiceLocator.getInstance() (i1)
    //  ...
    // ...
    //  a.setSertservice()
    //  CSL b = CachedServiceLocator.getInstance() (i1)
    //  b.setSertservice()

    //  b.setSertservice()
    //  b.setSertservice()

    //  a.getCount() ->4
    //  b.getCount() ->4*/
    private CachedServiceLocator(){
        this.factoriesMap = new HashMap<>();
    }

    public static CachedServiceLocator getInstance(){
        if (INSTANCE == null){
            return new CachedServiceLocator();
        }
        return INSTANCE;
    }

    @Override
    public void setService(String name, Factory factory) throws LocatorError {
        if (!factoriesMap.containsKey(name)){
            factoriesMap.put(name,new Object[]{factory.create(this),null});
        }else {
            throw new LocatorError("error setService jaja");
        }
    }

    @Override
    public void setConstant(String name, Object value) throws LocatorError {
        /*Object[] s = new Object[2];
        //s[0] =  factory;
        //s[1]= null;


        // --> "fact2",val2
        // --> "fact2",val3 --> LOCATE ERROR
        // {"fact1": [F123,null],
        //  "fact2": [F444,val2],
        //  }*/
        //almacenar el objeto
        if (factoriesMap.containsKey(name)){
            Object[] s = factoriesMap.get(name);
            //s[0] = factory;
            s[1]= value;
            factoriesMap.put(name,s);
        }else {
            throw new LocatorError("error setConstant jaja ");
        }
    }

    @Override
    public Object getObject(String name) throws LocatorError {
        // Nom-Factoria-constant=null--> Factoria.create
        // Nom Factoria-constant ---> constant

        if (factoriesMap.containsKey(name)){
            Object[] s = factoriesMap.get(name);
            //Factory factory = (Factory) s[0];
            Object Constant = s[1];
            if (Constant == null) {
                Object factory = s[0];
                return factory;
            }else{
                return Constant;
            }
        }else {
            throw new LocatorError("error setConstant jaja ");
        }
    }

    public static void main(String[] args) throws LocatorError {
        FactoryA1 ae= new FactoryA1();
        ServiceLocator sl = CachedServiceLocator.getInstance();
        sl.setService("A",new FactoryA1());
        sl.setService("B",new FactoryB1());
        sl.setService("C",new FactoryC1());
        sl.setService("D",new FactoryD1());
        ae.create(sl);
    }
}
