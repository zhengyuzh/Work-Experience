package A1多线程.B3锁相关.Demo1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/16 20:31
 * @Description:
 *              ReentrantLock是一个可重入的互斥锁，又被称为“独占锁”。
 *              ReentrantLock锁在同一个时间点只能被一个线程锁持有；可重入表示，ReentrantLock锁可以被同一个线程多次获取。
 *              ReentraantLock是通过一个FIFO的等待队列来管理获取该锁所有线程的。在“公平锁”的机制下，线程依次排队获取锁；
 *                            而“非公平锁”在锁是可获取状态时，不管自己是不是在队列的开头都会获取锁。
 *              公平锁：new ReentrantLock(true);  //结果 按照顺序打印
 *              非公平锁：new ReentrantLock(false); //结果 没有顺序

 */
public class TestReentramtLock {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            new Thread(()->{
                try{
                    reentrantLock.lock();
                    System.out.println(Thread.currentThread().getName()+ "打印: "+ finalI );
                }catch (Exception ex){
                    System.out.println("异常是:" + ex);
                }finally {
                    if(reentrantLock != null){
                        reentrantLock.unlock();;
                    }
                }

            }).start();
        }
    }

}
