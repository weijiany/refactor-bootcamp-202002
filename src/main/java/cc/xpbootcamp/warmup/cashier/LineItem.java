package cc.xpbootcamp.warmup.cashier;

import java.math.BigDecimal;

public class LineItem {
	private String desc;
	private BigDecimal price;
	private int qty;

	public LineItem(String desc, double price, int qty) {
		this.desc = desc;
		this.price = BigDecimal.valueOf(price);
		this.qty = qty;
	}

	BigDecimal totalAmount() {
        return price.multiply(BigDecimal.valueOf(qty));
    }

	public String print() {
		return desc +
				", " +
				price + " * " + qty +
				", " +
				FormatHelper.formatDecimal(totalAmount()) +
				'\n';
	}
}