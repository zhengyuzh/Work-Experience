package com.zyz.yu.SRCSqLite.utils;

import com.alibaba.fastjson.JSONObject;
import com.zyz.yu.SRCSqLite.model.JSCommandKey;


/**
 * @author zyz
 * @version 1.0
 * @data 2023/10/30 9:38
 * @Description: 响应结果响应给前端
 */
public class JSResult {

    /**
     * @author ZYZ
     * @description 打包成功返回的结果集
     * @param obj
     * @return java.lang.String
     */
    public static String packSuccess(Object obj) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(JSCommandKey.s_result, JSCommandKey.s_SuccessCode);

        JSONObject paramObject = new JSONObject();
        paramObject.put(JSCommandKey.s_data,obj);
        paramObject.put(JSCommandKey.s_msg,"");
        jsonObject.put(JSCommandKey.s_param, paramObject);
        return jsonObject.toJSONString();
    }


    /**
     * @author ZYZ
     * @description 打包失败返回的结果集
     * @param obj
     * @return java.lang.String
     */
    public static String packFail(Object obj) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(JSCommandKey.s_result, JSCommandKey.s_FailCode);

        JSONObject paramObject = new JSONObject();
        paramObject.put(JSCommandKey.s_data,"");
        paramObject.put(JSCommandKey.s_msg,obj);
        jsonObject.put(JSCommandKey.s_param, paramObject);
        return jsonObject.toJSONString();
    }


}
