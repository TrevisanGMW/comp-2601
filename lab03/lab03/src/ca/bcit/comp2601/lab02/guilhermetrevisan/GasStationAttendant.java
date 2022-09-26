package ca.bcit.comp2601.lab02.guilhermetrevisan;

import java.util.Objects;

/**
 * Example:
 * GasStationAttendant(“smith”, “uniform”, false, false, “pump”);
 * OVERTIME_PAY_RATE: 1.5
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-09-24
 */
public class GasStationAttendant extends Employee implements Comparable<GasStationAttendant> {

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

    /**
     * Override equals
     * @param o object to compare
     * @return true if same numberOfDollarsStolenPerDayUSD
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GasStationAttendant that = (GasStationAttendant) o;
        return Double.compare(that.numberOfDollarsStolenPerDayUSD, numberOfDollarsStolenPerDayUSD) == 0;
    }

    /**
     * Override hashCode
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(numberOfDollarsStolenPerDayUSD);
    }

    /**
     * Override compareTo
     * @param that the object to be compared.
     * @return comparison int, move up if getNumberOfDollarsStolenPerDayUSD is higher
     */
    @Override
    public int compareTo(GasStationAttendant that) {
        if (this.getNumberOfDollarsStolenPerDayUSD() != that.getNumberOfDollarsStolenPerDayUSD()) {
            return (this.getNumberOfDollarsStolenPerDayUSD() < that.getNumberOfDollarsStolenPerDayUSD() ? 1 : -1);
        }
        return 0;
    }
}
