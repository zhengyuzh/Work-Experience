package 枚举相关.基本使用.代码;

import java.util.Scanner;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/10/16 16:44
 * @Description:
 */
public class Mytest {
    public static void main(String[] args) {
        Boolean flag = false;
        //创建对象，获取键盘输入的值做准备
        Scanner src = new Scanner(System.in);
        do{
            System.out.println("请输入指令 【0~3】");
            //
            /**
             * nextInt();获取键盘输入的整数
             * next();一直到读取到输入的有效字符后结束输入，会自动忽略空白信息（空格）；
             * nextLine();可以获取所有信息，包括空白信息。
             */
            int code = src.nextInt();

            /**
             * 通过枚举得到指令类型
             */
            CMNDType CMMD = CMNDType.get(String.valueOf(code));
            switch (CMMD){
                case Start: //开启设备
                    System.out.println("开启设备");
                    break;
                case ShutDown: //关闭设备
                    System.out.println("关闭设备");
                    break;
                case Reboot:    //重启设备
                    System.out.println("重启设备");
                    break;
                default:
                    System.out.println("设备指令不正确");
                    break;
            }

            System.out.println("是否继续执行操作 ？【y是 / n 否】");
            String operate = src.next();
            if(operate.equals("y")|| operate.equals("Y")){
                flag = true;
            }else if(operate.equals("n") || operate.equals("N")){
                flag = false;
            }else{
                flag = true;
            }


        }while (flag);

    }
}
