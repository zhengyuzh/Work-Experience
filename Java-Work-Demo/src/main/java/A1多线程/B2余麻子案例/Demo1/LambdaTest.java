package A1多线程.B2余麻子案例.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/27 15:17
 * @Description:
 */
public class LambdaTest {


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("创建多线程 ");
            }
        };

        Runnable runnable1 = () -> {
            System.out.println("lambdad方式创建多线程");
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread1 = new Thread(runnable1);
        thread1.start();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("简化创建多线程2");
                    }
                }
        ).start();


        new Thread(()->{
            System.out.println("简化创建多线程3");
        }).start();

    }
}
