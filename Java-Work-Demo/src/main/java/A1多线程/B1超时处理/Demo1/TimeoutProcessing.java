package A1多线程.B1超时处理.Demo1;

import org.apache.log4j.Logger;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/14 9:52
 * @Description: 有些方法的执行 比较费时。执行时间 超过指定时间的时候 主动结束
 */
public class TimeoutProcessing {
    static final Logger log = Logger.getLogger(TimeoutProcessing.class); //创建日志对象 Logger

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String result = timeoutMethod();
        log.info("方法实际耗时：" + (System.currentTimeMillis() - start) + "毫秒");
        log.info("结果：" + result);

        try {
            Thread.sleep(3000);
            long start1 = System.currentTimeMillis();
            String result1 = timeoutMethod();
            log.info("方法实际耗时：" + (System.currentTimeMillis() - start1) + "毫秒");
            log.info("结果：" + result1);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * 有超时时间的方法
     * @param
     * @return
     */
    private static String timeoutMethod() {
        String result = "默认";
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return unknowMethod();
            }
        });

        executorService.execute(futureTask);
        try {
            result = futureTask.get(3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            futureTask.cancel(true);
            result = "调用方法超时了，返回默认的结果";
        }

        return result;
    }

    /**
     * 这个方法的耗时不确定
     * @return
     */
    private static String unknowMethod() {
        // Random random = new Random();
        // int time = (random.nextInt(10) + 1) * 1000;
        // log.info("任务将耗时： " + time + "毫秒");
        try {
            Thread.sleep(8000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "获得方法执行后的返回值";
    }



}
