package A9设计模式.B3创建型模式.C1单例模式.代码.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/27 13:58
 * @Description: 测试 懒汉模式
 */
public class LazySingletonPatternTest {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            LazySingletonPatternTest.testRun();
        }


    }

    /**
     * 开启线程
     */
    public static void testRun() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                    LazySingletonPattern L1 = LazySingletonPattern.getInstance();
                    System.out.println("当前线程:" + Thread.currentThread().getName() + " , 执行:" );
                }


        }).start();
    }

    /**
     *  输出如下：
     *
     * LazySingletonPattern 私有的构造方法被实例化 3 次。
     * LazySingletonPattern 私有的构造方法被实例化 14 次。
     * LazySingletonPattern 私有的构造方法被实例化 1 次。
     * LazySingletonPattern 私有的构造方法被实例化 6 次。
     * 当前线程:Thread-22 , 执行:
     * LazySingletonPattern 私有的构造方法被实例化 12 次。
     * LazySingletonPattern 私有的构造方法被实例化 13 次。
     * 当前线程:Thread-1 , 执行:
     * 当前线程:Thread-21 , 执行:
     * LazySingletonPattern 私有的构造方法被实例化 2 次。
     * LazySingletonPattern 私有的构造方法被实例化 5 次。
     * LazySingletonPattern 私有的构造方法被实例化 8 次。
     * LazySingletonPattern 私有的构造方法被实例化 11 次。
     * 当前线程:Thread-26 , 执行:
     * LazySingletonPattern 私有的构造方法被实例化 1 次。
     * LazySingletonPattern 私有的构造方法被实例化 10 次。
     * LazySingletonPattern 私有的构造方法被实例化 7 次。
     * LazySingletonPattern 私有的构造方法被实例化 4 次。
     * 当前线程:Thread-25 , 执行:
     * 当前线程:Thread-33 , 执行:
     * LazySingletonPattern 私有的构造方法被实例化 9 次。
     * 当前线程:Thread-31 , 执行:
     * 当前线程:Thread-5 , 执行:
     * 当前线程:Thread-30 , 执行:
     * 当前线程:Thread-4 , 执行:
     * 当前线程:Thread-9 , 执行:
     * 当前线程:Thread-28 , 执行:
     * 当前线程:Thread-6 , 执行:
     * 当前线程:Thread-23 , 执行:
     * 当前线程:Thread-12 , 执行:
     * 当前线程:Thread-27 , 执行:
     * 当前线程:Thread-3 , 执行:
     * 当前线程:Thread-14 , 执行:
     * 当前线程:Thread-24 , 执行:
     * 当前线程:Thread-8 , 执行:
     * 当前线程:Thread-16 , 执行:
     * 略
     *
     *
     *
     **/


}
