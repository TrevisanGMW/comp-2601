package ca.bcit.comp2601.lab02.guilhermetrevisan;

/**
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-09-24
 */
public interface Employable {

    public String getDressCode();
    public boolean isPaidSalary();
    public boolean postSecondaryEducationRequired();
    public String getWorkVerb();
    default public boolean getsPaid(){
        return true;
    }

}
