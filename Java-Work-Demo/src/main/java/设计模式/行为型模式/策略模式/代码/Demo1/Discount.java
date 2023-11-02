package 设计模式.行为型模式.策略模式.代码.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/2 9:31
 * @Description: 定义抽象类 及具体实现
 */
public interface Discount {
    double calculate(double price);
}

//学生票折扣类：具体策略类
class StudentDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("学生票：");
        return price * 0.8;
    }
}


//儿童票折扣类：具体策略类
class ChildrenDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("儿童票：");
        return price - 10;
    }
}


//VIP会员票折扣类：具体策略类
class VIPDiscount implements Discount {
    @Override
    public double calculate(double price) {
        System.out.println("VIP票：");
        System.out.println("增加积分！");
        return price * 0.5;
    }
}
