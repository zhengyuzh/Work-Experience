package A4字符串转换.B2字符串分割.代码.Demo;

import org.junit.Test;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/7 10:41
 * @Description:
 */
public class TestSplitAndSubString {

    /**
     * String[] split(String regex):
     *          根据给定的正则表达式的匹配拆分此字符串（返回一个数组）
     * String[] split(String regex,int limit):
     *          根据匹配给定的正则表达式来拆分此字符串（返回一个数组）
     */
    @Test
    public void Demo1(){
        String s=" welcome_to_china";
        String[] strings=s.split("_");
        String[] strings1=s.split("_",2);
        String[] strings2=s.substring(1).split("_");//先截取 后分割  从索引为1开始截取字符串

        for (int i = 0; i < strings2.length; i++) {
            System.out.println(strings2[i]);
        }
        System.out.println("============");
        //遍历根据"_"截取后的结果
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        System.out.println("============");
        //遍历根据"_"截取后的结果，限制条件（截取两份）
        for (int i = 0; i < strings1.length; i++) {
            System.out.println(strings1[i]);
        }

        /**
         * 输出结果如下:
         * welcome
         * to
         * china
         * ============
         *  welcome
         * to
         * china
         * ============
         *  welcome
         * to_china
         *
         *
         **/

    }


    /**
     * String[] subString(int beginIndex):
     *          返回一个新的字符串，他是此字符串的一个子字符串（返回一个字符串）
     * String[] subString(int beginIndex, int endIndex)
     *          返回一个新字符串，他是此字符串的一个子字符串（返回一个字符串）
     */
    @Test
    public void Demo2(){

        String s="welcome to china";

        String s1=s.substring(2);  //从索引为2开始截取字符串
        String s2=s.substring(2,5); //从索引为2开始截取字符串，终止索引为5

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s.substring(0, 1));


    }

    @Test
    public void Demo4(){
        String s = "2401273|0571845W|0129|114024|6225750082093887   |  CT|    |      |1|    4019|0|CM|    |      |01|ND|";
        System.out.println(s.substring(0, 66));
        System.out.println(s.substring(67));

        System.out.println(s.substring(0, 79));
        System.out.println(s.substring(81));
        String rs = s.substring(0,79)+ "NA" +s.substring(81);
        System.out.println("====");
        System.out.println(rs);
        System.out.println(s);

    }

    @Test
    public void testDemo3(){
        String responseMessage ="_MAC数据_001_00980";
        String[] strData = responseMessage.substring(1).split("_");
        for(String item : strData){
            System.out.println(item);
        }
        System.out.println(strData.length);
        String macData = strData[strData.length - 1];
        System.out.println(macData);

        /**
         * 输出数据如下：
         * MAC数据
         * 001
         * 00980
         * 3
         * 00980
         *
         **/
    }
}
