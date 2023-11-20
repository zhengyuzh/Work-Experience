package A9设计模式.B3创建型模式.C1单例模式.代码.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/27 14:28
 * @Description: 如果多个线程同时操作volatile变量，那么对该变量的写操作必须在读操作之前执行(禁止重排序)，
 *               并且写操作的结果对读操作可见（强缓存一致性）
 *               用volatile声明的变量总是能够在多线程中依旧保持其可见性
 */
public class LazySingletonPatternUpdate {

    //为了记录这个 LazySingletonPattern 类被实例化的次数 声明一个 static 类型的计数器
    private static int count;

    //不是立即初始化实例 把"唯一的"对象保存在单例类的属性里
    private volatile static  LazySingletonPatternUpdate instance = null;

    //构造器私有化,不能在类的外部随意创建对象
    private LazySingletonPatternUpdate(){
        System.out.println("LazySingletonPatternUpdate 私有的构造方法被实例化 " + (++count) + " 次。");
    }


    /**
     *      提供一个全局的访问点来获得这个"唯一"的对象
     *      请注意,这样的代码再多线程环境下是有问题的
     *      很可能 instance = new Singleton(); 会被执行多次
     *      我们可以模拟多线程环境来检验我们的猜想
     */
    public static LazySingletonPatternUpdate getInstance(){
        //第一重判断
        if(instance == null){
            //锁定代码块
            synchronized (LazySingletonPatternUpdate.class){
                //第二重判断
                if(instance == null){
                    instance = new LazySingletonPatternUpdate();//只有用到的时候才去创建
                }
            }
        }
        return instance;
    }
}
