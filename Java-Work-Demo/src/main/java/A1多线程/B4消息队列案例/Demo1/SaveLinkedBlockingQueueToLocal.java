package A1多线程.B4消息队列案例.Demo1;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/13 9:27
 * @Description: 直接保存消息队列到本地      后改造该方案 --》 使用sqlLite 数据库存储。使用数据池 然后发送
 *
 * 构造次案例的目的：
 *             1、需求：电子流水上传到V端。
 *             2、前提：前一个方式是担心数据库不能保存队列信息，故将队列保存到集合中，再将集合保存到本地。多了一次转换。
 *             2、步骤：
 *                  在网络故障情况下，流水信息加入到队列中。为了防止机器突然关机。需要将队列
 *                  保存的流水信息缓存到本地保存。同时需要确保，取出来的队列是存入的顺序。
 *             3、 结果：
 *                  本案例验证了 一个队列信息可以直接赋值给另外一个队列（覆盖的形式，同时队列信息顺序保持一致）
 */
public class SaveLinkedBlockingQueueToLocal {
    private static LinkedBlockingQueue<Object> linkedBlockingQueue = null;


    /**
     * 构造函数初始化
     */
    public SaveLinkedBlockingQueueToLocal() {
        linkedBlockingQueue = new LinkedBlockingQueue<Object>();
    }


    /**
     * 生产队列
     */
    public LinkedBlockingQueue ProductQueue() {
        for (int i = 0; i < 10; i++) {
            try {
                String e = String.valueOf(i);
                linkedBlockingQueue.put(e); //1、put 方法，当队列满时，阻塞
                System.out.println("放入元素：" + e);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        System.out.println("===队列深度：" + linkedBlockingQueue.size());
        return linkedBlockingQueue;
    }

    /**
     * 生产队列2
     */
    public LinkedBlockingQueue ProductQueue2() {
        for (int i = 0; i < 5; i++) {
            try {
                String e = String.valueOf(i+10);
                linkedBlockingQueue.put(e); //1、put 方法，当队列满时，阻塞
                System.out.println("放入元素：" + e);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        System.out.println("===队列深度：" + linkedBlockingQueue.size());
        return linkedBlockingQueue;
    }


    public static void main(String[] args) {
        SaveLinkedBlockingQueueToLocal queue = new SaveLinkedBlockingQueueToLocal();
        LinkedBlockingQueue blockingQueue = queue.ProductQueue();
        System.out.println(blockingQueue.toString());

        SaveLinkedBlockingQueueToLocal queue1 = new SaveLinkedBlockingQueueToLocal();
        LinkedBlockingQueue blockingQueue1 = queue1.ProductQueue2();
        System.out.println(blockingQueue1.toString());

        System.out.println("将队列二赋值给队列一");
        blockingQueue = blockingQueue1;
        System.out.println(blockingQueue.toString());

    }

}
