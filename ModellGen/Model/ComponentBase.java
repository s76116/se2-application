
import java.util.*;

/**
 * 
 */
public class ComponentBase {

    /**
     * Default constructor
     */
    public ComponentBase() {
    }

    /**
     * 
     */
    private Properties configs;

    /**
     * @param view 
     * @return
     */
    public void inject(ComponentIntf.ViewIntf view) {
        // TODO implement here
        return null;
    }

    /**
     * @param logic 
     * @return
     */
    public void inject(ComponentIntf.LogicIntf logic) {
        // TODO implement here
        return null;
    }

    /**
     * @param component 
     * @param callOut 
     * @return
     */
    public void static viewintf(ComponentBase component, Callback<T> callOut) {
        // TODO implement here
        return null;
    }

    /**
     * @param component 
     * @param callOut 
     * @return
     */
    public void static logicIntf(ComponentBase component, Callback <T> callOut) {
        // TODO implement here
        return null;
    }

    /**
     * @param key 
     * @param value 
     * @return
     */
    public ComponentBase configure(String key, Object value) {
        // TODO implement here
        return null;
    }

    /**
     * @param key 
     * @return
     */
    public Object get(String key) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getName() {
        // TODO implement here
        return "";
    }

}