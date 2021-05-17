package servicelocator;

import java.util.HashMap;

public class CachedServiceLocator implements ServiceLocator {
    private static CachedServiceLocator INSTANCE;
    private final HashMap<String,Object[]> dictionary;



    private CachedServiceLocator(){
        this.dictionary = new HashMap<>();
    }

    public static CachedServiceLocator getInstance(){
        if (INSTANCE == null){
            return new CachedServiceLocator();
        }
        return INSTANCE;
    }

    @Override
    public void setService(String name, Factory factory) throws LocatorError {
        if (!dictionary.containsKey(name)){
            dictionary.put(name,new Object[]{factory,null});
            System.err.println("Added Service with name="+name);
        }else {
            throw new LocatorError("A constant is registered to '"+name+"'");
        }
    }

    @Override
    public void setConstant(String name, Object value) throws LocatorError {
        if (!dictionary.containsKey(name)) {
            dictionary.put(name,new Object[]{null,value});
            System.err.println("Added implemntatiom with name="+name);
        }else{
            throw new LocatorError("ALready Factory registered to '"+name+"'");
        }
    }

    @Override
    public Object getObject(String name) throws LocatorError {
        // Nom-Factoria-constant=null--> Factoria.create
        // Nom Factoria-constant ---> constant

        if (dictionary.containsKey(name)) {
            Object[] elements = dictionary.get(name);
            //0 -> factory
            //1-> Implemntation
            if (elements[1] != null) {
                System.err.println("Returning cached implementation named: "+name);
                return elements[1];
            }else{
                System.err.println("Not found an implementation named: "+name+" creating it");
                Factory factory = (Factory) elements[0];
                elements[1] =factory.create(this);

                return elements[1];
            }
        }else{
            throw new LocatorError("Cant get");
        }
    }

}
