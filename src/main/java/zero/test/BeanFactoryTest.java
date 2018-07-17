package zero.test;

import org.junit.Test;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.io.ClassPathResource;

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
        System.out.println(app.getClass());
        System.out.println(beanFactory.getBean("app").getClass());
        app.sayHi();
    }


    @Test
    public void testLoad1() {
        BeanFactory beanFactory=new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
        reader.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));
        App app = (App) beanFactory.getBean("app");
        app = (App) beanFactory.getBean("app");
//        App app = beanFactory.getBean(App.class);
        logger.info("{}", beanFactory.isSingleton("app"));
        app.sayHi();
    }

    @Test
    public void testClassPathResource() {
        ClassPathResource classPathResource = new ClassPathResource("applicationContext.xml");
        logger.info("{}", classPathResource.getPath());
    }
}
