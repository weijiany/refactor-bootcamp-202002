package cc.xpbootcamp.warmup.cashier;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private String cName;
    private String addr;
    private List<LineItem> lineItemList;
    private double rebate;

    public Order(String cName, String addr, List<LineItem> lineItemList, LocalDate date) {
        this.cName = cName;
        this.addr = addr;
        this.lineItemList = lineItemList;
        rebate = getRebate(date);
    }

    public String print() {
        return cName +
                addr +
                lineItemList
                        .stream()
                        .map(l -> l.print(rebate))
                        .collect(Collectors.joining());
    }

    public double tot() {
        return lineItemList
                .stream()
                .mapToDouble(l -> l.totalAmountWithSale(rebate))
                .sum();
    }

    public double totSalesTx() {
        return lineItemList
                .stream()
                .mapToDouble(l -> l.salesTax(rebate))
                .sum();
    }

    private double getRebate(LocalDate date) {
        return isWednesday(date) ? 0.98 : 1;
    }

    private boolean isWednesday(LocalDate date) {
        return date.getDayOfWeek().getValue() == 3;
    }
}
