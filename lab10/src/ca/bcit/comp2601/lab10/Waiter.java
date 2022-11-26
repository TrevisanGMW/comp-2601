package ca.bcit.comp2601.lab10;

import java.util.HashMap;
import java.util.Map;

/*
 * Invoker class, which holds command object and invokes method
 */
public class Waiter {
    Map menuItems = new HashMap();

    public void setCommand(String operation, Command cmd){
        menuItems.put(operation, cmd);
    }

    public void runCommand(String operation){
//        menuItems.get(operation).execute();
        System.out.println(menuItems.get(operation));
    }

}