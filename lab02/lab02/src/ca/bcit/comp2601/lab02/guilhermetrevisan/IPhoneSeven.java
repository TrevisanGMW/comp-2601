package ca.bcit.comp2601.lab02.guilhermetrevisan;

import java.util.Objects;

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
 * Data, Constructor, Getters and Setters for:
 * (boolean) high-resolution camera
 * (int) gigabytes of memory
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-09-16
 */
public class IPhoneSeven extends IPhone{

    private final boolean hasHighResCamera;
    private int memoryGb;

    /**
     * IPhone Constructor
     *
     * @param minutesRemainingPhonePlan remaining time in current phone plan (minutes)
     * @param carrierName               name of the carrier
     * @throws IllegalArgumentException invalid arguments are used
     */
    public IPhoneSeven(final double minutesRemainingPhonePlan,
                       final String carrierName,
                       final boolean hasHighResCamera,
                       final int memoryGb) {
        super(minutesRemainingPhonePlan, carrierName);
        this.hasHighResCamera = hasHighResCamera;
        this.memoryGb = memoryGb;
    }


    /**
     * Getter hasHighResCamera
     * @return
     */
    public boolean getHasHighResCamera() {
        return hasHighResCamera;
    }


    /**
     * Setter hasHighResCamera
     * @return hasHighResCamera
     */
    public boolean setHasHighResCamera() {
        return hasHighResCamera;
    }

    /**
     * Getter getMemoryGb
     * @return getMemoryGb
     */
    public int getMemoryGb() {
        return memoryGb;
    }

    /**
     * Setter memoryGb
     * @param memoryGb memoryGb
     */
    public void setMemoryGb(int memoryGb) {
        this.memoryGb = memoryGb;
    }

    /**
     * Returns a string representation of the object.
     * @return All the class’s instance variables
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nhasHighResCamera: " + getHasHighResCamera() +
                "\nmemoryGb: " + getMemoryGb();
    }

    /**
     * IPhoneSevens that have +/- 10 minutes of each other’s number of minutes remaining on their phone plan are
     * considered equal, but only if they also have the same value for “high-resolution camera”.
     * @param o object to compare
     * @return true if with minutes threshold and identical highResCamera
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IPhoneSeven that = (IPhoneSeven) o;
        return hasHighResCamera == that.getHasHighResCamera();
    }

    /**
     * hashCode override
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasHighResCamera);
    }
}
