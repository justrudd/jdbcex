package io.justrudd.jdbcex;

import org.junit.Test;

import java.util.Optional;

import static io.justrudd.jdbcex.Coercions.coerceToCharacter;
import static io.justrudd.jdbcex.OptionalAssertions.assertThat;

public class Coercions_CharacterTest {

    @Test
    public void emptyWhenNullValueCoerced() {
        final Optional<Character> opt = coerceToCharacter(null);
        assertThat(opt).isEmpty();
    }

    @Test
    public void sameWhenCharacterValueCoerced() {
        final Character c = 'j';
        final Optional<Character> opt = coerceToCharacter(c);
        assertThat(opt).isPresentAndSameAs(c);
    }

    @Test
    public void oneCharacterStringValueCoerced() {
        final String s = "r";
        final Optional<Character> opt = coerceToCharacter(s);
        assertThat(opt).isPresentAndEqualTo('r');
    }

    @Test
    public void emptyWhenMultiCharacterStringCoerced() {
        final String s = "blah";
        final Optional<Character> opt = coerceToCharacter(s);
        assertThat(opt).isEmpty();
    }

    @Test
    public void trueValueCoerced() {
        final boolean b = true;
        final Optional<Character> opt = coerceToCharacter(b);
        assertThat(opt).isPresentAndEqualTo('t');
    }

    @Test
    public void falseValueCoerced() {
        final boolean b = false;
        final Optional<Character> opt = coerceToCharacter(b);
        assertThat(opt).isPresentAndEqualTo('f');
    }

    @Test
    public void emptyWhenUnexpectedValueTypeCoerced() {
        final long l = 100L;
        final Optional<Character> opt = coerceToCharacter(l);
        assertThat(opt).isEmpty();
    }

}
