package A1多线程.B3锁相关.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/17 21:16
 * @Description:
 */

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 演示 aba 的问题
 * （1）第一个参数 expectedReference：表示预期值。
 * （2）第二个参数 newReference：表示要更新的值。
 * （3）第三个参数 expectedStamp：表示预期的时间戳。
 * （4）第四个参数 newStamp：表示要更新的时间戳。
 */
public class AtomicMarkableReferenceTest {

    /**
     *    注意：如果引用类型是 Long、Integer、Short、Byte、Character 一定一定要注意值的缓存区间！
     *
     *    比如 Long、Integer、Short、Byte 缓存区间是在-128~127，会直接存在常量池中，而不在这个区间内对象的值
     *    则会每次都 new 一个对象，那么即使两个对象的值相同，CAS 方法都会返回 false
     *
     *   先声明初始值，修改后的值和临时的值是为了保证使用 CAS 方法不会因为对象不一样而返回 false
     */
    private static final Integer INIT_NUM = 1000;
    private static final Integer UPDATE_NUM = 100;
    private static final Integer TEM_NUM = 200;
    private static AtomicStampedReference atomicStampedReference = new
            AtomicStampedReference(INIT_NUM, 1);

    public static void main(String[] args) {
        new Thread(() -> {
            Integer value = (Integer) atomicStampedReference.getReference();
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + " : 当前值为：" + value + " 版本号为：" +
                    stamp);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // value 旧值 内存中的值 UPDATE_NUM 修改的值
            if (atomicStampedReference.compareAndSet(value, UPDATE_NUM, 0, stamp + 1)) {
                System.out.println(Thread.currentThread().getName() + " : 当前值为：" + atomicStampedReference.getReference() + " 版本号为：" + atomicStampedReference.getStamp());
            } else {
                System.out.println("版本号不同，更新失败！");
            }
        }, "线程 A").start();
    }
}