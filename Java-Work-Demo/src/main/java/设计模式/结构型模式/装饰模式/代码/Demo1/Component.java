package 设计模式.结构型模式.装饰模式.代码.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/2 11:13
 * @Description:  抽象界面构件类：抽象构件类，为了突出与模式相关的核心代码，对原有控件代码进行了大量的简化
 */
abstract  class Component {
    public abstract void display();
}

//窗体类：具体构件类

class Window extends Component {
    @Override
    public void display() {
        System.out.println("显示窗体！");
    }
}


//文本框类：具体构件类

class TextBox extends Component {
    @Override
    public void display() {
        System.out.println("显示文本框！");
    }
}

//列表框类：具体构件类

class ListBox extends Component {
    @Override
    public void display() {
        System.out.println("显示列表框！");
    }
}