package ca.bcit.comp2601.lab10;

/*
 * Concrete command to serve hamburgers
 */
public class HamburgerCommand implements Command{
    /**
     * Override execute to account for hamburgers only
     */
    @Override
    public void execute() {
        System.out.println("A hamburger is served!");
    }
}