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

public class Coercions_BigIntegerTest {

    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(null);
        assertThat(opt).isEmpty();
    }

    @Test
    public void sameWhenBigIntegerValueCoerced() {
        final BigInteger bd = BigInteger.valueOf(10);
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(bd);
        assertThat(opt).isPresentAndSameAs(bd);
    }

    @Test
    public void bigDecimalValueCoerced() {
        final BigDecimal bd = new BigDecimal("10");
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(bd);
        assertThat(opt).isPresentAndEqualTo(bd.toBigInteger());
    }

    @Test
    public void bigDecimalValueTruncatedWhenCoerced() {
        final BigDecimal bd = new BigDecimal("10.9002");
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(bd);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(10));
    }

    @Test
    public void byteValueCoerced() {
        final Byte b = (byte)random.nextInt(Byte.MAX_VALUE);
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(b);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(b.longValue()));
    }

    @Test
    public void shortValueCoerced() {
        final Short s = (short)random.nextInt(Short.MAX_VALUE);
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(s);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(s.longValue()));
    }

    @Test
    public void integerValueCoerced() {
        final Integer i = random.nextInt();
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(i);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(i.longValue()));
    }

    @Test
    public void bigDecimalWhenLongValueCoerced() {
        final Long l = random.nextLong();
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(l);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(l));
    }

    @Test
    public void floatValueCoerced() {
        final Float f = random.nextFloat();
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(f);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(f.longValue()));
    }

    @Test
    public void doubleValueCoerced() {
        final Double d = random.nextDouble();
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(d);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(d.longValue()));
    }

    @Test
    public void radix10DigitCharacterValueCoerced() {
        final Character c = '4';
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(c);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(4));
    }

    @Test
    public void emptyWhenNonRadix10DigitCharacterValueCoerced() {
        final Character c = 'd';
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(c);
        assertThat(opt).isEmpty();
    }

    @Test
    public void radix10StringValueCoerced() {
        final String s = "12345";
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(s);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(12345));
    }

    @Test
    public void emptyWhenNonRadix10StringValueCoerced() {
        final String s = "0hello";
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(s);
        assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenOtherTypeValueCoerced() {
        final List<String> strings = new ArrayList<>();
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(strings);
        assertThat(opt).isEmpty();
    }

    @Test
    public void trueValueCoerced() {
        final boolean b = true;
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(b);
        assertThat(opt).isPresentAndEqualTo(BigInteger.ONE);
    }

    @Test
    public void falseValueCoerced() {
        final boolean b = false;
        final Optional<BigInteger> opt = Coercions.coerceToBigInteger(b);
        assertThat(opt).isPresentAndEqualTo(BigInteger.ZERO);
    }

    private final Random random = new Random();

}
