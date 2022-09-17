package ca.bcit.comp2601.lab02.guilhermetrevisan;


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
    private double minutesRemainingPhonePlan;
    private String carrierName;

    /**
     * IPhone Constructor
     * @param minutesRemainingPhonePlan remaining time in current phone plan (minutes)
     * @param carrierName name of the carrier
     * @throws IllegalArgumentException invalid arguments are used
     */
    public IPhone(double minutesRemainingPhonePlan, String carrierName) {
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
     * @param minutesRemainingPhonePlan
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
     * @param carrierName
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
        System.out.println(this.toString());
    }
}
