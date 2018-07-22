package zero.test;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * AllReplacer
 *
 * @author liuguobin
 * @date 2018/7/19
 */

public class AllReplacer implements MethodReplacer {
    /**
     * Reimplement the given method.
     *
     * @param obj    the instance we're reimplementing the method for
     * @param method the method to reimplement
     * @param args   arguments to the method
     * @return return value for the method
     */
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("begin replacer");
        method.invoke(obj, args);
        System.out.println("end replacer");
        return null;
    }
}
