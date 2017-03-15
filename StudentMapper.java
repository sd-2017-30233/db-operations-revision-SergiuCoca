
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sergiu Coca on 3/15/2017.
 */
public class StudentMapper implements RowMapper<Student> {

    public Student mapRow(ResultSet rs, int rowNumber) throws SQLException{
        Student student=new Student();
        student.setID(rs.getInt("studentID"));
        student.setName(rs.getString("name"));
        student.setBirthDate(rs.getDate("birthDate"));
        student.setAddress(rs.getString("address"));
        return student;

    }

}
