/**
 * Created by Sergiu Coca on 3/14/2017.
 */
public class Enroll {
    private int studentID;
    private int courseID;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "Enroll{" +
                "studentID=" + studentID +
                ", courseID=" + courseID +
                '}';
    }
}
