package A12文件操作.B3操作图片.Demo1;

import org.junit.Test;
import java.io.File;

/**
 * @BelongsProject: 图片文件重命名
 * @BelongsPackage: A12文件操作.B3操作图片.Demo1
 * @Author: zhengyuzhu
 * @CreateTime: 2024-02-01  17:50
 * @Description: TODO
 * @Version: 1.0
 */
public class PictureFileRenaming {

    /**
     * @description: 图片文件重命名
     * @author: zhengyuzhu
     * @date: 2024/2/1 17:51
     **/
    @Test
    public void TestDemo1(){

        // 指定图片文件所在的目录
        String directoryPath = "/path/to/your/image/directory";

        // 创建File对象表示目录
        File directory = new File(directoryPath);

        // 检查目录是否存在
        if (directory.exists() && directory.isDirectory()) {
            // 获取目录中的所有文件
            File[] files = directory.listFiles();

            // 遍历文件数组
            if (files != null) {
                for (File file : files) {
                    // 判断文件是否为图片文件，这里假设只处理JPEG和PNG格式的图片
                    if (file.isFile() && (file.getName().endsWith(".jpg") || file.getName().endsWith(".png"))) {
                        // 新的文件名，可以根据需要修改命名规则
                        String newFileName = "new_prefix_" + file.getName();

                        // 创建新的File对象表示重命名后的文件
                        File newFile = new File(directoryPath, newFileName);

                        // 使用renameTo方法进行重命名
                        if (file.renameTo(newFile)) {
                            System.out.println("File renamed successfully: " + newFileName);
                        } else {
                            System.out.println("Failed to rename file: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }

    }
}
