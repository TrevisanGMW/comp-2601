package ca.bcit.comp2601.lab02.guilhermetrevisan;

/**
 * HockeyPlayer (“gretzky”, “jersey”, true, false, “play”);
 * OVERTIME_PAY_RATE: 0.0
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-09-24
 */
public class HockeyPlayer extends Employee {

    private static final double OVERTIME_PAY_RATE = 0.0d;
    private static final boolean IS_PAID_SALARY = true;
    private static final boolean IS_POST_SECONDARY_EDUCATION_REQUIRED = false;
    private static final String WORK_VERB = "play";
    private static final String DRESS_CODE = "jersey";
    private int numberOfGoals;

    /**
     * Constructor Hockey Player (Employee)
     *
     * @param name                           person's name
     * @param numberOfGoals                  number of goals
     */
    protected HockeyPlayer(final String name, final int numberOfGoals) {
        super(name, DRESS_CODE, WORK_VERB, IS_POST_SECONDARY_EDUCATION_REQUIRED, IS_PAID_SALARY);
        this.numberOfGoals = numberOfGoals;
    }

    /**
     * Getter Number of Goals
     * @return numberOfGoals
     */
    public int getNumberOfGoals() {
        return numberOfGoals;
    }

    /**
     * Setter numberOfGoals
     * @param numberOfGoals numberOfGoals to set
     */
    public void setNumberOfGoals(int numberOfGoals) {
        this.numberOfGoals = numberOfGoals;
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
