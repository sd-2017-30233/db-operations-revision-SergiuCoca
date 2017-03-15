import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by Sergiu Coca on 3/15/2017.
 */
public class CourseDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public  void  setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
       // this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int count(){
        String SQL = "select count(*) from Courses";
        jdbcTemplate = new JdbcTemplate(dataSource);
        int rowCount =jdbcTemplate.queryForObject(SQL,Integer.class);
        System.out.println(rowCount);
        return  rowCount;
    }

    public Course createCourse() {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        String teacher = sc.nextLine();
        int studyYear=sc.nextInt();
        return new Course(id,name,teacher,studyYear);

    }
    public void add(Course course){
        String sql = "INSERT INTO Courses " + "(courseID, name, teacher, studyYear) VALUES (?, ?, ?, ?)";
        jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] params = { course.getID(),course.getName(),course.getTeacher(),course.getStudyYear()};
        jdbcTemplate.update(sql, params);
    }

    public Course read(int id){
        String SQL = "select * from Courses where courseID = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        Course course= jdbcTemplate.queryForObject(SQL, new Object[]{id}, new CourseMapper());
        //System.out.println(course.toString());
        return course;
    }

    public void delete(int id){
        String SQL = "DELETE FROM Courses WHERE courseID=?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] params = { id };
        jdbcTemplate.update(SQL, params);
    }
    public void update(int id,String name){
        String SQL = "update Courses set name = ? where studentID = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] params = { id ,name};
        jdbcTemplate.update(SQL,params);
    }
}
