package ca.bcit.comp2601.lab02.guilhermetrevisan;

/**
 * Example:
 * GasStationAttendant(“smith”, “uniform”, false, false, “pump”);
 * OVERTIME_PAY_RATE: 1.5
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-09-24
 */
public class GasStationAttendant extends Employee{

    private static final double OVERTIME_PAY_RATE = 1.5d;
    private static final boolean IS_PAID_SALARY = false;
    private static final boolean IS_POST_SECONDARY_EDUCATION_REQUIRED = false;
    private static final String WORK_VERB = "pump";
    private static final String DRESS_CODE = "uniform";

    private double numberOfDollarsStolenPerDayUSD;

    /**
     * GasStationAttendant Constructor
     * @param name represents the person's name
     * @param numberOfDollarsStolenPerDayUSD number of
     */
    public GasStationAttendant(final String name,
                               final double numberOfDollarsStolenPerDayUSD) {
        super(name, DRESS_CODE, WORK_VERB, IS_POST_SECONDARY_EDUCATION_REQUIRED, IS_PAID_SALARY);
        this.numberOfDollarsStolenPerDayUSD = numberOfDollarsStolenPerDayUSD;
    }


    /**
     * Getter Number Of Dollars Stolen Per Day
     * @return numberOfDollarsStolenPerDay
     */
    public double getNumberOfDollarsStolenPerDayUSD() {
        return numberOfDollarsStolenPerDayUSD;
    }

    /**
     * Setter Number Of Dollars Stolen Per Day
     * @param numberOfDollarsStolenPerDayUSD numberOfDollarsStolenPerDayUSD
     */
    public void setNumberOfDollarsStolenPerDayUSD(double numberOfDollarsStolenPerDayUSD) {
        this.numberOfDollarsStolenPerDayUSD = numberOfDollarsStolenPerDayUSD;
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
