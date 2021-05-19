package servicelocator2;
import errors.*;
import java.util.HashMap;


public class CachedServiceLocator implements ServiceLocator {
    HashMap<Class<?>, Factory<?>> dictionary = new HashMap<>();
    HashMap<Class<?>, ?> dictionary_cnt = new HashMap<>();

    @Override
    public <T> void setService(Class<T> klass, Factory<T> factory) throws LocatorError {
        if (!dictionary.containsKey(klass) && !dictionary_cnt.containsKey(klass) ){
            dictionary.put(klass, factory);
            dictionary_cnt.put(klass,null);

        }else {
            throw new LocatorError("A constant is registered to '"+klass.getName()+"'");
        }

    }

    @Override
    public <T> void setConstant(Class<T> klass, T value) throws LocatorError {
        if (!dictionary.containsKey(klass) && !dictionary_cnt.containsKey(klass) ) {
            dictionary.put(klass, null);
            dictionary_cnt.put(klass,value);
            //System.err.println("Added implemntatiom with name="+name);
        }else{
            throw new LocatorError("ALready Factory registered to '"+klass.getName()+"'");
        }

    }

    @Override
    public <T> T getObject(Class<T> klass) throws LocatorError {
        return null;
    }


    /*
    private static CachedServiceLocator INSTANCE;
    public final HashMap<Class<?>,HashMap<Factory<?>,?> > dictionary;

    private CachedServiceLocator<T>(){
        this.dictionary = new HashMap<Factory<?>,T>();
    }

    public static <T> CachedServiceLocator getInstance() {
        if(INSTANCE==null){
            INSTANCE= new CachedServiceLocator();
        }
        return INSTANCE;
        return null;
    }

    @Override
    public <T> void setService(Class<T> klass, Factory<T> factory) throws LocatorError {
        if (!dictionary.containsKey(klass)){
            HashMap<Factory<?>,T> value = new HashMap<>();
            value.put(factory,null);
            dictionary.put(klass, value);
            //System.err.println("Added Service with name="+name);
        }else {
            throw new LocatorError("A constant is registered to '"+klass.getName()+"'");
        }

    }*/

    /*@Override
    public <T> void setConstant(Class<T> klass, T value) throws LocatorError {
        if (!dictionary.containsKey(klass)) {
            HashMap<Factory<?>,T> val = new HashMap<>();
            val.put(null,value);
            dictionary.put(klass,val);
            //System.err.println("Added implemntatiom with name="+name);
        }else{
            throw new LocatorError("ALready Factory registered to '"+klass.getName()+"'");
        }


    }


    @Override
    public <T> T getObject(Class<T> klass) throws LocatorError {
        if (dictionary.containsKey(klass)) {
            HashMap<Factory<?>, ?> elements= dictionary.get(klass);
            //{class : T }
            //0 -> factory
            //1-> Implemntation
            if (elements.get(klass) != null) {
                //System.err.println("Returning cached implementation named: "+name);
                return (T) elements.get(klass);
            }else{
                //System.err.println("Not found an implementation named: "+name+" creating it");
                servicelocator2.Factory factory = (servicelocator2.Factory) elements[0];
                elements[1] =factory.create(this);

                return elements[1];
            }
        }else{
            throw new LocatorError("Cant get");
        }
        return null;
    }

    public static void main(String[] args) {

    }*/
}
