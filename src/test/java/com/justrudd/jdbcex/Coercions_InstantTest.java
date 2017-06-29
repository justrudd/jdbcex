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

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;
import org.junit.Test;

public class Coercions_InstantTest {

    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<Instant> opt = Coercions.coerceToInstant(null);
        OptionalAssertions.assertThat(opt).isEmpty();
    }

    @Test
    public void sameObjectWhenLocalDateCoerced() {
        final Instant value = Instant.now();
        final Optional<Instant> opt = Coercions.coerceToInstant(value);
        OptionalAssertions.assertThat(opt).isPresentAndSameAs(value);
    }

    @Test
    public void timestampValueIsProperlyCoerced() {
        final java.sql.Timestamp value = java.sql.Timestamp.valueOf(LocalDateTime.now());
        final Optional<Instant> opt = Coercions.coerceToInstant(value);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(value.toInstant());
    }

    @Test
    public void integerValueIsProperlyCoerced() {
        final Integer bicentennialEpochSeconds = 205329600;
        final Optional<Instant> opt = Coercions.coerceToInstant(bicentennialEpochSeconds);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(BICENTENNIAL);
    }

    @Test
    public void longValueIsProperlyCoerced() {
        final Long bicentennialEpochMilliSeconds = 205329600000L;
        final Optional<Instant> opt = Coercions.coerceToInstant(bicentennialEpochMilliSeconds);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(BICENTENNIAL);
    }

    @Test
    public void stringValueIsProperlyCoerced() {
        final String bicentennialString = "1976-07-04T12:00:00Z";
        final Optional<Instant> opt = Coercions.coerceToInstant(bicentennialString);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(BICENTENNIAL);
    }

    @Test
    public void badStringValueReturnsEmpty() {
        final String string = "hello world";
        final Optional<Instant> opt = Coercions.coerceToInstant(string);
        OptionalAssertions.assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenUnexpectedTypeCoerced() {
        final Byte value = 1;
        final Optional<Instant> opt = Coercions.coerceToInstant(value);
        OptionalAssertions.assertThat(opt).isEmpty();
    }

    private final Instant BICENTENNIAL = LocalDateTime.of(1976, 7, 4, 12, 0, 0).toInstant(ZoneOffset.UTC);
}
