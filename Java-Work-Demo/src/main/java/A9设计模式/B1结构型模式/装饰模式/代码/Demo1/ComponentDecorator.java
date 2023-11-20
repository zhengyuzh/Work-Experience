package A9设计模式.B1结构型模式.装饰模式.代码.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/2 11:15
 * @Description:  构件装饰类：抽象装饰类
 */
public  class ComponentDecorator extends Component {
    private Component component; //维持对抽象构建类型对象的引用

    public ComponentDecorator(Component component) {  //注入抽象构建类型的对象
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}

//滚动条装饰类：具体装饰类
class ScrollBarDecorator extends ComponentDecorator {

    public ScrollBarDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        this.setScrollBar();
        super.display();
    }

    public void setScrollBar() {
        System.out.println("为构件增加滚动条！");
    }
}

//黑色边框装饰类：具体装饰类
class BlackBorderDecorator extends ComponentDecorator {

    public BlackBorderDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        this.setBlackBorder();
        super.display();
    }

    public void setBlackBorder() {
        System.out.println("为构件增加黑色边框！");
    }

}