package A9设计模式.B3创建型模式.C1单例模式.代码.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/27 14:32
 * @Description:
 */
public class LazySingletonPatternUpdateTest {
    public static void main(String[] args) {
        for (int i = 0; i < 8000; i++) {
            LazySingletonPatternUpdateTest.testrun();
        }

    }

    private static void testrun(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingletonPatternUpdate L1 = LazySingletonPatternUpdate.getInstance();
                System.out.println("当前线程:" + Thread.currentThread().getName() + " , 执行:" );

            }
        }).start();

    }

    /**
     *
     *  输出如下：
     *
     * LazySingletonPatternUpdate 私有的构造方法被实例化 1 次。
     * 当前线程:Thread-7 , 执行:
     * 当前线程:Thread-6 , 执行:
     * 当前线程:Thread-0 , 执行:
     * 当前线程:Thread-13 , 执行:
     * 当前线程:Thread-15 , 执行:
     * 当前线程:Thread-10 , 执行:
     * 当前线程:Thread-9 , 执行:
     * 当前线程:Thread-8 , 执行:
     * 当前线程:Thread-25 , 执行:
     * 当前线程:Thread-4 , 执行:
     * 当前线程:Thread-2 , 执行:
     * 当前线程:Thread-21 , 执行:
     * 当前线程:Thread-1 , 执行:
     * 当前线程:Thread-11 , 执行:
     * 当前线程:Thread-3 , 执行:
     * 当前线程:Thread-23 , 执行:
     * 当前线程:Thread-30 , 执行:
     * 当前线程:Thread-20 , 执行:
     * 当前线程:Thread-27 , 执行:
     * 当前线程:Thread-22 , 执行:
     *
     *
     *
     *
     **/
}
