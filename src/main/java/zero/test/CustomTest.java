package zero.test;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Custom test
 *
 * @author liuguobin
 * @date 2017/10/19
 */

public class CustomTest extends AbstractTest {

    @Test
    public void test() {
        List<String> pathElements = new LinkedList<>();
        pathElements.add("1");
        pathElements.add("2");
        pathElements.add(0, "3");
        logger.info(pathElements.toString());
    }

    @Test
    public void testSpecial() {
        int i = 1 << 30; // int 的最大长度
        int j = i + 1+1;
        logger.info(i);
        logger.info(j);
    }


    @Test
    public void testPrimitive() {
        System.out.println(float[].class.getName());
        System.out.println(Float[].class.getName());
        System.out.println(String.class.getName());
        System.out.println(String[].class.getName());
        System.out.println(String[][].class.getName());

    }
}
