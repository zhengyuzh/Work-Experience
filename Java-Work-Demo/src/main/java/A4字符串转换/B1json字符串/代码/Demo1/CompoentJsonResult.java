package A4字符串转换.B1json字符串.代码.Demo1;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/6 15:20
 * @Description: 组合JSON 返回数据  双层JSON嵌套
 */
public class CompoentJsonResult {

    /**
     * 构造一个JSONOject 返回数据报文 使用双层嵌套
     *
     * @return
     */
    public JSONObject getJSONObject() {
        JSONObject result = new JSONObject();
        JSONObject paramJson = new JSONObject();
        result.put("result", "00");
        paramJson.put("msg", "Success");
        paramJson.put("name", "张三");
        paramJson.put("age", 18);
        result.put("param", paramJson);
        return result;
    }

    /**
     * 将JSON对象转换为字符串
     * @param jsonObject
     * @return
     */
     public String getJsonToString(JSONObject jsonObject){
        return jsonObject.toJSONString();
     }


    /**
     * 组合返回的数据 使用JSONOject
     */
    @Test
    public void Demo() {
        JSONObject json_result = getJSONObject();
        String string_result = getJsonToString(json_result);
        System.out.println(string_result);


    }

    @Test
    public void test(){
        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("name","张三");
        dataMap.put("address","河南郑州");
        dataMap.put("sex","男");
        System.out.println(dataMap);
        System.out.println(dataMap.get("name"));

    }

}
