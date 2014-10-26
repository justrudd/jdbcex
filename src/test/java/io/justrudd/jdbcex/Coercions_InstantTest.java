package io.justrudd.jdbcex;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

import static io.justrudd.jdbcex.Coercions.coerceToInstant;
import static io.justrudd.jdbcex.OptionalAssertions.assertThat;

public class Coercions_InstantTest {

    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<Instant> opt = coerceToInstant(null);
        assertThat(opt).isEmpty();
    }

    @Test
    public void sameObjectWhenLocalDateCoerced() {
        final Instant value = Instant.now();
        final Optional<Instant> opt = coerceToInstant(value);
        assertThat(opt).isPresentAndSameAs(value);
    }

    @Test
    public void timestampValueIsProperlyCoerced() {
        final java.sql.Timestamp value = java.sql.Timestamp.valueOf(LocalDateTime.now());
        final Optional<Instant> opt = coerceToInstant(value);
        assertThat(opt).isPresentAndEqualTo(value.toInstant());
    }

    @Test
    public void integerValueIsProperlyCoerced() {
        final Integer bicentennialEpochSeconds = 205329600;
        final Optional<Instant> opt = coerceToInstant(bicentennialEpochSeconds);
        assertThat(opt).isPresentAndEqualTo(BICENTENNIAL);
    }

    @Test
    public void longValueIsProperlyCoerced() {
        final Long bicentennialEpochMilliSeconds = 205329600000L;
        final Optional<Instant> opt = coerceToInstant(bicentennialEpochMilliSeconds);
        assertThat(opt).isPresentAndEqualTo(BICENTENNIAL);
    }

    @Test
    public void stringValueIsProperlyCoerced() {
        final String bicentennialString = "1976-07-04T12:00:00Z";
        final Optional<Instant> opt = coerceToInstant(bicentennialString);
        assertThat(opt).isPresentAndEqualTo(BICENTENNIAL);
    }

    @Test
    public void badStringValueReturnsEmpty() {
        final String string = "hello world";
        final Optional<Instant> opt = coerceToInstant(string);
        assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenUnexpectedTypeCoerced() {
        final Byte value = 1;
        final Optional<Instant> opt = coerceToInstant(value);
        assertThat(opt).isEmpty();
    }

    private final Instant BICENTENNIAL = LocalDateTime.of(1976, 7, 4, 12, 0, 0).toInstant(ZoneOffset.UTC);
}
