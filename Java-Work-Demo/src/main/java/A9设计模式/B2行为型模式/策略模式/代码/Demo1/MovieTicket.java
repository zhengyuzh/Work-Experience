package A9设计模式.B2行为型模式.策略模式.代码.Demo1;

/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/2 9:34
 * @Description:  电影票类：环境类
 */
class MovieTicket {
    private double price;
    private Discount discount; //维持一个对抽象折扣类的引用

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 注入一个折扣类对象
     * @param discount
     */
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getPrice() {
        //调用折扣类的折扣价计算方法
        return discount.calculate(this.price);
    }
}
