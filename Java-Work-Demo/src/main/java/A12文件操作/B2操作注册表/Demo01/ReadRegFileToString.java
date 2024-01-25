package A12文件操作.B2操作注册表.Demo01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A12文件操作.B2操作注册表.Demo01
 * @Author: zhengyuzhu
 * @CreateTime: 2024-01-25  11:29
 * @Description: TODO
 * @Version: 1.0
 */


public class ReadRegFileToString {

    public static void main(String[] args) {
        try {
            String filePath = "E:\\广电运通\\招商银行信创CRS\\注册表\\VendorUpdate.reg";
            String regContent = readRegFileToString(filePath);
            System.out.println(regContent);
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

    private static String readRegFileToString(String filePath) throws IOException {
        System.out.println(Paths.get(filePath));
        byte[] encoded = Files.readAllBytes(Paths.get(filePath));
        return new String(encoded, StandardCharsets.UTF_8);

        // try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
        //     String line;
        //     while ((line = reader.readLine()) != null) {
        //         // 处理每一行
        //         System.out.println(line);
        //     }
        // }

        // return null;
    }

}

