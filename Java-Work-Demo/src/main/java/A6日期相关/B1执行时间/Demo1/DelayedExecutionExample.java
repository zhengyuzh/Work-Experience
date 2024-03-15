package A6日期相关.B1执行时间.Demo1;

import org.junit.Test;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A6日期相关.B1执行时间.Demo1
 * @Author: zhengyuzhu
 * @CreateTime: 2024-02-27  14:27
 * @Description: TODO
 * @Version: 1.0
 */
public class DelayedExecutionExample {


    /**
     * @description: 延时处理
     * @author: zhengyuzhu
     * @date: 2024/2/27 14:27
     **/
    @Test
    public void Demo(){
        System.out.println("开始执行任务");

        try {
            // 在这里设置延时时间，单位是毫秒
            long delayMillis = 5000;

            // 使用 Thread.sleep 实现延时
            Thread.sleep(delayMillis);

            // 在延时后执行的任务
            System.out.println("延时任务执行了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("任务执行完成");
    }


    @Test
    public void Demo2(){
        for(int i = 0; i< 3; i++){
            Demo();
        }
    }



    @Test
    public void Demo3(){
        String TRCD = "M050";
        String TRCDS = "M000";

        if(TRCD != TRCDS) {
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
