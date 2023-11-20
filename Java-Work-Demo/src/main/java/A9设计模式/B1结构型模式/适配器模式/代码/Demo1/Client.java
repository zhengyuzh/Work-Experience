package A9设计模式.B1结构型模式.适配器模式.代码.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/2 10:10
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        ScoreOperation operation; //针对抽象目标接口编程
        operation = new OperationAdapter();

        int scores[] = {84, 76, 50, 69, 90, 91, 88, 96}; //定义成绩数组
        int result[];
        int score;

        System.out.println("成绩排序结果：");
        result = operation.sort(scores);
        for (int i : result) {
            System.out.print(i + ",");
        }
        System.out.println(" ");

        System.out.println("查找成绩: 90");
        score = operation.search(result,90);
        if (score != -1) {
            System.out.println("找到成绩 90");
        }
        else {
            System.out.println("没有找到成绩 90。");
        }

        System.out.println("查找成绩: 92");
        score = operation.search(result,92);
        if (score != -1) {
            System.out.println("找到成绩 92");
        }
        else {
            System.out.println("没有找到成绩 92");
        }
    }
}

