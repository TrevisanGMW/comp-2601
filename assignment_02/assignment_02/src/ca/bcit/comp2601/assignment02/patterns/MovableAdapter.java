package ca.bcit.comp2601.assignment02.patterns;

/**
 * MovableAdapter interface used to convert MPH into KMPH
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-12-03
 */
public interface MovableAdapter {
    /**
     * returns speed in KM/H
     * @return returns speed in KM/H
     */
    double getSpeed();
}