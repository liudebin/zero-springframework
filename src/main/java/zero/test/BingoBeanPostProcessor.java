package zero.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 *
 *
 * @author liuguobin
 * @date 2018/7/21
 */


public class BingoBeanPostProcessor implements BeanPostProcessor {

//    private ApplicationContext applicationContext;
//
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" BingoBeanPostProcessor before  Initialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" BingoBeanPostProcessor after  Initialization");
//        Class clazz = bean.getClass();
//        Method[] methods = clazz.getDeclaredMethods();
//        for (Method m : methods) {
//            if (m.getReturnType() == App.class) {
//                m = new Method();
//            }
//        }

        return bean;
    }
}

