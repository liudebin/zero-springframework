package zero;

import org.junit.Test;
import zero.org.springframework.beans.factory.xml.XmlBeanFactory;
import zero.org.springframework.beans.factory.BeanFactory;
import zero.org.springframework.core.io.ClassPathResource;

/**
 * ApplicationContext的测试用例
 *
 * @author liuguobin
 * @date 2017/10/16
 */

public class BeanFactoryTest extends AbstractTest {

    @Test
    public void testLoad() {
        BeanFactory beanFactory=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        App app = (App) beanFactory.getBean("app");
        app.sayHi();
    }

    @Test
    public void testClassPathResource() {
        ClassPathResource classPathResource = new ClassPathResource("applicationContext.xml");

    }
}
