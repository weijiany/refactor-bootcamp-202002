package cc.xpbootcamp.warmup.cashier;

public class LineItem {
	private String desc;
	private double price;
	private int qty;

	public LineItem(String desc, double price, int qty) {
		this.desc = desc;
		this.price = price;
		this.qty = qty;
	}

	double totalAmount() {
        return price * qty;
    }

	public double totalAmountWithSale() {
		return totalAmount() + salesTax();
	}

	public double salesTax() {
		return totalAmount() * .10;
	}

	public String print() {
		return desc +
				'\t' +
				price +
				'\t' +
				qty +
				'\t' +
				price * qty +
				'\n';
	}
}