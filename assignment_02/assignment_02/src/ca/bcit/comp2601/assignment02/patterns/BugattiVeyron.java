package ca.bcit.comp2601.assignment02.patterns;

/**
 * BugattiVeyron class
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-12-03
 */
public class BugattiVeyron implements Movable {

    private final double speed;

    public BugattiVeyron(double speed) {
        this.speed = speed;
    }

    @Override
    public double getSpeed() {
        return 268;
    }
}