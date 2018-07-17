package zero;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ApplicationContext的测试用例
 *
 * @author liuguobin
 * @date 2017/10/16
 */
@Deprecated
public class ApplicationContextTest extends AbstractTest {

    @Test
    public void testLoad() {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
