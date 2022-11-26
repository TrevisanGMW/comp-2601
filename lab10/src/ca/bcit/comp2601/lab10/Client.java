package ca.bcit.comp2601.lab10;


/**
 * Java program to implement Command design pattern with example.
 *
 * @author Guilherme Trevisan
 */
public class Client {

    public static void main(String args[]) {

        // Client creates Invoker object, command object and configure them
        Waiter waiter = new Waiter();
        waiter.setCommand("Hamburger", new HamburgerCommand());
        waiter.setCommand("HotDog", new HotDogCommand());

        //Invoker invokes command
        waiter.runCommand("Hamburger");
        waiter.runCommand("HotDog");
    }


}
