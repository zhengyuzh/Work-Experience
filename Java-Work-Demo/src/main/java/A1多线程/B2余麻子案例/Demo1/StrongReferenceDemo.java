package A1多线程.B2余麻子案例.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/26 11:36
 * @Description: 强引用： 当内存不足时，JVM 开始进行 GC(垃圾回收)，对于强引用对象，就算是出现了
 *               OOM 也不会对该对象进行回收，死都不会收。
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        //定义一个强引用
        Object o1 = new Object();

        //o2 引用赋值
        Object o2 = o1;
        o1 = null;
        System.gc();
        System.out.println("o1的值：" + o1);
        System.out.println("o2的值：" + o2);
    }
}
