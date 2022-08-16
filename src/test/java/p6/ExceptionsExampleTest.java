package p6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static p6.ExceptionsExample.DEFAULT_NUMBER;

class ExceptionsExampleTest {

    private ExceptionsExample exceptionsExample = new ExceptionsExample();

    @Test
    void shouldReturnStringFromNumberIfNumberIsLessThanDefault() {
        // given
        int i = 1;
        // when
        String string = exceptionsExample.doSomething(i);
        // then
        assertThat(string).isEqualTo("1");
    }

    @Test
    void shouldReturnStringFromNumberIfNumberIsEqualDefault() {
        // when
        String string = exceptionsExample.doSomething(DEFAULT_NUMBER);
        // then
        assertThat(string).isEqualTo(String.valueOf(DEFAULT_NUMBER));
    }

    @Test
    void shouldThrowExceptionIfNumberIsGreaterThatDefault() {
        // given
        int i = 10;
        // when
        assertThrows(IllegalArgumentException.class,
                () -> exceptionsExample.doSomething(i),
                "Parametr jest większy od 5"
        );

        Assertions.assertThatThrownBy(() -> exceptionsExample.doSomething(i))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Parametr jest większy od 5");
    }
}