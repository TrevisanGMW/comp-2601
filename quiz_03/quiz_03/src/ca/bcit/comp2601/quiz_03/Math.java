package ca.bcit.comp2601.quiz_03;

/**
 * Math Class
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-11-12
 */
public class Math {

    private final static int INVALID_DENOMINATOR;

    static {
        INVALID_DENOMINATOR = 0;
    }

    /**
     * Divide Method
     *
     * @param numerator   How many equal parts do you have?
     * @param denominator how many equal part is the whole divided into?
     * @return division result
     * @throws IllegalDivisorException when dividing by zero
     */
    public static double divide(final int numerator, int denominator) throws IllegalDivisorException {
        if (denominator == INVALID_DENOMINATOR){
            throw new IllegalDivisorException("Invalid denominator. Cannot divide by zero.");
        } else {
            return (double)numerator/denominator;
        }
    }

    /**
     * Main method
     * @param args incoming arguments
     */
    public static void main(final String[] args) {

        int numerator;
        int denominator;
        double divisionResult;

        numerator = 5;
        denominator = 2;

        try {
            divisionResult = Math.divide(numerator, denominator);
            System.out.println(numerator + " divided by " + denominator + " is " +  divisionResult);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    }
