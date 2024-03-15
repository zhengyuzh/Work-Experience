package A4字符串转换.B2字符串分割.代码.Demo;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A4字符串转换.B2字符串分割.代码.Demo
 * @Author: zhengyuzhu
 * @CreateTime: 2024-02-23  15:54
 * @Description: TODO
 * @Version: 1.0
 */
public class Testss {

    @Test
    public void demo1() {
        String str = "0531_advert_2024.02.23.a00,2024.02.23.a00,20240223165300;0531_advert_2024.02.23.b00,2024.02.23.b00,20240223165300;0531_advert_2024.02.23.c00,2024.02.23.c00,20240223165300;0531_advert_2024.02.23.d00,2024.02.23.d00,20240223165300;0531_advert_2024.02.23.e00,2024.02.23.e00,20240223165300;";
        String endStr = "0,";

        try{
            String[] fileList = str.split(";");
            for(String item : fileList){
                System.out.println(item.toString());
                String subStr = item.substring(12);
                endStr = endStr +subStr + ",";
            }

        }catch (Exception e){
            System.out.println(e.getMessage());

        }



        System.out.println(endStr);


    }


    @Test
    public void demo2(){
        Map<String,String> adMap = new LinkedHashMap<>();
        String adParams = "0531_advert_2024.02.23.a00,2024.02.23.a00,20240223165300;0531_advert_2024.02.23.b00,2024.02.23.b00,20240223165300;0531_advert_2024.02.23.c00,2024.02.23.c00,20240223165300;0531_advert_2024.02.23.d00,2024.02.23.d00,20240223165300;0531_advert_2024.02.23.e00,2024.02.23.e00,20240223165300;";

        String[] adList = adParams.split(";");

        String[] status = new String[]{"outofservice", "inservice", "waitauth", "procidle", "takecard"};
        String[] props = new String[]{"file", "version", "time"};

        for (int i = 0; i < adList.length; i++) {
            String[] statusProps = adList[i].split(",");
            for (int propIndex = 0; propIndex < props.length; propIndex++) {
                System.out.println(statusProps[propIndex]);

                    // adMap.put(status[i] + "_" + props[propIndex], statusProps[propIndex]);

            }
        }
    }

    @Test
    public void Demo4(){
        String TRANSCODE = "01";
        String TRANSCODE1 = "ournal.downloadWorkkeyNu";
        if(TRANSCODE.length() > 5){
            System.out.println("TRANSCODE 长度大于5");
        }else{
            System.out.println("TRANSCODE 长度不大于5");
        }

        if(TRANSCODE1.length() > 5){
            System.out.println("TRANSCODE1 长度大于5");
        }else{
            System.out.println("TRANSCODE1 长度不大于5");
        }


    }

    @Test
    public void Demo5(){
        String str1 = "{\"param\":{\"ID\":\"CHIP\",\"status\":\"NODEVICE\"}}";
        String str = "{\"result\":0,\"phyresult\":\"\",\"param\":{\"track1\":\"\",\"track2\":\"6225881170001639=49121201233200282636\",\"track3\":\"996225881170001639=1561560500050000001015889351214000049120=1170001639=000000000=03000000755000000000000\"},\"command\":\"ReadRawDataAsyn\"}";
        System.out.println(str.length());
        if(str.length() > 50){
            String strRs = str.substring(0,50);
            System.out.println(strRs);

        }
    }
}
