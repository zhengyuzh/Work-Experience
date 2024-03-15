package A13定时器.B1基本案例.Dem01;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A13定时器.B1基本案例.Dem01
 * @Author: zhengyuzhu
 * @CreateTime: 2024-02-02  10:55
 * @Description: TODO
 * @Version: 1.0
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyScheduledTask implements Runnable {
    @Override
    public void run() {
        System.out.println("1");
        // 在这里添加你的定时任务逻辑
    }

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        // 延迟1秒后执行任务，之后每隔5秒执行一次
        scheduledExecutorService.scheduleAtFixedRate(new MyScheduledTask(), 1, 5, TimeUnit.SECONDS);
    }
}

