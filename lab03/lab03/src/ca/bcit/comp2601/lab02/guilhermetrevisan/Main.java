package ca.bcit.comp2601.lab02.guilhermetrevisan;
public class Main {
    public static void main(String[] args) {

        Employees employees;
        employees = new Employees();

        System.out.println("- Before:");
        employees.printAllParents();

        System.out.println("- After:");
        employees.sortAllEmployeeLists();
        employees.printAllParents();
    }
}