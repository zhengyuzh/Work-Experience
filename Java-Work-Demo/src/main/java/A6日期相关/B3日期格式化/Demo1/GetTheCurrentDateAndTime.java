package A6日期相关.B3日期格式化.Demo1;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A6日期相关.B3日期格式化.Demo1
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-20  14:49
 * @Description: TODO
 * @Version: 1.0
 */
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/14 9:51
 * @Description: 获取当前日期和时间
 */
public class GetTheCurrentDateAndTime {

    /**
     * 获取这个格式化类型的日期和时间： 可以根据格式化的方式 来获取不同格式的时间
     *      yyyyMMdd             ->    20231120
     *      HHmmss               ->    145504
     *      yyyy-MM-dd HH:mm:ss  ->    2023-11-20 14:55:04
     *      yyyy/MM/dd HH:mm:ss  ->    2023/11/20 14:55:04
     *
     * 测试结果：交易日期：20231120
     *         交易时间：145025
     *         交易完整时间：2023-11-20 14:52:42
     *         交易完整时间：2023/11/20 14:55:04
     */
    public static void testData01(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String jyrq = simpleDateFormat.format(new Date()); //交易日期
        System.out.println("交易日期：" + jyrq);

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HHmmss");
        String jysj = simpleDateFormat1.format(new Date()); //交易时间
        System.out.println("交易时间：" + jysj);

        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = simpleDateFormat2.format(new Date()); //交易时间
        System.out.println("交易完整时间：" + data);

        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String data1 = simpleDateFormat3.format(new Date()); //交易时间
        System.out.println("交易完整时间：" + data1);
    }

    public static void main(String[] args) {
        // 测试获取 交易日期：20231120  交易时间：145504 类型的时间格式
        GetTheCurrentDateAndTime.testData01();

    }
}

