package ca.bcit.comp2601.lab02.guilhermetrevisan;

/**
 * IPhoneSeven Class
 *
 * Overrides toString() to return all the object data in a String.
 * Use the @Override annotation. This toString() method must also call its parent’s toString() method.
 * Furthermore, this class also overrides equals().
 * IPhoneSevens that have +/- 10 minutes of each other’s number of minutes remaining on their phone plan are
 * considered equal, but only if they also have the same value for “high-resolution camera”.
 * Use the @Override annotation.
 * Override hashCode properly too for this class.
 *
 *
 * Data, Constructor, Getters and Setters for:
 * (boolean) high-resolution camera
 * (int) gigabytes of memory
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-09-16
 *
 */


public class IPhoneSeven extends IPhone{

    /**
     * IPhone Constructor
     *
     * @param minutesRemainingPhonePlan remaining time in current phone plan (minutes)
     * @param carrierName               name of the carrier
     * @throws IllegalArgumentException invalid arguments are used
     */
    public IPhoneSeven(double minutesRemainingPhonePlan, String carrierName) {
        super(minutesRemainingPhonePlan, carrierName);
    }
}
