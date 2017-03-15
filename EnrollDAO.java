import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Sergiu Coca on 3/15/2017.
 */
public class EnrollDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public  void  setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        //this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int count(){
        String SQL = "select count(*) from Enroll";
        jdbcTemplate = new JdbcTemplate(dataSource);
        int rowCount =jdbcTemplate.queryForObject(SQL,Integer.class);
        System.out.println(rowCount);
        return  rowCount;
    }

    public void read(int id){
        String SQL = "select * from Enroll where studentID = ?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        Enroll enroll= jdbcTemplate.queryForObject(SQL, new Object[]{id}, new EnrollMapper());
        enroll.toString();
    }

    public void enroll(int id1,int id2){
        String sql = "INSERT INTO Enroll WHERE studentID=? AND courseID=?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] params = { id1,id2};
        jdbcTemplate.update(sql, params);
    }

    public void unenroll(int id1,int id2){
        String sql = "DELETE FROM Enroll WHERE studentID=? AND courseID=?";
        jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] params = { id1 ,id2};
        jdbcTemplate.update(sql, params);
    }
}
