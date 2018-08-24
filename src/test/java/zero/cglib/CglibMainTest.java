package zero.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * CglibMainTest
 *
 * @author liuguobin
 * @date 2018/7/30
 */

public class CglibMainTest {
    public static void main(String[] args) {
        // 设置代理类
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(ConcreteClassNoInterface.class);



        /*一个callback filter*/
        // 会在调用代理类的方法的时候，过滤调用方法前要调用的代理方法。
        CallbackFilter filter=new ConcreteClassCallbackFilter();
        enhancer.setCallbackFilter(filter);

        /* 3 个 callback */

        // 方法拦截  回调类
        Callback interceptor=new ConcreteClassInterceptor();//(1)
        // 无操作 回调
        Callback noOp= NoOp.INSTANCE;//(2)
        // 固定值 回调。
        Callback fixedValue=new ConcreteClassFixedValue();//(3)

        // 回调类组。
        Callback[] callbacks=new Callback[]{interceptor,noOp,fixedValue};

        // 设定增强器 的回调组
        enhancer.setCallbacks(callbacks);

        // 创建代理对象
        ConcreteClassNoInterface proxyObject=(ConcreteClassNoInterface)enhancer.create();

        // 调用不同方法，有不同的表现
        System.out.println("*** NoOp Callback ***");
        proxyObject.getConcreteMethodA("abcde");

        System.out.println("*** MethodInterceptor Callback ***");
        final int concreteMethodB = proxyObject.getConcreteMethodB(1);
        System.out.println(concreteMethodB);

        System.out.println("*** FixedValue Callback ***");
        int fixed1=proxyObject.getConcreteMethodFixedValue(128);
        System.out.println("fixedValue1:"+fixed1);


        int fixed2=proxyObject.getConcreteMethodFixedValue(256);
        System.out.println("fixedValue2:"+fixed2);


    }
}
