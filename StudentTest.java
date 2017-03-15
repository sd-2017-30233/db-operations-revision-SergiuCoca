import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * Created by Sergiu Coca on 3/15/2017.
 */
public class StudentTest {
    static ApplicationContext context;
    static  StudentDAO studentDAO;
    @BeforeClass
    public static void setUp(){
         context = new ClassPathXmlApplicationContext("beans.xml");
         studentDAO = (StudentDAO)context.getBean("stud");
    }

    @Test
    public void createTest(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = sdf.parse("1985-11-04");
        } catch (Exception e) {
        }
        int cnt1=studentDAO.count();
        Student student=new Student(1,"Popa Vasile",date,"Cluj");
        studentDAO.add(student);
        int cnt2=studentDAO.count();
        cnt1=cnt1+1;
        assertTrue(cnt1==cnt2);
    }

    @Test
    public void readTest(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        java.sql.Date sqldate = null;
        try {
             date = sdf.parse("1995-12-27");
                sqldate = new java.sql.Date(date.getTime());
        } catch (Exception e) {
        }
        Student student=new Student(2,"Coca Sergiu",sqldate,"Zalau");
        Student student1=studentDAO.read(2);
        assertEquals(student,student1);
    }

    @Test
    public void updateTest(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        java.sql.Date sqldate = null;
        try {
            date = sdf.parse("1985-11-04");
            sqldate = new java.sql.Date(date.getTime());
        } catch (Exception e) {
        }
        Student student=new Student(1,"Popa Vasile",sqldate,"Cluj");
        studentDAO.update(1,"Poapa Eugen");
        Student student1=studentDAO.read(1);
        assertThat(student, not(equalTo(student1)));
    }

    @Test
    public void deleteTest() {
        int cnt1 =studentDAO.count();
        studentDAO.delete(1);
        int cnt2=studentDAO.count();
        cnt2 += 1;
        assertTrue(cnt1 == cnt2);
    }
}
