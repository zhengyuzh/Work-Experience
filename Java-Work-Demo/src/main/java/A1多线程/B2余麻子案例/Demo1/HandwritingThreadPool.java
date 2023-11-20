package A1多线程.B2余麻子案例.Demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/14 9:44
 * @Description: 手写线程池
 *
 *    线程池核心点 ：复用机制 -----
 *    1、提前创建好固定的线程一直在运行状态----死循环实现
 *    2、提交的线程任务缓存到一个并发队列集合中，交给我们正在运行的线程执行
 *    3、正在运行的线程就从队列中获取该任务执行
 */
public class HandwritingThreadPool {
    private List<WorkThread> workThread; //工作线程
    private BlockingDeque<Runnable> runnableDeque; //队列
    private Boolean isRun = true;

    /**
     *
     * @param maxThreadCount 最大线程数
     * @param dequeSize      缓存消息队列
     */
    public HandwritingThreadPool(int maxThreadCount,int dequeSize){
        //2、限制队列容量缓存
        runnableDeque = new LinkedBlockingDeque<Runnable>(dequeSize);
        //1、提前创建好固定的线程一直在运行状态---死循环实现
        workThread = new ArrayList<WorkThread>(maxThreadCount);
        for (int i = 0; i < maxThreadCount; i++) {
            new WorkThread().start();
        }

    }

    class WorkThread extends Thread{
        @Override
        public void run() {
            while (isRun || runnableDeque.size()>0){
                Runnable runnable = runnableDeque.poll();
                if(runnable != null){
                    runnable.run();
                }
            }
        }
    }

    /**
     * 线程任务缓存到一个并发队列集合
     * @param command
     * @return
     */
    public boolean execute(Runnable command){
        return runnableDeque.offer(command);
    }

    public static void main(String[] args) {
        HandwritingThreadPool testExecutors = new HandwritingThreadPool(2, 2);
        for (int i = 0; i < 10; i++) {
            final int finalI = i+1;
            testExecutors.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+","+finalI);
                }
            });
        }
        testExecutors.isRun = false;
    }
}
