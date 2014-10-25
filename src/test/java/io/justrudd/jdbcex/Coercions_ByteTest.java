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

import static io.justrudd.jdbcex.Coercions.coerceToByte;
import static io.justrudd.jdbcex.OptionalAssertions.assertThat;

public class Coercions_ByteTest {

    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<Byte> opt = coerceToByte(null);
        assertThat(opt).isEmpty();
    }

    @Test
    public void sameObjectWhenByteValueCoerced() {
        final Byte i = 10;
        final Optional<Byte> opt = coerceToByte(i);
        assertThat(opt).isPresentAndSameAs(i);
    }

    @Test
    public void shortValueIsProperlyWidenedWhenCoerced() {
        final Short s = (short)random.nextInt(Short.MAX_VALUE);
        final Optional<Byte> opt = coerceToByte(s);
        assertThat(opt).isPresentAndEqualTo(s.byteValue());
    }

    @Test
    public void longValueIsProperlyNarrowedWhenCoerced() {
        final Long l = random.nextLong();
        final Optional<Byte> opt = coerceToByte(l);
        assertThat(opt).isPresentAndEqualTo(l.byteValue());
    }

    @Test
    public void floatValueIsProperlyTruncatedWhenCoerced() {
        final Float f = 10.9023f;
        final Optional<Byte> opt = coerceToByte(f);
        assertThat(opt).isPresentAndEqualTo(f.byteValue());
    }

    @Test
    public void doubleValueIsProperlyTruncatedWhenCoerced() {
        final Double d = 10.9023d;
        final Optional<Byte> opt = coerceToByte(d);
        assertThat(opt).isPresentAndEqualTo(d.byteValue());
    }

    @Test
    public void bigByteIsProperlyNarrowedWhenCoerced() {
        final BigInteger bi = BigInteger.valueOf(random.nextLong());
        final Optional<Byte> opt = coerceToByte(bi);
        assertThat(opt).isPresentAndEqualTo(bi.byteValue());
    }

    @Test
    public void bigDecimalIsProperlyTruncateWhenCoerced() {
        final BigDecimal bd = new BigDecimal("23.600912");
        final Optional<Byte> opt = coerceToByte(bd);
        assertThat(opt).isPresentAndEqualTo(bd.byteValue());
    }

    @Test
    public void trueBooleanValueIsOneWhenCoerced() {
        final Boolean b = Boolean.TRUE;
        final Optional<Byte> opt = coerceToByte(b);
        assertThat(opt).isPresentAndEqualTo((byte)1);
    }

    @Test
    public void falseBooleanValueIsOneWhenCoerced() {
        final Boolean b = Boolean.FALSE;
        final Optional<Byte> opt = coerceToByte(b);
        assertThat(opt).isPresentAndEqualTo((byte)0);
    }

    @Test
    public void radix10CharacterProperlyCoerced() {
        final Character c = '8';
        final Optional<Byte> opt = coerceToByte(c);
        assertThat(opt).isPresentAndEqualTo((byte)8);
    }

    @Test
    public void emptyWhenNonRadix10CharacterIsCoerced() {
        final Character c = 'x';
        final Optional<Byte> opt = coerceToByte(c);
        assertThat(opt).isEmpty();
    }

    @Test
    public void radix10StringProperlyCoerced() {
        final String s = "49";
        final Optional<Byte> opt = coerceToByte(s);
        assertThat(opt).isPresentAndEqualTo((byte)49);
    }

    @Test
    public void emptyWhenNonRadix10StringIsCoerced() {
        final String s = "blah";
        final Optional<Byte> opt = coerceToByte(s);
        assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenUnknownTypeIsCoerced() {
        final List<String> strings = new ArrayList<>();
        final Optional<Byte> opt = coerceToByte(strings);
        assertThat(opt).isEmpty();
    }

    private final Random random = new Random();

}
