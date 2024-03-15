package A6日期相关.B3日期格式化.Demo1;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A6日期相关.B3日期格式化.Demo1
 * @Author: zhengyuzhu
 * @CreateTime: 2024-02-24  15:43
 * @Description: TODO
 * @Version: 1.0
 */
public class addMonth {

    @Test
    public void Demo(){
        // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        Date date = new Date();
        System.out.println(df.format(date));   // 当前系统时间
        Date newDate = stepMonth(date, 1);
        System.out.println("当前时间前1个月的日期：" + df.format(newDate));
    }

    @Test
    public void Demo2() throws ParseException {
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        String data = simpleDateFormat2.format(new Date());
        System.out.println(data);
        Date startDate = simpleDateFormat2.parse(data);
        System.out.println(startDate);

        Date date = new Date();
        Date endDateTrans = stepMonth(date, 2);

        String endData = simpleDateFormat2.format(endDateTrans);
        System.out.println(endData);
        Date endDate = simpleDateFormat2.parse(endData);
        System.out.println(endDate);

        //是否超限判断
        System.out.println("时间先后" + endDate.after(startDate));

    }




    public static Date stepMonth(Date sourceDate, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(sourceDate);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }


    @Test
    public void test(){
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date star = dft.parse("2024-02-25");//开始时间
            Date endDay=dft.parse("2024-02-29");//结束时间
            Long starTime=star.getTime();
            Long endTime=endDay.getTime();
            Long num=endTime-starTime;//时间戳相差的毫秒数
            System.out.println("相差天数为："+num/24/60/60/1000);//除以一天的毫秒数
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
