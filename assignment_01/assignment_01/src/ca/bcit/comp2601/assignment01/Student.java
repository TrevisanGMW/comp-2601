package ca.bcit.comp2601.assignment01;

/**
 * Student class
 * This class extends the Person class. It also has an additional instance variable and its accessor method:
 * String studentNumber and public String getStudentNumber().
 * public Student (Date born, Name name, String studentNumber): This constructor throws IllegalPersonException
 * exceptions if born or name is null; also, it throws IllegalPersonException exceptions if studentNumber is null,
 * blank, or not nine characters long.
 * This class overrides the public String toString() method, which returns a String in one of these two exact formats:
 * a) Alive people example: "Tiger Woods (student number: A12345678) was born 1975-12-30 and is still alive"
 * b) Dead people example: "Albert Einstein (student number: A87654321) was born 1879-03-14 and died 1955-04-18"
 * Use the parent's getName() return value, then its getPrettyName() method, and the born/died getYyyyMmDd() method.
 *
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
     *
     * @param born
     * @param name person's name
     * @param studentNumber a student number composed of 9 characters
     */
    public Student (Date born, Name name, String studentNumber){
        super(born, name);
        if (studentNumber == null || studentNumber.isBlank()){
            throw new IllegalPersonException("Invalid student number. Cannot be null or blank");
        } else if (studentNumber.length() != LENGTH_STUDENT_NUM){
            throw new IllegalPersonException("Invalid student number. Must be composed of 9 characters");
        } else {
            this.studentNumber = studentNumber;
        }
    }




    /**
     *
     * @return
     */
    public String getStudentNumber(){

    }

}
