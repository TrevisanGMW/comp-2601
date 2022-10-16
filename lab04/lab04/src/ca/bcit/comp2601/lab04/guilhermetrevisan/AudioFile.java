package ca.bcit.comp2601.lab04.guilhermetrevisan;

/**
 * AudioFile Class
 * @author  Guilherme Trevisan
 * @version 0.0.1
 * @since   2022-09-16
 */
public class AudioFile extends MusicMedia implements FileManager {

    private final int sizeBitRatePerSecond;
    private String fileName;
    private static final int MIN_BIT_RATE_PER_SECOND;
    private static final String READING_METHOD;

    static{
        MIN_BIT_RATE_PER_SECOND = 1;
        READING_METHOD = "decode";
    }
    
    /**
     * Audio File Constructor
     * @param fileName name of the file
     * @param sizeBitRatePerSecond size of the file bps
     * @param title song title
     * @param artist artist name
     */
    public AudioFile(final String title,
                     final String artist,
                     final String fileName,
                     final int sizeBitRatePerSecond) {
        super(title, artist, READING_METHOD);
        this.fileName = validateFileNameString(fileName);
        this.sizeBitRatePerSecond = validateSizeBitRatePerSecond(sizeBitRatePerSecond);
    }

    /**
     * String must not be null nor blank;
     * @param inputString string to check
     * @return true if it's valid (not null or blank)
     * @throws IllegalArgumentException when provided a string or provided a blank one
     */
    private static String validateFileNameString(String inputString) {
        if(inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException("Invalid name. It cannot be null or empty.");
        }
        else {
            return inputString;
        }
    }

    /**
     * Validates sizeBitRatePerSecond (must be more or equal to MIN_BIT_RATE_PER_SECOND)
     * @param sizeBitRatePerSecond sizeBitRatePerSecond
     * @return sizeBitRatePerSecond if valid
     * @throws IllegalArgumentException if invalid bit rate was provided (less than MIN_BIT_RATE_PER_SECOND)
     */
    private static int validateSizeBitRatePerSecond(final int sizeBitRatePerSecond){
        if (sizeBitRatePerSecond >= MIN_BIT_RATE_PER_SECOND){
            return sizeBitRatePerSecond;
        } else {
            throw new IllegalArgumentException("Invalid sizeBitRatePerSecond. Must be more than " +
                                                MIN_BIT_RATE_PER_SECOND);
        }
    }

    /**
     * Displays (System.out) message saying that the provided audio file is playing
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
        return this.getArtist() + " - " + this.getTitle() + " (File Name: \"" + fileName + "\")";
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
     * Setter fileName
     * @param fileName fileName
     */
    public void setFileName(String fileName) {
        this.fileName = validateFileNameString(fileName);
    }

    /**
     * Display message about this object playing
     */
    @Override
    public void play() {
        System.out.println("Playing: " + this.getTitle() + " by " + this.getArtist());
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
