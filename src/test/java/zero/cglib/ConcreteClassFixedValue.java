package zero.cglib;

import org.springframework.cglib.proxy.FixedValue;

/**
 * ConcreteClassFixedValue
 *
 * @author liuguobin
 * @date 2018/7/30
 */

public class ConcreteClassFixedValue implements FixedValue {
    public Object loadObject() throws Exception {
        System.out.println("ConcreteClassFixedValue loadObject ...");
        Object object=999;
        return object;
    }
}