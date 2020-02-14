package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

    private static Object[][] generateValue() {
        return new Object[][] {
                {1, 1},
                {2, 1}
        };
    }

    @ParameterizedTest
    @MethodSource("generateValue")
    public void should_return_correct_value_when_calculate_given_specific_position(int in, int expect) {
        assertEquals(expect, new Fibonacci().calculate(in));
    }
}