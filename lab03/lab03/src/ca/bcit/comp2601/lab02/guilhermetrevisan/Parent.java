package ca.bcit.comp2601.lab02.guilhermetrevisan;

import java.util.Objects;

/**
 * Parent(“mother”, “anything”, false, false, “care”);
 * OVERTIME_PAY_RATE: -2.0
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-09-24
 */
public class Parent extends Employee implements Comparable<Parent> {

    private static final double OVERTIME_PAY_RATE = -2.0d;
    private static final int MIN_NUM_HOURS_SPENT_PER_WEEK = 0;
    private static final boolean GETS_PAID = false;
    private static final boolean IS_PAID_SALARY = false;
    private static final boolean IS_POST_SECONDARY_EDUCATION_REQUIRED = false;
    private static final String WORK_VERB = "care";
    private static final String DRESS_CODE = "anything";
    private int numberOfHoursSpentPerWeekWithKids;

    /**
     * Constructor Parent (Employee)
     * @param name                                                person's name
     * @param numberOfHoursSpentPerWeekWithKids                   hours spent with kids
     */
    protected Parent(final String name, final int numberOfHoursSpentPerWeekWithKids) {
        super(name, DRESS_CODE, WORK_VERB, IS_POST_SECONDARY_EDUCATION_REQUIRED, IS_PAID_SALARY);
        if (numberOfHoursSpentPerWeekWithKids < MIN_NUM_HOURS_SPENT_PER_WEEK){
            throw new IllegalArgumentException("Invalid numberOfHoursSpentPerWeekWithKids. Cannot be less than " +
                    MIN_NUM_HOURS_SPENT_PER_WEEK + ".");
        }

        this.numberOfHoursSpentPerWeekWithKids = numberOfHoursSpentPerWeekWithKids;
    }


    /**
     * Getter numberOfHoursSpentPerWeekWithKids
     * @return numberOfHoursSpentPerWeekWithKids
     */
    public int getNumberOfHoursSpentPerWeekWithKids() {
        return numberOfHoursSpentPerWeekWithKids;
    }

    /**
     * Setter numberOfHoursSpentPerWeekWithKids
     * @param numberOfHoursSpentPerWeekWithKids numberOfHoursSpentPerWeekWithKids
     */
    public void setNumberOfHoursSpentPerWeekWithKids(final int numberOfHoursSpentPerWeekWithKids) {

        if (numberOfHoursSpentPerWeekWithKids < MIN_NUM_HOURS_SPENT_PER_WEEK){
            throw new IllegalArgumentException("Invalid numberOfHoursSpentPerWeekWithKids. Cannot be less than " +
                    MIN_NUM_HOURS_SPENT_PER_WEEK + ".");
        }
        this.numberOfHoursSpentPerWeekWithKids = numberOfHoursSpentPerWeekWithKids;
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
     * Getter Is Paid
     * @return getsPaid
     */
    @Override
    public boolean getsPaid() {
        return GETS_PAID;
    }

    /**
     * Overide equals
     * @param o object to compare to
     * @return true if same number of hours spent per week with kids
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return numberOfHoursSpentPerWeekWithKids == parent.numberOfHoursSpentPerWeekWithKids;
    }

    /**
     * Override hashCode
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(numberOfHoursSpentPerWeekWithKids);
    }

    /**
     * Override compareTo
     * @param that the object to be compared.
     * @return comparison int, higher if getNumberOfHoursSpentPerWeekWithKids is bigger
     */
    @Override
    public int compareTo(Parent that) {
        if (this.getNumberOfHoursSpentPerWeekWithKids() != that.getNumberOfHoursSpentPerWeekWithKids()) {
            return (this.getNumberOfHoursSpentPerWeekWithKids() < that.getNumberOfHoursSpentPerWeekWithKids() ? -1 : 1);
        }
        return 0;
    }
}
