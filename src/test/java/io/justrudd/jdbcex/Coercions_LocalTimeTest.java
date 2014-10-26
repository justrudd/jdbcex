/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */

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
    public void stringValueIsProperlyCoerced() {
        final String value = "10:00:30";
        final Optional<LocalTime> opt = coerceToLocalTime(value);
        assertThat(opt).isPresentAndEqualTo(LocalTime.of(10, 0, 30));
    }

    @Test
    public void badStringIsEmptyValue() {
        final String value = "hello world";
        final Optional<LocalTime> opt = coerceToLocalTime(value);
        assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenUnexpectedTypeCoerced() {
        final Byte value = 1;
        final Optional<LocalTime> opt = coerceToLocalTime(value);
        assertThat(opt).isEmpty();
    }

}
