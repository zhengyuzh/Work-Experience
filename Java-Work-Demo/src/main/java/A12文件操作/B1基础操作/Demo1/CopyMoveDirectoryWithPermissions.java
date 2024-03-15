package A12文件操作.B1基础操作.Demo1;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @BelongsProject: Java-Work-Demo
 * @BelongsPackage: A12文件操作.B1基础操作.Demo1
 * @Author: zhengyuzhu
 * @CreateTime: 2024-02-28  09:47
 * @Description: TODO
 * @Version: 1.0
 */
public class CopyMoveDirectoryWithPermissions {


    @Test
    public void Demo(){


                // Path sourceDirectory = Paths.get("path/to/source/directory");
                // Path destinationDirectory = Paths.get("path/to/destination/directory");

                Path sourceDirectory = Paths.get("F:\\data\\ZYZ\\image");
                Path destinationDirectory = Paths.get("E:\\data\\myimage");

                try {
                    // 复制整个目录
                    copyDirectory(sourceDirectory, destinationDirectory);

                    // 或者移动整个目录
                    // moveDirectory(sourceDirectory, destinationDirectory);

                    System.out.println("Directory copied/moved successfully.");
                } catch (IOException e) {
                    System.out.println("源文件地址不存在：" + e.getMessage());
                 e.printStackTrace();
                }
            }

            private static void copyDirectory(Path source, Path destination) throws IOException {
                Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                        Path targetDir = destination.resolve(source.relativize(dir));
                        Files.copy(dir, targetDir, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Path targetFile = destination.resolve(source.relativize(file));
                        Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);
                        return FileVisitResult.CONTINUE;
                    }
                });
            }

            private static void moveDirectory(Path source, Path destination) throws IOException {
                Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
            }

}
