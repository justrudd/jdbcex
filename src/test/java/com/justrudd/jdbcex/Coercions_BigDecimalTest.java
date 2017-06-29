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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.junit.Test;

public class Coercions_BigDecimalTest {

    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<BigDecimal> opt = Coercions.coerceToBigDecimal(null);
        OptionalAssertions.assertThat(opt).isEmpty();
    }

    @Test
    public void sameWhenBigDecimalValueCoerced() {
        final BigDecimal bd = new BigDecimal("10.0");
        final Optional<BigDecimal> opt = Coercions.coerceToBigDecimal(bd);
        OptionalAssertions.assertThat(opt).isPresentAndSameAs(bd);
    }

    @Test
    public void bigIntegerValueCoerced() {
        final BigInteger bi = BigInteger.valueOf(random.nextLong());
        final Optional<BigDecimal> opt = Coercions.coerceToBigDecimal(bi);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(new BigDecimal(bi));
    }

    @Test
    public void byteValueCoerced() {
        final Byte b = (byte)random.nextInt(Byte.MAX_VALUE);
        final Optional<BigDecimal> opt = Coercions.coerceToBigDecimal(b);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(new BigDecimal(b.longValue()));
    }

    @Test
    public void shortValueCoerced() {
        final Short s = (short)random.nextInt(Short.MAX_VALUE);
        final Optional<BigDecimal> opt = Coercions.coerceToBigDecimal(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(new BigDecimal(s.longValue()));
    }

    @Test
    public void integerValueCoerced() {
        final Integer i = random.nextInt();
        final Optional<BigDecimal> opt = Coercions.coerceToBigDecimal(i);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(new BigDecimal(i.longValue()));
    }

    @Test
    public void bigDecimalWhenLongValueCoerced() {
        final Long l = random.nextLong();
        final Optional<BigDecimal> opt = Coercions.coerceToBigDecimal(l);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(new BigDecimal(l.longValue()));
    }

    @Test
    public void floatValueCoerced() {
        final Float f = random.nextFloat();
        final Optional<BigDecimal> opt = Coercions.coerceToBigDecimal(f);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(new BigDecimal(f.toString()));
    }

    @Test
    public void doubleValueCoerced() {
        final Double d = random.nextDouble();
        final Optional<BigDecimal> opt = Coercions.coerceToBigDecimal(d);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(new BigDecimal(d.toString()));
    }

    @Test
    public void radix10DigitCharacterValueCoerced() {
        final Character c = '4';
        final Optional<BigDecimal> opt = Coercions.coerceToBigDecimal(c);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(new BigDecimal(4));
    }

    @Test
    public void emptyWhenNonRadix10DigitCharacterValueCoerced() {
        final Character c = 'd';
        final Optional<BigDecimal> opt = Coercions.coerceToBigDecimal(c);
        OptionalAssertions.assertThat(opt).isEmpty();
    }

    @Test
    public void radix10StringValueCoerced() {
        final String s = "12345.12345";
        final Optional<BigDecimal> opt = Coercions.coerceToBigDecimal(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(new BigDecimal(s));
    }

    @Test
    public void emptyWhenNonRadix10StringValueCoerced() {
        final String s = "0hello";
        final Optional<BigDecimal> opt = Coercions.coerceToBigDecimal(s);
        OptionalAssertions.assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenOtherTypeValueCoerced() {
        final List<String> strings = new ArrayList<>();
        final Optional<BigDecimal> opt = Coercions.coerceToBigDecimal(strings);
        OptionalAssertions.assertThat(opt).isEmpty();
    }

    @Test
    public void trueValueCoerced() {
        final boolean b = true;
        final Optional<BigDecimal> opt = Coercions.coerceToBigDecimal(b);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(BigDecimal.ONE);
    }

    @Test
    public void falseValueCoerced() {
        final boolean b = false;
        final Optional<BigDecimal> opt = Coercions.coerceToBigDecimal(b);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(BigDecimal.ZERO);
    }

    private final Random random = new Random();
}
