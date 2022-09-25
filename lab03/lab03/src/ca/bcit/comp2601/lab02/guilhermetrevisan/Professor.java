package ca.bcit.comp2601.lab02.guilhermetrevisan;

/**
 * Professor (“einstein”, “fancy”, true, true, “teach”);
 * OVERTIME_PAY_RATE: 2.0
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-09-24
 */
public class Professor extends Employee{

    private static final double OVERTIME_PAY_RATE = 2.0d;
    private static final boolean IS_PAID_SALARY = true;
    private static final boolean IS_POST_SECONDARY_EDUCATION_REQUIRED = true;
    private static final String WORK_VERB = "teach";
    private static final String DRESS_CODE = "fancy";
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
}
