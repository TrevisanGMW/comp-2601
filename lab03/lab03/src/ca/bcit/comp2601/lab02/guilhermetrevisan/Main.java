package ca.bcit.comp2601.lab02.guilhermetrevisan;
public class Main {
    public static void main(String[] args) {

        Employees employees;
        employees = new Employees();

        final String separator;
        separator = "___________________________";

        // Hockey Players
        System.out.println(" - Hockey Players - Before:");
        employees.printAllHockeyPlayers();
        System.out.println(" - Hockey Players - After:");
        employees.sortHockeyPlayersList();
        employees.printAllHockeyPlayers();
        System.out.println(separator);

        // Professors
        System.out.println(" - Professors - Before:");
        employees.printAllProfessors();
        System.out.println(" - Professors - After:");
        employees.sortProfessorsList();
        employees.printAllProfessors();
        System.out.println(separator);

        // Parents
        System.out.println(" - Parents - Before:");
        employees.printAllParents();
        System.out.println(" - Parents - After:");
        employees.sortParentsList();
        employees.printAllParents();
        System.out.println(separator);

        // Gas Station Attendants
        System.out.println(" - Gas Station Attendants - Before:");
        employees.printAllGasStationAttendants();
        System.out.println(" - Gas Station Attendants - After:");
        employees.sortGasStationAttendantsList();
        employees.printAllGasStationAttendants();
        System.out.println(separator);

        System.out.println(" - Equal Employees:");
        employees.printAllEqualEmployees();
//        Employees.getEqualEmployeesList(employees); // In case it needs to be done purely through a method

    }
}