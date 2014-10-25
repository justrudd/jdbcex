/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */

package io.justrudd.jdbcex;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static io.justrudd.jdbcex.Coercions.coerceToDouble;
import static io.justrudd.jdbcex.OptionalAssertions.assertThat;

public class Coercions_DoubleTest {

    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<Double> opt = coerceToDouble(null);
        assertThat(opt).isEmpty();
    }

    @Test
    public void sameObjectWhenDoubleValueCoerced() {
        final Double d = 1000.98d;
        final Optional<Double> opt = coerceToDouble(d);
        assertThat(opt).isPresentAndSameAs(d);
    }

    @Test
    public void byteValueIsProperlyWidenedWhenCoerced() {
        final Byte b = (byte)random.nextInt(Byte.MAX_VALUE);
        final Optional<Double> opt = coerceToDouble(b);
        assertThat(opt).isPresentAndEqualTo(b.doubleValue());
    }

    @Test
    public void shortValueIsProperlyWidenedWhenCoerced() {
        final Short s = (short)random.nextInt(Short.MAX_VALUE);
        final Optional<Double> opt = coerceToDouble(s);
        assertThat(opt).isPresentAndEqualTo(s.doubleValue());
    }

    @Test
    public void intValueIsProperlyWidenedWhenCoerced() {
        final Integer i = random.nextInt();
        final Optional<Double> opt = coerceToDouble(i);
        assertThat(opt).isPresentAndEqualTo(i.doubleValue());
    }

    @Test
    public void longValueIsProperlyWidenedWhenCoerced() {
        final Long l = random.nextLong();
        final Optional<Double> opt = coerceToDouble(l);
        assertThat(opt).isPresentAndEqualTo(l.doubleValue());
    }

    @Test
    public void floatValueIsProperlyTruncatedWhenCoerced() {
        final Float f = 10.9023f;
        final Optional<Double> opt = coerceToDouble(f);
        assertThat(opt).isPresentAndEqualTo(f.doubleValue());
    }

    @Test
    public void bigDoubleIsProperlyNarrowedWhenCoerced() {
        final BigInteger bi = BigInteger.valueOf(random.nextLong());
        final Optional<Double> opt = coerceToDouble(bi);
        assertThat(opt).isPresentAndEqualTo(bi.doubleValue());
    }

    @Test
    public void bigDecimalIsProperlyTruncateWhenCoerced() {
        final BigDecimal bd = new BigDecimal("23.600912");
        final Optional<Double> opt = coerceToDouble(bd);
        assertThat(opt).isPresentAndEqualTo(bd.doubleValue());
    }

    @Test
    public void trueBooleanValueIsOneWhenCoerced() {
        final Boolean b = Boolean.TRUE;
        final Optional<Double> opt = coerceToDouble(b);
        assertThat(opt).isPresentAndEqualTo(1.0d);
    }

    @Test
    public void falseBooleanValueIsOneWhenCoerced() {
        final Boolean b = Boolean.FALSE;
        final Optional<Double> opt = coerceToDouble(b);
        assertThat(opt).isPresentAndEqualTo(0.0d);
    }

    @Test
    public void radix10CharacterProperlyCoerced() {
        final Character c = '8';
        final Optional<Double> opt = coerceToDouble(c);
        assertThat(opt).isPresentAndEqualTo(8d);
    }

    @Test
    public void emptyWhenNonRadix10CharacterIsCoerced() {
        final Character c = 'x';
        final Optional<Double> opt = coerceToDouble(c);
        assertThat(opt).isEmpty();
    }

    @Test
    public void radix10StringProperlyCoerced() {
        final String s = "9687.6912";
        final Optional<Double> opt = coerceToDouble(s);
        assertThat(opt).isPresentAndEqualTo(9687.6912d);
    }

    @Test
    public void emptyWhenNonRadix10StringIsCoerced() {
        final String s = "blah";
        final Optional<Double> opt = coerceToDouble(s);
        assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenUnknownTypeIsCoerced() {
        final List<String> strings = new ArrayList<>();
        final Optional<Double> opt = coerceToDouble(strings);
        assertThat(opt).isEmpty();
    }

    private final Random random = new Random();

}
