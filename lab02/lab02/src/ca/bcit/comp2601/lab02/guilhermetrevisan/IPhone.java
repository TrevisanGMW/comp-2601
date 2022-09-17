package ca.bcit.comp2601.lab02.guilhermetrevisan;


import java.util.Objects;

/**
 * IPhone Class - The purpose of this iDevice is “talking”
 *
 * Data, Constructor, Getters and Setters for:
 * (double) number of minutes remaining on phone plan,
 * (String) carrier
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-09-16
 */

public class IPhone extends IDevice {

    private static final int MIN_MINUTES_REMAINING = 0;
    private static final int COMPARISON_THRESHOLD = 10;
    private double minutesRemainingPhonePlan;
    private String carrierName;

    /**
     * IPhone Constructor
     * @param minutesRemainingPhonePlan remaining time in current phone plan (minutes)
     * @param carrierName name of the carrier
     * @throws IllegalArgumentException invalid arguments are used
     */
    public IPhone(final double minutesRemainingPhonePlan, final String carrierName) {
        super("talking");

        // Validate minutesRemainingPhonePlan
        if (minutesRemainingPhonePlan < MIN_MINUTES_REMAINING) {
            throw new IllegalArgumentException("Invalid minutesRemainingPhonePlan. Cannot be negative");
        }
        this.minutesRemainingPhonePlan = minutesRemainingPhonePlan;

        // Validate carrierName
        if (carrierName == null || carrierName.isBlank()) {
            throw new IllegalArgumentException("Invalid carrierName. Cannot be empty or null.");
        }
        this.carrierName = carrierName;
    }

    /**
     * Getter minutesRemainingPhonePlan
     * @return minutesRemainingPhonePlan
     */
    public double getMinutesRemainingPhonePlan() {
        return minutesRemainingPhonePlan;
    }

    /**
     * Setter minutesRemainingPhonePlan
     * @param minutesRemainingPhonePlan minutesRemainingPhonePlan
     * @throws IllegalArgumentException value is less than MIN_INITIAL_MINUTES_REMAINING (aka negative)
     */
    public void setMinutesRemainingPhonePlan(double minutesRemainingPhonePlan) {
        if (minutesRemainingPhonePlan >= MIN_MINUTES_REMAINING) {
            throw new IllegalArgumentException("Invalid minutesRemainingPhonePlan. Cannot be negative");
        }
        this.minutesRemainingPhonePlan = minutesRemainingPhonePlan;
    }

    /**
     * Getter carrierName
     * @return carrierName
     */
    public String getCarrierName() {
        return carrierName;
    }

    /**
     * Setter carrierName
     * @param carrierName carrierName
     * @throws IllegalArgumentException if argument is null or empty
     */
    public void setCarrierName(String carrierName) {
        if (carrierName == null || carrierName.isBlank()) {
            throw new IllegalArgumentException("Invalid carrierName. Cannot be empty or null.");
        }
        this.carrierName = carrierName;
    }

    /**
     * Returns a string representation of the object.
     * @return All the class’s instance variables
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nminutesRemainingPhonePlan: " + getMinutesRemainingPhonePlan() +
                "\ncarrierName: " + getCarrierName();
    }

    /**
     * Prints out all the class’s instance variables
     */
    @Override
    public void printDetails() {
        System.out.println(this);
    }

    /**
     * +/- 10 minutes of each other’s number of minutes remaining on their phone plan are considered equal
     * @param o object to compare
     * @return true if difference between minutesRemainingPhonePlan is less than COMPARISON_THRESHOLD
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IPhone iPhone = (IPhone) o;
        double doubleDifference = iPhone.minutesRemainingPhonePlan - minutesRemainingPhonePlan;
        return (Math.abs(doubleDifference) <= COMPARISON_THRESHOLD);
    }

    /**
     * Override hashCode
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), minutesRemainingPhonePlan);
    }
}