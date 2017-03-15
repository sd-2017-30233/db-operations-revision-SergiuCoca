import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sergiu Coca on 3/15/2017.
 */
public class CourseMapper implements RowMapper<Course> {
    public Course mapRow(ResultSet rs, int rowNumber) throws SQLException {
        Course course=new Course();
        course.setID(rs.getInt("studentID"));
        course.setName(rs.getString("name"));
        course.setTeacher(rs.getString("teacher"));
        course.setStudyYear(rs.getInt("studyYear"));
        return course;

    }

}