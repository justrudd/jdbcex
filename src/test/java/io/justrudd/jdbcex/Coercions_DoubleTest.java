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
