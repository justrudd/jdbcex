package io.justrudd.jdbcex;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static io.justrudd.jdbcex.Coercions.coerceToFloat;
import static io.justrudd.jdbcex.OptionalAssertions.assertThat;

public class Coercions_FloatTest {

    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<Float> opt = coerceToFloat(null);
        assertThat(opt).isEmpty();
    }

    @Test
    public void sameObjectWhenFloatValueCoerced() {
        final Float f = 1000.98f;
        final Optional<Float> opt = coerceToFloat(f);
        assertThat(opt).isPresentAndSameAs(f);
    }

    @Test
    public void byteValueIsProperlyWidenedWhenCoerced() {
        final Byte b = (byte)random.nextInt(Byte.MAX_VALUE);
        final Optional<Float> opt = coerceToFloat(b);
        assertThat(opt).isPresentAndEqualTo(b.floatValue());
    }

    @Test
    public void shortValueIsProperlyWidenedWhenCoerced() {
        final Short s = (short)random.nextInt(Short.MAX_VALUE);
        final Optional<Float> opt = coerceToFloat(s);
        assertThat(opt).isPresentAndEqualTo(s.floatValue());
    }

    @Test
    public void intValueIsProperlyWidenedWhenCoerced() {
        final Integer i = random.nextInt();
        final Optional<Float> opt = coerceToFloat(i);
        assertThat(opt).isPresentAndEqualTo(i.floatValue());
    }

    @Test
    public void longValueIsProperlyWidenedWhenCoerced() {
        final Long l = random.nextLong();
        final Optional<Float> opt = coerceToFloat(l);
        assertThat(opt).isPresentAndEqualTo(l.floatValue());
    }

    @Test
    public void floatValueIsProperlyNarrowedWhenCoerced() {
        final Double d = 10.9023d;
        final Optional<Float> opt = coerceToFloat(d);
        assertThat(opt).isPresentAndEqualTo(d.floatValue());
    }

    @Test
    public void bigFloatIsProperlyNarrowedWhenCoerced() {
        final BigInteger bi = BigInteger.valueOf(random.nextLong());
        final Optional<Float> opt = coerceToFloat(bi);
        assertThat(opt).isPresentAndEqualTo(bi.floatValue());
    }

    @Test
    public void bigDecimalIsProperlyTruncateWhenCoerced() {
        final BigDecimal bd = new BigDecimal("23.600912");
        final Optional<Float> opt = coerceToFloat(bd);
        assertThat(opt).isPresentAndEqualTo(bd.floatValue());
    }

    @Test
    public void trueBooleanValueIsOneWhenCoerced() {
        final Boolean b = Boolean.TRUE;
        final Optional<Float> opt = coerceToFloat(b);
        assertThat(opt).isPresentAndEqualTo(1.0f);
    }

    @Test
    public void falseBooleanValueIsOneWhenCoerced() {
        final Boolean b = Boolean.FALSE;
        final Optional<Float> opt = coerceToFloat(b);
        assertThat(opt).isPresentAndEqualTo(0.0f);
    }

    @Test
    public void radix10CharacterProperlyCoerced() {
        final Character c = '8';
        final Optional<Float> opt = coerceToFloat(c);
        assertThat(opt).isPresentAndEqualTo(8f);
    }

    @Test
    public void emptyWhenNonRadix10CharacterIsCoerced() {
        final Character c = 'x';
        final Optional<Float> opt = coerceToFloat(c);
        assertThat(opt).isEmpty();
    }

    @Test
    public void radix10StringProperlyCoerced() {
        final String s = "9687.6912";
        final Optional<Float> opt = coerceToFloat(s);
        assertThat(opt).isPresentAndEqualTo(9687.6912f);
    }

    @Test
    public void emptyWhenNonRadix10StringIsCoerced() {
        final String s = "blah";
        final Optional<Float> opt = coerceToFloat(s);
        assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenUnknownTypeIsCoerced() {
        final List<String> strings = new ArrayList<>();
        final Optional<Float> opt = coerceToFloat(strings);
        assertThat(opt).isEmpty();
    }

    private final Random random = new Random();

}
