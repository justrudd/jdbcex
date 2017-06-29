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

public class Coercions_ShortTest {

    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<Short> opt = Coercions.coerceToShort(null);
        assertThat(opt).isEmpty();
    }

    @Test
    public void sameObjectWhenShortValueCoerced() {
        final Short s = 10;
        final Optional<Short> opt = Coercions.coerceToShort(s);
        assertThat(opt).isPresentAndSameAs(s);
    }

    @Test
    public void byteValueIsProperlyWidenedWhenCoerced() {
        final Byte b = (byte)random.nextInt(Byte.MAX_VALUE);
        final Optional<Short> opt = Coercions.coerceToShort(b);
        assertThat(opt).isPresentAndEqualTo(b.shortValue());
    }

    @Test
    public void intValueIsProperlyNarrowedWhenCoerced() {
        final Integer i = random.nextInt();
        final Optional<Short> opt = Coercions.coerceToShort(i);
        assertThat(opt).isPresentAndEqualTo(i.shortValue());
    }

    @Test
    public void shortValueIsProperlyNarrowedWhenCoerced() {
        final Long l = random.nextLong();
        final Optional<Short> opt = Coercions.coerceToShort(l);
        assertThat(opt).isPresentAndEqualTo(l.shortValue());
    }

    @Test
    public void floatValueIsProperlyTruncatedWhenCoerced() {
        final Float f = 10.9023f;
        final Optional<Short> opt = Coercions.coerceToShort(f);
        assertThat(opt).isPresentAndEqualTo(f.shortValue());
    }

    @Test
    public void doubleValueIsProperlyTruncatedWhenCoerced() {
        final Double d = 10.9023d;
        final Optional<Short> opt = Coercions.coerceToShort(d);
        assertThat(opt).isPresentAndEqualTo(d.shortValue());
    }

    @Test
    public void bigShortIsProperlyNarrowedWhenCoerced() {
        final BigInteger bi = BigInteger.valueOf(random.nextLong());
        final Optional<Short> opt = Coercions.coerceToShort(bi);
        assertThat(opt).isPresentAndEqualTo(bi.shortValue());
    }

    @Test
    public void bigDecimalIsProperlyTruncateWhenCoerced() {
        final BigDecimal bd = new BigDecimal("23.600912");
        final Optional<Short> opt = Coercions.coerceToShort(bd);
        assertThat(opt).isPresentAndEqualTo(bd.shortValue());
    }

    @Test
    public void trueBooleanValueIsOneWhenCoerced() {
        final Boolean b = Boolean.TRUE;
        final Optional<Short> opt = Coercions.coerceToShort(b);
        assertThat(opt).isPresentAndEqualTo((short) 1);
    }

    @Test
    public void falseBooleanValueIsOneWhenCoerced() {
        final Boolean b = Boolean.FALSE;
        final Optional<Short> opt = Coercions.coerceToShort(b);
        assertThat(opt).isPresentAndEqualTo((short) 0);
    }

    @Test
    public void radix10CharacterProperlyCoerced() {
        final Character c = '8';
        final Optional<Short> opt = Coercions.coerceToShort(c);
        assertThat(opt).isPresentAndEqualTo((short) 8);
    }

    @Test
    public void emptyWhenNonRadix10CharacterIsCoerced() {
        final Character c = 'x';
        final Optional<Short> opt = Coercions.coerceToShort(c);
        assertThat(opt).isEmpty();
    }

    @Test
    public void radix10StringProperlyCoerced() {
        final String s = "9687";
        final Optional<Short> opt = Coercions.coerceToShort(s);
        assertThat(opt).isPresentAndEqualTo((short) 9687);
    }

    @Test
    public void emptyWhenNonRadix10StringIsCoerced() {
        final String s = "blah";
        final Optional<Short> opt = Coercions.coerceToShort(s);
        assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenUnknownTypeIsCoerced() {
        final List<String> strings = new ArrayList<>();
        final Optional<Short> opt = Coercions.coerceToShort(strings);
        assertThat(opt).isEmpty();
    }

    private final Random random = new Random();

}
