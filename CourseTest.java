import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Sergiu Coca on 3/15/2017.
 */
public class CourseTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    CourseDAO courseDAO = (CourseDAO) context.getBean("curs");

    @Test
    public void createTest(){
        int cnt1=courseDAO.count();
        Course course=new Course(3,"Gavrea Ioan","CN",2);
        courseDAO.add(course);
        int cnt2=courseDAO.count();
        cnt1+=1;
        assertTrue(cnt1==cnt2);
    }

    @Test
    public void readTest(){
        Course course=new Course(1,"Oniga Florin","AC",2);
        Course course1=courseDAO.read(1);
        assertEquals(course,course1);
    }

    @Test
    public void updateTest(){
        Course course=new Course(1,"Oniga Florin","AC",2);
        courseDAO.update(1,"Oniga Marcel");
        Course course1=courseDAO.read(1);
        assertThat(course, not(equalTo(course1)));
    }

    @Test
    public void deleteTest(){
        int cnt1= courseDAO.count();
        courseDAO.delete(1);
        int cnt2=courseDAO.count();
        cnt2+=1;
        assertTrue(cnt1==cnt2);
    }
}
