package p7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.*;

class FibonacciTest {

    @ParameterizedTest
    @MethodSource("fibonacciParams")
    void fibonacci(int n, int expected) {
        // when
        int fibonacci = Fibonacci.fibonacci(n);
        // then
        assertThat(fibonacci).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "0 ,0",
            "6, 8",
            "10, 55",
            "11, 89"
    })
    void fibonacciV2(int n, int expected) {
        // when
        int fibonacci = Fibonacci.fibonacci(n);
        // then
        assertThat(fibonacci).isEqualTo(expected);
    }

    static Stream<Arguments> fibonacciParams() {
        return Stream.of(
                arguments(0, 0),
                arguments(1, 1),
                arguments(2, 1),
                arguments(6, 8),
                arguments(8, 21),
                arguments(9, 34),
                arguments(10, 55),
                arguments(11, 89),
                arguments(12, 144)
        );
    }
}