package ca.bcit.comp2601.quiz;

public class Dog implements Printable, Comparable<Dog>{

    private final String name;
    private final int yearBirth;

    private static final int LARGER = 1;
    private static final int SMALLER = -1;
    private static final int EQUAL = 0;

    /**
     * Dog Constructor
     * @param name name
     * @param yearBirth yearBirth
     */
    public Dog(String name, int yearBirth) {
        this.name = name;
        this.yearBirth = yearBirth;
    }

    /**
     * Getter name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter yearBirth
     * @return yearBirth
     */
    public int getYearBirth() {
        return yearBirth;
    }

    /**
     * Print dog details according to this pattern: "My name is <name> and I was born in <birthYear>"
     */
    @Override
    public void printDetails() {
        System.out.println("My name is " + name + " and I was born in " + yearBirth);
    }

    /**
     * Override compareTo
     * @param that the object to be compared.
     * @return larger according to name length
     */
    @Override
    public int compareTo(Dog that) {
        if (this.name == null && that.name == null) {
            return EQUAL;
        } else if (this.name == null) {
            return SMALLER;
        } else if (that.name == null) {
            return LARGER;
        } else {
            if (this.name.length() > that.name.length()){
                return LARGER;
            } else if (that.name.length() > this.name.length()) {
                return SMALLER;
            } else {
                return EQUAL;
            }
        }
    }
}
