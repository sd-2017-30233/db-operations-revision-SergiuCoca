import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

/**
 * Created by Sergiu Coca on 3/15/2017.
 */
public class EnrollTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    EnrollDAO enrollDAO = (EnrollDAO) context.getBean("enroll");

    @Test
    public void enrollTest(){
        int cnt1=enrollDAO.count();
        enrollDAO.enroll(3,2);
        int cnt2=enrollDAO.count();
        cnt1+=1;
        assertTrue(cnt1==cnt2);
    }

    @Test
    public void unenrollTest(){
        int cnt1=enrollDAO.count();
        enrollDAO.unenroll(3,1);
        int cnt2=enrollDAO.count();
        cnt1-=1;
        assertTrue(cnt1==cnt2);

    }
}
