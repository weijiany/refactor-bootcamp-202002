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

	double totalAmount(double rebate) {
        return rebate * price * qty;
    }

	public double totalAmountWithSale(double rebate) {
		return totalAmount(rebate) + salesTax(rebate);
	}

	public double salesTax(double rebate) {
		return totalAmount(rebate) * .10;
	}

	public String print(double rebate) {
		return desc +
				'\t' +
				price * rebate +
				'\t' +
				qty +
				'\t' +
				totalAmount(rebate) +
				'\n';
	}
}