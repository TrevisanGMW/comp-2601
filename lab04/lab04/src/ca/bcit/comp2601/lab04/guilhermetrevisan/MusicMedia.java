package ca.bcit.comp2601.lab04.guilhermetrevisan;

/**
 * o	An abstract class with fields for song title and artist.
 * o	Constructor that takes parameters to set both fields. Parameters must be validated appropriately before
 *      they are assigned to the fields. If either parameter is invalid throw an IllegalArgumentException and do
 *      nothing else (let the program terminate).
 * o	Getter and setter for each field
 * o	toString() to display the field values
 * o	Abstract method void play()
 *
 *  @author  Guilherme Trevisan
 *  @version 0.0.1
 *  @since   2022-09-16
 */
public abstract class MusicMedia {

    private String title;
    private String artist;

    /**
     * Music Media Constructor
     * @param title title of the media (cannot be empty or null)
     * @param artist artist who created the media (cannot be empty or null)
     */
    public MusicMedia(final String title, final String artist) {
        this.title = validateAudioString(title);
        this.artist = validateAudioString(artist);
    }

    /**
     * String must not be null nor blank;
     * @param inputString string to check (first or last)
     * @return true if it's valid
     * @throws IllegalArgumentException when provided a string or provided a blank one
     */
    private static String validateAudioString(String inputString) {
        if(inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException("Invalid name. It cannot be null or empty.");
        }
        else {
            return inputString;
        }
    }

    /**
     * Abstract method void play()
     */
    public abstract void play();

    // Getters and Setters
    /**
     * Getter title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter artist
     * @return artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Setter artist
     * @param artist artist
     */
    public void setArtist(String artist) {
        this.artist = validateAudioString(artist);
    }

    /**
     * Setter title
     * @param title title
     */
    public void setTitle(String title) {
        this.title = validateAudioString(title);
    }
}
