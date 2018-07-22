package zero.test;

/**
 * 包含所有的属性？
 *
 * @author liuguobin
 * @date 2018/7/18
 */

public class AllAttribute {
    int a;
    private String b;

    public static AllAttribute factoryMethod() {
        final AllAttribute allAttribute = new AllAttribute();
        allAttribute.a = 2222;
        return allAttribute;
    }


    void init() {
        System.out.println("init");
        a = 10;
    }

    void destroy() {
        System.out.println("destroy");
        a = -9999;
    }
    void sayHi() {
        System.out.println( "allAttribute say hi");
    }


    public App returnApp() {
        return null;
    }


    public void beReplace() {
        System.out.println("be replace");
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getB() {
        return b;
    }
}
