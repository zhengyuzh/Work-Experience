package A8网络编程.网络助手.代码;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/10/17 10:11
 * @Description:
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.1.46.29", 8888);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        Scanner src = new Scanner(System.in);
        while (true){
            System.out.println("请输入和服务器的通信内容：");
            String content = src.next();
            outputStream.write(content.getBytes());

            byte[] data = new byte[1024];
            int len;
            System.out.println("开始接收服务器返回的数据：");

            while ((len=inputStream.read(data))!=-1){
                /**
                 * String(byte[] bytes, int offset, int length)
                 * 构造一个新的 String，方法是使用指定的字符集解码字节的指定子数组。
                 */
                System.out.println(new String(data,0,len));
                System.out.println(len);
            }

            System.out.println("结束接收服务器返回的数据：");


        }
    }
}
