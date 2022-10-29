package ca.bcit.comp2601.quiz02;

class A{
    private final static int MAX_A_VALUE;
    private int a;

    static {
        MAX_A_VALUE = 500;
    }

    /**
     * A Constructor
     * @param a a value
     */
    A(final int a){
        this.a = validateA(b);
    }

    /**
     * Validates A value before setting it
     * @param b new "a" value (aka b)
     * @return valid A value
     * @throws IllegalArgumentException when A is lower than MAX_A_VALUE
     */
    private static int validateA(final int b){
        if(b < MAX_A_VALUE){
            throw new IllegalArgumentException("Invalid argument. A value is too low." );
        } else {
            return b;
        }
    }

    /**
     * Setter A
     * @param b new "a" value (aka b)
     */
    void setA(final int b){
        this.a = validateA(b);
    }
}
