package ca.bcit.comp2601.assignment01;

/**
 * Teacher class
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-10
 */

public class Teacher extends Person{

    private final String specialty;

    /**
     * @param name Name object
     * @param born Date object for the birth date
     * @param specialty Teacher's specialty (can be null)
     * @throws IllegalArgumentException if any arguments are invalid
     */
    public Teacher(Date born,Name name, String specialty) {
        super(born, name);
        if (specialty.isBlank()){
            throw new IllegalPersonException("Invalid specialty. Cannot be blank. (Null is ok)");
        } else {
            this.specialty = specialty;
        }
    }

    /**
     * Getter specialty
     * @return specialty
     */
    public String getSpecialty() {
        return specialty;
    }

    /**
     * Alive people example: "Tiger Woods (specialty: mathematics) was born 1975-12-30 and is still alive"
     * Dead people example: "Albert Einstein (specialty: mathematics) was born 1879-03-14 and died 1955-04-18"
     * @return formatted
     */
    @Override
    public String toString() {
        String result;
        String livingCondition;
        String specialtyInformation;
        specialtyInformation = "(specialty: " + getSpecialty() + ")";
        if (isAlive()) {
            livingCondition = "is still alive";
        }
        else {
            livingCondition = "died " + getDateOfDeath().getYyyyMmDd();
        }

        result = getName().getPrettyName() + specialtyInformation + " was born " +
                getDateOfBirth().getYyyyMmDd() + " and " + livingCondition;
        return result;
    }
}
