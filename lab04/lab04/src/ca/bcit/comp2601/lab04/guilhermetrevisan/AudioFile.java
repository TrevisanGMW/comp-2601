package ca.bcit.comp2601.lab04.guilhermetrevisan;

/**
 * o	Fields for the file name and the file size in bytes per second (eg. 320 bps)
 * o	Constructor with parameters for title, artist, filename, file size. File name and file size must be validated
 *      appropriately and an IllegalArgumentException will be thrown if the values are bad.
 * o	Getters, setters toString
 * o	play() method will display a simple message indicating that the file is being played.
 * o	Implements FileManager -  methods need only output a simple message to the console.
 *
 *  @author  Guilherme Trevisan
 *  @version 0.0.1
 *  @since   2022-09-16
 */
public class AudioFile implements FileManager {

    private final int sizeBitRatePerSecond;
    private String fileName;
    private String title;
    private String artist;

    /**
     * Audio File Constructor
     * @param fileName name of the file
     * @param sizeBitRatePerSecond size of the file bps
     * @param title song title
     * @param artist artist name
     */
    public AudioFile(final String fileName,
                     final int sizeBitRatePerSecond,
                     final String title,
                     final String artist) {
        this.fileName = validateAudioString(fileName);
        this.sizeBitRatePerSecond = sizeBitRatePerSecond;
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
     * Displays (sout) message saying that the provided audio file is playing
     * @param audioFile audioFile
     */
    public static void play(final AudioFile audioFile) {
        System.out.println("Now playing: " + audioFile.toString());
    }

    /**
     * Override toString to return "Artist - Title"
     * @return string following this pattern "Artist - Title"
     */
    @Override
    public String toString() {
        return artist + " - " + title;
    }

    // Getters and Setters

    /**
     * Getter fileName
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Getter sizeBitRatePerSecond
     * @return sizeBitRatePerSecond
     */
    public int getSizeBitRatePerSecond() {
        return sizeBitRatePerSecond;
    }

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
     * Setter Title
     * @param title title
     */
    public void setTitle(String title) {
        this.title = validateAudioString(title);
    }

    /**
     * Setter artist
     * @param artist artist
     */
    public void setArtist(String artist) {
        this.artist = validateAudioString(artist);
    }

    /**
     * Setter fileName
     * @param fileName fileName
     */
    public void setFileName(String fileName) {
        this.fileName = validateAudioString(fileName);
    }

    // File manager implementation
    /**
     * Saves audio file
     * @param fileName fileName
     */
    @Override
    public void save(String fileName) {
        System.out.println("Saving: " + fileName);
    }

    /**
     * Deletes audio file
     * @param fileName fileName
     */
    @Override
    public void delete(String fileName) {
        System.out.println("Deleting: " + fileName);
    }
}
