package A11集合框架.B1Map框架.Demo1;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A11集合框架.B1Map框架.Demo1
 * @Author: zhengyuzhu
 * @CreateTime: 2023-11-20  14:45
 * @Description: TODO
 * @Version: 1.0
 */
import java.util.HashMap;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/7/17 10:17
 * @Description: HashMap是一种十分常用的数据结构对象，可以保存键值对
 *              常用方法：1、添加元素 ：put( )方法
 *                      2、访问元素 ：get( )方法
 *
 */
public class TestHashMapDemo {

    /**
     * 将数据放入map集合中
     * @param key1
     * @param key2
     * @return
     */
    public HashMap<String,String> getSites(String key1,String key2){
        HashMap<String, String> map = new HashMap<>();
        String value1 = key1 + key2;
        String value2 = key2 + key1;
        map.put(key1,value1);
        map.put(key2,value2);
        return map;
    }

    public static void main(String[] args) {
        TestHashMapDemo demo = new TestHashMapDemo();
        HashMap<String,String> getValue = demo.getSites("test01","test02");
        System.out.println("获取test01的值:" + getValue.get("test01"));
        System.out.println("获取test02的值:" + getValue.get("test02"));

    }

}

