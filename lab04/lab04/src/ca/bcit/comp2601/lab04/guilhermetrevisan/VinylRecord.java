package ca.bcit.comp2601.lab04.guilhermetrevisan;

import java.util.ArrayList;
import java.util.List;

/**
 * VinylRecord Class
 *  @author  Guilherme Trevisan
 *  @version 0.0.1
 *  @since   2022-09-16
 */
public class VinylRecord extends MusicMedia{
    private int numOfTracks;
    private final int sizeInches;
    private final int weightGrams;
    private static final String READING_METHOD;
    private static final int MIN_NUM_TRACKS;
    private static final int DEFAULT_NUM_TRACKS;
    private static final int DEFAULT_SIZE_INCHES;
    private static final int DEFAULT_WEIGHT_GRAMS;
    private static final int VALID_SIZE_INCHES_BIG;
    private static final int VALID_SIZE_INCHES_MID;
    private static final int VALID_SIZE_INCHES_SMALL;
    private static final List VALID_BIG_WEIGHTS_GRAMS;
    private static final List VALID_MID_WEIGHTS_GRAMS;
    private static final List VALID_SMALL_WEIGHTS_GRAMS;

    static{
        READING_METHOD = "needle";
        MIN_NUM_TRACKS = 1;
        DEFAULT_NUM_TRACKS = 1;
        DEFAULT_SIZE_INCHES = 12;
        DEFAULT_WEIGHT_GRAMS = 200;
        VALID_SIZE_INCHES_BIG = 12;
        VALID_SIZE_INCHES_MID = 10;
        VALID_SIZE_INCHES_SMALL = 7;
        VALID_BIG_WEIGHTS_GRAMS = new ArrayList<>();
        VALID_MID_WEIGHTS_GRAMS = new ArrayList<>();
        VALID_SMALL_WEIGHTS_GRAMS = new ArrayList<>();
        VALID_BIG_WEIGHTS_GRAMS.add(140);
        VALID_BIG_WEIGHTS_GRAMS.add(180);
        VALID_BIG_WEIGHTS_GRAMS.add(200);
        VALID_MID_WEIGHTS_GRAMS.add(100);
        VALID_SMALL_WEIGHTS_GRAMS.add(40);
    }

    /**
     * Vinyl Record Constructor
     * @param artist artist cannot be null or blank
     * @param title title cannot be null or blank
     * @param numOfTracks numOfTracks must be 0 or more
     * @param sizeInches sizeInches must be 7, 10 or 12
     * @param weightGrams weightGrams, must conform to its size weight
     *                    (140g, 180g, 200g for a 12”, 100g for a 10”, 40g for a 7” record)
     */
    public VinylRecord(final String title,
                       final String artist,
                       final int numOfTracks,
                       final int sizeInches,
                       final int weightGrams) {
        super(artist, title, READING_METHOD);
        this.numOfTracks = validateNumOfTracks(numOfTracks);
        this.sizeInches = validateSizeInches(sizeInches);
        this.weightGrams = validateWeightGrams(this.sizeInches, weightGrams);
    }

    /**
     * Vinyl Record Constructor with only title and artist (default values for the others)
     * @param artist artist cannot be null or blank
     * @param title title cannot be null or blank
     */
    public VinylRecord(final String title,
                       final String artist) {
        this(artist, title, DEFAULT_NUM_TRACKS, DEFAULT_SIZE_INCHES, DEFAULT_WEIGHT_GRAMS);
    }

    /**
     * Validate size inches
     * @param sizeInches sizeInches
     * @return sizeInches if valid
     * @throws IllegalArgumentException if not a valid size
     */
    private static int validateSizeInches(final int sizeInches){
        List validSizes;
        validSizes = new ArrayList();
        validSizes.add(VALID_SIZE_INCHES_BIG);
        validSizes.add(VALID_SIZE_INCHES_MID);
        validSizes.add(VALID_SIZE_INCHES_SMALL);

        if(validSizes.contains(sizeInches)) {
            return sizeInches;
        }
        else {
            throw new IllegalArgumentException("Invalid size. Must conform to accepted sizes. Accepted:" + validSizes);
        }
    }

    /**
     * Validates weight according to provided size
     * @param sizeInches sizeInches
     * @param weightGrams weightGrams
     * @return weightGrams if valid
     * @throws IllegalArgumentException if not valid weight
     */
    private static int validateWeightGrams(final int sizeInches, final int weightGrams){
        String errorMessage = "Invalid weight. Valid weight for ";
        if (sizeInches == VALID_SIZE_INCHES_BIG){
            if (!VALID_BIG_WEIGHTS_GRAMS.contains(weightGrams)){
                throw new IllegalArgumentException(errorMessage + sizeInches + "\": " + VALID_BIG_WEIGHTS_GRAMS);
            } else {
                // do nothing
            }
        } else if (sizeInches == VALID_SIZE_INCHES_MID){
            if (!VALID_MID_WEIGHTS_GRAMS.contains(weightGrams)){
                throw new IllegalArgumentException(errorMessage + sizeInches + "\": " + VALID_MID_WEIGHTS_GRAMS);
            } else {
                // do nothing
            }
        } else if (sizeInches == VALID_SIZE_INCHES_SMALL){
            if (!VALID_SMALL_WEIGHTS_GRAMS.contains(weightGrams)){
                throw new IllegalArgumentException(errorMessage + sizeInches + "\": " + VALID_SMALL_WEIGHTS_GRAMS);
            } else {
                // do nothing
            }
        } else {
            throw new IllegalArgumentException("Invalid size.");
        }
        return weightGrams;
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

    /**
     * Display message about this object playing
     */
    @Override
    public void play() {
        System.out.println("Playing: " + this.getTitle() + " by " + this.getArtist());
    }

    /**
     * Override toString to return artist title and num of tracks
     * @return artist, title and num of tracks
     */
    @Override
    public String toString() {
        return this.getArtist() + " - " + this.getTitle() + " (Number of tracks:" + numOfTracks + ")";
    }

    // Getters and Setters
    /**
     * Setter numOfTracks
     * @param numOfTracks numOfTracks
     */
    public void setNumOfTracks(int numOfTracks) {
        this.numOfTracks = numOfTracks;
    }

    /**
     * Getter numOfTracks
     * @return numOfTracks
     */
    public int getNumOfTracks() {
        return validateNumOfTracks(numOfTracks);
    }

    /**
     * Getter sizeInches
     * @return sizeInches
     */
    public int getSizeInches() {
        return sizeInches;
    }

    /**
     * Getter weightGrams
     * @return weightGrams
     */
    public int getWeightGrams() {
        return weightGrams;
    }
}
