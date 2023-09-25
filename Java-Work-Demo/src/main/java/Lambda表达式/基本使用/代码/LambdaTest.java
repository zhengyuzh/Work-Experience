package Lambda表达式.基本使用.代码;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/9/25 11:36
 * @Description: 关于接口实现，可以有很多种方式来实现。
 *               例如：设计接口的实现类、使用匿名内部类。 但是lambda表达式，比这两种方式都简单。
 */
public class LambdaTest {
    public static void main(String[] args) {

        /**
         *  使用lambda表达式实现接口
         */
        TestDemo testDemo = () ->{
            System.out.println("test");
        };

        testDemo.test();

    }

}

@FunctionalInterface
interface TestDemo{
    /**
     * 测试方法
     */
    public void test();

}
