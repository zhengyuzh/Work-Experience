package A1多线程.B2余麻子案例.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/26 10:12
 * @Description:
 *
 * ThreadLocal 提供了线程本地变量，它可以保证访问到的变量属于当前线程，每个线程都保
 * 存有一个变量副本，每个线程的变量都不同。ThreadLocal 相当于提供了一种线程隔离，将
 * 变量与线程相绑定。
 * Threadlocal 适用于在多线程的情况下，可以实现传递数据，实现线程隔离。
 * ThreadLocal 提供给我们每个线程缓存局部变量
 *
 * Threadlocal 基本 API
 * 1.New Threadlocal();---创建 Threadlocal
 * 2.set 设置当前线程绑定的局部变量
 * 3.get 获取当前线程绑定的局部变量
 * 4.remove() 移除当前线程绑定的变量
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<String> stringThreadLcal = new ThreadLocal<>();
//        stringThreadLcal.set("hello 666");
//        stringThreadLcal.set("hello 999");
//        stringThreadLcal.remove(); //返回空值 null
//
//        //主线程
//        System.out.println(stringThreadLcal.get());//返回hello 999


        new Thread(new Runnable(){
            @Override
            public void run(){
                stringThreadLcal.set("hello 000");
                System.out.println("子线程：" + stringThreadLcal.get());
            }

        }).start();

        System.out.println("主线程：" + stringThreadLcal.get());
    }



}
