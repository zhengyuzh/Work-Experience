package A1多线程.B2余麻子案例.Demo1;

import java.lang.ref.SoftReference;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/26 11:39
 * @Description: 软引用：当系统内存充足的时候，不会被回收；当系统内存不足时，它会被回收，软引用通
 *               常用在对内存敏感的 程序中，比如高速缓存就用到软引用，内存够用时就保留，不够时就
 *               回收。
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {

        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println("o1:" + o1);
        System.out.println("软引用对象:"+ softReference.get());
    }
}
