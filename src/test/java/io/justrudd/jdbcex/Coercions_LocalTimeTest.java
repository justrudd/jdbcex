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

import static io.justrudd.jdbcex.Coercions.coerceToLocalTime;
import static io.justrudd.jdbcex.OptionalAssertions.assertThat;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import org.junit.Test;

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
