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
