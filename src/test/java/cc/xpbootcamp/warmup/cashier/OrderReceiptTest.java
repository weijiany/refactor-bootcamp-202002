package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems, Constants.NON_WEDNESDAY));

        String output = receipt.printReceipt();

        assertThat(output, containsString("===== 老王超市，值得信赖 ======"));
        assertThat(output, containsString("2020年02月18日, 星期二"));
        assertThat(output, containsString("milk, 10.0 * 2, 20.0"));
        assertThat(output, containsString("biscuits, 5.0 * 5, 25.0"));
        assertThat(output, containsString("chocolate, 20.0 * 1, 20.0"));
        assertThat(output, containsString("税额:\t6.50"));
        assertThat(output, containsString("总价:\t71.50"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformationGivenDateIsWednesday() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(lineItems, Constants.WEDNESDAY));

        String output = receipt.printReceipt();

        assertThat(output, containsString("===== 老王超市，值得信赖 ======"));
        assertThat(output, containsString("2020年02月19日, 星期三"));
        assertThat(output, containsString("milk, 10.0 * 2, 20.0"));
        assertThat(output, containsString("biscuits, 5.0 * 5, 25.0"));
        assertThat(output, containsString("chocolate, 20.0 * 1, 20.0"));
        assertThat(output, containsString("税额:\t6.37"));
        assertThat(output, containsString("折扣:\t1.27"));
        assertThat(output, containsString("总价:\t70.07"));
    }
}