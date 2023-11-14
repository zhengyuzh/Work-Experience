package A5数据结构与算法.分治法.递归.代码;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/10/18 16:16
 * @Description: 计算n 的阶乘
 */
public class TestDiGui {

    public static int getResult(int n){
        if(n == 0) return 1;

        if(n == 1) return 1;


        return n * getResult(n - 1);

    }

    public static void main(String[] args) {
        System.out.println(TestDiGui.getResult(4));
    }
}
