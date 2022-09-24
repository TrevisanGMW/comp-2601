package ca.bcit.comp2601.lab02.guilhermetrevisan;

/**
 * Create an abstract class Employee which defines one abstract method:
 * public double getOverTimePayRate().
 * It also has a String name instance variable.
 * It also implements Employable.
 */
public abstract class Employee implements Employable {

    private final String name;

    protected Employee(String name) {
        this.name = name;
    }

    public abstract double getOverTimePayRate();

}
