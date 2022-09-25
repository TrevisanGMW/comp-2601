package ca.bcit.comp2601.lab02.guilhermetrevisan;

import java.util.ArrayList;
import java.util.Collections;
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
    private final List<HockeyPlayer> hockeyPlayersList;
    private final List<Professor> professorsList;
    private final List<Parent> parentsList;
    private final List<GasStationAttendant> gasStationAttendantsList;

    public Employees() {
        employeesList = new ArrayList<>(); // All of them combined
        hockeyPlayersList = new ArrayList<>();
        professorsList = new ArrayList<>();
        parentsList = new ArrayList<>();
        gasStationAttendantsList = new ArrayList<>();

        hockeyPlayersList.add(new HockeyPlayer("Wayne Gretzky", 894));
        hockeyPlayersList.add(new HockeyPlayer("Who Ever", 0));
        hockeyPlayersList.add(new HockeyPlayer("Brent Gretzky", 1));
        hockeyPlayersList.add(new HockeyPlayer("Pavel Bure", 437));
        hockeyPlayersList.add(new HockeyPlayer("Jason Harrison", 0));

        professorsList.add(new Professor("Albert Einstein", "Physics"));
        professorsList.add(new Professor("Jason Harrison", "Computer Systems"));
        professorsList.add(new Professor("Richard Feynman", "Physics"));
        professorsList.add(new Professor("BCIT Instructor", "Computer Systems"));
        professorsList.add(new Professor("Kurt Godel", "Logic"));

        parentsList.add(new Parent("Tiger Woods", 1));
        parentsList.add(new Parent("Super Mom", 168));
        parentsList.add(new Parent("Lazy Larry", 20));
        parentsList.add(new Parent("Ex Hausted", 168));
        parentsList.add(new Parent("Super Dad", 167));

        gasStationAttendantsList.add(new GasStationAttendant("Joe Smith", 10));
        gasStationAttendantsList.add(new GasStationAttendant("Tony Baloney", 100));
        gasStationAttendantsList.add(new GasStationAttendant("Benjamin Franklin", 100));
        gasStationAttendantsList.add(new GasStationAttendant("Mary Fairy", 101));
        gasStationAttendantsList.add(new GasStationAttendant("Bee See", 1));

        // Populate employeesList
        employeesList.addAll(hockeyPlayersList);
        employeesList.addAll(professorsList);
        employeesList.addAll(parentsList);
        employeesList.addAll(gasStationAttendantsList);

    }

    /**
     * @param employeesListToPrint employeesList the employable list to print
     */
    private void printEmployeeNames(final List employeesListToPrint){
        ArrayList<Employable> employees;
        employees = (ArrayList<Employable>)employeesListToPrint;
        for (Employable employee : employees)
        {
            Employee e = (Employee)employee;
            System.out.println(e.getName());
        }
    }

    /**
     * sortEmployeeList sorts input list using compareTo
     */
    public void sortAllEmployeeLists() {
        Collections.sort(hockeyPlayersList);
        Collections.sort(professorsList);
        Collections.sort(parentsList);
        Collections.sort(gasStationAttendantsList);
    }

    /**
     * Prints the name of all employees found in the employeesList
     */
    public void printAllEmployees(){
        printEmployeeNames(employeesList);
    }

    /**
     * Prints the name of all employees found in the employeesList
     */
    public void printAllHockeyPlayers(){
        printEmployeeNames(hockeyPlayersList);
    }

    /**
     * Prints the name of all employees found in the employeesList
     */
    public void printAllParents(){
        printEmployeeNames(parentsList);
    }

    /**
     * Prints the name of all employees found in the employeesList
     */
    public void printAllGasStationAttendants(){
        printEmployeeNames(gasStationAttendantsList);
    }


//    /**
//     * Prints/Displays all employees that are equal
//     * @param a
//     */
//    static public void getMax(final int[] a)    {
//        int max = a[0];
//        for(int i: a)        {
//            if(i > max)            {
//                max = i;
//            }
//        }
//
//    }


}
