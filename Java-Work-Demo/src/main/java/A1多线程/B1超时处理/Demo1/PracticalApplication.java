package A1多线程.B1超时处理.Demo1;

import com.cfcc.spz.sdk.SPZUtils;
import org.apache.log4j.Logger;

import java.net.URLDecoder;
import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/14 10:46
 * @Description:
 */
public class PracticalApplication {
    static final Logger log = Logger.getLogger(PracticalApplication.class); //创建日志对象 Logger

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        // String OriginalString = "`H234C3`H2CC56`H036C3依`H04DAE";//取出生僻字
        String OriginalString = "军`H2E9F5`H31364";
        try{
            String TransferStringSub = timeoutMethod(OriginalString);
            if(TransferStringSub.equals("*") || TransferStringSub == "*"){
                log.info("生僻字转换超时 返回:" + TransferStringSub);
            }else{
                //处理隐藏第一个字符
                byte[] orignalUTF_32 = TransferStringSub.getBytes("UTF-32");
                int lastIndex = orignalUTF_32.length;
                byte[] afterUTF_32 = Arrays.copyOfRange(orignalUTF_32,4,lastIndex);//截取
                String result = new String(afterUTF_32,"UTF-32");
                TransferStringSub = "*"+result;
                log.info("生僻字转换成功及隐藏第一个字符 " + TransferStringSub);

                TransferStringSub = URLDecoder.decode(TransferStringSub,"utf-8");
                log.info("UTF-8 转 字符串:" + TransferStringSub);
            }


        }catch (Exception e){
            log.error("生僻字转换异常 " + e);
        }
    }


    /**
     * 超时时间的方法  生僻字转换
     * @return
     */
    private static String timeoutMethod(String OriginalString) {
        String result = "*";
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {

            @Override
            public String call() throws Exception {
                // Thread.sleep(3000); 模拟延时
                return  SPZUtils.unescapeRareCJK(OriginalString); //调用库转换;
            }
        });

        executorService.execute(futureTask);
        try {
            // 延迟 3 秒 没响应返回 *
            result = futureTask.get(3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
           log.error("生僻字转换超时:" +e);
            futureTask.cancel(true);
            result = "*";
        }
        return result;
    }


}
