/**
 * Created by Sergiu Coca on 3/13/2017.
 */
public class Course {
    private int ID;
    private String name;
    private String teacher;
    private int studyYear;

    public Course(int ID, String name, String teacher, int studyYear) {
        this.ID = ID;
        this.name = name;
        this.teacher = teacher;
        this.studyYear = studyYear;
    }
    public Course(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    @Override
    public String toString() {
        return "Course{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", studyYear=" + studyYear +
                '}';
    }
}
