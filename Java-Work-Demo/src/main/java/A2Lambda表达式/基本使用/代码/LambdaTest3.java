package A2Lambda表达式.基本使用.代码;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/9/25 14:04
 * @Description: 函数引用：
 *                     引用⼀个已经存在的方法，使其替代lambda表达式完成接口的实现
 */
public class LambdaTest3 {
    public static void main(String[] args) {
        /**
         * 1、静态方法的引用。
         *       语法：类::静态方法
         *    注意:
         *       在引用的方法后面，不要添加小括号。
         *       引用的这个方法，参数（数量、类型）和返回值，必须要跟接口中定义的⼀致
         */
        TestDemo01 testDemo = NumberTest::numberTest;
        System.out.println(testDemo.test(5, 3));


        /**
         * 2、非静态方法的引用。
         *       语法：对象::非静态方法
         *    注意:
         *       在引用的方法后面，不要添加小括号。
         *       引用的这个方法，参数（数量、类型）和返回值，必须要跟接口中定义的⼀致
         */
        TestDemo02 testDemo2 =new NumberTest()::numberTest02;
        System.out.println(testDemo2.test(5, 3,2));


    }
}
class NumberTest{
    /**
     * 静态方法
     * @param a
     * @param b
     * @return
     */
    public static int numberTest(int a ,int b){
        if(a > b){
            return a -b;
        }else{
            return b -a ;
        }
    }

    /**
     * 非静态方法的引用
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int numberTest02(int a,int b,int c){
        if(a > b && a > c){
            return b + c;
        }else{
            return a + b + c;
        }
    }

}

interface TestDemo01{
    int test(int a,int b);
}

interface TestDemo02{
    int test(int a,int b,int c);
}
