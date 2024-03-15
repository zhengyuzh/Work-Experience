package A13定时器.B1基本案例.Dem01;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A13定时器.B1基本案例.Dem01
 * @Author: zhengyuzhu
 * @CreateTime: 2024-02-02  10:53
 * @Description: TODO
 * @Version: 1.0
 */
import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("定时器任务");
        // 在这里添加你的定时任务逻辑
    }

    public static void main(String[] args) {
        Timer timer = new Timer();

        // 延迟1秒后执行任务，之后每隔5秒执行一次
        timer.schedule(new MyTimerTask(), 1000, 5000);
    }
}

