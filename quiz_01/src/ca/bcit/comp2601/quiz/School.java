package ca.bcit.comp2601.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Describing a school
 *
 * @author Guilherme Trevisan
 * @version 0.0.1
 * @since 2022-10-14
 */
public abstract class School {

    private final List<Student> students;

    /**
     * School Constructor - Initializes student list
     */
    public School() {
        students = new ArrayList<Student>();
    }

    /**
     * Adds a new student to students list
     * @param student student
     */
    public void register(final Student student) {
        students.add(student);
    }

    ;
}
