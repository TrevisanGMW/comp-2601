package ca.bcit.comp2601.lab10;


/**
 * Simple Java program to implement Command design pattern.
 * Doesn't
 * @author Guilherme Trevisan
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
