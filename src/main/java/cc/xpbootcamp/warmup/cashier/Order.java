package cc.xpbootcamp.warmup.cashier;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private List<LineItem> lineItemList;
    LocalDate date;
    private BigDecimal disCount;

    public Order(List<LineItem> lineItemList, LocalDate date) {
        this.lineItemList = lineItemList;
        this.date = date;
        disCount = getDiscount(date);
    }

    public String showItems() {
        return lineItemList
                        .stream()
                        .map(LineItem::print)
                        .collect(Collectors.joining());
    }

    private BigDecimal total() {
        return lineItemList
                .stream()
                .map(LineItem::totalAmount)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add)
            .multiply(disCount);
    }

    public BigDecimal totalSalesTax() {
        return total().multiply(BigDecimal.valueOf(.1));
    }

    private BigDecimal getDiscount(LocalDate date) {
        return BigDecimal.valueOf(isWednesday(date) ? 0.98 : 1);
    }

    private boolean isWednesday(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.WEDNESDAY;
    }

    public String showDate() {
        return date.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日, 星期")) + StringConstants.WEEK_DAYS[date.getDayOfWeek().getValue()];
    }

    public BigDecimal totalWithSalesTax() {
        return total().add(totalSalesTax());
    }

    public BigDecimal showDiscountCost() {
        return disCount.doubleValue() == 1
                ? BigDecimal.ZERO
                : total().multiply(BigDecimal.ONE.subtract(disCount));
    }
}
