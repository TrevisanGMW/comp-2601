package ca.bcit.comp2601.lab04.guilhermetrevisan;

/**
 * CompactDisc Class
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since   2022-09-16
 */
public class CompactDisc extends MusicMedia {

    private int numOfTracks;
    private static final int MIN_NUM_TRACKS;
    private static final int DEFAULT_NUM_TRACKS;
    private static final String READING_METHOD;

    static{
        MIN_NUM_TRACKS = 1;
        DEFAULT_NUM_TRACKS = 1;
        READING_METHOD = "laser";
    }

    /**
     * CompactDisc Constructor
     * @param title title
     * @param artist artist
     * @param numOfTracks numOfTracks
     */
    public CompactDisc(final String title,
                       final String artist,
                       final int numOfTracks) {
        super(title, artist, READING_METHOD);
        this.numOfTracks = validateNumOfTracks(numOfTracks);
    }

    /**
     * CompactDisc Constructor without numOfTracks (one track)
     * @param title title
     * @param artist artist
     */
    public CompactDisc(final String title,
                       final String artist) {
        super(title, artist);
        this.numOfTracks = DEFAULT_NUM_TRACKS;
    }

    /**
     * Validate the number of tracks
     * @param numOfTracks numOfTracks
     * @return valid int value
     * @throws IllegalArgumentException if less than zero
     */
    private static int validateNumOfTracks(final int numOfTracks){
        if(numOfTracks < MIN_NUM_TRACKS) {
            throw new IllegalArgumentException("Invalid number of tracks. It cannot be less than zero.");
        }
        else {
            return numOfTracks;
        }
    }

    // Getters and Setters
    /**
     * Getter numOfTracks
     * @return numOfTracks
     */
    public int getNumOfTracks() {
        return numOfTracks;
    }

    /**
     * Setter numOfTracks
     * @param numOfTracks numOfTracks
     */
    public void setNumOfTracks(int numOfTracks) {
        this.numOfTracks = validateNumOfTracks(numOfTracks);
    }

    // Misc and Overrides
    /**
     * Display "play" message with information about this object
     */
    @Override
    public void play() {
        System.out.println("Playing: " + this.getTitle() + " by " + this.getArtist());
    }

    /**
     * Display the number of tracks, title, and artist
     * @return string following this pattern "Artist - Title (Number of tracks : #)"
     */
    @Override
    public String toString() {
        return this.getArtist() + " - " + this.getTitle() + " (Number of tracks:" + numOfTracks + ")";
    }
}
