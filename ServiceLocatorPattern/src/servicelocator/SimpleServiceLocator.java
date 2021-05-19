package servicelocator;

import common.LocatorError;

public class SimpleServiceLocator implements ServiceLocator {
    @Override
    public void setService(String name, Factory factory) throws LocatorError {
        //almacenar factory
    }

    @Override
    public void setConstant(String name, Object vaue) throws LocatorError {

    }

    @Override
    public Object getObject(String name) throws LocatorError {
        /*if (factoriesMap.containsKey(name)){
            Object[] s = factoriesMap.get(name);
            //Factory factory = (Factory) s[0];
            Object Constant = s[1];
            if (Constant == null) {
                Factory factory = (Factory) s[0];
                return factory.create(this);
            }else{
                return Constant;
            }
        }else {
            throw new LocatorError("error setConstant jaja ");
        }*/
        return null;
    }
}
