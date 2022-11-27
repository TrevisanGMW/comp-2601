package ca.bcit.comp2601.lab10;

/**
 * Concrete command to turn off music
 */
public class MusicOffCommand implements Command{
    /**
     * Override execute to turn off music
     */
    @Override
    public void execute() {
        System.out.println("Music is now OFF");
        System.out.println("Volume Set to 0");
    }
}