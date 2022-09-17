package ca.bcit.comp2601.lab02.guilhermetrevisan;

import java.util.Objects;

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
    public IPod(final int numStoredSongs, final double maxVolumeDecibels) {
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
     * @return maxVolumeDecibels
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
        System.out.println(this);
    }


    /**
     * IPods with the same number of songs stored are considered equal
     * @param o object to compare
     * @return true if same number of numStoredSongs
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IPod iPod = (IPod) o;
        return numStoredSongs == iPod.numStoredSongs;
    }

    /**
     * hasCode Override
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numStoredSongs);
    }
}
