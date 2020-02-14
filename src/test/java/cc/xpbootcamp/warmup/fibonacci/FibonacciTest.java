package cc.xpbootcamp.warmup.fibonacci;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FibonacciTest {

    private static Object[][] generateValue() {
        return new Object[][] {
                {1, 1},
                {2, 1},
                {3, 2},
                {4, 3},
                {5, 5},
                {6, 8},
                {7, 13},
                {8, 21},
                {9, 34},
                {10, 55},
                {50, 12586269025L}
        };
    }

    @ParameterizedTest
    @MethodSource("generateValue")
    public void should_return_correct_value_when_calculate_given_specific_position(int in, long expect) {
        assertThat(new Fibonacci().calculate(in), Matchers.equalTo(expect));
    }

    @Test
    public void should_throw_exception_when_calculate_given_position_is_negative() {
        assertThrows(RuntimeException.class, () -> new Fibonacci().calculate(-1));
    }
}