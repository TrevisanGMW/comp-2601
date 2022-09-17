package ca.bcit.comp2601.lab02.guilhermetrevisan;

/**
 * IDevice Abstract Class
 *
 * The parent class – IDevice – has a non-abstract method called getPurpose() which returns its purpose String.
 *
 * The purpose String instance variable is set in the constructor.
 *
 * The IDevice class also has an abstract method called printDetails() which prints out all of the child class’s
 * instance variables.
 *
 *
 * @author  Guilherme Trevisan
 * @version 0.0.1
 * @since   2022-09-17
 */

abstract class IDevice {
    private final String purpose;

    protected IDevice(final String purpose) {
        if (purpose == null || purpose.isBlank())
        {
            throw new IllegalArgumentException("Invalid purpose. Cannot be empty or null.");
        }

        this.purpose = purpose;
    }

    public String getPurpose() {
        return null;
    }

    public abstract String printDetails();

}
