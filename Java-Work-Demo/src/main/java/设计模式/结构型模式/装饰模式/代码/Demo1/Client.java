package 设计模式.结构型模式.装饰模式.代码.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/2 11:17
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        Component component ,componentSB;   //使用抽象构件定义
        component = new Window();   //定义具体构件
        componentSB = new ScrollBarDecorator(component);//定义装饰后的构件
        componentSB.display();
    }
}