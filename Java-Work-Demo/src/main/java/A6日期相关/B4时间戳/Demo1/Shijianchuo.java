package A6日期相关.B4时间戳.Demo1;

import org.junit.Test;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A6日期相关.B4时间戳.Demo1
 * @Author: zhengyuzhu
 * @CreateTime: 2024-01-05  23:59
 * @Description: TODO
 * @Version: 1.0
 */
public class Shijianchuo {


    @Test
    public void test(){
        Date timestamp1 = new Date();
        Date timestamp2 = new Date(System.currentTimeMillis() + 3600 * 1000);

        Instant instant1 = timestamp1.toInstant();
        Instant instant2 = timestamp2.toInstant();

        Duration duration = Duration.between(instant1, instant2);

        long seconds = duration.getSeconds();

        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long remainingSeconds = seconds % 60;

        String formattedTime = String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);

        System.out.println("时间差为：" + formattedTime);
    }


}
