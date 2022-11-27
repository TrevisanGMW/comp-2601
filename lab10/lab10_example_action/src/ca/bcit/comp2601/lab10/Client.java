package ca.bcit.comp2601.lab10;

/**
 * Java program to implement simplified version of the "command" design pattern.
 */
public class Client {

    public static void main(String args[]) {

        // Client creates Invoker object, command object and configure them
        Menu menu = new Menu();
        menu.setCommand("Hamburger", new HamburgerCommand());
        menu.setCommand("HotDog", new HotDogCommand());

        //Invoker invokes command
        menu.runCommand("Hamburger");
        menu.runCommand("HotDog");
    }
}
