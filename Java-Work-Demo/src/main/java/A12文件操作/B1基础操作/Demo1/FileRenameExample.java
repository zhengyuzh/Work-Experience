package A12文件操作.B1基础操作.Demo1;

import org.junit.Test;

import java.io.File;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A12文件操作.B1基础操作.Demo1
 * @Author: zhengyuzhu
 * @CreateTime: 2024-02-20  09:43
 * @Description: 文件重命名
 * @Version: 1.0
 */
public class FileRenameExample {

    @Test
    public void testDemo1(){

        // 指定原始文件路径
        String filePath = "F:\\data\\Branch\\DEPOSIT_INSURANCE.jpg";

        // 创建File对象
        File oldFile = new File(filePath);

        // 指定新的文件名
        String newFileName = "newFileName.jpg";

        // 构建新的文件路径
        String newFilePath = oldFile.getParent() + File.separator + newFileName;

        // 创建新的File对象
        File newFile = new File(newFilePath);

        // 使用renameTo()方法进行重命名
        boolean isRenamed = oldFile.renameTo(newFile);

        if (isRenamed) {
            System.out.println("文件重命名成功！");
        } else {
            System.out.println("文件重命名失败！");
        }

    }


    /**
     * @description:测试调用文件重命名封装方法
     * @author: zhengyuzhu
     * @date: 2024/2/20 11:01
     **/
    @Test
    public void TestDemo2(){
        String path = "F:\\data\\Branch";
        String oldFileName ="DEPOSIT_INSURANCE.jpg";
        String oldFilePath = path + File.separator + oldFileName;

        // 指定新的文件名
        String newFileName = "newFileName.jpg";

        // 构建新的文件路径
        String newFilePath = path + File.separator + newFileName;

        // 使用renameTo()方法进行重命名
        boolean isRenamed = renameFile(oldFilePath,newFilePath);

        if (isRenamed) {
            System.out.println("文件重命名成功！");
        } else {
            System.out.println("文件重命名失败！");
        }

    }


    /**
     * @description: 文件重命名
     * @author: zhengyuzhu
     * @date: 2024/2/20 10:58
     * @param: oldFilePath
     * @param: newFilePath
     * @return: java.lang.Boolean
     **/
    public Boolean renameFile(String oldFilePath,String newFilePath){
        try{

            // 创建File对象
            File oldFile = new File(oldFilePath);

            // 创建新的File对象
            File newFile = new File(newFilePath);

            if(newFile.exists()){
                newFile.delete();
            }

            // 使用renameTo()方法进行重命名
            boolean isRenamed = oldFile.renameTo(newFile);
            return isRenamed;

        }catch (Exception e){
            System.out.println("重命名异常" + e.getMessage());
            return false;
        }


    }
}
