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

import org.assertj.core.api.AbstractAssert;

import java.util.Objects;
import java.util.Optional;

public class OptionalAssertions extends AbstractAssert<OptionalAssertions, Optional> {

    public static OptionalAssertions assertThat(final Optional<?> actual) {
        return new OptionalAssertions(actual);
    }

    public OptionalAssertions isEmpty() {
        isNotNull();

        if (actual.isPresent()) {
            failWithMessage("Expected Optional to be empty");
        }

        return this;
    }

    public OptionalAssertions isPresent() {
        isNotNull();

        if (!actual.isPresent()) {
            failWithMessage("Expected Optional to be present");
        }

        return this;
    }

    public OptionalAssertions isPresentAndEqualTo(final Object expected) {
        isPresent();

        if (!Objects.equals(actual.get(), expected)) {
            failWithMessage("Expected Optional(%s) to be equal to %s", actual.get(), expected);
        }

        return this;
    }

    public OptionalAssertions isPresentAndSameAs(final Object expected) {
        isPresent();

        if (actual.get() != expected) {
            failWithMessage("Expected Optional(%s) to be same as %s", actual.get(), expected);
        }

        return this;
    }

    private OptionalAssertions(final Optional<?> actual) {
        super(actual, OptionalAssertions.class);
    }

}
