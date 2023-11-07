package 字符串转换.json字符串.代码.Demo1;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/6 10:58
 * @Description: 生成JSON字符串
 *                   1、生成拼接的形式
 *                   2、使用JSONObject
 */
public class GenerateJsonString {

    /**
     * 使用JSONObject 组合字符串
     */
    @Test
    public void Demo1(){
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name","张三");
        jsonObj.put("age",18);

        String student = JSONObject.toJSONString(jsonObj);
        System.out.println(student);

    }

    /**
     * 拼接JSON字符串
     */
    @Test
    public void Demo2(){
        String json_to_string = "{\"name\":\"李四\"," + "\"age" +
                "\":\"18\"}";
        System.out.println(json_to_string);
    }


}
