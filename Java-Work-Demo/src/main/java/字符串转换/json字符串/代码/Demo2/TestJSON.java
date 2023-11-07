package 字符串转换.json字符串.代码.Demo2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/7 15:08
 * @Description:      有关json对象获取的常用使用方法
 *                                1、通过key - value 取值 ？
 *                                2、双层嵌套JSON 如何取值？
 *                                3、对象数组 如何取值？
 */
public class TestJSON {
    /**
     * JSON实际上也是键值对（"key":"value"）
     * key 必须是字符串，value 可以是合法的 JSON 数据类型（字符串, 数字, 对象, 数组, 布尔值或 null）
     * value如果是字符串，用jsonobj.getString("key")获取
     * value如果是数  字，用jsonobj.getIntValue("key"),jsonobj.getFloatValue("key")，jsonobj.getInteger("key")等基本数据类型及其包装类的方法获取
     * value如果是布尔值，用jsonobj.getBoolean("key"),jsonobj.getBooleanValue("key")获取
     * value如果是数  组，用jsonobj.getJSONArray("key")获取
     * value如果是Object对象，用jsonobj.get("key")，获取
     * value如果是JSONObject对象，用jsonobj.getJSONObject("key")获取
     */

    /**
     * 该方法用于将已有的json字符串转换为json对象，并取出该对象中相应的key对应的value值
     * 将已有的字符串转换成jsonobject，用JSON.parseObject(jsonStr)方法
     * json中只要是{}就代表一个JSONObject,[]就代表一个JSONArray
     * 获取JSONObject对象用JSONObject jsonobject.getJSONObject("key")方法
     * 获取JSONArray对象用JSONObject jsonobject.getJSONArray("key")方法
     */

    @Test
    public void strWritedToJSONObject() {
        //以下是一个json对象中嵌套一个json子对象
        String myJsonObj = "{\n" +
                "    \"name\":\"runoob\",\n" +
                "    \"alexa\":10000,\n" +
                "    \"sites\": {\n" +
                "        \"site1\":\"www.runoob.com\",\n" +
                "        \"site2\":\"m.runoob.com\",\n" +
                "        \"site3\":\"c.runoob.com\"\n" +
                "    }\n" +
                "}";
        JSONObject jsonobj = JSON.parseObject(myJsonObj); //将json字符串转换成jsonObject对象
        /***获取JSONObject中每个key对应的value值时，可以根据实际场景中想得到什么类型就分别运用不到的方法***/
        System.out.println(jsonobj.get("name")); //取出name对应的value值，得到的是一个object
        System.out.println(jsonobj.getString("name")); //取出name对应的value值，得到的是一个String
        System.out.println(jsonobj.getIntValue("alexa")); //取出name对应的value值，得到的是一个int
        System.out.println(jsonobj.get("sites")); //取出sites对应的value值，得到的是一个object
        System.out.println(jsonobj.getString("sites"));
        System.out.println(jsonobj.getJSONObject("sites")); //取出sites对应的value值，得到一个JSONObject子对象
        System.out.println(jsonobj.getJSONObject("sites").getString("site2")); //取出嵌套的JSONObject子对象中site2对应的value值，必须用getJSONObject()先获取JSONObject


        /**
         * 以下是一个json对象中包含数组，数组中又包含json子对象和子数组
         */
        String myJsonObj2 = "{\n" +
                "    \"name\":\"网站\",\n" +
                "    \"num\":3,\n" +
                "    \"sites\": [\n" +
                "        { \"name\":\"Google\", \"info\":[ \"Android\", \"Google 搜索\", \"Google 翻译\" ] },\n" +
                "        { \"name\":\"Runoob\", \"info\":[ \"菜鸟教程\", \"菜鸟工具\", \"菜鸟微信\" ] },\n" +
                "        { \"name\":\"Taobao\", \"info\":[ \"淘宝\", \"网购\" ] }\n" +
                "    ]\n" +
                "}";
        JSONObject jsonobj2 = JSON.parseObject(myJsonObj2); //将json字符串转换成jsonObject对象
        System.out.println(jsonobj2.get("sites"));
        System.out.println(jsonobj2.getString("sites"));
        System.out.println(jsonobj2.getJSONArray("sites")); //取出sites对应的value值，得到一个JSONOArray对象
        //System.out.println(jsonobj2.getJSONObject("sites")); 不能用该方法，因为sites是一个JSONOArray对象
        //取出json对象中sites对应数组中第一个json子对象的值
        System.out.println(jsonobj2.getJSONArray("sites").getJSONObject(0)); //得到结果：{"name":"Google","info":["Android","Google 搜索","Google 翻译"]}
        System.out.println(jsonobj2.getJSONArray("sites").get(0));
        System.out.println(jsonobj2.getJSONArray("sites").getString(0));
        //取出json对象中sites对应数组中第一个json子对象下面info对应的嵌套子数组值
        System.out.println(jsonobj2.getJSONArray("sites").getJSONObject(0).getJSONArray("info")); //得到结果：["Android","Google 搜索","Google 翻译"]
        //取出json对象中sites对应数组中第一个json子对象下面info对应的嵌套子数组中第二个值
        System.out.println(jsonobj2.getJSONArray("sites").getJSONObject(0).getJSONArray("info").getString(1)); //得到结果：Google 搜索

        //依次取出json对象中sites对应数组中的值
        JSONArray array = jsonobj2.getJSONArray("sites");
        getJsonArrayItem(array);
        //依次取出json对象中sites对应数组中第二个json子对象下面info对应的嵌套子数组值
        JSONArray arr = jsonobj2.getJSONArray("sites").getJSONObject(1).getJSONArray("info");
        getJsonArrayItem(arr);
    }

    /**
     * 手动添加对象到一个JSONObject
     */
    @Test
     public void writeStrToJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","tom");
        jsonObject.put("age",20);

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonArrayObject1 = new JSONObject();
        jsonArrayObject1.put("name","alibaba");
        jsonArrayObject1.put("info","www.alibaba.com");
        JSONObject jsonArrayObject2 = new JSONObject();
        jsonArrayObject2.put("name","baidu");
        jsonArrayObject2.put("info","www.baidu.com");

        jsonArray.add(jsonArrayObject1);
        jsonArray.add(jsonArrayObject2);

        jsonObject.put("sites",jsonArray);

        System.out.println(jsonObject);
    }

    /**
     * 将字符串转为JSONArray
     */
    @Test
    public void strToJsonArray() {
        String arrayStr = "[\n" +
                "        {\n" +
                "            \"name\":\"alibaba\",\n" +
                "            \"info\":\"www.alibaba.com\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"baidu\",\n" +
                "            \"info\":\"www.baidu.com\"\n" +
                "        }\n" +
                "    ]";

        JSONArray array = JSON.parseArray(arrayStr);
        System.out.println(array);
    }

    public JSONArray getJsonArray() {
        String arrayStr = "[\n" +
                "        {\n" +
                "            \"name\":\"alibaba\",\n" +
                "            \"info\":\"www.alibaba.com\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\":\"baidu\",\n" +
                "            \"info\":\"www.baidu.com\"\n" +
                "        }\n" +
                "    ]";

        JSONArray array = JSON.parseArray(arrayStr);
        return array;

    }

    /**
     * 依次取出JSONArray中的值
     */
    @Test
    public void getJsonArrayItem() {
        JSONArray array = getJsonArray();
        for (int i=0; i<array.size(); i++) {
            System.out.println(array.get(i));
        }
    }

    public void getJsonArrayItem(JSONArray array) {
        for (int i=0; i<array.size(); i++) {
            System.out.println(array.get(i));
        }
    }


}
