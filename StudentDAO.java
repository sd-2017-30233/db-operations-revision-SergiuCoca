import org.springframework.jdbc.core.*;
import javax.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by Sergiu Coca on 3/14/2017.
 */
public class StudentDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public  void  setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        //this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int count(){
        String SQL = "select count(*) from Students";
        jdbcTemplate = new JdbcTemplate(dataSource);
        int rowCount =jdbcTemplate.queryForObject(SQL,Integer.class);
        return  rowCount;
    }

    public Student createStudent() {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        String data = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String address=sc.nextLine();
        java.sql.Date sqldate = null;
        try {
            java.util.Date date = sdf.parse(data);
            sqldate = new java.sql.Date(date.getTime());
        } catch (Exception e) {
        }
        return new Student(id,name,sqldate,address);
    }

    public Student createStudent1(Student student) {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        String data = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String address=sc.nextLine();
        java.sql.Date sqldate = null;
        try {
            java.util.Date date = sdf.parse(data);
            sqldate = new java.sql.Date(date.getTime());
        } catch (Exception e) {
        }
        student=new Student(id,name,sqldate,address);
        return student;
    }

    public void add(Student student){
        String sql = "INSERT INTO Students " + "(studentID, name, birthDate, address) VALUES (?, ?, ?, ?)";
        jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] params = { student.getID(),student.getName(),student.getBirthDate(),student.getAdress()};
        jdbcTemplate.update(sql, params);
    }

    public Student read(int id){
        String SQL = "select * from Students where studentID = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        Student student= jdbcTemplate.queryForObject(SQL, new Object[]{id}, new StudentMapper());
        System.out.println(student.toString());
        return  student;
    }

    public void update(int id,String name){
        String SQL = "update students set name = '"+name+"' where studentID = "+ id;
        jdbcTemplate = new JdbcTemplate(dataSource);
        //Object[] params = { id ,name};
        jdbcTemplate.update(SQL);
    }

    public void delete(int id){
        String SQL = "DELETE FROM Students WHERE studentID=?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] params = { id };
        jdbcTemplate.update(SQL, params);
    }
}
