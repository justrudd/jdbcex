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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static io.justrudd.jdbcex.Coercions.coerceToLocalDate;
import static io.justrudd.jdbcex.OptionalAssertions.assertThat;

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
