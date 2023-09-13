package 日期相关.日期比较.代码;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/9/12 9:14
 * @Description: 判断时间是否是今天
 */
public class CompareTimeisEquall {

    /**
     * 获取这个格式化类型的日期和时间：
     *
     * 测试结果：交易日期：20230714
     *         交易时间：095356
     */
    public static void testData01(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String jyrq = sdf.format(new Date()); //交易日期
        System.out.println("交易日期："+jyrq);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HHmmss");
        String jysj = simpleDateFormat1.format(new Date()); //交易时间
        System.out.println("交易时间："+jysj);
    }

    /**
     * 获取当前时间  日期：20230912  年:2023  月:9  日:12
     */
    public static void testData02(){
        Date currentDate = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        Calendar calender = Calendar.getInstance();
        calender.setTime(currentDate);
        String currentTime = ft.format(calender.getTime());
        int currentYear = calender.get(Calendar.YEAR);
        int currentMonth = calender.get(Calendar.MONTH)+1;
        int currentDay = calender.get(Calendar.DATE);
        System.out.println("日期：" + currentTime +" " + " 年:" + currentYear + " "
        + " 月:" + currentMonth + " " +" 日:" + currentDay);

    }

    /**
     * 方法一：使用Calendar类
     * 判断两个时间是否为同一天
     * @param date1 时间1
     * @param date2 时间2
     * @return 是否为同一天
     */
    public static boolean isSameDay1(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 方法二：使用SimpleDateFormat类
     * 判断两个时间是否为同一天
     * @param date1 时间1
     * @param date2 时间2
     * @return 是否为同一天
     */
    public static boolean isSameDay2(Date date1, Date date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date1).equals(sdf.format(date2));
    }

    public static void main(String[] args) throws ParseException {
        CompareTimeisEquall.testData02();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");

        Date date1 = sdf.parse("2021-07-01");
        Date date2 = sdf.parse("2021-07-01");
        Date date3 = sdf.parse("2021-07-02");
        Date date4 = sdf1.parse("20230912");
        Date date5 = sdf1.parse("20230912");
        Date date6 = sdf1.parse("20230911");


        // 方法一示例
        System.out.println(isSameDay1(date1, date2)); // true
        System.out.println(isSameDay1(date1, date3)); // false

        // 测试 20230912 类型的日期
        System.out.println(isSameDay1(date4, date5)); // true
        System.out.println(isSameDay1(date5, date6)); // false

        // 方法二示例
        System.out.println(isSameDay2(date1, date2)); // true
        System.out.println(isSameDay2(date1, date3)); // false
    }

}
