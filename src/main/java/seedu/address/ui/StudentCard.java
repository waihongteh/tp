package seedu.address.ui;


import javafx.collections.SetChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.student.Student;
import seedu.address.model.tut.TutDate;

/**
 * A UI component that displays information of a {@code Student}.
 */
public class StudentCard extends UiPart<Region> {

    private static final String FXML = "StudentListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Student student;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label studentId;
    @FXML
    private Label tutorialClass;
    @FXML
    private Label attendance;

    /**
     * Creates a {@code StudentCode} with the given {@code Student} and index to display.
     */
    public StudentCard(Student student, int displayedIndex) {
        super(FXML);
        this.student = student;
        id.setText(displayedIndex + ". ");
        name.setText(student.getName().fullName);
        studentId.setText(student.getStudentId().value);
        tutorialClass.setText(student.getTutorialClass().value);
        attendance.setText(student.getPresentDates().toString());

        // Listen for changes in the presentDates property
        student.presentDatesProperty().addListener((observable, oldValue, newValue) -> {
            updateAttendanceLabel();
        });

        // Listen for changes in the dates set within presentDates
        student.getPresentDates().getDates().addListener((SetChangeListener<TutDate>) change -> {
            updateAttendanceLabel();
        });
    }

    private void updateAttendanceLabel() {
        attendance.setText(student.getPresentDates().toString());
    }
}
