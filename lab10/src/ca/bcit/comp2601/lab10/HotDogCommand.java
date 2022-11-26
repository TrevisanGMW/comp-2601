package ca.bcit.comp2601.lab10;

/*
 * Concrete command to serve hot dogs
 */
public class HotDogCommand implements Command{
    /**
     * Override execute to account for hot dogs only
     */
    @Override
    public void execute() {
        System.out.println("A hot dog is served!");
    }
}