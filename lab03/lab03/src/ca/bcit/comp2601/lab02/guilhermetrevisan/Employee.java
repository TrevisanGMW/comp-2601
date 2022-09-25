package ca.bcit.comp2601.lab02.guilhermetrevisan;

/**
 * Create an abstract class Employee which defines one abstract method:
 * public double getOverTimePayRate().
 * It also has a String name instance variable.
 * It also implements Employable.
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-09-24
 */
public abstract class Employee implements Employable {

    private final String name;
    private final String dressCode;
    private final String workVerb;
    private final boolean postSecondaryEducationRequired;
    private final boolean isPaidSalary;

    /**
     * Constructor Employee
     * @param name person's name
     * @param dressCode dressCode
     * @param workVerb workVerb
     * @param postSecondaryEducationRequired postSecondaryEducationRequired
     * @param isPaidSalary isPaidSalary
     */
    protected Employee(final String name,
                       final String dressCode,
                       final String workVerb,
                       final boolean postSecondaryEducationRequired,
                       final boolean isPaidSalary) {
        this.name = name;
        this.dressCode = dressCode;
        this.workVerb = workVerb;
        this.postSecondaryEducationRequired = postSecondaryEducationRequired;
        this.isPaidSalary = isPaidSalary;
    }

    /**
     * Getter Name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter Work Verb
     * @return workVerb
     */
    public String getWorkVerb(){
        return workVerb;
    }

    /**
     * Getter Dress Code
     * @return dressCode
     */
    @Override
    public String getDressCode() {
        return dressCode;
    }

    /**
     * Getter Paid Salary
     * @return isPaidSalary
     */
    @Override
    public boolean isPaidSalary() {
        return isPaidSalary;
    }

    /**
     * Getter Post Secondary Education Requirement
     * @return postSecondaryEducationRequired
     */
    @Override
    public boolean postSecondaryEducationRequired() {
        return postSecondaryEducationRequired;
    }

    /**
     * To be overridden Get Over TIme Pay Rate
     * @return OVERTIME_PAY_RATE (Defined in the child where it was overridden)
     */
    public abstract double getOverTimePayRate();

}
