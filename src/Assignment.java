import java.time.Duration;
import java.time.LocalDate;

public class Assignment extends Test {
    private LocalDate Assignment_startDate;
    private LocalDate Assignment_Deadline;

    public Assignment(){

    }
    public Assignment(LocalDate Assignment_startDate, LocalDate Assignment_Deadline) {
        this.Assignment_startDate = Assignment_startDate;
        this.Assignment_Deadline = Assignment_Deadline;

    }
    public Assignment(int id, String Title, double max_score,String Assignment_startDate, String assignment_Deadline) {
        super(id, Title, max_score);
        this.Assignment_startDate = LocalDate.parse(Assignment_startDate);
        this.Assignment_Deadline = LocalDate.parse(assignment_Deadline);
    }
    public Assignment(int id, String Title, double max_score,String Assignment_startDate, String assignment_Deadline,String courseCode) {
        this(id, Title, max_score,Assignment_startDate,assignment_Deadline);
        this.courseCode=courseCode;
    }

    public void setAssignment_startDate(LocalDate assignment_startDate) {
        Assignment_startDate = assignment_startDate;
    }

    public LocalDate getAssignment_startDate() {
        return Assignment_startDate;
    }

    public void set_Assignment_deadline(LocalDate assignment_Deadline) {
        Assignment_Deadline = assignment_Deadline;
    }

    public LocalDate getAssignment_Deadline() {
        return Assignment_Deadline;
    }
    public String toString()
    {
        return  getID()+","+getTitle()+","+getMax_score()+","+Assignment_startDate+","+Assignment_Deadline+","+courseCode;
    }
}