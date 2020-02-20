package cc.xpbootcamp.warmup.cashier;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class FormatHelper {
    static String formatDecimal(BigDecimal decimal) {
        return new DecimalFormat("0.00").format(decimal);
    }
}
