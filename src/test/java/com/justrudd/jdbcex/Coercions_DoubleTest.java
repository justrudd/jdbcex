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

public class Coercions_DoubleTest {

    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<Double> opt = Coercions.coerceToDouble(null);
        assertThat(opt).isEmpty();
    }

    @Test
    public void sameObjectWhenDoubleValueCoerced() {
        final Double d = 1000.98d;
        final Optional<Double> opt = Coercions.coerceToDouble(d);
        assertThat(opt).isPresentAndSameAs(d);
    }

    @Test
    public void byteValueIsProperlyWidenedWhenCoerced() {
        final Byte b = (byte)random.nextInt(Byte.MAX_VALUE);
        final Optional<Double> opt = Coercions.coerceToDouble(b);
        assertThat(opt).isPresentAndEqualTo(b.doubleValue());
    }

    @Test
    public void shortValueIsProperlyWidenedWhenCoerced() {
        final Short s = (short)random.nextInt(Short.MAX_VALUE);
        final Optional<Double> opt = Coercions.coerceToDouble(s);
        assertThat(opt).isPresentAndEqualTo(s.doubleValue());
    }

    @Test
    public void intValueIsProperlyWidenedWhenCoerced() {
        final Integer i = random.nextInt();
        final Optional<Double> opt = Coercions.coerceToDouble(i);
        assertThat(opt).isPresentAndEqualTo(i.doubleValue());
    }

    @Test
    public void longValueIsProperlyWidenedWhenCoerced() {
        final Long l = random.nextLong();
        final Optional<Double> opt = Coercions.coerceToDouble(l);
        assertThat(opt).isPresentAndEqualTo(l.doubleValue());
    }

    @Test
    public void floatValueIsProperlyTruncatedWhenCoerced() {
        final Float f = 10.9023f;
        final Optional<Double> opt = Coercions.coerceToDouble(f);
        assertThat(opt).isPresentAndEqualTo(f.doubleValue());
    }

    @Test
    public void bigDoubleIsProperlyNarrowedWhenCoerced() {
        final BigInteger bi = BigInteger.valueOf(random.nextLong());
        final Optional<Double> opt = Coercions.coerceToDouble(bi);
        assertThat(opt).isPresentAndEqualTo(bi.doubleValue());
    }

    @Test
    public void bigDecimalIsProperlyTruncateWhenCoerced() {
        final BigDecimal bd = new BigDecimal("23.600912");
        final Optional<Double> opt = Coercions.coerceToDouble(bd);
        assertThat(opt).isPresentAndEqualTo(bd.doubleValue());
    }

    @Test
    public void trueBooleanValueIsOneWhenCoerced() {
        final Boolean b = Boolean.TRUE;
        final Optional<Double> opt = Coercions.coerceToDouble(b);
        assertThat(opt).isPresentAndEqualTo(1.0d);
    }

    @Test
    public void falseBooleanValueIsOneWhenCoerced() {
        final Boolean b = Boolean.FALSE;
        final Optional<Double> opt = Coercions.coerceToDouble(b);
        assertThat(opt).isPresentAndEqualTo(0.0d);
    }

    @Test
    public void radix10CharacterProperlyCoerced() {
        final Character c = '8';
        final Optional<Double> opt = Coercions.coerceToDouble(c);
        assertThat(opt).isPresentAndEqualTo(8d);
    }

    @Test
    public void emptyWhenNonRadix10CharacterIsCoerced() {
        final Character c = 'x';
        final Optional<Double> opt = Coercions.coerceToDouble(c);
        assertThat(opt).isEmpty();
    }

    @Test
    public void radix10StringProperlyCoerced() {
        final String s = "9687.6912";
        final Optional<Double> opt = Coercions.coerceToDouble(s);
        assertThat(opt).isPresentAndEqualTo(9687.6912d);
    }

    @Test
    public void emptyWhenNonRadix10StringIsCoerced() {
        final String s = "blah";
        final Optional<Double> opt = Coercions.coerceToDouble(s);
        assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenUnknownTypeIsCoerced() {
        final List<String> strings = new ArrayList<>();
        final Optional<Double> opt = Coercions.coerceToDouble(strings);
        assertThat(opt).isEmpty();
    }

    private final Random random = new Random();

}
