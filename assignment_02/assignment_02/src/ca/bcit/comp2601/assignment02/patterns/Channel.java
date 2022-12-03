package ca.bcit.comp2601.assignment02.patterns;

/**
 * Channel interface used to implement observer design pattern
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-12-03
 */
public interface Channel {
    /**
     * Update method to be implemented
     * @param o object to update
     */
    public void update(Object o);
}