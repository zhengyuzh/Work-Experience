package A1多线程.B3锁相关.Demo1;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/17 15:09
 * @Description: 使用CAS实现一把锁
 *               测试
 *                  1、上锁不使用循环实现
 *                     1)：获取锁、释放锁, 结果有些获取成功，有些获取失败
 *                     2)：获取锁，不释放锁  结果：只有一个线程获取锁成功，其它都失败
 *                  2、上锁使用循环实现
 *                     1) 获取锁、释放锁, 全部成功。
 *                     2) 获取锁，不释放锁， 结果：只有一个线程获取成功，其它线程一直循环等待。CPU飙高
 */
public class UsingCasHandwritingLock {
    private AtomicLong cas = new AtomicLong(0);
    private Thread lockCurrentThread;

    /**
     * 获取锁
     * 锁是有状态的
     * 0 --- 表示没有人持有该锁
     * 1 --- 表示该锁已经被线程持有
     * 获取成功：cas 0变为1 cas = true
     * 获取锁失败 cas false
     */
    public Boolean tryLock() {
        boolean result = cas.compareAndSet(0, 1);
        return result;
    }

    /**
     *：优点：没有获取到锁的线程，会一直在用户态，不会阻塞，没有锁的线程会一直通过循环控制重试。
     * 缺点：通过死循环控制，消耗 cpu 资源比较高，需要控制循次数，避免 cpu 飙高问题；
     * @return
     */
//    public Boolean tryLock(){
//        while (true){
//            System.out.println(Thread.currentThread().getName() + ",CAS");
//            boolean result = cas.compareAndSet(0,1);
//            if(result){
//                lockCurrentThread = Thread.currentThread();
//                return true;
//            }
//        }
//    }

    /**
     * 释放锁
     */
    public Boolean unLock() {
        if (lockCurrentThread != Thread.currentThread()) {
            return false;
        }
        return cas.compareAndSet(1, 0);

    }

    public static void main(String[] args) {
        UsingCasHandwritingLock lock = new UsingCasHandwritingLock();
        IntStream.range(1, 10).forEach((i) -> new Thread(() -> {
            try {
                boolean result = lock.tryLock();
                if (result) {
                    lock.lockCurrentThread = Thread.currentThread();
                    System.out.println(Thread.currentThread().getName() + ",获取锁成功~~~");
                } else {
                    System.out.println(Thread.currentThread().getName() + ",获取锁失败~~~");
                }

            } catch (Exception ex) {

            } finally {
                if (lock != null) {
                    lock.unLock();
                }

            }
        }).start());
    }
}
