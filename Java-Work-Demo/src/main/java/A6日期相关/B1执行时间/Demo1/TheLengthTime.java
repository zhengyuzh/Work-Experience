package A6日期相关.B1执行时间.Demo1;

import A1多线程.B1超时处理.Demo1.PracticalApplication;
import jdk.internal.dynalink.linker.LinkerServices;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/14 11:01
 * @Description: 某一部分代码片段 执行时间长短
 */
public class TheLengthTime {
    static final Logger log = Logger.getLogger(TheLengthTime.class); //创建日志对象 Logger



    /**
     * @description:
     * @author: zhengyuzhu
     * @date: 2023/11/14 13:20 
     * @param: num 
     **/
    public void showNum(int num){
        for (int i = 0; i < num; i++) {
            log.info("当前 i 值:" + i);
        }
    }

    /**
     * @description: 查看某一代码片段执行时间
     * @author: zhengyuzhu
     * @date: 2023/11/14 13:19  
     **/
    @Test
    public void testDemo1(){

        long startTime = System.currentTimeMillis();
        showNum(6);//执行代码 查看耗时
        long endTime = System.currentTimeMillis();

        log.info("方法实际耗时：" + (endTime - startTime) + "毫秒");

    }
    
 
    
    

}
