package ca.bcit.comp2601.lab02.guilhermetrevisan;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a class called Employees which has an ArrayList of 20 Employee references.
 * The constructor adds five of each type of Employee above, in this order: <In the constructor>
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-09-24
 */
public class Employees {

    private final List<Employable> employeesList;

    public Employees() {
        employeesList = new ArrayList<>();

        employeesList.add(new HockeyPlayer("Wayne Gretzky", 894));
        employeesList.add(new HockeyPlayer("Who Ever", 0));
        employeesList.add(new HockeyPlayer("Brent Gretzky", 1));
        employeesList.add(new HockeyPlayer("Pavel Bure", 437));
        employeesList.add(new HockeyPlayer("Jason Harrison", 0));

        employeesList.add(new Professor("Albert Einstein", "Physics"));
        employeesList.add(new Professor("Jason Harrison", "Computer Systems"));
        employeesList.add(new Professor("Richard Feynman", "Physics"));
        employeesList.add(new Professor("BCIT Instructor", "Computer Systems"));
        employeesList.add(new Professor("Kurt Godel", "Logic"));

        employeesList.add(new Parent("Tiger Woods", 1));
        employeesList.add(new Parent("Super Mom", 168));
        employeesList.add(new Parent("Lazy Larry", 20));
        employeesList.add(new Parent("Ex Hausted", 168));
        employeesList.add(new Parent("Super Dad", 167));

        employeesList.add(new GasStationAttendant("Joe Smith", 10));
        employeesList.add(new  GasStationAttendant("Tony Baloney", 100));
        employeesList.add(new  GasStationAttendant("Benjamin Franklin", 100));
        employeesList.add(new GasStationAttendant("Mary Fairy", 101));
        employeesList.add(new GasStationAttendant("Bee See", 1));
    }



}
