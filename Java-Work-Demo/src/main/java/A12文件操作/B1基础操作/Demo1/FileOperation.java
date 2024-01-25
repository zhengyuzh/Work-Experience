package A12文件操作.B1基础操作.Demo1;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A12文件操作.B1基础操作.Demo1
 * @Author: zhengyuzhu
 * @CreateTime: 2023-12-22  10:57
 * @Description: TODO
 * @Version: 1.0
 */
public class FileOperation {

    @Test
    public void test1(){
        try{
            String basePath = "E:\\data\\test";
            File file = new File("E:\\data\\zipTest\\Apifox7.zip");
            String batch_no = "231222";
            if(file.exists()){
                System.out.println("文件存在");
            }else {
                System.out.println("文件不存在");
                String fileRetractashName = basePath + File.separator + batch_no + ".RetractCash.log";
                String fileRetractCardName = basePath + File.separator + batch_no + ".RetractCard.log";
                String fileBusiDetailName = basePath + File.separator + batch_no + ".BusiDetail.log";

                File fileRetractashName1 = new File(fileRetractashName);
                File fileRetractCardName1 = new File(fileRetractCardName);
                File fileBusiDetailName1 = new File(fileBusiDetailName);

                ArrayList<Object> list = new ArrayList<>();
                list.add(fileRetractashName1);
                list.add(fileRetractCardName1);
                list.add(fileBusiDetailName1);
                for(int i =0 ; i<list.size();i++){
                    System.out.println("取出文件名: " + list.get(i));
                }

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("filename",list);

                String param = JSONObject.toJSONString(jsonObject);
                System.out.println("转换成JSON:" + param);

                System.out.println("================");
                JSONObject jsonObject666 = JSONObject.parseObject(param);

                JSONArray arrFiles = jsonObject666.getJSONArray("filename");
                String packageName = jsonObject666.getString("packageName");

                System.out.println(arrFiles);
                System.out.println(packageName);


                List<String> fileList = new ArrayList<>();
                for (int i = 0; i < arrFiles.size(); i++) {
                    fileList.add(arrFiles.getString(i));
                }
                System.out.println("++++++++++++");
                System.out.println(fileList);


                if(!fileRetractashName1.exists()){
                    System.out.println("fileRetractashName1成功创建文件");
                    fileRetractashName1.createNewFile();
                }else{
                    System.out.println("fileRetractashName1此文件已经创建");
                }

                if(!fileRetractCardName1.exists()){
                    System.out.println("fileRetractCardName1成功创建文件");
                    fileRetractCardName1.createNewFile();
                }else{
                    System.out.println("fileRetractCardName1此文件已经创建");
                }

                if(!fileBusiDetailName1.exists()){
                    System.out.println("fileBusiDetailName1成功创建文件");
                    fileBusiDetailName1.createNewFile();
                }else{
                    System.out.println("fileBusiDetailName1此文件已经创建");
                }



            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
