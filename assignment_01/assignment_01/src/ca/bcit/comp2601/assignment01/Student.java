package ca.bcit.comp2601.assignment01;

/**
 * Student class
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-10
 */
public class Student extends Person{

    private final String studentNumber;
    private static final int LENGTH_STUDENT_NUM;

    static {
        LENGTH_STUDENT_NUM = 9;
    }

    /**
     * Student Constructor
     * @param born date when the student was born
     * @param name person's name
     * @param studentNumber a student number composed of 9 characters
     * @throws IllegalPersonException if arguments are invalid (student number must be 9 characters)
     */
    public Student (Date born, Name name, String studentNumber){
        super(born, name);
        String invalidArgumentMessage = "bad student number";
        if (studentNumber == null || studentNumber.isBlank()){
            throw new IllegalPersonException(invalidArgumentMessage);
        } else if (studentNumber.length() != LENGTH_STUDENT_NUM){
            throw new IllegalPersonException(invalidArgumentMessage);
        } else {
            this.studentNumber = studentNumber;
        }
    }

    /**
     * Getter getStudentNumber
     * @return getStudentNumber (composed of 9 characters)
     */
    public String getStudentNumber() {
        return studentNumber;
    }

    /**
     * Alive people example: "Tiger Woods (student number: A12345678) was born 1975-12-30 and is still alive"
     * Dead people example: "Albert Einstein (student number: A87654321) was born 1879-03-14 and died 1955-04-18"
     * @return formatted
     */
    @Override
    public String toString() {
        String result;
        String livingCondition;
        String studentInformation;
        studentInformation = " (student number: " + studentNumber.toUpperCase() + ")";
        if (isAlive()) {
            livingCondition = "is still alive";
        }
        else {
            livingCondition = "died " + getDateOfDeath().getYyyyMmDd();
        }

        result = getName().getPrettyName() + studentInformation + " was born " +
                getDateOfBirth().getYyyyMmDd() + " and " + livingCondition;
        return result;
    }
}
