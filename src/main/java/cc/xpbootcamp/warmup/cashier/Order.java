package cc.xpbootcamp.warmup.cashier;

import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private String cName;
    private String addr;
    private List<LineItem> lineItemList;

    public Order(String cName, String addr, List<LineItem> lineItemList) {
        this.cName = cName;
        this.addr = addr;
        this.lineItemList = lineItemList;
    }

    public String print() {
        return cName +
                addr +
                lineItemList
                        .stream()
                        .map(LineItem::print)
                        .collect(Collectors.joining());
    }

    public double tot() {
        return lineItemList
                .stream()
                .mapToDouble(LineItem::totalAmountWithSale)
                .sum();
    }

    public double totSalesTx() {
        return lineItemList
                .stream()
                .mapToDouble(LineItem::salesTax)
                .sum();
    }
}
