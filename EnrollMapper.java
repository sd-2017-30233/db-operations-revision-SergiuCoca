import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sergiu Coca on 3/15/2017.
 */
public class EnrollMapper implements RowMapper<Enroll> {
    public Enroll mapRow(ResultSet rs, int rowNumber) throws SQLException {
        Enroll enroll=new Enroll();
        enroll.setStudentID(rs.getInt("studentID"));
        enroll.setCourseID(rs.getInt("courseID"));
        return enroll;
    }
}
