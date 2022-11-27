package ca.bcit.comp2601.lab10;

import java.util.HashMap;
import java.util.Map;

/**
 * Invoker class, which holds command object and invokes method
 */
public class Menu {
    private Map menuItems;

    /**
     * Default Constructor, initializes the menuItem map
     */
    public Menu(){
        menuItems = new HashMap();
    }

    /**
     * Populates menuItems with desired commands
     * @param operation command trigger name
     * @param cmd command to execute
     */
    public void setCommand(String operation, Command cmd){
        menuItems.put(operation, cmd);
    }

    /**
     * Executes a command from the menuItems
     * @param operation name of the operation to execute
     */
    public void runCommand(String operation){
        Command c;
        c = (Command) menuItems.get(operation);
        c.execute();
    }
}
