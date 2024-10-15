package seedu.address.model.tut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import seedu.address.model.student.Student;

/**
 * A class representing a tutorial date. Each {@code TutDate} object holds a specific {@link Date}
 * and a list of {@link Student} objects who are associated with that date.
 */
public class TutDate {

    public static final String MESSAGE_CONSTRAINTS = "Date should be in correct format (dd/mm/yyyy)!";
    private final Date date;
    private final List<Student> students;

    /**
     * Constructs a {@code TutDate} object with a specified {@link Date}.
     * Initializes an empty list of {@link Student} objects for this date.
     *
     * @param date The date associated with the {@code TutDate}.
     */
    public TutDate(Date date) {
        this.date = date;
        this.students = new ArrayList<>();
    }

    /**
     * Adds a student to the tutorial date.
     * Prevents adding duplicate students.
     *
     * @param student The student to add.
     */
    public void add(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    /**
     * Returns the date of this tutorial.
     *
     * @return the associated {@link Date}.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Returns an unmodifiable list of students.
     *
     * @return an unmodifiable list of {@link Student}.
     */
    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    /**
     * Returns whether the tutorial date is valid (i.e., has a non-null date).
     *
     * @return true if the date is valid, false otherwise.
     */
    public boolean isValid() {
        return date != null;
    }

    /**
     * Custom equals method to check if two TutDate objects are considered equal.
     * Two TutDate objects are equal if they have the same date and student list.
     *
     * @param other The object to compare.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof TutDate)) {
            return false;
        }

        TutDate otherTutDate = (TutDate) other;
        return Objects.equals(date, otherTutDate.date) && students.equals(otherTutDate.students);
    }

    /**
     * Returns a string representation of the tutorial date.
     *
     * @return the string representation of the date.
     */
    @Override
    public String toString() {
        return date.toString();
    }

    /**
     * Generates a hash code based on the date and students.
     *
     * @return the hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(date, students);
    }
}
