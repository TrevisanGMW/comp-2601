package ca.bcit.comp2601.lab02.guilhermetrevisan;

/**
 * Employable interface
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-09-24
 */
public interface Employable {

    /**
     * Getter Dress Code
     * @return string representing the dress code
     */
    String getDressCode();

    /**
     * Getter is paid salary
     * @return if the employable object is paid salary or not
     */
    boolean isPaidSalary();

    /**
     * Getter post secondary requirement
     * @return if the employable object needs post secondary education or not
     */
    boolean postSecondaryEducationRequired();

    /**
     * Getter work verb
     * @return returns a description of the work verb (purpose)
     */
    String getWorkVerb();

    /**
     * Default gets paid state
     * @return true (if not overridden)
     */
    default boolean getsPaid(){
        return true;
    }

}
