package zero.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * BeanFactory的测试用例
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
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);


//        reader.loadBeanDefinitions(new ClassPathResource("error_applicationContext.xml")); // 错误数据
        reader.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));
        beanFactory.addBeanPostProcessor(new BingoBeanPostProcessor());
//        App app = (App) beanFactory.getBean("app");
//        app = (App) beanFactory.getBean("app");
//        App app = beanFactory.getBean(App.class);
//        logger.info(beanFactory.isSingleton("app"));
//        app.sayHi();

        try {
            System.out.println("可以了");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AllAttribute allAttribute = (AllAttribute) beanFactory.getBean("allAttribute");
        allAttribute = (AllAttribute) beanFactory.getBean("allAttribute");
        allAttribute.sayHi();
        System.out.println(allAttribute.getB());
        beanFactory.destroyBean(allAttribute);
    }

    @Test
    public void testClassPathResource() {
        ClassPathResource classPathResource = new ClassPathResource("applicationContext.xml");
//        logger.info("{}", classPathResource.getPath());
    }
}
