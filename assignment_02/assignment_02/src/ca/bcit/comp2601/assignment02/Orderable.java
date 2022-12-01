package ca.bcit.comp2601.assignment02;

/**
 * Orderable Interface
 *
 * This interface has two abstract methods:
 * public Orderable next()
 * public Orderable previous()
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
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
