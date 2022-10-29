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
