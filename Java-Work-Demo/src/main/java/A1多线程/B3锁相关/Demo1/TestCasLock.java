package A1多线程.B3锁相关.Demo1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/17 14:15
 * @Description: 利用CAS自旋锁，乐观锁。实现计数。
 *                            悲观锁：synchronized
 *                            路径参考案例: 多线程相关/TestinSynchronizedLocks.java
 */
public class TestCasLock extends Thread{
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run(){
        while (atomicInteger.get() <= 10000){
            // getAndIncrement 0+1 i++ 利用cas  保证线程安全问题
            int i = atomicInteger.getAndIncrement();
            System.out.println(Thread.currentThread().getName() + "," + i);
        }
    }

    public static void main(String[] args) {
        TestCasLock testCasLock1 = new TestCasLock();
        TestCasLock testCasLock2 = new TestCasLock();
        testCasLock1.start();
        testCasLock2.start();
    }
}
