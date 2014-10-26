package io.justrudd.jdbcex;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import static io.justrudd.jdbcex.Coercions.coerceToLocalDateTime;
import static io.justrudd.jdbcex.OptionalAssertions.assertThat;

public class Coercions_LocalDateTimeTest {
    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<LocalDateTime> opt = coerceToLocalDateTime(null);
        assertThat(opt).isEmpty();
    }

    @Test
    public void sameObjectWhenLocalDateCoerced() {
        final LocalDateTime value = LocalDateTime.now();
        final Optional<LocalDateTime> opt = coerceToLocalDateTime(value);
        assertThat(opt).isPresentAndSameAs(value);
    }

    @Test
    public void timestampValueIsProperlyCoerced() {
        final java.sql.Timestamp value = java.sql.Timestamp.valueOf(LocalDateTime.now());
        final Optional<LocalDateTime> opt = coerceToLocalDateTime(value);
        assertThat(opt).isPresentAndEqualTo(value.toLocalDateTime());
    }

    @Test
    public void dateValueIsProperlyCoerced() {
        final java.sql.Date value = java.sql.Date.valueOf(LocalDate.now());
        final Optional<LocalDateTime> opt = coerceToLocalDateTime(value);
        assertThat(opt).isPresentAndEqualTo(LocalDateTime.of(value.toLocalDate(), LocalTime.MIDNIGHT));
    }

    @Test
    public void stringValueIsProperlyCoerced() {
        final String bicentennialString = "1976-07-04T12:00:00";
        final Optional<LocalDateTime> opt = coerceToLocalDateTime(bicentennialString);
        assertThat(opt).isPresentAndEqualTo(BICENTENNIAL);
    }

    @Test
    public void badStringValueReturnsEmpty() {
        final String string = "hello world";
        final Optional<LocalDateTime> opt = coerceToLocalDateTime(string);
        assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenUnexpectedTypeCoerced() {
        final Byte value = 1;
        final Optional<LocalDateTime> opt = coerceToLocalDateTime(value);
        assertThat(opt).isEmpty();
    }

    private final LocalDateTime BICENTENNIAL = LocalDateTime.of(1976, 7, 4, 12, 0, 0);

}