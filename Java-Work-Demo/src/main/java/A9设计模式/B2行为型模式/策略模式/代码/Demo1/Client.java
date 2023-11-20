package A9设计模式.B2行为型模式.策略模式.代码.Demo1;



/**
 * @author zyz
 * @version 1.0
 * @data 2023/11/2 9:35
 * @Description:
 */
class Client {
    public static void main(String args[]) {
        MovieTicket mt = new MovieTicket();
        double originalPrice = 60.0;
        double currentPrice;

        mt.setPrice(originalPrice);
        System.out.println("原始价为：" + originalPrice);
        System.out.println("---------------------------------");

        Discount discount;
        discount = new StudentDiscount();
        mt.setDiscount(discount); //注入折扣对象

        currentPrice = mt.getPrice();
        System.out.println("折后价为：" + currentPrice);
    }
}

