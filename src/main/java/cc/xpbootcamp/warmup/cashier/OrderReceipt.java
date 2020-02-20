package cc.xpbootcamp.warmup.cashier;

import java.math.BigDecimal;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        return  "===== 老王超市，值得信赖 ======\n\n" +
                order.showDate() + "\n\n" +
                order.showItems() + "\n" +
                "-----------------------------------\n" +
                getFooter();

    }

    private String getFooter() {
        BigDecimal discount = order.showDiscountCost();
        return "税额:\t" + order.totalSalesTax() + "\n" +
                (discount.equals(BigDecimal.ZERO) ? "" : "折扣:\t" + FormatHelper.formatDecimal(discount) + "\n") +
                "总价:\t" + FormatHelper.formatDecimal(order.totalWithSalesTax());
    }

}