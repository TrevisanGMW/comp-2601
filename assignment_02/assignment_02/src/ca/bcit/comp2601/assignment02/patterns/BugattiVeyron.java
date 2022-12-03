package ca.bcit.comp2601.assignment02.patterns;

/**
 * BugattiVeyron class
 * Ideally it would extend a luxury car base class, but was kept like this for simplicity.
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-12-03
 */
public class BugattiVeyron implements Movable {

    private final double speed;

    /**
     * BugattiVeyron constructor
     * @param speed car's speed
     */
    public BugattiVeyron(double speed) {
        this.speed = speed;
    }

    /**
     * Movable implemetantion
     * @return speed
     */
    @Override
    public double getSpeed() {
        return speed;
    }
}