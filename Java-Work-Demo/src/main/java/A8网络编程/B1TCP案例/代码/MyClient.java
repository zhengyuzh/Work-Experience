package A8网络编程.B1TCP案例.代码;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/10/16 14:53
 * @Description: 客户端
 *               实现的基本步骤：
 *                          1、建立Scoker 目标 IP + 端口
 *                          2、输入流(接收客户端传来的数据)、输出流(向客户端发送数据 output)
 *                          3、输入流 (接收传来的数据，使用read读取转换)
 *                          4、关闭相应开关
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        /**
         *  1、准备Scoket，连接服务器，需要指定服务器的IP地址和端口号
         */

        Socket socket = new Socket("127.0.0.1",8888);

        /**
         * 2、获取输出流，用来发送数据给服务器
         */
        OutputStream outputStream = socket.getOutputStream();

        /**
         * 获取输入流，用来接收服务器发给客户端的数据
         */
        InputStream inputStream = socket.getInputStream();

        /**
         * 3、通信   先发送，后接收。否则阻塞，同服务端相反
         */
        outputStream.write("客户端发送的数据".getBytes());

        /**
         * flush 相关资料说明
         *
         * 首先，咱们设想要给鱼缸换水，所以需要一个水泵，水泵是连接鱼缸和下水道的，
         * 咱们的任务就是将鱼缸里面水全抽干，这时，我们就可以把水管当做缓冲区。
         * 如果咱们一见鱼缸里面水抽干了就立马关了水泵，
         * 这时会发现水管里还有来不及通过水泵流向下水道的残留水，
         * 我们可以把抽水当做读数据，排水当做写数据，水管当做缓冲区，这样就容易明白了。
         *
         * 那么这样一来我们如果中途调用close()方法，
         * 输出区也还是有数据的，就像水缸里有水，只是在缓冲区遗留了一部分，
         * 这时如果我们先调用flush()方法，就会强制把数据输出，缓存区就清空了，
         * 最后再关闭读写流调用close()就完成了。
         */
        outputStream.flush();
        socket.shutdownOutput();


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
         *
         *5、关闭socket，不再与服务器通信，即断开与服务器的连接
         *socker关闭，意味着InputStream和OutputStrem也关闭了
         */

        socket.close();


    }
}
