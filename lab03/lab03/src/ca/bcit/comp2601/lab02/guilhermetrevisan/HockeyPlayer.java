package ca.bcit.comp2601.lab02.guilhermetrevisan;

import java.util.Objects;

/**
 * HockeyPlayer (“gretzky”, “jersey”, true, false, “play”);
 * OVERTIME_PAY_RATE: 0.0
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-09-24
 */
public class HockeyPlayer extends Employee implements Comparable<HockeyPlayer> {

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

    /**
     * Overide equals
     * @param o object to compare
     * @return true if the number of goals are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HockeyPlayer that = (HockeyPlayer) o;
        return numberOfGoals == that.numberOfGoals;
    }

    /**
     * Overide hashCode
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(numberOfGoals);
    }


    /**
     * Highest number of goals is greater
     * @param that the object to be compared.
     * @return comparison int, positive if getNumberOfGoals is higher
     */
    @Override
    public int compareTo(HockeyPlayer that) {
        if (this.getNumberOfGoals() != that.getNumberOfGoals()) {
            return (this.getNumberOfGoals() < that.getNumberOfGoals() ? -1 : 1);
        }

        return 0;
    }
}
