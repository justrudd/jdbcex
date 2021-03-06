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

package com.justrudd.jdbcex;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.sql.ResultSet;
import org.junit.Before;
import org.junit.Test;

public class JdbcExTest {

    @Before
    public void beforeEachTest() {
        rs = mock(ResultSet.class);
    }

    @Test
    public void resultSetWrapWrapsInExImpl() {
        final ResultSetEx wrapped = JdbcEx.wrap(rs);
        assertThat(wrapped).isNotSameAs(rs);
        assertThat(wrapped).isInstanceOf(ResultSetExImpl.class);
    }

    @Test
    public void resultSetWrapDoesNotRewrapExInstances() {
        final ResultSetEx wrapped = new ResultSetExImpl(rs);
        final ResultSetEx reWrapped = JdbcEx.wrap(wrapped);
        assertThat(reWrapped).isSameAs(wrapped);
    }

    private ResultSet rs;
}
