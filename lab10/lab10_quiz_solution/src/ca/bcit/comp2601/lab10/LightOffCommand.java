package ca.bcit.comp2601.lab10;

/**
 * Concrete command to turn off a light
 */
public class LightOffCommand implements Command{
    /**
     * Override execute to turn off the light
     */
    @Override
    public void execute() {
        System.out.println("Light is now OFF");
    }
}