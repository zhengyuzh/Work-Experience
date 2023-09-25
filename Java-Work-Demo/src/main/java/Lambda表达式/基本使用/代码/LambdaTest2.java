package Lambda表达式.基本使用.代码;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/9/25 11:45
 * @Description: 基本语法
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        /**
         *  使用lambda表达式实现接口:
         *      1、无参方法
         *      2、有参 无返回值
         *      3、有参 有返回值
         */

        /**
         * 1、无参方法
         */
        Test01 t1 = () ->{
            System.out.println("我是无参方法");
        };
        t1.test01();

        /**
         * 2、有参 无返回值
         */
        Test02 t2 = (String name,int age) ->{
            System.out.println("我是有参方法：姓名:" + name + ",年龄: " + age);
        };
        t2.test02("张三",18);

        /**
         * 3、有参 有返回值
         */
        Test03 t3 = (name,age) ->{
            int ageAfter = age + 4;
            System.out.println("我是有参 有返回值方法：姓名:" + name + ",年龄: " + age);
            return ageAfter;
        };
        int ageGet = t3.test03("李四",18);
        System.out.println("四年后年龄：" + ageGet);


        /**
         * 精简写法:
         *        1、省略传入参数的类型
         *        2、方法参数列表只有一个，可以省略圆括号
         *        3、当一个方法体中的逻辑，有且只有一句的情况，大括号可以省略
         *        4、如果⼀个方法中唯⼀的⼀条语句是⼀个返回语句， 此时在省略掉大括号的同时， 也必须省略掉return。
         */

        /**
         * 1、省略传入参数的类型
         */
        Test02 t21 = (name,age) ->{
            System.out.println("我是有参方法：姓名:" + name + ",年龄: " + age);
        };
        t21.test02("张三",18);

        /**
         * 2、方法参数列表只有一个，可以省略圆括号
         */
        Test04 t4 = age ->{
            System.out.println("年龄是:" + age);
            return age + 1;
        };
        t4.test04(18);

        /**
         * 3、方法体只有一句的情况，大括号可以省略
         */
        Test02 t22 = (String name,int age) -> System.out.println("我是有参方法：姓名:" + name + ",年龄: " + age);
        t22.test02("张三",18);

        /**
         * 4、如果⼀个方法中唯⼀的⼀条语句是⼀个返回语句， 此时在省略掉大括号的同时， 也必须省略掉return。
         */
        Test04 t41 = age -> age + 1;
        int ageGet1 = t41.test04(18);
        System.out.println("精简写法,年龄加1:" + ageGet1);


    }
}

/**
 * 无参
 */
@FunctionalInterface
interface Test01{
    public void test01();
}

/**
 * 有参 无返回值
 */
@FunctionalInterface
interface Test02{
    public void test02(String name,int age);
}

/**
 * 有参 有返回值
 */
@FunctionalInterface
interface Test03{
    public int test03(String name,int age);
}

/**
 * 只有一个参数
 */
@FunctionalInterface
interface Test04{
    public int test04(int age);

}