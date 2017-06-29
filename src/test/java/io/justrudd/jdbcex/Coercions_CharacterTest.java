/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.justrudd.jdbcex;

import static io.justrudd.jdbcex.Coercions.coerceToCharacter;
import static io.justrudd.jdbcex.OptionalAssertions.assertThat;

import java.util.Optional;
import org.junit.Test;

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
