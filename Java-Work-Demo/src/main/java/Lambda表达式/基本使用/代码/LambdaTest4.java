package Lambda表达式.基本使用.代码;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/9/25 14:37
 * @Description:
 *              语法：类名::new
 *              注意事项：可以通过接口中的方法的参数， 区分引用不同的构造方法。
 */
public class LambdaTest4 {
    public static void main(String[] args) {
        //lambda表达式实现接口
        GetDog getDog = Dog::new;
        Dog dog = getDog.test();
        System.out.println("无参构造函数:->" + "姓名:" + dog.name + "，年龄:" + dog.age);

        GetDogWithParameter getDogWithParameter = Dog::new;
        Dog dog1 = getDogWithParameter.test("赛虎",11);
        System.out.println("有参构造函数:->" + "姓名:" + dog1.name + "，年龄:" + dog1.age);

    }
}

/**
 * 定义一个函数式接口,用以获取无参的对象
 */
@FunctionalInterface
interface GetDog {
    /**
     * 若此方法仅仅是为了获得一个Dog对象，而且通过无参构造去获取一个Dog对象作为返回值
     *
     * @return
     */
    Dog test();
}

/**
 * 定义一个函数式接口,用以获取有参的对象
 */
@FunctionalInterface
interface GetDogWithParameter {
    /**
     * 若此方法仅仅是为了获得一个Dog对象，而且通过有参构造去获取一个Dog对象作为返回值
     *
     * @param name
     * @param age
     * @return
     */
    Dog test(String name, int age);
}

class Dog {
    String name;
    int age;

    /**
     * 无参构造
     */
    public Dog() {
        System.out.println("一个Dog对象通过无参构造被实例化了");
    }

    /**
     * 有参构造
     *
     * @param name
     * @param age
     */
    public Dog(String name, int age) {
        System.out.println("一个Dog对象通过有参构造被实例化了");
        this.name = name;
        this.age = age;
    }
}
