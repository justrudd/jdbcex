package jdbcex.typeof;

/*
 * Original code: https://github.com/nurkiewicz/typeof
 * Idea: http://www.nurkiewicz.com/2013/09/instanceof-operator-and-visitor-pattern.html
 *
 * Copyright 2013 Tomasz Nurkiewicz
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

public class WhenTypeOf<S> {

    private S object;

    WhenTypeOf(S object) {
        this.object = object;
    }

    public <T> FirstIs<S, T> is(Class<T> type) {
        return new FirstIs<>(new Then<>(object), object, type);
    }
}
