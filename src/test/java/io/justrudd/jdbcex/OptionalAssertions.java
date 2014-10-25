/*
 * Copyright 2014 Justin Rudd
 *
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
