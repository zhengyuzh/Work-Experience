package A4字符串转换.B4字符串转数字.代码.Demo1;

import org.junit.Test;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A4字符串转换.B4字符串转数字.代码.Demo1
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-27  13:52
 * @Description: TODO
 * @Version: 1.0
 */
public class StringToFloat {


    /**
     * @description: 字符串转浮点数
     * @author: zhengyuzhu
     * @date: 2023/11/27 13:52
     **/
    @Test
    public void testDemo1(){
        String withdrawalamount = "44.78654";
        int iHeadLen = 23;
        //交易金额
        float famount = Float.parseFloat(withdrawalamount);
        int iamount = (int)famount;
        System.out.println(iamount);
        int realAmount1 = iamount / 100;
        System.out.println(realAmount1);
        String realAmount = Integer.toString(realAmount1);
        realAmount += ".00";
        System.out.println(realAmount);

    }
}
