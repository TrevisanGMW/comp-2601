package ca.bcit.comp2601.lab10;

/**
 * Concrete command to turn on a light
 */
public class LightOnCommand implements Command{
    /**
     * Override execute to turn on the light
     */
    @Override
    public void execute() {
        System.out.println("Light is now ON");
    }
}