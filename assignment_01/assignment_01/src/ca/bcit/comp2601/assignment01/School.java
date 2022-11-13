package ca.bcit.comp2601.assignment01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * School class - List of Person references
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-10
 */
public class School {

    private static final int CURRENT_YEAR;
    private static final int COUNTER_START_VALUE;
    private static final String OUTPUT_FILE_NAME;
    List people;

    static {
        CURRENT_YEAR = 2022;
        COUNTER_START_VALUE = 0;
        OUTPUT_FILE_NAME = "people.txt";
    }

    {
        people = new ArrayList();
    }

    /**
     * Adds person to end of people's list
     * @param p person to add to the end of the list
     * @throws IllegalPersonException if the argument is null
     */
    public void register(Person p){
        if (p == null){
            throw new IllegalPersonException("cannot register a non-person");
        } else {
            people.add(p);
        }
    }

    /**
     * This method uses a method reference to print out all the people (i.e. triggering a call to
     * their respective toString() methods)
     */
    public void printRoster(){
        people.forEach(System.out::println);
    }

    /**
     * Users a lambda expression to go through the list of people while printing each year of their lives
     */
    public void printAgesAndYears(){
        Writeable w;

        w = (fullName, yearBorn, maxYear) -> {
            int counter;
            counter = COUNTER_START_VALUE;
            for (int i = yearBorn; i <= maxYear; i++){
                System.out.println(fullName + ": " + i + " (age " + counter + ")");
                counter++;
            }
        };

        for (Object object : people) {
            Person p1 = (Person)object;
            int maxYear;
            if (p1.isAlive()){
                maxYear = CURRENT_YEAR;
            } else {
                maxYear = p1.getDateOfDeath().getYear();
            }
            w.printData(p1.getName().getPrettyName(), p1.getDateOfBirth().getYear(), maxYear);
        }
    }

    /**
     * Saved the school details to a file called "people.txt"
     */
    public void saveDetails(){
        FileWriter writer;
        try {
            writer = new FileWriter(OUTPUT_FILE_NAME);
            for (Object object : people) {
                Person p1;
                p1 = (Person)object;
                String result;
                String livingCondition;
                if (p1.isAlive()) {
                    livingCondition = ".";
                }
                else {
                    livingCondition = " and died on " + p1.getDateOfDeath().getDayOfTheWeek() +
                            " " + p1.getDateOfDeath().getYyyyMmDd() +  ".";
                }
                result = p1.getName().getPrettyName() + " (" +
                        p1.getName().getInitials() + ") was born on " +
                        p1.getDateOfBirth().getDayOfTheWeek() + " " +
                        p1.getDateOfBirth().getYyyyMmDd() + livingCondition;
                writer.write(result + System.lineSeparator());
            }
            writer.close();
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // Do nothing
        }
    }
}
