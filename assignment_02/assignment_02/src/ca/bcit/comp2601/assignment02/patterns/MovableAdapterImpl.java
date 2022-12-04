package ca.bcit.comp2601.assignment02.patterns;

/**
 * MovableAdapterImpl class used to convert MPH into KMPH for luxuryCars
 *
 * @author Guilherme Trevisan, Monika Szucs
 * @version 0.0.1
 * @since 2022-12-03
 */
public class MovableAdapterImpl implements MovableAdapter {
    private final static double MPH_KMPH_CONVERSION_MULTIPLIER;
    private Movable luxuryCar;

    static {
        MPH_KMPH_CONVERSION_MULTIPLIER = 1.60934;
    }

    /**
     * MovableAdapterImpl constructor - Sets car to be converted
     * @param luxuryCar a luxuryCar
     */
    public MovableAdapterImpl(Movable luxuryCar) {
        this.luxuryCar = luxuryCar;
    }

    /**
     * MovableAdapter method overwritten to convert MPH to KMPH
     * @return kmph (kilometers per hour) speed value for the car
     */
    @Override
    public double getSpeed() {
        return convertMPHtoKMPH(luxuryCar.getSpeed());
    }

    /**
     * Converts MPH (miles per hour) to KMPH (kilometers per hour)
     * @param mph value in miles per hour
     * @return converted value in KMPH
     */
    private double convertMPHtoKMPH(final double mph) {
        return mph * MPH_KMPH_CONVERSION_MULTIPLIER;
    }
}
