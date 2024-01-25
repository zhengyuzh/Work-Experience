package A6日期相关.B3日期格式化.Demo1;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A6日期相关.B3日期格式化.Demo1
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-20  14:49
 * @Description: TODO
 * @Version: 1.0
 */
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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


    @Test
    public void test1(){
        long times = Calendar.getInstance().getTimeInMillis();       //毫秒级
        System.out.println(times);
    }

    /**
     * @description: 组合文件名称
     * @author: zhengyuzhu
     * @date: 2023/12/22 16:09
     **/
    @Test
    public void test2(){
        String machineNo = "0571XCKB";
        String batch_no = "2312121";
        String batch_no_splic = batch_no.substring(0,6);
        String bastPath ="/sdcard/grgbanking/iterminal/cmbAgent/fileTmpSend/";
        System.out.println(batch_no_splic);
        long times = Calendar.getInstance().getTimeInMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String jyrq = sdf.format(new Date()); //交易日期
        String jyrqSplic = jyrq.substring(0,2);
        String nums =bastPath+ machineNo +"_"  + jyrqSplic + batch_no_splic + "." + times +".gz";
        System.out.println(nums);



        String packNameBefore = machineNo +"_" +batch_no + "." + times +".gz";
        System.out.println(packNameBefore);
    }
}

