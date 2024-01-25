package A12文件操作.B2操作注册表.Demo01;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A12文件操作.B2操作注册表.Demo01
 * @Author: zhengyuzhu
 * @CreateTime: 2024-01-25  10:36
 * @Description: TODO
 * @Version: 1.0
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class OperationRegistry {
    public static void main(String[] args) {
        try {
            String filePath = "E:\\广电运通\\招商银行信创CRS\\注册表\\VendorUpdate.reg";
            parseRegFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseRegFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern pattern = Pattern.compile("\\s*\"(.*)\"=\"(.*)\"\\s*");
            HashMap<String, Object> map = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    String key = matcher.group(1);
                    String value = matcher.group(2);
                    map.put(key,value);
                    System.out.println("Key: " + key + ", Value: " + value);
                }
            }

            System.out.println("NoteSNRInfo: " + map.get("NoteSNRInfo"));
            System.out.println("AutoCUCount: " + map.get("AutoCUCount"));
            System.out.println("RejectNoteInfo: " + map.get("RejectNoteInfo"));
            System.out.println("Version: " + map.get("Version"));
            System.out.println("UpdateFlag: " + map.get("UpdateFlag"));
            System.out.println("UpdateResult: " + map.get("UpdateResult"));
            System.out.println("BVUpdateFlag: " + map.get("BVUpdateFlag"));
            System.out.println("UpdateResult: " + map.get("UpdateResult"));
            System.out.println("BVUpdateResult: " + map.get("BVUpdateResult"));
            System.out.println("FSNPath: " + map.get("FSNPath"));
            System.out.println("BVVersion: " + map.get("BVVersion"));
            System.out.println("DeviceNo: " + map.get("DeviceNo"));
            System.out.println("BVUpdateProg: " + map.get("BVUpdateProg"));
            System.out.println("CashInfo: " + map.get("CashInfo"));

        }
    }

}





