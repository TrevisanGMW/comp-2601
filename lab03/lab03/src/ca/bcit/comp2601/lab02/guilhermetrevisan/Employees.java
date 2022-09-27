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
    private void printEmployeeNames(final List<?> employeesListToPrint){
        ArrayList<Employable> employees;
        employees = (ArrayList<Employable>)employeesListToPrint;
        for (Employable employee : employees)
        {
            Employee e = (Employee)employee;
            System.out.println(e.getName());
        }
    }

    /**
     * sorts all employee lists using compareTo
     */
    public void sortAllEmployeeLists() {
        Collections.sort(hockeyPlayersList);
        Collections.sort(professorsList);
        Collections.sort(parentsList);
        Collections.sort(gasStationAttendantsList);
    }

    /**
     * sorts hockeyPlayersList using compareTo
     */
    public void sortHockeyPlayersList() {
        Collections.sort(hockeyPlayersList);
    }

    /**
     * sorts professorsList using compareTo
     */
    public void sortProfessorsList() {
        Collections.sort(professorsList);
    }

    /**
     * sorts parentsList using compareTo
     */
    public void sortParentsList() {
        Collections.sort(parentsList);
    }

    /**
     * sorts gasStationAttendantsList using compareTo
     */
    public void sortGasStationAttendantsList() {
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
    public void printAllProfessors(){
        printEmployeeNames(professorsList);
    }

    /**
     * Prints the name of all employees found in the employeesList
     */
    public void printAllGasStationAttendants(){
        printEmployeeNames(gasStationAttendantsList);
    }


    /**
     * Getter employeesList
     * @return employeesList
     */
    public List<Employable> getEmployeesList() {
        return employeesList;
    }

    /**
     * Getter hockeyPlayersList
     * @return hockeyPlayersList
     */
    public List<HockeyPlayer> getHockeyPlayersList() {
        return hockeyPlayersList;
    }

    /**
     * Getter professorsList
     * @return professorsList
     */
    public List<Professor> getProfessorsList() {
        return professorsList;
    }

    /**
     * Getter parentsList
     * @return parentsList
     */
    public List<Parent> getParentsList() {
        return parentsList;
    }

    /**
     * Getter gasStationAttendantsList
     * @return gasStationAttendantsList
     */
    public List<GasStationAttendant> getGasStationAttendantsList() {
        return gasStationAttendantsList;
    }


    /**
     * Prints all equal employees using the "getEqualEmployeesList" method
     */
    public void printAllEqualEmployees(){
        List<String> equalEmployees;
        equalEmployees = getEqualEmployeesList(employeesList);
        for (String str : equalEmployees){
            System.out.println(str);
        }
    }

    /**
     * Finds all employees that are equals according to their equal() overrides
     * @param employableList employableList
     * @return list of string with objects that are equal to one another. E.g., (A = B)
     *         Doesn't repeat objects
     */
    public static List<String> getEqualEmployeesList(final List<Employable> employableList){
        List<String> resultList;
        resultList = new ArrayList<>();
        for (int i = 0; i < employableList.size(); i++) {
            for (int j = i + 1; j < employableList.size(); j++) {
                if (employableList.get(i) != employableList.get(j) &&
                        employableList.get(i).equals(employableList.get(j))) {
                    Employee a;
                    Employee b;
                    a = (Employee) employableList.get(i);
                    b = (Employee) employableList.get(j);
                    resultList.add(a.getName() + " = " + b.getName());
                }
            }
        }
        return resultList;
    }


    /**
     * Method to allow for Employees object as input and to do it only with methods
     * @param employablesObj employablesObj
     */
    public static void printEqualEmployeesList(final Employees employablesObj){
        List<Employable> employableList;
        employableList = employablesObj.getEmployeesList();
        for (int i = 0; i < employableList.size(); i++) {
            for (int j = i + 1; j < employableList.size(); j++) {
                if (employableList.get(i) != employableList.get(j) &&
                        employableList.get(i).equals(employableList.get(j))) {
                    Employee a;
                    Employee b;
                    a = (Employee) employableList.get(i);
                    b = (Employee) employableList.get(j);
                    System.out.println(a.getName() + " = " + b.getName());
                }
            }
        }
    }
}
