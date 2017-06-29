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

import static java.util.Objects.requireNonNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

final class StatementExImpl implements StatementEx {

    //
    // Wrapper delegates
    //

    /** {@inheritDoc} */
    @Override
    public <T> T unwrap(final Class<T> iface) throws SQLException {
        return inner.unwrap(iface);
    }

    /** {@inheritDoc} */
    @Override
    public boolean isWrapperFor(final Class<?> iface) throws SQLException {
        return inner.isWrapperFor(iface);
    }

    //
    // AutoCloseable delegates
    //

    /** {@inheritDoc} */
    @Override
    public void close() throws SQLException {
        inner.close();
    }

    //
    // Statement delegates
    //

    /** {@inheritDoc} */
    @Override
    public ResultSet executeQuery(final String sql) throws SQLException {
        return inner.executeQuery(sql);
    }

    /** {@inheritDoc} */
    @Override
    public int executeUpdate(final String sql) throws SQLException {
        return inner.executeUpdate(sql);
    }

    /** {@inheritDoc} */
    @Override
    public int getMaxFieldSize() throws SQLException {
        return inner.getMaxFieldSize();
    }

    /** {@inheritDoc} */
    @Override
    public void setMaxFieldSize(final int max) throws SQLException {
        inner.setMaxFieldSize(max);
    }

    /** {@inheritDoc} */
    @Override
    public int getMaxRows() throws SQLException {
        return inner.getMaxRows();
    }

    /** {@inheritDoc} */
    @Override
    public void setMaxRows(final int max) throws SQLException {
        inner.setMaxRows(max);
    }

    /** {@inheritDoc} */
    @Override
    public void setEscapeProcessing(final boolean enable) throws SQLException {
        inner.setEscapeProcessing(enable);
    }

    /** {@inheritDoc} */
    @Override
    public int getQueryTimeout() throws SQLException {
        return inner.getQueryTimeout();
    }

    /** {@inheritDoc} */
    @Override
    public void setQueryTimeout(final int seconds) throws SQLException {
        inner.setQueryTimeout(seconds);
    }

    /** {@inheritDoc} */
    @Override
    public void cancel() throws SQLException {
        inner.cancel();
    }

    /** {@inheritDoc} */
    @Override
    public SQLWarning getWarnings() throws SQLException {
        return inner.getWarnings();
    }

    /** {@inheritDoc} */
    @Override
    public void clearWarnings() throws SQLException {
        inner.clearWarnings();
    }

    /** {@inheritDoc} */
    @Override
    public void setCursorName(final String name) throws SQLException {
        inner.setCursorName(name);
    }

    /** {@inheritDoc} */
    @Override
    public boolean execute(final String sql) throws SQLException {
        return inner.execute(sql);
    }

    /** {@inheritDoc} */
    @Override
    public ResultSet getResultSet() throws SQLException {
        return inner.getResultSet();
    }

    /** {@inheritDoc} */
    @Override
    public int getUpdateCount() throws SQLException {
        return inner.getUpdateCount();
    }

    /** {@inheritDoc} */
    @Override
    public boolean getMoreResults() throws SQLException {
        return inner.getMoreResults();
    }

    /** {@inheritDoc} */
    @Override
    public void setFetchDirection(final int direction) throws SQLException {
        inner.setFetchDirection(direction);
    }

    /** {@inheritDoc} */
    @Override
    public int getFetchDirection() throws SQLException {
        return inner.getFetchDirection();
    }

    /** {@inheritDoc} */
    @Override
    public void setFetchSize(final int rows) throws SQLException {
        inner.setFetchSize(rows);
    }

    /** {@inheritDoc} */
    @Override
    public int getFetchSize() throws SQLException {
        return inner.getFetchSize();
    }

    /** {@inheritDoc} */
    @Override
    public int getResultSetConcurrency() throws SQLException {
        return inner.getResultSetConcurrency();
    }

    /** {@inheritDoc} */
    @Override
    public int getResultSetType() throws SQLException {
        return inner.getResultSetType();
    }

    /** {@inheritDoc} */
    @Override
    public void addBatch(final String sql) throws SQLException {
        inner.addBatch(sql);
    }

    /** {@inheritDoc} */
    @Override
    public void clearBatch() throws SQLException {
        inner.clearBatch();
    }

    /** {@inheritDoc} */
    @Override
    public int[] executeBatch() throws SQLException {
        return inner.executeBatch();
    }

    /** {@inheritDoc} */
    @Override
    public Connection getConnection() throws SQLException {
        return inner.getConnection();
    }

    /** {@inheritDoc} */
    @Override
    public boolean getMoreResults(final int current) throws SQLException {
        return inner.getMoreResults(current);
    }

    /** {@inheritDoc} */
    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        return inner.getGeneratedKeys();
    }

    /** {@inheritDoc} */
    @Override
    public int executeUpdate(final String sql, final int autoGeneratedKeys) throws SQLException {
        return inner.executeUpdate(sql, autoGeneratedKeys);
    }

    /** {@inheritDoc} */
    @Override
    public int executeUpdate(final String sql, final int[] columnIndexes) throws SQLException {
        return inner.executeUpdate(sql, columnIndexes);
    }

    /** {@inheritDoc} */
    @Override
    public int executeUpdate(final String sql, final String[] columnNames) throws SQLException {
        return inner.executeUpdate(sql, columnNames);
    }

    /** {@inheritDoc} */
    @Override
    public boolean execute(final String sql, final int autoGeneratedKeys) throws SQLException {
        return inner.execute(sql, autoGeneratedKeys);
    }

    /** {@inheritDoc} */
    @Override
    public boolean execute(final String sql, final int[] columnIndexes) throws SQLException {
        return inner.execute(sql, columnIndexes);
    }

    /** {@inheritDoc} */
    @Override
    public boolean execute(final String sql, final String[] columnNames) throws SQLException {
        return inner.execute(sql, columnNames);
    }

    /** {@inheritDoc} */
    @Override
    public int getResultSetHoldability() throws SQLException {
        return inner.getResultSetHoldability();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isClosed() throws SQLException {
        return inner.isClosed();
    }

    /** {@inheritDoc} */
    @Override
    public void setPoolable(final boolean poolable) throws SQLException {
        inner.setPoolable(poolable);
    }

    /** {@inheritDoc} */
    @Override
    public boolean isPoolable() throws SQLException {
        return inner.isPoolable();
    }

    /** {@inheritDoc} */
    @Override
    public void closeOnCompletion() throws SQLException {
        inner.closeOnCompletion();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        return inner.isCloseOnCompletion();
    }

    StatementExImpl(final Statement inner) {
        this.inner = requireNonNull(inner, "inner cannot be null");
    }

    private final Statement inner;
}
