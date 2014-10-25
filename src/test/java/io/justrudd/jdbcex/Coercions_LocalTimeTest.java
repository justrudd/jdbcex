package io.justrudd.jdbcex;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import static io.justrudd.jdbcex.Coercions.coerceToLocalTime;
import static io.justrudd.jdbcex.OptionalAssertions.assertThat;

public class Coercions_LocalTimeTest {

    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<LocalTime> opt = coerceToLocalTime(null);
        assertThat(opt).isEmpty();
    }

    @Test
    public void sameObjectWhenLocalDateCoerced() {
        final LocalTime value = LocalTime.now();
        final Optional<LocalTime> opt = coerceToLocalTime(value);
        assertThat(opt).isPresentAndSameAs(value);
    }

    @Test
    public void dateValueIsProperlyCoerced() {
        final java.sql.Time value = java.sql.Time.valueOf(LocalTime.now());
        final Optional<LocalTime> opt = coerceToLocalTime(value);
        assertThat(opt).isPresentAndEqualTo(value.toLocalTime());
    }

    @Test
    public void timestampValueIsProperlyCoerced() {
        final java.sql.Timestamp value = java.sql.Timestamp.valueOf(LocalDateTime.now());
        final Optional<LocalTime> opt = coerceToLocalTime(value);
        assertThat(opt).isPresentAndEqualTo(value.toLocalDateTime().toLocalTime());
    }

    @Test
    public void emptyWhenUnexpectedTypeCoerced() {
        final String value = "blah blah";
        final Optional<LocalTime> opt = coerceToLocalTime(value);
        assertThat(opt).isEmpty();
    }

}
