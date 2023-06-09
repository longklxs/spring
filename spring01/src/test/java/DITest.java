import com.longklxs.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DITest {
    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
        UserService userservice = ac.getBean("userservice", UserService.class);
        userservice.saveUser();

    }
}
