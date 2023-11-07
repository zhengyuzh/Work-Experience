package 字符串转换.字符串分割.代码.Demo;

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
        System.out.println("======");
        //遍历根据“-”截取后的结果
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        System.out.println("============");
        //遍历根据“-”截取后的结果，限制条件（截取两份）
        for (int i = 0; i < strings1.length; i++) {
            System.out.println(strings1[i]);
        }

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


    }
}
