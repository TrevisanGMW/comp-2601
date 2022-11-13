package ca.bcit.comp2601.lab08;

/**
 * Car Class
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-11-12
 */
public class Car {
    private String id;
    private String make;
    private String model;
    private int year;
    private boolean isElectric;
    private static final int FIRST_CHAR_INDEX = 0;
    private static final int SECOND_CHAR_INDEX = 1;

    /**
     * Car Constructor
     * @param id car id
     * @param make car maker
     * @param model car model
     * @param year year created
     * @param isElectric if the car is electric it's true
     */
    public Car(String id, String make, String model, int year, boolean isElectric) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.isElectric = isElectric;
    }

    /**
     * Getter ID
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter ID
     * @param id id
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Getter Make
     * @return make
     */
    public String getMake() {
        return make.substring(FIRST_CHAR_INDEX, SECOND_CHAR_INDEX).toUpperCase() +
                make.substring(SECOND_CHAR_INDEX).toLowerCase();
    }

    /**
     * Setter Make
     * @param make make
     */
    public void setMake(final String make) {
        this.make = make;
    }

    /**
     * Getter Model
     * @return model
     */
    public String getModel() {
        return model.substring(FIRST_CHAR_INDEX, SECOND_CHAR_INDEX).toUpperCase() +
                model.substring(SECOND_CHAR_INDEX).toLowerCase();
    }

    /**
     * Setter Model
     * @param model model
     */
    public void setModel(final String model) {
        this.model = model;
    }

    /**
     * Getter year
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter year
     * @param year year
     */
    public void setYear(final int year) {
        this.year = year;
    }

    /**
     * Getter isElectric
     * @return isElectric
     */
    public boolean isElectric() {
        return isElectric;
    }

    /**
     * Setter is electric
     * @param electric
     */
    public void setElectric(final boolean electric) {
        isElectric = electric;
    }

    /**
     * Override to String with information to fill list
     * @return string with this pattern "Make Model (Year, system)"
     */
    @Override
    public String toString() {
        String electricStatus;
        if (isElectric()){
            electricStatus = ", electric";
        } else {
            electricStatus = ", combustion";
        }
        return getMake() + " " + getModel() + " (" + getYear() + electricStatus + ")";
    }
}
