package ca.bcit.comp2601.quiz02;

/**
 * Class B
 */
class B{
    private final static int MAX_NUM_MONTHS;
    private int day;

    static {
        MAX_NUM_MONTHS = 12;
    }

    /**
     * Constructor B
     * @param day a number for the day
     */
    public B(int day) {
        this.day = day;
    }
}
