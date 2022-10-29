package ca.bcit.comp2601.quiz02;

/**
 * Main Class - Program Entry Point
 */
public class Main {
    /**
     * Main Function
     * @param args provided arguments
     */
    public static void main(String[] args) {
        Quizzable q1;
        Quizzable q2;

        q1 = (x, y, z) -> {
            String myString;
            myString = String.valueOf(x) + String.valueOf(y) + String.valueOf(z);
            return myString;
        };

        q2 = (x, y, z) -> {
            String anotherString ;
            anotherString  = String.valueOf(x+y+z);
            return anotherString ;
        };

        System.out.println(q1.makeQuestion(1,2,3));
        System.out.println(q2.makeQuestion(1,2,3));
    }
}

package ca.bcit.comp2601.quiz02;

/**
 * Quizzable Functional Interface
 */
@FunctionalInterface
public interface Quizzable {
    /**
     * Make Question Method (To be implemented through lambda expressions)
     * @param x a number
     * @param y another number
     * @param z yet another number
     * @return a string
     */
    String makeQuestion(int x, int y, int z);
}
