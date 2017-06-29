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

package com.justrudd.jdbcex;

import static com.justrudd.jdbcex.OptionalAssertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import org.junit.Test;

public class Coercions_LocalDateTimeTest {
    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<LocalDateTime> opt = Coercions.coerceToLocalDateTime(null);
        assertThat(opt).isEmpty();
    }

    @Test
    public void sameObjectWhenLocalDateCoerced() {
        final LocalDateTime value = LocalDateTime.now();
        final Optional<LocalDateTime> opt = Coercions.coerceToLocalDateTime(value);
        assertThat(opt).isPresentAndSameAs(value);
    }

    @Test
    public void timestampValueIsProperlyCoerced() {
        final java.sql.Timestamp value = java.sql.Timestamp.valueOf(LocalDateTime.now());
        final Optional<LocalDateTime> opt = Coercions.coerceToLocalDateTime(value);
        assertThat(opt).isPresentAndEqualTo(value.toLocalDateTime());
    }

    @Test
    public void dateValueIsProperlyCoerced() {
        final java.sql.Date value = java.sql.Date.valueOf(LocalDate.now());
        final Optional<LocalDateTime> opt = Coercions.coerceToLocalDateTime(value);
        assertThat(opt).isPresentAndEqualTo(LocalDateTime.of(value.toLocalDate(), LocalTime.MIDNIGHT));
    }

    @Test
    public void stringValueIsProperlyCoerced() {
        final String bicentennialString = "1976-07-04T12:00:00";
        final Optional<LocalDateTime> opt = Coercions.coerceToLocalDateTime(bicentennialString);
        assertThat(opt).isPresentAndEqualTo(BICENTENNIAL);
    }

    @Test
    public void badStringValueReturnsEmpty() {
        final String string = "hello world";
        final Optional<LocalDateTime> opt = Coercions.coerceToLocalDateTime(string);
        assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenUnexpectedTypeCoerced() {
        final Byte value = 1;
        final Optional<LocalDateTime> opt = Coercions.coerceToLocalDateTime(value);
        assertThat(opt).isEmpty();
    }

    private final LocalDateTime BICENTENNIAL = LocalDateTime.of(1976, 7, 4, 12, 0, 0);

}
