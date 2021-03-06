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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.junit.Test;

public class Coercions_LongTest {
    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<Long> opt = Coercions.coerceToLong(null);
        assertThat(opt).isEmpty();
    }

    @Test
    public void sameObjectWhenLongValueCoerced() {
        final Long l = 10L;
        final Optional<Long> opt = Coercions.coerceToLong(l);
        assertThat(opt).isPresentAndSameAs(l);
    }

    @Test
    public void byteValueIsProperlyWidenedWhenCoerced() {
        final Byte b = (byte)random.nextInt(Byte.MAX_VALUE);
        final Optional<Long> opt = Coercions.coerceToLong(b);
        assertThat(opt).isPresentAndEqualTo(b.longValue());
    }

    @Test
    public void shortValueIsProperlyWidenedWhenCoerced() {
        final Short s = (short)random.nextInt(Short.MAX_VALUE);
        final Optional<Long> opt = Coercions.coerceToLong(s);
        assertThat(opt).isPresentAndEqualTo(s.longValue());
    }

    @Test
    public void intValueIsProperlyWidenedWhenCoerced() {
        final Integer i = random.nextInt();
        final Optional<Long> opt = Coercions.coerceToLong(i);
        assertThat(opt).isPresentAndEqualTo(i.longValue());
    }

    @Test
    public void floatValueIsProperlyTruncatedWhenCoerced() {
        final Float f = 10.9023f;
        final Optional<Long> opt = Coercions.coerceToLong(f);
        assertThat(opt).isPresentAndEqualTo(f.longValue());
    }

    @Test
    public void doubleValueIsProperlyTruncatedWhenCoerced() {
        final Double d = 10.9023d;
        final Optional<Long> opt = Coercions.coerceToLong(d);
        assertThat(opt).isPresentAndEqualTo(d.longValue());
    }

    @Test
    public void bigLongIsProperlyNarrowedWhenCoerced() {
        final BigInteger bi = BigInteger.valueOf(random.nextLong());
        final Optional<Long> opt = Coercions.coerceToLong(bi);
        assertThat(opt).isPresentAndEqualTo(bi.longValue());
    }

    @Test
    public void bigDecimalIsProperlyTruncateWhenCoerced() {
        final BigDecimal bd = new BigDecimal("23.600912");
        final Optional<Long> opt = Coercions.coerceToLong(bd);
        assertThat(opt).isPresentAndEqualTo(bd.longValue());
    }

    @Test
    public void trueBooleanValueIsOneWhenCoerced() {
        final Boolean b = Boolean.TRUE;
        final Optional<Long> opt = Coercions.coerceToLong(b);
        assertThat(opt).isPresentAndEqualTo(1L);
    }

    @Test
    public void falseBooleanValueIsOneWhenCoerced() {
        final Boolean b = Boolean.FALSE;
        final Optional<Long> opt = Coercions.coerceToLong(b);
        assertThat(opt).isPresentAndEqualTo(0L);
    }

    @Test
    public void radix10CharacterProperlyCoerced() {
        final Character c = '8';
        final Optional<Long> opt = Coercions.coerceToLong(c);
        assertThat(opt).isPresentAndEqualTo(8L);
    }

    @Test
    public void emptyWhenNonRadix10CharacterIsCoerced() {
        final Character c = 'x';
        final Optional<Long> opt = Coercions.coerceToLong(c);
        assertThat(opt).isEmpty();
    }

    @Test
    public void radix10StringProperlyCoerced() {
        final String s = "96876912";
        final Optional<Long> opt = Coercions.coerceToLong(s);
        assertThat(opt).isPresentAndEqualTo(96876912L);
    }

    @Test
    public void emptyWhenNonRadix10StringIsCoerced() {
        final String s = "blah";
        final Optional<Long> opt = Coercions.coerceToLong(s);
        assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenUnknownTypeIsCoerced() {
        final List<String> strings = new ArrayList<>();
        final Optional<Long> opt = Coercions.coerceToLong(strings);
        assertThat(opt).isEmpty();
    }

    private final Random random = new Random();

}
