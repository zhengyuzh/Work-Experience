package com.zyz.yu.SRCSqLite;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyz.yu.SRCSqLite.model.ElectronicFlow;
import com.zyz.yu.SRCSqLite.utils.ElectronicFlowUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/1 15:27
 * @Description: 测试数据
 */
public class TestSqlLite {
    //创建日志对象 Logger
    static final Logger log = Logger.getLogger(TestSqlLite.class);

    /**
     * 测试代码执行的时间差
     */
    @Test
    public void testDemo1(){
        try{
            // 开始时间
            long stime = System.currentTimeMillis();
            // 执行时间（1s）
            Thread.sleep(1000);
            // 结束时间
            long etime = System.currentTimeMillis();
            // 计算执行时间
            System.out.printf("执行时长：%d 毫秒.", (etime - stime));

        }catch (Exception e){
            log.error("计算时间差出错:" + e);
        }


    }

    /**
     * 测试插入数据库，采用数据池的方式
     *              //插入 50次 执行时长 957毫秒
     *              //插入100次 执行时长：1077 毫秒.
     *              // 插入 1000 次 执行时长：3309 毫秒.
     *              // 执行1000次 查询 和 添加 执行时长：3916 毫秒.
     *              插入 1000次 查询 1000 次 修改 1000次 执行时长：4924 毫秒. 执行时长：5180 毫秒.
     *
     */
    @Test
    public void testDemo2(){
        ElectronicFlow electronicFlow = new ElectronicFlow();
        electronicFlow.setUploadFlag(1);
        electronicFlow.setResCode("9999");
        electronicFlow.setSerialNumber("20201013");
        electronicFlow.setDescription("测试使用用数据池更新");
        JSONObject object = (JSONObject) JSON.toJSON(electronicFlow);
        // 开始时间
        long stime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            String seriaNumber = "60212"+i;
             ElectronicFlowUtils.insert(seriaNumber, "测试数据库连接池");
             ElectronicFlowUtils.queryOneData();
            ElectronicFlowUtils.updateBySerialNumber(object);//执行更新
        }
        // 结束时间
        long etime = System.currentTimeMillis();
        // 计算执行时间
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));

    }

    /**
     * 测试插入数据库，不使用数据池技术
     *              //插入 50次 执行时长 执行时长：1011 毫秒.
     *              //插入100次 执行时长：1167 毫秒.
     *              //插入1000次  执行时长：3931 毫秒.
     *              插入 1000次 查询 1000 次 执行时长：5199 毫秒.
     *             插入 1000次 查询 1000 次 修改 1000次 执行时长：6508 毫秒.
     *
     */
    @Test
    public void testDemo3(){
        ElectronicFlow electronicFlow = new ElectronicFlow();
        electronicFlow.setUploadFlag(1);
        electronicFlow.setResCode("9999");
        electronicFlow.setSerialNumber("20201013");
        electronicFlow.setDescription("测试不适用数据池更新");
        JSONObject object = (JSONObject) JSON.toJSON(electronicFlow);


        // 开始时间
        long stime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            String seriaNumber = "31212"+i;
            ElectronicFlowUtils.insert(seriaNumber, "测试数据库连接池");
            ElectronicFlowUtils.queryOneData(); //执行查询
            ElectronicFlowUtils.updateBySerialNumber(object);//执行更新
        }
        // 结束时间
        long etime = System.currentTimeMillis();
        // 计算执行时间
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));

    }

    @Test
    public void test(){
        System.out.println("这是我的测试");
        log.info("我的测试");
        log.warn("警告提示");
        log.error("错误提示");
    }


}
