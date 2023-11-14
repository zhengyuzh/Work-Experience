package A4字符串转换.json字符串.代码.Demo2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import A4字符串转换.json字符串.代码.Demo2.mode.Student;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/7 15:17
 * @Description:
 */
public class TestJSONOne {


    /**
     * 1、通过原生生成json数据格式。
     */
    @Test
    public void Demo1() {
        JSONObject zhangsan = new JSONObject();
        try {
            //添加
            zhangsan.put("name", "张三");
            zhangsan.put("age", 18.4);
            zhangsan.put("birthday", "1900-20-03");
            zhangsan.put("majar", new String[]{"哈哈", "嘿嘿"});
            zhangsan.put("null", null);
            zhangsan.put("house", false);
            System.out.println(zhangsan.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 2.通过hashMap数据结构生成
     */
    @Test
    public void Demo2() {
        HashMap<String, Object> zhangsan = new HashMap<>();

        zhangsan.put("name", "张三");
        zhangsan.put("age", 18.4);
        zhangsan.put("birthday", "1900-20-03");
        zhangsan.put("majar", new String[]{"哈哈", "嘿嘿"});
        zhangsan.put("null", null);
        zhangsan.put("house", false);
        System.out.println(new JSONObject(zhangsan).toString());
    }

    /**
     * 3.通过实体生成
     */
    @Test
    public void Demo3() {
        Student student = new Student();
        student.setId(1);
        student.setAge("20");
        student.setName("张三");
        //生成json格式
        System.out.println(JSON.toJSON(student));
        //对象转成string
        String stuString = JSONObject.toJSONString(student);
    }

    /**
     * 4.JSON字符串转换成JSON对象
     */
    @Test
    public void Demo4() {
        String studentString = "{\"id\":1,\"age\":2,\"name\":\"zhang\"}";

        //JSON字符串转换成JSON对象
        JSONObject jsonObject1 = JSONObject.parseObject(studentString);

        System.out.println(jsonObject1);
    }

    /**
     * 5.list对象转listJson
     */
    @Test
    public void Demo5(){
        ArrayList<Student> studentLsit = new ArrayList<>();
        Student student1 = new Student();
        student1.setId(1);
        student1.setAge("20");
        student1.setName("asdasdasd");

        studentLsit.add(student1);

        Student student2 = new Student();
        student2.setId(2);
        student2.setAge("20");
        student2.setName("aaaa:;aaa");

        studentLsit.add(student2);

        //list转json字符串
        String string = JSON.toJSON(studentLsit).toString();
        System.out.println(string);

        //json字符串转listJson格式
        JSONArray jsonArray = JSONObject.parseArray(string);

        System.out.println(jsonArray);
    }

}
