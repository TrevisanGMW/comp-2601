package ca.bcit.comp2601.lab02.guilhermetrevisan;

import java.util.Objects;

/**
 * Professor (“einstein”, “fancy”, true, true, “teach”);
 * OVERTIME_PAY_RATE: 2.0
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-09-24
 */
public class Professor extends Employee implements Comparable<Professor> {

    private static final double OVERTIME_PAY_RATE = 2.0d;
    private static final boolean IS_PAID_SALARY = true;
    private static final boolean IS_POST_SECONDARY_EDUCATION_REQUIRED = true;
    private static final String WORK_VERB = "teach";
    private static final String DRESS_CODE = "fancy";
    private static final String MOST_PRESTIGIOUS_MAJOR = "Computer Science";
    private String teachingMajor;

    /**
     * Constructor Employee
     *
     * @param name                           person's name
     * @param teachingMajor                  teachingMajor
     */
    protected Professor(final String name, final String teachingMajor) {
        super(name, DRESS_CODE, WORK_VERB, IS_POST_SECONDARY_EDUCATION_REQUIRED, IS_PAID_SALARY);
            if (teachingMajor == null || teachingMajor.isBlank()){
                throw new IllegalArgumentException("Invalid teachingMajor. Cannot be null or empty.");
            }
            this.teachingMajor = teachingMajor;
    }

    /**
     * Getter teachingMajor
     * @return teachingMajor
     */
    public String getTeachingMajor() {
        return teachingMajor;
    }

    /**
     * Setter teachingMajor
     * @param teachingMajor teachingMajor
     */
    public void setTeachingMajor(String teachingMajor) {
        this.teachingMajor = teachingMajor;
    }

    /**
     * Override Get Over TIme Pay Rate
     * @return OVERTIME_PAY_RATE
     */
    @Override
    public double getOverTimePayRate() {
        return OVERTIME_PAY_RATE;
    }

    /**
     * Override equals
     * @param o object to compare
     * @return true if teachingMajor is the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return teachingMajor.equals(professor.teachingMajor);
    }

    /**
     * Override hashCode
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(teachingMajor);
    }

    /**
     * Override compareTo
     * @param that the object to be compared.
     * @return comparison int, positive if major is MOST_PRESTIGIOUS_MAJOR, else it's equal
     */
    @Override
    public int compareTo(Professor that) {
        if (this.getTeachingMajor() == null && that.getTeachingMajor() == null) {
            return 0;
        } else if (this.getTeachingMajor() == null) {
            return -1;
        } else if (that.getTeachingMajor() == null) {
            return 1;
        } else {
            if (this.getTeachingMajor().equalsIgnoreCase(MOST_PRESTIGIOUS_MAJOR)){
                return 1;
            } else {
                return 0;
            }
        }
    }
}
