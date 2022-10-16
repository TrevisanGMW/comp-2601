package ca.bcit.comp2601.lab04.guilhermetrevisan;

/**
 *  Music Media Abstract Class
 *  @author  Guilherme Trevisan
 *  @version 0.0.1
 *  @since   2022-09-16
 */
public abstract class MusicMedia {

    private String title;
    private String artist;
    private final String readingMethod;
    private static final String DEFAULT_READING_METHOD;
    private static final String DEFAULT_TITLE;
    private static final String DEFAULT_ARTIST;

    static {
        DEFAULT_READING_METHOD = "unknown";
        DEFAULT_TITLE = "Unknown";
        DEFAULT_ARTIST = "Unknown";
    }

    {
        this.title = DEFAULT_TITLE;
        this.artist = DEFAULT_ARTIST;
    }

    /**
     * Empty Music Media Constructor
     */
    public MusicMedia() {
        this.readingMethod = DEFAULT_READING_METHOD;
    }

    /**
     * Music Media Constructor
     * @param title title of the media (cannot be empty or null)
     * @param artist artist who created the media (cannot be empty or null)
     */
    public MusicMedia(final String title, final String artist) {
        this.title = validateAudioString(title);
        this.artist = validateAudioString(artist);
        this.readingMethod = DEFAULT_READING_METHOD;
    }

    /**
     * Music Media Constructor with readingMethod
     * @param title title of the media (cannot be empty or null)
     * @param artist artist who created the media (cannot be empty or null)
     */
    public MusicMedia(final String title, final String artist, final String readingMethod) {
        this.title = validateAudioString(title);
        this.artist = validateAudioString(artist);
        this.readingMethod = validateAudioString(readingMethod);
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

    /**
     * Override toString
     * @return title and artist info
     */
    @Override
    public String toString() {
        return title + " - " + artist;
    }

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

    /**
     * Getter readingMethod
     * @return readingMethod
     */
    public String getReadingMethod() {
        return readingMethod;
    }
}