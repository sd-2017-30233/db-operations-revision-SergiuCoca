import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;

/**
 * Created by Sergiu Coca on 3/14/2017.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentDAO studentDAO = (StudentDAO)context.getBean("stud");
        CourseDAO courseDAO = (CourseDAO) context.getBean("curs");
        EnrollDAO enrollDAO = (EnrollDAO) context.getBean("enroll");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = sdf.parse("1985-11-04");
        } catch (Exception e) {
        }
        Student student=new Student(1,"Popa Vasile",date,"Cluj");
        studentDAO.add(student);
    }

}
