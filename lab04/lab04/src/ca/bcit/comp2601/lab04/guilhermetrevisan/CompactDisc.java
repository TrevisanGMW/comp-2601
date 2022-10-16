package ca.bcit.comp2601.lab04.guilhermetrevisan;

/**
 * CompactDisc Class
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since   2022-09-16
 */
public class CompactDisc extends MusicMedia {

    private int numOfTracks;
    private static final String READING_METHOD = "laser";

    /**
     * CompactDisc Constructor
     * @param title title
     * @param artist artist
     * @param numOfTracks numOfTracks
     */
    public CompactDisc(final String title,
                       final String artist,
                       final int numOfTracks) {
        super(title, artist);
        this.numOfTracks = validateNumOfTracks(numOfTracks);
    }

    /**
     * Validate the number of tracks
     * @param numOfTracks numOfTracks
     * @return valid int value
     * @throws IllegalArgumentException if less than zero
     */
    private static int validateNumOfTracks(final int numOfTracks){
        if(numOfTracks < 0) { // Zero is ok, a disk might be empty
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
     * method void play()
     */
    @Override
    public void play() {
        System.out.println("Playing: " + this.getTitle() + " by " + this.getArtist());
    }

    /**
     * display the number of tracks, title, and artist
     * @return string following this pattern "Artist - Title (Number of tracks : #)"
     */
    @Override
    public String toString() {
        return this.getArtist() + " - " + this.getTitle() + " (Number of tracks:" + numOfTracks + ")";
    }
}
