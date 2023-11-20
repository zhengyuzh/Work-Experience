package A1多线程.B4消息队列案例.Demo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/14 9:22
 * @Description: 队列转换为集合，集合抓换为队列
 *
 *              构造次案例的目的：测试消息队列保存到集合中，然后将集合存储到本地。（不确定能否直接将队列保存到本地）
 *              结果：可以将队列转账为集合，集合也可以转换成队列
 *
 */
public class TestSaveQueByArrayList {
    private static LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue<Object>();
    List list = new ArrayList();

    /**
     * 生产队列
     */
    public LinkedBlockingQueue ProductQueue() {
        /**
         * 1、put 方法，当队列满时，阻塞
         */
        for (int i = 0; i < 10; i++) {
            try {
                String e = String.valueOf(i);
                linkedBlockingQueue.put(e);
                System.out.println("放入元素：" + e);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        System.out.println("队列深度：" + linkedBlockingQueue.size());
        return linkedBlockingQueue;
    }

    /**
     * 打印队列
     */
    public void PrintQueue(LinkedBlockingQueue queue) {
        //take 方法，当队列为空，阻塞
        for (int i = 0; i < 10; i++) {
            Object e = null;
            try {
                e = queue.take();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.out.println("取出元素：" + e);
        }
    }

    /**
     * 将队列消息放入List集合中保存
     * @param queue
     */
    public List QueueTransArray(LinkedBlockingQueue queue) {
        List list1 = new ArrayList();
        try {
            for (int i = queue.size(); i > 0; --i) {
                Object take = queue.take();
                if (take != null) {
                    //将队列消息放入集合中
                    System.out.println("队列信息放入集合："+take.toString());
                    list1.add(take);
                }
            }

        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        return list1;
    }

    /**
     * 遍历集合数据
     * @param list
     */
    public void PrintArrayList(List list){
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println("遍历集合数据：" + listIterator.next());
        }

    }


    /**
     * 集合数据放入队列
     * @param arrayList
     * @return
     */
    public LinkedBlockingQueue ArrayTransQueue(List arrayList){
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            try{
                linkedBlockingQueue.put(listIterator.next());
            }catch (InterruptedException ex){
                System.out.println(ex);
            }

        }
        return linkedBlockingQueue;

    }

    public static void main(String[] args) {
        TestSaveQueByArrayList test = new TestSaveQueByArrayList();

        List array = Collections.singletonList("[]");
        System.out.println(array.size());

        System.out.println("1、生产队列消息");
        LinkedBlockingQueue queue1 =  test.ProductQueue();

//        System.out.println("2、查看生成的队列");
//        test.PrintQueue(queue1);

        System.out.println("3、队列信息保存到集合中");
        List list1 = test.QueueTransArray(queue1);

        System.out.println("4、将集合中的数据打印：");
        test.PrintArrayList(list1);

        System.out.println("5、查看集合数据放入队列中，打印转换的队列信息：");
        LinkedBlockingQueue queue2 = test.ArrayTransQueue(list1);
        test.PrintQueue(queue2);


    }

    /**
     *
     *  输出结果如下：
     * 1
     * 1、生产队列消息
     * 放入元素：0
     * 放入元素：1
     * 放入元素：2
     * 放入元素：3
     * 放入元素：4
     * 放入元素：5
     * 放入元素：6
     * 放入元素：7
     * 放入元素：8
     * 放入元素：9
     * 队列深度：10
     * 3、队列信息保存到集合中
     * 队列信息放入集合：0
     * 队列信息放入集合：1
     * 队列信息放入集合：2
     * 队列信息放入集合：3
     * 队列信息放入集合：4
     * 队列信息放入集合：5
     * 队列信息放入集合：6
     * 队列信息放入集合：7
     * 队列信息放入集合：8
     * 队列信息放入集合：9
     * 4、将集合中的数据打印：
     * 遍历集合数据：0
     * 遍历集合数据：1
     * 遍历集合数据：2
     * 遍历集合数据：3
     * 遍历集合数据：4
     * 遍历集合数据：5
     * 遍历集合数据：6
     * 遍历集合数据：7
     * 遍历集合数据：8
     * 遍历集合数据：9
     * 5、查看集合数据放入队列中，打印转换的队列信息：
     * 取出元素：0
     * 取出元素：1
     * 取出元素：2
     * 取出元素：3
     * 取出元素：4
     * 取出元素：5
     * 取出元素：6
     * 取出元素：7
     * 取出元素：8
     * 取出元素：9
     *
     *
     *
     *
     *
     *
     *
     **/

}
