package zero.cglib;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * ConcreteClassCallbackFilter
 *
 * @author liuguobin
 * @date 2018/7/30
 */

public class ConcreteClassCallbackFilter implements CallbackFilter {

    @Override
    public int accept(Method method) {
        if("getConcreteMethodB".equals(method.getName())){
            return 0;//Callback callbacks[0]
        }else if("getConcreteMethodA".equals(method.getName())){
            return 1;//Callback callbacks[1]
        }else if("getConcreteMethodFixedValue".equals(method.getName())){
            return 2;//Callback callbacks[2]
        }
        return 1;
    }
}