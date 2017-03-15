import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by Sergiu Coca on 3/15/2017.
 */
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(StudentTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
