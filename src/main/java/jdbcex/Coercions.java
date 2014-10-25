package jdbcex;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.function.Function;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;
import static java.util.function.Function.identity;
import static jdbcex.typeof.TypeOf.whenTypeOf;

final class Coercions {

    static Optional<BigDecimal> coerceToBigDecimal(final Object o) {
        if (o == null) {
            return empty();
        }

        final BigDecimal result =
                whenTypeOf(o)
                    .is(BigDecimal.class).thenReturn(identity())
                    .is(BigInteger.class).thenReturn(BigDecimal::new)
                    .is(Byte.class).thenReturn(v -> new BigDecimal(v.longValue()))
                    .is(Short.class).thenReturn(v -> new BigDecimal(v.longValue()))
                    .is(Integer.class).thenReturn(v -> new BigDecimal(v.longValue()))
                    .is(Long.class).thenReturn(v -> new BigDecimal(v.longValue()))
                    .is(Number.class).thenReturn(v -> Conv.stringToBigDecimal(v.toString()))
                    .is(Boolean.class).thenReturn(v -> v ? BigDecimal.ONE : BigDecimal.ZERO)
                    .is(Character.class).thenReturn(Conv::characterToBigDecimal)
                    .is(String.class).thenReturn(Conv::stringToBigDecimal)
                    .orElse(Conv::nullValue);

        return ofNullable(result);
    }

    static Optional<BigInteger> coerceToBigInteger(final Object o) {
        if (o == null) {
            return empty();
        }

        final BigInteger result =
                whenTypeOf(o)
                    .is(BigInteger.class).thenReturn(identity())
                    .is(BigDecimal.class).thenReturn(BigDecimal::toBigInteger)
                    .is(Number.class).thenReturn(v -> BigInteger.valueOf(v.longValue()))
                    .is(Boolean.class).thenReturn(v -> v ? BigInteger.ONE : BigInteger.ZERO)
                    .is(Character.class).thenReturn(Conv::characterToBigInteger)
                    .is(String.class).thenReturn(Conv::stringToBigInteger)
                    .orElse(Conv::nullValue);

        return ofNullable(result);
    }

    static Optional<Boolean> coerceToBoolean(final Object o) {
        if (o == null) {
            return empty();
        }

        final Boolean result =
                whenTypeOf(o)
                    .is(Boolean.class).thenReturn(identity())
                    .is(Number.class).thenReturn(v -> v.intValue() != 0)
                    .is(Character.class).thenReturn(Conv::characterToBoolean)
                    .is(String.class).thenReturn(Conv::stringToBoolean)
                    .orElse(Conv::nullValue);

        return ofNullable(result);
    }

    static Optional<Byte> coerceToByte(final Object o) {
        if (o == null) {
            return empty();
        }

        final Byte result =
                whenTypeOf(o)
                    .is(Byte.class).thenReturn(identity())
                    .is(Number.class).thenReturn(Number::byteValue)
                    .is(Boolean.class).thenReturn(v -> v ? (byte)1 : 0)
                    .is(Character.class).thenReturn(Conv::characterToByte)
                    .is(String.class).thenReturn(Conv::stringToByte)
                    .orElse(Conv::nullValue);

        return ofNullable(result);
    }

    static Optional<Character> coerceToCharacter(final Object o) {
        if (o == null) {
            return empty();
        }

        final Character result =
                whenTypeOf(o)
                    .is(Character.class).thenReturn(identity())
                    .is(String.class).thenReturn(v -> v.length() == 1 ? v.charAt(0) : null)
                    .is(Boolean.class).thenReturn(v -> v ? 't' : 'f')
                    .orElse(Conv::nullValue);

        return ofNullable(result);
    }

    static Optional<Double> coerceToDouble(final Object o) {
        if (o == null) {
            return empty();
        }

        final Double result =
                whenTypeOf(o)
                    .is(Double.class).thenReturn(identity())
                    .is(Number.class).thenReturn(Number::doubleValue)
                    .is(Boolean.class).thenReturn(v -> v ? 1.0d : 0.0d)
                    .is(Character.class).thenReturn(Conv::characterToDouble)
                    .is(String.class).thenReturn(Conv::stringToDouble)
                    .orElse(Conv::nullValue);

        return ofNullable(result);
    }

    static Optional<Float> coerceToFloat(final Object o) {
        if (o == null) {
            return empty();
        }

        final Float result =
                whenTypeOf(o)
                    .is(Float.class).thenReturn(identity())
                    .is(Number.class).thenReturn(Number::floatValue)
                    .is(Boolean.class).thenReturn(v -> v ? 1.0f : 0.0f)
                    .is(Character.class).thenReturn(Conv::characterToFloat)
                    .is(String.class).thenReturn(Conv::stringToFloat)
                    .orElse(Conv::nullValue);

        return ofNullable(result);
    }

    static Optional<Integer> coerceToInteger(final Object o) {
        if (o == null) {
            return empty();
        }

        final Integer result =
                whenTypeOf(o)
                    .is(Integer.class).thenReturn(identity())
                    .is(Number.class).thenReturn(Number::intValue)
                    .is(Boolean.class).thenReturn(v -> v ? 1 : 0)
                    .is(Character.class).thenReturn(Conv::characterToInteger)
                    .is(String.class).thenReturn(Conv::stringToInteger)
                    .orElse(Conv::nullValue);

        return ofNullable(result);
    }

    static Optional<LocalDate> coerceToLocalDate(final Object o) {
        if (o == null) {
            return empty();
        }

        final LocalDate result =
                whenTypeOf(o)
                    .is(LocalDate.class).thenReturn(identity())
                    .is(Date.class).thenReturn(Date::toLocalDate)
                    .is(Timestamp.class).thenReturn(ts -> ts.toLocalDateTime().toLocalDate())
                    .orElse(Conv::nullValue);

        return ofNullable(result);
    }

    static Optional<LocalTime> coerceToLocalTime(final Object o) {
        if (o == null) {
            return empty();
        }

        final LocalTime result =
                whenTypeOf(o)
                    .is(LocalTime.class).thenReturn(identity())
                    .is(Time.class).thenReturn(Time::toLocalTime)
                    .is(Timestamp.class).thenReturn(ts -> ts.toLocalDateTime().toLocalTime())
                    .orElse(Conv::nullValue);

        return ofNullable(result);
    }

    static Optional<Long> coerceToLong(final Object o) {
        if (o == null) {
            return empty();
        }

        final Long result =
                whenTypeOf(o)
                    .is(Long.class).thenReturn(identity())
                    .is(Number.class).thenReturn(Number::longValue)
                    .is(Boolean.class).thenReturn(v -> v ? (long) 1 : 0)
                    .is(Character.class).thenReturn(Conv::characterToLong)
                    .is(String.class).thenReturn(Conv::stringToLong)
                    .orElse(Conv::nullValue);

        return ofNullable(result);
    }

    static Optional<Short> coerceToShort(final Object o) {
        if (o == null) {
            return empty();
        }

        final Short result =
                whenTypeOf(o)
                    .is(Short.class).thenReturn(identity())
                    .is(Number.class).thenReturn(Number::shortValue)
                    .is(Boolean.class).thenReturn(v -> v ? (short) 1 : 0)
                    .is(Character.class).thenReturn(Conv::characterToShort)
                    .is(String.class).thenReturn(Conv::stringToShort)
                    .orElse(Conv::nullValue);

        return ofNullable(result);
    }

    private static final class Conv {
        static BigDecimal characterToBigDecimal(final Character c) {
            if (Character.isDigit(c)) {
                return new BigDecimal(Character.digit(c, 10));
            }
            return null;
        }

        static BigInteger characterToBigInteger(final Character c) {
            if (Character.isDigit(c)) {
                return BigInteger.valueOf(Character.digit(c, 10));
            }
            return null;
        }

        static Boolean characterToBoolean(final Character c) {
            if (c == 't' || c == 'y') {
                return true;
            }
            if (c == 'f' || c == 'n') {
                return false;
            }
            if (Character.isDigit(c)) {
                return Character.digit(c, 10) != 0;
            }
            return null;
        }

        static Byte characterToByte(final Character c) {
            if (Character.isDigit(c)) {
                return (byte) Character.digit(c, 10);
            }
            return null;
        }

        static Double characterToDouble(final Character c) {
            if (Character.isDigit(c)) {
                return (double) Character.digit(c, 10);
            }
            return null;
        }

        static Float characterToFloat(final Character c) {
            if (Character.isDigit(c)) {
                return (float) Character.digit(c, 10);
            }
            return null;
        }

        static Integer characterToInteger(final Character c) {
            if (Character.isDigit(c)) {
                return Character.digit(c, 10);
            }
            return null;
        }

        static Long characterToLong(final Character c) {
            if (Character.isDigit(c)) {
                return (long) Character.digit(c, 10);
            }
            return null;
        }

        static Short characterToShort(final Character c) {
            if (Character.isDigit(c)) {
                return (short) Character.digit(c, 10);
            }
            return null;
        }

        static <T, R> R nullValue(final T t)  {
            return null;
        }

        static BigDecimal stringToBigDecimal(final String s) {
            return stringToT(s, BigDecimal::new);
        }

        static BigInteger stringToBigInteger(final String s) {
            return stringToT(s, BigInteger::new);
        }

        static Boolean stringToBoolean(final String s) {
            final String sl = s.toLowerCase();
            if (sl.isEmpty()) {
                return false;
            }
            if (sl.length() == 1) {
                return characterToBoolean(s.charAt(0));
            }
            if (sl.equals("true") || sl.equals("yes") || sl.equals("on")) {
                return true;
            }
            if (sl.equals("false") || sl.equals("no") || sl.equals("off")) {
                return false;
            }
            return null;
        }

        static Byte stringToByte(final String s) {
            return stringToT(s, Byte::parseByte);
        }

        static Double stringToDouble(final String s) {
            return stringToT(s, Double::parseDouble);
        }

        static Float stringToFloat(final String s) {
            return stringToT(s, Float::parseFloat);
        }

        static Integer stringToInteger(final String s) {
            return stringToT(s, Integer::parseInt);
        }

        static Long stringToLong(final String s) {
            return stringToT(s, Long::parseLong);
        }

        static Short stringToShort(final String s) {
            return stringToT(s, Short::parseShort);
        }

        private static <T> T stringToT(final String s, final Function<String, T> toT) {
            T temp;
            try {
                temp = toT.apply(s);
            }
            catch (ArithmeticException | NumberFormatException expected) {
                temp = null;
            }
            return temp;
        }
    }

    private Coercions() { }
}
