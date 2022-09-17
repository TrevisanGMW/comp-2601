package ca.bcit.comp2601.lab02.guilhermetrevisan;

import java.util.Objects;

/**
 * IDevice Abstract Class
 *
 * The parent class – IDevice – has a non-abstract method called getPurpose() which returns its purpose String.
 * The purpose String instance variable is set in the constructor.
 * The IDevice class also has an abstract method called printDetails() which prints out all the child class’s
 * instance variables.
 *
 * @author  Guilherme Trevisan
 * @version 0.0.1
 * @since   2022-09-16
 */

abstract class IDevice {
    private final String purpose;

    /**
     * Constructor used to define purpose
     * @param purpose purpose of the device
     * @throws IllegalArgumentException in case an invalid purpose is provided.
     */
    protected IDevice(final String purpose) {
        if (purpose == null || purpose.isBlank()) {
            throw new IllegalArgumentException("Invalid purpose. Cannot be empty or null.");
        }

        this.purpose = purpose;
    }

    /**
     * @return purpose
     */
    public String getPurpose() {
        return purpose;
    }

    @Override
    public String toString() {
        return "purpose: " + getPurpose();
    }

    /**
     * Prints out all the class’s instance variables
     */
    public abstract void printDetails();

    /**
     * @param o object to compare
     * @return true if devices have the same purpose
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IDevice iDevice = (IDevice) o;
        return Objects.equals(purpose, iDevice.purpose);
    }

    /**
     * hashCode override
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(purpose);
    }
}
