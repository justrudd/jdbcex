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

public class Coercions_BooleanTest {

    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<Boolean> opt = Coercions.coerceToBoolean(null);
        OptionalAssertions.assertThat(opt).isEmpty();
    }

    @Test
    public void sameWhenBooleanValueCoerced() {
        final Boolean b = random.nextBoolean();
        final Optional<Boolean> opt = Coercions.coerceToBoolean(b);
        OptionalAssertions.assertThat(opt).isPresentAndSameAs(b);
    }

    @Test
    public void zeroByteValueCoercedToFalse() {
        final Byte b = 0;
        final Optional<Boolean> opt = Coercions.coerceToBoolean(b);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void nonZeroByteValueCoercedToTrue() {
        final Byte b = (byte)(random.nextInt(Byte.MAX_VALUE - 1) + 1);
        final Optional<Boolean> opt = Coercions.coerceToBoolean(b);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void zeroShortValueCoercedToFalse() {
        final Short s = 0;
        final Optional<Boolean> opt = Coercions.coerceToBoolean(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void nonZeroShortValueCoercedToTrue() {
        final Short s = (short)(random.nextInt(Short.MAX_VALUE - 1) + 1);
        final Optional<Boolean> opt = Coercions.coerceToBoolean(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void zeroIntegerValueCoercedToFalse() {
        final Integer i = 0;
        final Optional<Boolean> opt = Coercions.coerceToBoolean(i);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void nonZeroIntegerValueCoercedToTrue() {
        final Integer i = random.nextInt();
        final Optional<Boolean> opt = Coercions.coerceToBoolean(i);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void zeroLongValueCoercedToFalse() {
        final Long l = 0L;
        final Optional<Boolean> opt = Coercions.coerceToBoolean(l);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void nonZeroLongValueCoercedToTrue() {
        final Long l = random.nextLong();
        final Optional<Boolean> opt = Coercions.coerceToBoolean(l);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void zeroFloatValueCoercedToFalse() {
        final Float f = 0.0f;
        final Optional<Boolean> opt = Coercions.coerceToBoolean(f);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void nonZeroFloatValueCoercedToTrue() {
        // can't use Random.nextFloat because it returns a number in the range of
        // 0.0 to 1.0. So we just hard-code something...
        final Float f = 10.023f;
        final Optional<Boolean> opt = Coercions.coerceToBoolean(f);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void zeroDoubleValueCoercedToFalse() {
        final Double d = 0.0d;
        final Optional<Boolean> opt = Coercions.coerceToBoolean(d);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void nonZeroDoubleValueCoercedToTrue() {
        // can't use Random.nextDouble because it returns a number in the range of
        // 0.0 to 1.0. So we just hard-code something...
        final Double d = 10.023d;
        final Optional<Boolean> opt = Coercions.coerceToBoolean(d);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void zeroBigIntegerValueCoercedToFalse() {
        final BigInteger bi = BigInteger.valueOf(0);
        final Optional<Boolean> opt = Coercions.coerceToBoolean(bi);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void nonZeroBigIntegerValueCoercedToTrue() {
        final BigInteger bi = BigInteger.valueOf(random.nextLong());
        final Optional<Boolean> opt = Coercions.coerceToBoolean(bi);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void zeroBigDecimalValueCoercedToFalse() {
        final BigDecimal bd = new BigDecimal("0");
        final Optional<Boolean> opt = Coercions.coerceToBoolean(bd);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void nonZeroBigDecimalValueCoercedToTrue() {
        final BigDecimal bd = new BigDecimal("10.00218");
        final Optional<Boolean> opt = Coercions.coerceToBoolean(bd);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void tCharacterValueCoercedToTrue() {
        final Character c = 't';
        final Optional<Boolean> opt = Coercions.coerceToBoolean(c);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void yCharacterValueCoercedToTrue() {
        final Character c = 'y';
        final Optional<Boolean> opt = Coercions.coerceToBoolean(c);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void nonZeroDigitCharacterValueCoercedToTrue() {
        final Character c = '4';
        final Optional<Boolean> opt = Coercions.coerceToBoolean(c);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void fCharacterValueCoercedToFalse() {
        final Character c = 'f';
        final Optional<Boolean> opt = Coercions.coerceToBoolean(c);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void nCharacterValueCoercedToFalse() {
        final Character c = 'n';
        final Optional<Boolean> opt = Coercions.coerceToBoolean(c);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void zeroDigitCharacterValueCoercedToFalse() {
        final Character c = '0';
        final Optional<Boolean> opt = Coercions.coerceToBoolean(c);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void emptyWhenNonExpectedCharacterCoerced() {
        final Character c = 'z';
        final Optional<Boolean> opt = Coercions.coerceToBoolean(c);
        OptionalAssertions.assertThat(opt).isEmpty();
    }

    @Test
    public void tStringValueCoercedToTrue() {
        final String s = "t";
        final Optional<Boolean> opt = Coercions.coerceToBoolean(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void yStringValueCoercedToTrue() {
        final String s = "y";
        final Optional<Boolean> opt = Coercions.coerceToBoolean(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void nonZeroDigitStringValueCoercedToTrue() {
        final String s = "2";
        final Optional<Boolean> opt = Coercions.coerceToBoolean(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void fStringValueCoercedToFalse() {
        final String s = "f";
        final Optional<Boolean> opt = Coercions.coerceToBoolean(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void nStringValueCoercedToFalse() {
        final String s = "n";
        final Optional<Boolean> opt = Coercions.coerceToBoolean(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void zeroDigitStringValueCoercedToFalse() {
        final String s = "0";
        final Optional<Boolean> opt = Coercions.coerceToBoolean(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void emptyStringValueCoercedToFalse() {
        final String s = "";
        final Optional<Boolean> opt = Coercions.coerceToBoolean(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void trueStringValueCoercedToTrue() {
        final String s = "true";
        final Optional<Boolean> opt = Coercions.coerceToBoolean(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void yesStringValueCoercedToTrue() {
        final String s = "yes";
        final Optional<Boolean> opt = Coercions.coerceToBoolean(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void onStringValueCoercedToTrue() {
        final String s = "on";
        final Optional<Boolean> opt = Coercions.coerceToBoolean(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(true);
    }

    @Test
    public void falseStringValueCoercedToFalse() {
        final String s = "false";
        final Optional<Boolean> opt = Coercions.coerceToBoolean(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void noStringValueCoercedToFalse() {
        final String s = "no";
        final Optional<Boolean> opt = Coercions.coerceToBoolean(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void offStringValueCoercedToFalse() {
        final String s = "off";
        final Optional<Boolean> opt = Coercions.coerceToBoolean(s);
        OptionalAssertions.assertThat(opt).isPresentAndEqualTo(false);
    }

    @Test
    public void emptyWhenRandomCharacterValueCoerced() {
        final Character c = 'z';
        final Optional<Boolean> opt = Coercions.coerceToBoolean(c);
        OptionalAssertions.assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenRandomStringValueCoerced() {
        final String s = "hello";
        final Optional<Boolean> opt = Coercions.coerceToBoolean(s);
        OptionalAssertions.assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenOtherTypeValueCoerced() {
        final List<String> strings = new ArrayList<>();
        final Optional<Boolean> opt = Coercions.coerceToBoolean(strings);
        OptionalAssertions.assertThat(opt).isEmpty();
    }

    private final Random random = new Random();

}
