package A1多线程.B2余麻子案例.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/15 19:13
 * @Description:
 */
public class TestinSynchronizedLocks extends Thread{
    private int count = 0;

    @Override
    public void run(){
        while (true){
            synchronized (this){
                if(count >= 10000){
                    break;
                }
                count++;
                System.out.println(Thread.currentThread().getName() + "," + count);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        TestinSynchronizedLocks locks = new TestinSynchronizedLocks();
        Thread thread1 = new Thread(locks);
        Thread thread2 = new Thread(locks);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        Long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

    }
}
