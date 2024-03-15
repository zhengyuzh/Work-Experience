package A12文件操作.B1基础操作.Demo1;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.util.EnumSet;
/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A12文件操作.B1基础操作.Demo1
 * @Author: zhengyuzhu
 * @CreateTime: 2024-02-28  09:38
 * @Description: TODO
 * @Version: 1.0
 */
public class DirectoryCopyExample {


    /**
     * @description: 拷贝目录下的文件 到新的地址
     * @author: zhengyuzhu
     * @date: 2024/2/28 9:42
     **/
    @Test
    public void Demo(){
        // Path sourceDirectory = Paths.get("path/to/source/directory");
        // Path targetDirectory = Paths.get("path/to/target/directory");

        Path sourceDirectory = Paths.get("F:\\data\\ZYZ\\image");
        Path targetDirectory = Paths.get("E:\\data\\myimage");

        try {
            // 创建目标目录（如果不存在）
            Files.createDirectories(targetDirectory);

            // 遍历源目录下的所有文件和子目录
            Files.walk(sourceDirectory)
                    .forEach(source -> {
                        try {
                            // 构建目标路径
                            Path target = targetDirectory.resolve(sourceDirectory.relativize(source));

                            // 如果是目录，创建目标目录
                            if (Files.isDirectory(source)) {
                                Files.createDirectories(target);
                            } else {
                                // 如果是文件，复制到目标目录
                                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            System.out.println("Directory copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
