package ca.bcit.comp2601.assignment02.junit;

/**
 * Orderable Interface - Copied from Assignment 01 (Used for Unit Testing)
 *
 * This interface has two abstract methods:
 * public Orderable next()
 * public Orderable previous()
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.2
 * @since 2022-10-10
 */
public interface Orderable {
    /**
     * Should return the next object in an Orderable object
     * @return next object in an Orderable object
     */
    public Orderable next();

    /**
     * Should return the previous object in an Orderable object
     * @return previous object in an Orderable object
     */
    public Orderable previous();
}
