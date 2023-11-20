package A1多线程.B3锁相关.Demo1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/17 14:57
 * @Description:
 *          CAS 原理:
 *                 CAS: Compare and Swap，翻译成比较并交换。 执行函数 CAS（V，E,N）
 *                 CAS 有 3 个操作数，内存值 V，旧的预期值 E，要修改的新值 N。当且仅当预期值 E 和内
 *                 存值 V 相同时，将内存值 V 修改为 N
 */
public class CasPrinciple {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        /**
         *  V=共享变量 = 0
         *  线程1 ---- E = 每个线程都会缓存副本V的值 ---- 旧的预期值  E = 0 , N = 1
         *  线程2 ---- E = 每个线程都会缓存副本V的值 ---- 旧的预期值  E = 0 , N = 2
         *
         *  cas成功则需要 V （共享变量值） == E (线程中内存缓存的值)，cas修改成功将 N 赋值给我们的V
         */
        boolean b1 = atomicInteger.compareAndSet(0,1);
        boolean b2 = atomicInteger.compareAndSet(0,1);
        System.out.println(b1 + "..." + atomicInteger.get());
        System.out.println(b2 + "..." + atomicInteger.get());

    }
}
