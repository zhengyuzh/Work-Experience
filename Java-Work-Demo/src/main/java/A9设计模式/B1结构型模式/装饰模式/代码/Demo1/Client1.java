package A9设计模式.B1结构型模式.装饰模式.代码.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/2 11:17
 * @Description:
 */
public class Client1 {
    public static void main(String[] args) {
        Component component,component1,component2;
        component = new Window();
        component1 = new ScrollBarDecorator(component);

        component2 = new BlackBorderDecorator(component1);
        component2.display();
    }
}
