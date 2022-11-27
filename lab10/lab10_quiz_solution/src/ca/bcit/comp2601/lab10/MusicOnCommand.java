package ca.bcit.comp2601.lab10;

/**
 * Concrete command to turn on music
 */
public class MusicOnCommand implements Command{
    /**
     * Override execute to turn on music
     */
    @Override
    public void execute() {
        System.out.println("Music is now ON");
        System.out.println("Volume Set to 5");
    }
}