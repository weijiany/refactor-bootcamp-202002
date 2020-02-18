package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {
    @Test
    public void shouldRebateAllItemInWed() {
        Order order = new Order(null, null, Collections.singletonList(new LineItem("milk", 10.0, 2)), StringConstants.WEDNESDAY);

        String output = order.print();

        assertThat(output).contains("milk\t9.8\t2\t19.6\n");
    }
}
