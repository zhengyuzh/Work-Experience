package A1多线程.B2余麻子案例.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/27 15:29
 * @Description:
 *              join()方法:
 *                     1.能把指定的线程加入到当前线程，
 *                     2.可以将两个交替执行的线程合并为顺序执行的线程，
 *                     3.让指定的线程先执行完。
 */
public class JoinTest {
    public static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            for (int k = 0; k < 5; k++) {
                a = a + 1;
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();//先执行thread线程，执行完这个线程后，a的值是5

        /**
         * 假如主线程的main方法就执行System.out.println(a)方法之前，做了一个较耗时的操作导致不能瞬间输出。
         * 这就为子线程执行创造了条件，这时就有可能输出5。比如，在编号①处添加代码Thread.sleep(3000);,
         * 就能达到目的。
         */
//        Thread.sleep(3000);
        System.out.println("查看当前线程:"+ Thread.currentThread().getName() + ",查看a的值" + a);
    }

}
