package 网络编程.TCP案例.代码;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/10/16 14:53
 * @Description: 服务端
 *               实现的基本步骤：
 *                          1、建立ServerSocet  监听的端口
 *                          2、等待连接
 *                          3、通信，输入流。获取服务端发来的数据。输出流 要发送给客户端的数据
 *                          4、关系相应的开关
 */
public class MyServer {

    public static void main(String[] args) throws IOException {
        /**
         * 1、准备一个ServerSocker
         */
        ServerSocket serverSocket = new ServerSocket(8888);
        /**
         * 2、监听一个客户端的连接。accept()是一个阻塞的方法，如果没有客户端连接，将一直等待
         */
        Socket socket = serverSocket.accept();
        System.out.println("一个客户端连接成功");

        /**
         * 3、获取输入流，用来接收客户端发送给服务器的数据
         */
        InputStream inputStream = socket.getInputStream();

        /**
         * 获取输出流，用来发送数据给服务器
         */
        OutputStream outputStream = socket.getOutputStream();



        /**
         * 4、接收数据
         */
        byte[] data = new byte[1024];
        int len;
        /**
         *
         * read()这个方法完成的事情就是从数据源中读取8个二进制位，
         * 并将这8个0或1转换成十进制的整数，然后将其返回
         *
         * read(byte[] b)
         * 这个方法使用一个byte的数组作为一个缓冲区，
         * 每次从数据源中读取和缓冲区大小（二进制位）相同的数据并将其存在缓冲区中。
         * 当然byte数组中存放的仍然是0-255的整数，将二进制转换为十进制这个过程仍然是read方法实现的。
         * 需要注意的是，虽然我们可以指定缓冲区的大小，但是read方法在读取数据的时候仍然是按照字节来读取的
         *
         * 资料参考：https://blog.csdn.net/u010276761/article/details/52692962

         */
        while ((len=inputStream.read(data))!=-1){
            /**
             * String(byte[] bytes, int offset, int length)
             * 构造一个新的 String，方法是使用指定的字符集解码字节的指定子数组。
             */
            System.out.println(new String(data,0,len));
        }

        /**
         * 发送数据给服务端
         */
        outputStream.write("服务端端发送的数据".getBytes());
        outputStream.flush();

        //socker关闭，意味着InputStream和OutputStrem也关闭了
        socket.close();

        //6、如果不在接收任何客户端通信，可以关闭ServerSocker
        serverSocket.close();

    }

}
