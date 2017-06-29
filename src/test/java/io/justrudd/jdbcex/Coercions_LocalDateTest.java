/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.justrudd.jdbcex;

import static io.justrudd.jdbcex.Coercions.coerceToLocalDate;
import static io.justrudd.jdbcex.OptionalAssertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.Test;

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
    public void stringValueIsProperlyCoerced() {
        final String value = "1976-07-04";
        final Optional<LocalDate> opt = coerceToLocalDate(value);
        assertThat(opt).isPresentAndEqualTo(LocalDate.of(1976, 7, 4));
    }

    @Test
    public void badStringIsEmptyValue() {
        final String value = "hello world";
        final Optional<LocalDate> opt = coerceToLocalDate(value);
        assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenUnexpectedTypeCoerced() {
        final Byte value = 1;
        final Optional<LocalDate> opt = coerceToLocalDate(value);
        assertThat(opt).isEmpty();
    }

}
