package ca.bcit.comp2601.lab02.guilhermetrevisan;


import java.util.Objects;

/**
 * IPad Class - The purpose of this iDevice is “learning”
 *
 * Data, Constructor, Getters and Setters for:
 * (boolean) has a case,
 * (String) operating system version
 *
 * @author  Guilherme Trevisan
 * @version 0.0.1
 * @since   2022-09-16
 */
public class IPad extends IDevice {

    private boolean hasCase;
    private String operatingSystemVersion;

    /**
     * IPad Constructor
     * @param hasCase hasCase - Might get a case in the future
     * @param operatingSystemVersion operatingSystemVersion - Might be updated in the future
     * @throws IllegalArgumentException if operatingSystemVersion is null or empty
     */
    public IPad(final boolean hasCase, final String operatingSystemVersion) {
        super("learning");
        this.hasCase = hasCase;

        if (operatingSystemVersion == null || operatingSystemVersion.isBlank()) {
            throw new IllegalArgumentException("Invalid operatingSystemVersion. Cannot be empty or null.");
        }

        this.operatingSystemVersion = operatingSystemVersion;
    }

    /**
     * Getter hasCase
     * @return hasCase
     */
    public boolean hasCase() {
        return hasCase;
    }

    /**
     * Setter for hasCase
     * @param hasCase hasCase
     */
    public void setHasCase(boolean hasCase) {
        this.hasCase = hasCase;
    }

    /**
     * Getter for getOperatingSystemVersion
     * @return getOperatingSystemVersion
     */
    public String getOperatingSystemVersion() {
        return operatingSystemVersion;
    }

    /**
     * Setter operatingSystemVersion
     * @param operatingSystemVersion operatingSystemVersion e.g. 0.0.1
     * @throws IllegalArgumentException if operatingSystemVersion is null or empty
     */
    public void setOperatingSystemVersion(String operatingSystemVersion) {
        if (operatingSystemVersion == null || operatingSystemVersion.isBlank()) {
            throw new IllegalArgumentException("Invalid operatingSystemVersion. Cannot be empty or null.");
        }
        this.operatingSystemVersion = operatingSystemVersion;
    }

    /**
     * Returns a string representation of the object.
     * @return All the class’s instance variables
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nhasCase: " + hasCase() +
                "\noperatingSystemVersion: " + getOperatingSystemVersion();
    }


    /**
     * Prints out all the class’s instance variables
     */
    @Override
    public void printDetails() {
        System.out.println(this);
    }

    /**
     * IPads with the operating system version are considered equal; (ignoring casing)
     * @param o object to compare
     * @return true if operatingSystemVersion are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IPad iPad = (IPad) o;
        return Objects.equals(operatingSystemVersion.toLowerCase(), iPad.operatingSystemVersion.toLowerCase());
    }

    /**
     * Override hashCode
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), operatingSystemVersion);
    }
}
