package zero.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * ConcreteClassInterceptor
 *
 * @author liuguobin
 * @date 2018/7/30
 */

public class ConcreteClassInterceptor implements MethodInterceptor {
    public Object intercept(Object obj, Method method, Object[] arg, MethodProxy proxy) throws Throwable {
        System.out.println("Before:"+method);
        System.out.println(obj.getClass().getSuperclass().getName());
        System.out.println(obj.getClass().getName());
        Object object=proxy.invokeSuper(obj, arg);
        System.out.println("After:"+method);
        return object;
    }
}