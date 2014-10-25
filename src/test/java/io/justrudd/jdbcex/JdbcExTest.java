package io.justrudd.jdbcex;

import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

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
