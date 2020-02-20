package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {
    @Test
    public void shouldRebateAllItemInWed() {
        Order order = new Order(Collections.singletonList(new LineItem("milk", 10.0, 2)), Constants.WEDNESDAY);

        String output = order.showItems();

        assertThat(output).contains("milk, 10.0 * 2, 20.0");
    }
}
