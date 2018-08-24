package zero.cglib;

/**
 * ConcreteClassNoInterface
 *
 * @author liuguobin
 * @date 2018/7/30
 */

public class ConcreteClassNoInterface {
    public String getConcreteMethodA(String str){
        System.out.println("getConcreteMethod A ... "+str);
        return str;
    }
    public int getConcreteMethodB(int n){
        System.out.println("getConcreteMethod B ... "+n);
        return n+10;
    }
    public int getConcreteMethodFixedValue(int n){
        System.out.println("getConcreteMethodFixedValue..."+n);
        return n+10;
    }
}
