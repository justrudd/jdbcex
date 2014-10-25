package io.justrudd.jdbcex;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static io.justrudd.jdbcex.Coercions.coerceToBigInteger;
import static io.justrudd.jdbcex.OptionalAssertions.assertThat;

public class Coercions_BigIntegerTest {

    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<BigInteger> opt = coerceToBigInteger(null);
        assertThat(opt).isEmpty();
    }

    @Test
    public void sameWhenBigIntegerValueCoerced() {
        final BigInteger bd = BigInteger.valueOf(10);
        final Optional<BigInteger> opt = coerceToBigInteger(bd);
        assertThat(opt).isPresentAndSameAs(bd);
    }

    @Test
    public void bigDecimalValueCoerced() {
        final BigDecimal bd = new BigDecimal("10");
        final Optional<BigInteger> opt = coerceToBigInteger(bd);
        assertThat(opt).isPresentAndEqualTo(bd.toBigInteger());
    }

    @Test
    public void bigDecimalValueTruncatedWhenCoerced() {
        final BigDecimal bd = new BigDecimal("10.9002");
        final Optional<BigInteger> opt = coerceToBigInteger(bd);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(10));
    }

    @Test
    public void byteValueCoerced() {
        final Byte b = (byte)random.nextInt(Byte.MAX_VALUE);
        final Optional<BigInteger> opt = coerceToBigInteger(b);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(b.longValue()));
    }

    @Test
    public void shortValueCoerced() {
        final Short s = (short)random.nextInt(Short.MAX_VALUE);
        final Optional<BigInteger> opt = coerceToBigInteger(s);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(s.longValue()));
    }

    @Test
    public void integerValueCoerced() {
        final Integer i = random.nextInt();
        final Optional<BigInteger> opt = coerceToBigInteger(i);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(i.longValue()));
    }

    @Test
    public void bigDecimalWhenLongValueCoerced() {
        final Long l = random.nextLong();
        final Optional<BigInteger> opt = coerceToBigInteger(l);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(l));
    }

    @Test
    public void floatValueCoerced() {
        final Float f = random.nextFloat();
        final Optional<BigInteger> opt = coerceToBigInteger(f);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(f.longValue()));
    }

    @Test
    public void doubleValueCoerced() {
        final Double d = random.nextDouble();
        final Optional<BigInteger> opt = coerceToBigInteger(d);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(d.longValue()));
    }

    @Test
    public void radix10DigitCharacterValueCoerced() {
        final Character c = '4';
        final Optional<BigInteger> opt = coerceToBigInteger(c);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(4));
    }

    @Test
    public void emptyWhenNonRadix10DigitCharacterValueCoerced() {
        final Character c = 'd';
        final Optional<BigInteger> opt = coerceToBigInteger(c);
        assertThat(opt).isEmpty();
    }

    @Test
    public void radix10StringValueCoerced() {
        final String s = "12345";
        final Optional<BigInteger> opt = coerceToBigInteger(s);
        assertThat(opt).isPresentAndEqualTo(BigInteger.valueOf(12345));
    }

    @Test
    public void emptyWhenNonRadix10StringValueCoerced() {
        final String s = "0hello";
        final Optional<BigInteger> opt = coerceToBigInteger(s);
        assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenOtherTypeValueCoerced() {
        final List<String> strings = new ArrayList<>();
        final Optional<BigInteger> opt = coerceToBigInteger(strings);
        assertThat(opt).isEmpty();
    }

    @Test
    public void trueValueCoerced() {
        final boolean b = true;
        final Optional<BigInteger> opt = coerceToBigInteger(b);
        assertThat(opt).isPresentAndEqualTo(BigInteger.ONE);
    }

    @Test
    public void falseValueCoerced() {
        final boolean b = false;
        final Optional<BigInteger> opt = coerceToBigInteger(b);
        assertThat(opt).isPresentAndEqualTo(BigInteger.ZERO);
    }

    private final Random random = new Random();

}
