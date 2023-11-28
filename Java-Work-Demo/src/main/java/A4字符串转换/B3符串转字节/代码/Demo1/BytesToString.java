package A4字符串转换.B3符串转字节.代码.Demo1;

import org.junit.Test;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A4字符串转换.B3符串转字节.代码.Demo1
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-27  13:22
 * @Description: 字节和字符串互转
 * @Version: 1.0
 */
public class BytesToString {
    /**
     * @description: 字节转换成字符串
     * @author: zhengyuzhu
     * @date: 2023/11/27 13:22
     **/
    @Test
    public void TestDemo1(){
        String str = "Hello, World!";
        /**
         * @description: 字符串转换成字节
         *               具体代码如下：
         **/
        byte[] bytes = str.getBytes();

        for(byte item  : bytes){
            System.out.println(item);
        }


        /**
         *
         * @description: 使用String类的构造方法，将字节数组转换为字符串。
         *               具体代码如下：
         **/
        String result = new String(bytes);
        System.out.println(result);
        /**
         *
         * 输出如下：
         *
         * 72
         * 101
         * 108
         * 108
         * 111
         * 44
         * 32
         * 87
         * 111
         * 114
         * 108
         * 100
         * 33
         * Hello, World!
         *
         *
         *
         *
         **/
    }

}
