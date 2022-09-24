package ca.bcit.comp2601.lab02.guilhermetrevisan;

import java.util.ArrayList;
import java.util.List;

/**
 * Create a class called Employees which has an ArrayList of 20 Employee references.
 * The constructor adds five of each type of Employee above, in this order: <In the constructor>
 */
public class Employees {



    //    private final List<Employable> employeesList;
    private final List employeesList;

    public Employees() {
        employeesList = new ArrayList<>();
        employeesList.add("Abc");
    }

    public String getEmployeesList() {
        return employeesList.toArray().toString();
    }

}
