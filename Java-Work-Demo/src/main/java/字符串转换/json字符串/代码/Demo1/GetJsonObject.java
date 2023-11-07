package 字符串转换.json字符串.代码.Demo1;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/7 14:40
 * @Description:  假如返回的报文是双层嵌套的json格式，如何转换成对象。取出对应的数据值
 */
public class GetJsonObject {


    /**
     * 构造一个双层json嵌套的的 JSON 格式的String
     * @return
     */
    public String getJsonObjectString() {
        JSONObject result = new JSONObject();
        JSONObject paramJson = new JSONObject();
        result.put("result", "00");
        paramJson.put("msg", "Success");
        paramJson.put("name", "张三");
        paramJson.put("age", 18);
        result.put("param", paramJson);

        String resultJson = result.toJSONString();
        return resultJson;
    }


    /**
     * 测试取出JSON中的值 通过 key - value 的形式
     */
    @Test
    public void Test(){
        String result = getJsonObjectString();
        System.out.println("字符串JSON: " + result);

        //解析该json
        JSONObject resultJson = JSONObject.parseObject(result);

        //通过key-value的形式获取值
        String resultCode = (String) resultJson.get("result");
        System.out.println( "对象JSON key-value result取值: " + resultCode);

        //获取嵌套 json 中的数据值  参数param
        JSONObject resultParam = (JSONObject) resultJson.get("param");
        String resultMsg = (String) resultParam.get("msg");
        System.out.println("首先取出params,然后取出 msg 值:" + resultMsg);

        String resultMsgs = (String) resultJson.getJSONObject("param").get("msg");
        System.out.println("一次性取出嵌套json中的  msg 值:" + resultMsgs);
    }
}
