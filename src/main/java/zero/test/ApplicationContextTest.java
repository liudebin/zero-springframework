package zero.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zero.test.tx.TxTest;

/**
 * ApplicationContext的测试用例
 *
 * @author liuguobin
 * @date 2017/10/16
 */
//@Deprecated
public class ApplicationContextTest extends AbstractTest {

    @Test
    public void testLoad() {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext context1=new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        App app = (App) context.getBean("app");
        app.sayHi();
    }


    @Test
    public void testTransaction() {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("可以了");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        TxTest txTest = (TxTest) context.getBean("txTest");

        System.out.println(txTest.getClass().getSuperclass());
        System.out.println(txTest.getClass());
        txTest.saveOne();
//        txTest.noTx();
    }
}
