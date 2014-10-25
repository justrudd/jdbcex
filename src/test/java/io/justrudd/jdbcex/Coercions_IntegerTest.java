package io.justrudd.jdbcex;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static io.justrudd.jdbcex.Coercions.coerceToInteger;
import static io.justrudd.jdbcex.OptionalAssertions.assertThat;

public class Coercions_IntegerTest {

    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<Integer> opt = coerceToInteger(null);
        assertThat(opt).isEmpty();
    }

    @Test
    public void sameObjectWhenIntegerValueCoerced() {
        final Integer i = 10;
        final Optional<Integer> opt = coerceToInteger(i);
        assertThat(opt).isPresentAndSameAs(i);
    }

    @Test
    public void byteValueIsProperlyWidenedWhenCoerced() {
        final Byte b = (byte)random.nextInt(Byte.MAX_VALUE);
        final Optional<Integer> opt = coerceToInteger(b);
        assertThat(opt).isPresentAndEqualTo(b.intValue());
    }

    @Test
    public void shortValueIsProperlyWidenedWhenCoerced() {
        final Short s = (short)random.nextInt(Short.MAX_VALUE);
        final Optional<Integer> opt = coerceToInteger(s);
        assertThat(opt).isPresentAndEqualTo(s.intValue());
    }

    @Test
    public void longValueIsProperlyNarrowedWhenCoerced() {
        final Long l = random.nextLong();
        final Optional<Integer> opt = coerceToInteger(l);
        assertThat(opt).isPresentAndEqualTo(l.intValue());
    }

    @Test
    public void floatValueIsProperlyTruncatedWhenCoerced() {
        final Float f = 10.9023f;
        final Optional<Integer> opt = coerceToInteger(f);
        assertThat(opt).isPresentAndEqualTo(f.intValue());
    }

    @Test
    public void doubleValueIsProperlyTruncatedWhenCoerced() {
        final Double d = 10.9023d;
        final Optional<Integer> opt = coerceToInteger(d);
        assertThat(opt).isPresentAndEqualTo(d.intValue());
    }

    @Test
    public void bigIntegerIsProperlyNarrowedWhenCoerced() {
        final BigInteger bi = BigInteger.valueOf(random.nextLong());
        final Optional<Integer> opt = coerceToInteger(bi);
        assertThat(opt).isPresentAndEqualTo(bi.intValue());
    }

    @Test
    public void bigDecimalIsProperlyTruncateWhenCoerced() {
        final BigDecimal bd = new BigDecimal("23.600912");
        final Optional<Integer> opt = coerceToInteger(bd);
        assertThat(opt).isPresentAndEqualTo(bd.intValue());
    }

    @Test
    public void trueBooleanValueIsOneWhenCoerced() {
        final Boolean b = Boolean.TRUE;
        final Optional<Integer> opt = coerceToInteger(b);
        assertThat(opt).isPresentAndEqualTo(1);
    }

    @Test
    public void falseBooleanValueIsOneWhenCoerced() {
        final Boolean b = Boolean.FALSE;
        final Optional<Integer> opt = coerceToInteger(b);
        assertThat(opt).isPresentAndEqualTo(0);
    }

    @Test
    public void radix10CharacterProperlyCoerced() {
        final Character c = '8';
        final Optional<Integer> opt = coerceToInteger(c);
        assertThat(opt).isPresentAndEqualTo(8);
    }

    @Test
    public void emptyWhenNonRadix10CharacterIsCoerced() {
        final Character c = 'x';
        final Optional<Integer> opt = coerceToInteger(c);
        assertThat(opt).isEmpty();
    }

    @Test
    public void radix10StringProperlyCoerced() {
        final String s = "96876912";
        final Optional<Integer> opt = coerceToInteger(s);
        assertThat(opt).isPresentAndEqualTo(96876912);
    }

    @Test
    public void emptyWhenNonRadix10StringIsCoerced() {
        final String s = "blah";
        final Optional<Integer> opt = coerceToInteger(s);
        assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenUnknownTypeIsCoerced() {
        final List<String> strings = new ArrayList<>();
        final Optional<Integer> opt = coerceToInteger(strings);
        assertThat(opt).isEmpty();
    }

    private final Random random = new Random();

}
