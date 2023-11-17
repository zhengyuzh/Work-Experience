package A4字符串转换.B3符串转字节.代码.Demo1;

import org.junit.Test;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A4字符串转换.B3符串转字节.代码.Demo1
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-17  08:40
 * @Description: TODO
 * @Version: 1.0
 */
public class StringsToBytes {

    @Test
    public void TestDemo1(){
        String str = "Hello, World!";
        byte[] bytes = str.getBytes();
        System.out.println(bytes.toString());
    }
}
