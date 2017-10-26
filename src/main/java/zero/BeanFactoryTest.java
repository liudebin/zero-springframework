package zero;

import org.junit.Test;
import zero.org.springframework.beans.factory.support.BeanDefinitionRegistry;
import zero.org.springframework.beans.factory.support.DefaultListableBeanFactory;
import zero.org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
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
    public void testLoad1() {
        BeanFactory beanFactory=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
        reader.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));
        App app = (App) beanFactory.getBean("app");
        logger.info("{}", beanFactory.isSingleton("app"));
        app.sayHi();
    }

    @Test
    public void testClassPathResource() {
        ClassPathResource classPathResource = new ClassPathResource("applicationContext.xml");
        logger.info("{}", classPathResource.getPath());
    }
}
