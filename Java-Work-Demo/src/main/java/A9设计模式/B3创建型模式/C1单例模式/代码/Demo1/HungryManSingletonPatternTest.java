package A9设计模式.B3创建型模式.C1单例模式.代码.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/27 13:48
 * @Description:
 */
public class HungryManSingletonPatternTest {
    public static void main(String[] args) {
        HungryManSingletonPattern h1 = HungryManSingletonPattern.getInstance();
        HungryManSingletonPattern h2 = HungryManSingletonPattern.getInstance();
        HungryManSingletonPattern h3 = HungryManSingletonPattern.getInstance();
        if(h1 == h2 && h1 == h3 && h2 == h3){
            System.out.println("创建的对象是同一个");
        }
        //不可以访问的
//        HungryManSingletonPattern h4 = new HungryManSingletonPattern();

        for (int i = 0; i < 10000; i++) {
            HungryManSingletonPatternTest.testRun();
        }

    }

    public static void testRun(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HungryManSingletonPattern L1 = HungryManSingletonPattern.getInstance();
                System.out.println("当前线程:" + Thread.currentThread().getName() + " , 执行:" );

            }
        }).start();
    }

    /**
     *  输出如下：
     *
     * LazySingletonPattern 私有的构造方法被实例化 1 次。
     * 创建的对象是同一个
     * 当前线程:Thread-0 , 执行:
     * 当前线程:Thread-2 , 执行:
     * 当前线程:Thread-1 , 执行:
     * 当前线程:Thread-3 , 执行:
     * 当前线程:Thread-4 , 执行:
     * 当前线程:Thread-5 , 执行:
     * 当前线程:Thread-6 , 执行:
     * 当前线程:Thread-7 , 执行:
     * 当前线程:Thread-8 , 执行:
     * 当前线程:Thread-9 , 执行:
     * 当前线程:Thread-10 , 执行:
     * 当前线程:Thread-11 , 执行:
     * 当前线程:Thread-12 , 执行:
     * 当前线程:Thread-13 , 执行:
     * 当前线程:Thread-14 , 执行:
     * 当前线程:Thread-15 , 执行:
     * 当前线程:Thread-16 , 执行:
     * 当前线程:Thread-17 , 执行:
     * 当前线程:Thread-18 , 执行:
     * 当前线程:Thread-19 , 执行:
     * 略
     *
     *
     *
     *
     **/


}
