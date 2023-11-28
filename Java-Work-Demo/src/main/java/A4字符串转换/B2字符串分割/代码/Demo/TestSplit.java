package A4字符串转换.B2字符串分割.代码.Demo;


import org.junit.Test;
import org.omg.IOP.Encoding;

import java.sql.Array;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A4字符串转换.B2字符串分割.代码.Demo
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-27  10:16
 * @Description: TODO
 * @Version: 1.0
 */
public class TestSplit {


    /**
     * @description:
     * @author: 解析变长报文
     * @date: 2023/11/27 10:21
     * @param: argSource
     * @param: argOffset
     * @param: argLength
     * @return: java.lang.String
     **/
    public String GetFieldValue(byte[] argSource, int argOffset, int argLength) {
        /**
         *
         * arraycopy() 方法位于 java.lang.System 类中，其语法形式如下：
         *
         * System.arraycopy(dataType[] srcArray,int srcIndex,dataType[] destArray,int destIndex,int length)
         * 其中，srcArray 表示原数组；
         *      srcIndex 表示原数组中的起始索引；
         *      destArray 表示目标数组；
         *      destIndex 表示目标数组中的起始索引；
         *      length 表示要复制的数组长度。
         *
         * 使用此方法复制数组时，length+srcIndex 必须小于等于 srcArray.length，
         * 同时 length+destIndex 必须小于等于 destArray.length。
         *
         * 注意：目标数组必须已经存在，且不会被重构，相当于替换目标数组中的部分元素。
         *
         *
         **/
        byte[] byteValue = new byte[argLength];
        System.arraycopy(argSource, argOffset, byteValue, 0, argLength);
        return new String(byteValue);
    }

    @Test
    public void test1() {
        String str = "asdfghffff";
        byte[] bytes = str.getBytes();
        String strRs = GetFieldValue(bytes, 2, 5);
        System.out.println(strRs);

    }

    public String getRev(byte[] receiveData){
        String OrderId = null;
        String OrderTime = null;
        String TransAmountCent = null;
        String CurrentCurrency = null;
        String PAN = null;
        int iHeadLen = 23;
        if (receiveData.length > 3){

            //2、订单号
            OrderId = GetFieldValue(receiveData, iHeadLen, 40).trim();
            System.out.println("订单号:" + OrderId);

            //3、订单时间
            OrderTime = GetFieldValue(receiveData,iHeadLen+40,14);
            System.out.println("订单时间:" + OrderTime);

            //4、交易金额
            TransAmountCent = GetFieldValue(receiveData, iHeadLen+40+14, 12);
            System.out.println("交易金额:" + TransAmountCent);

            //5、交易币种
            CurrentCurrency = GetFieldValue(receiveData, iHeadLen+40+14+12, 3);
            System.out.println("交易币种:" + CurrentCurrency);

            //6、取现账号
            PAN = GetFieldValue(receiveData, iHeadLen+40+14+12+3, 40).trim();
            System.out.println("账号:" + PAN);

            /**
             * 输出结果如下：
             * 订单号:FSD20221103
             * 订单时间:20231127 14:18
             * 交易金额:40000.000000
             * 交易币种:CNY
             * 账号:45321234567
             *
             **/
        }else{
            System.out.println("rev data: null");
        }
        return null;

    }

    @Test
    public void testDemo2(){
        String responseData = "12345123451234512345000" + "FSD20221103                             "+
                "20231127 14:18"+"40000.000000" + "CNY" + "45321234567                             "
                ;
        byte [] receiveData = responseData.getBytes();
        getRev(receiveData);
    }


}
