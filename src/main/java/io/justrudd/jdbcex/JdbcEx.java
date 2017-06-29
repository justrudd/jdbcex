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

import static java.util.Objects.requireNonNull;

import java.sql.ResultSet;

public final class JdbcEx {

    /**
     * Wrap a {@link ResultSetEx} around a {@link ResultSet}.
     * @param rs
     *      The {@link ResultSet} to wrap.
     * @return a new instance of {@link ResultSetEx}.
     * @throws NullPointerException if {@code rs} is null.
     */
    public static ResultSetEx wrap(final ResultSet rs) {
        requireNonNull(rs, "rs cannot be null");

        if (rs instanceof ResultSetEx) {
            return (ResultSetEx) rs;
        }
        return new ResultSetExImpl(rs);
    }

    private JdbcEx() { }
}
