package A9设计模式.B3创建型模式.C1单例模式.代码.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/27 13:30
 * @Description:  1.饿汉模式(比较着急的去创建实例)
 *                2.在定义静态变量的时候实例化单例类，因此在类加载的时候就已经创建了单例对象
 *                3.是不如允许new的
 */
class HungryManSingletonPattern {
    //为了记录这个 LazySingletonPattern 类被实例化的次数 声明一个 static 类型的计数器
    private static int count;
    //使用static创建一个实例,并且立即进行实例化(比较着急)
    private static final HungryManSingletonPattern instance = new HungryManSingletonPattern();

    //为了防止程序员在其他地方不小心的new Singleton,我们把这个构造方法设置为private的不能new
    private HungryManSingletonPattern(){
        System.out.println("LazySingletonPattern 私有的构造方法被实例化 " + (++count) + " 次。");


    }

    //提供方法是在类外能获得到这个实例
    public static HungryManSingletonPattern getInstance(){
        return instance;
    }


}
