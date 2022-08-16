package p1;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateFormatterTest {

    @Test
    void shouldFormatDateToYearMonthString() {
        // given
        LocalDate date = LocalDate.of(2020, 2, 25);
        // when
        String dateString = DateFormatter.format(date);
        // then
        assertEquals("2020-02", dateString);
    }
}