package jdbcex;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static jdbcex.Coercions.coerceToLocalDate;
import static jdbcex.OptionalAssertions.assertThat;

public class Coercions_LocalDateTest {

    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<LocalDate> opt = coerceToLocalDate(null);
        assertThat(opt).isEmpty();
    }

    @Test
    public void sameObjectWhenLocalDateCoerced() {
        final LocalDate value = LocalDate.now();
        final Optional<LocalDate> opt = coerceToLocalDate(value);
        assertThat(opt).isPresentAndSameAs(value);
    }

    @Test
    public void dateValueIsProperlyCoerced() {
        final java.sql.Date value = java.sql.Date.valueOf(LocalDate.now());
        final Optional<LocalDate> opt = coerceToLocalDate(value);
        assertThat(opt).isPresentAndEqualTo(value.toLocalDate());
    }

    @Test
    public void timestampValueIsProperlyCoerced() {
        final java.sql.Timestamp value = java.sql.Timestamp.valueOf(LocalDateTime.now());
        final Optional<LocalDate> opt = coerceToLocalDate(value);
        assertThat(opt).isPresentAndEqualTo(value.toLocalDateTime().toLocalDate());
    }

    @Test
    public void emptyWhenUnexpectedTypeCoerced() {
        final String value = "blah blah";
        final Optional<LocalDate> opt = coerceToLocalDate(value);
        assertThat(opt).isEmpty();
    }

}
