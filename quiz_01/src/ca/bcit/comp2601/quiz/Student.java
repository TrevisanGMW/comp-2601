package ca.bcit.comp2601.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *  Class Describing a student
 *  @author  Guilherme Trevisan
 *  @version 0.0.1
 *  @since   2022-10-14
 */
public class Student {

    private final String studentId;

    /**
     * Student constructor
     * @param studentId ID of the student
     */
    public Student(final String studentId) {
        this.studentId = studentId;
    }

    /**
     * Getter studentId
     * @return id of the student
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Overrides equals
     * @param o object to compare
     * @return true if equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId);
    }

    /**
     * Override hashCode because equals was overridden
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}


