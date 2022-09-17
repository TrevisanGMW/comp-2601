package ca.bcit.comp2601.lab02.guilhermetrevisan;

/**
 * IPod Class - the purpose of this iDevice is “music”
 *
 * Data, Constructor, Getters and Setters for:
 * (int) number of songs stored,
 * (double) maximum volume in decibels
 *
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-09-16
 */
public class IPod extends IDevice {

    private static final int MIN_NUM_STORED_SONGS = 0;
    private int numStoredSongs;
    private final double  maxVolumeDecibels;

    /**
     * IPod Constructor
     * @param numStoredSongs numStoredSongs
     * @param maxVolumeDecibels maxVolumeDecibels
     * @throws IllegalArgumentException if negative number of songsStored
     */
    public IPod(int numStoredSongs, double maxVolumeDecibels) {
        super("music");

        // Validate numSongsStored
        if (numStoredSongs < MIN_NUM_STORED_SONGS){
            throw new IllegalArgumentException("Invalid numSongsStored. Cannot be negative.");
        }
        this.numStoredSongs = numStoredSongs;
        this.maxVolumeDecibels = maxVolumeDecibels;
    }

    /**
     * Getter numStoredSongs
     * @return numStoredSongs
     */
    public int getNumStoredSongs() {
        return numStoredSongs;
    }

    /**
     * Setter setNumStoredSongs
     * @param numStoredSongs setNumStoredSongs
     * @throws IllegalArgumentException if negative number of songsStored
     */
    public void setNumStoredSongs(int numStoredSongs) {
        if (numStoredSongs < MIN_NUM_STORED_SONGS){
            throw new IllegalArgumentException("Invalid numSongsStored. Cannot be negative.");
        }
        this.numStoredSongs = numStoredSongs;
    }

    /**
     * Getter maxVolumeDecibels
     * @return
     */
    public double getMaxVolumeDecibels() {
        return maxVolumeDecibels;
    }

    /**
     * Returns a string representation of the object.
     * @return All the class’s instance variables
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nnumStoredSongs: " + getNumStoredSongs() +
                "\nmaxVolumeDecibels: " + getMaxVolumeDecibels();
    }

    /**
     * Prints out all the class’s instance variables
     */
    @Override
    public void printDetails() {
        System.out.println(this.toString());
    }
}
