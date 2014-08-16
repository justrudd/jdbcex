package jdbcex;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static jdbcex.Coercions.coerceToBigDecimal;
import static jdbcex.OptionalAssertions.assertThat;

public class Coercions_BigDecimalTest {

    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<BigDecimal> opt = coerceToBigDecimal(null);
        assertThat(opt).isEmpty();
    }

    @Test
    public void sameWhenBigDecimalValueCoerced() {
        final BigDecimal bd = new BigDecimal("10.0");
        final Optional<BigDecimal> opt = coerceToBigDecimal(bd);
        assertThat(opt).isPresentAndSameAs(bd);
    }

    @Test
    public void bigIntegerValueCoerced() {
        final BigInteger bi = BigInteger.valueOf(random.nextLong());
        final Optional<BigDecimal> opt = coerceToBigDecimal(bi);
        assertThat(opt).isPresentAndEqualTo(new BigDecimal(bi));
    }

    @Test
    public void byteValueCoerced() {
        final Byte b = (byte)random.nextInt(Byte.MAX_VALUE);
        final Optional<BigDecimal> opt = coerceToBigDecimal(b);
        assertThat(opt).isPresentAndEqualTo(new BigDecimal(b.longValue()));
    }

    @Test
    public void shortValueCoerced() {
        final Short s = (short)random.nextInt(Short.MAX_VALUE);
        final Optional<BigDecimal> opt = coerceToBigDecimal(s);
        assertThat(opt).isPresentAndEqualTo(new BigDecimal(s.longValue()));
    }

    @Test
    public void integerValueCoerced() {
        final Integer i = random.nextInt();
        final Optional<BigDecimal> opt = coerceToBigDecimal(i);
        assertThat(opt).isPresentAndEqualTo(new BigDecimal(i.longValue()));
    }

    @Test
    public void bigDecimalWhenLongValueCoerced() {
        final Long l = random.nextLong();
        final Optional<BigDecimal> opt = coerceToBigDecimal(l);
        assertThat(opt).isPresentAndEqualTo(new BigDecimal(l.longValue()));
    }

    @Test
    public void floatValueCoerced() {
        final Float f = random.nextFloat();
        final Optional<BigDecimal> opt = coerceToBigDecimal(f);
        assertThat(opt).isPresentAndEqualTo(new BigDecimal(f.toString()));
    }

    @Test
    public void doubleValueCoerced() {
        final Double d = random.nextDouble();
        final Optional<BigDecimal> opt = coerceToBigDecimal(d);
        assertThat(opt).isPresentAndEqualTo(new BigDecimal(d.toString()));
    }

    @Test
    public void radix10DigitCharacterValueCoerced() {
        final Character c = '4';
        final Optional<BigDecimal> opt = coerceToBigDecimal(c);
        assertThat(opt).isPresentAndEqualTo(new BigDecimal(4));
    }

    @Test
    public void emptyWhenNonRadix10DigitCharacterValueCoerced() {
        final Character c = 'd';
        final Optional<BigDecimal> opt = coerceToBigDecimal(c);
        assertThat(opt).isEmpty();
    }

    @Test
    public void radix10StringValueCoerced() {
        final String s = "12345.12345";
        final Optional<BigDecimal> opt = coerceToBigDecimal(s);
        assertThat(opt).isPresentAndEqualTo(new BigDecimal(s));
    }

    @Test
    public void emptyWhenNonRadix10StringValueCoerced() {
        final String s = "0hello";
        final Optional<BigDecimal> opt = coerceToBigDecimal(s);
        assertThat(opt).isEmpty();
    }

    @Test
    public void emptyWhenOtherTypeValueCoerced() {
        final List<String> strings = new ArrayList<>();
        final Optional<BigDecimal> opt = coerceToBigDecimal(strings);
        assertThat(opt).isEmpty();
    }

    @Test
    public void trueValueCoerced() {
        final boolean b = true;
        final Optional<BigDecimal> opt = coerceToBigDecimal(b);
        assertThat(opt).isPresentAndEqualTo(BigDecimal.ONE);
    }

    @Test
    public void falseValueCoerced() {
        final boolean b = false;
        final Optional<BigDecimal> opt = coerceToBigDecimal(b);
        assertThat(opt).isPresentAndEqualTo(BigDecimal.ZERO);
    }

    private final Random random = new Random();
}
