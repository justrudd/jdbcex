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

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

final class ResultSetExImpl implements ResultSetEx {

    /** {@inheritDoc} */
    @Override
    public boolean absolute(final int row) throws SQLException {
        return inner.absolute(row);
    }

    /** {@inheritDoc} */
    @Override
    public void afterLast() throws SQLException {
        inner.afterLast();
    }

    /** {@inheritDoc} */
    @Override
    public void beforeFirst() throws SQLException {
        inner.beforeFirst();
    }

    /** {@inheritDoc} */
    @Override
    public void cancelRowUpdates() throws SQLException {
        inner.cancelRowUpdates();
    }

    /** {@inheritDoc} */
    @Override
    public void clearWarnings() throws SQLException {
        inner.clearWarnings();
    }

    /** {@inheritDoc} */
    @Override
    public void close() throws SQLException {
        inner.close();
    }

    /** {@inheritDoc} */
    @Override
    public void deleteRow() throws SQLException {
        inner.deleteRow();
    }

    /** {@inheritDoc} */
    @Override
    public int findColumn(final String columnLabel) throws SQLException {
        return inner.findColumn(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public boolean first() throws SQLException {
        return inner.first();
    }

    /** {@inheritDoc} */
    @Override
    public Array getArray(final int columnIndex) throws SQLException {
        return inner.getArray(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public Array getArray(final String columnLabel) throws SQLException {
        return inner.getArray(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public InputStream getAsciiStream(final int columnIndex) throws SQLException {
        return inner.getAsciiStream(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public InputStream getAsciiStream(final String columnLabel) throws SQLException {
        return inner.getAsciiStream(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public BigDecimal getBigDecimal(final int columnIndex) throws SQLException {
        return inner.getBigDecimal(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    @Deprecated
    public BigDecimal getBigDecimal(final int columnIndex, final int scale) throws SQLException {
        return inner.getBigDecimal(columnIndex, scale);
    }

    /** {@inheritDoc} */
    @Override
    public BigDecimal getBigDecimal(final String columnLabel) throws SQLException {
        return inner.getBigDecimal(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    @Deprecated
    public BigDecimal getBigDecimal(final String columnLabel, final int scale) throws SQLException {
        return inner.getBigDecimal(columnLabel, scale);
    }

    /** {@inheritDoc} */
    @Override
    public InputStream getBinaryStream(final int columnIndex) throws SQLException {
        return inner.getBinaryStream(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public InputStream getBinaryStream(final String columnLabel) throws SQLException {
        return inner.getBinaryStream(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public Blob getBlob(final int columnIndex) throws SQLException {
        return inner.getBlob(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public Blob getBlob(final String columnLabel) throws SQLException {
        return inner.getBlob(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public boolean getBoolean(final int columnIndex) throws SQLException {
        return inner.getBoolean(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public boolean getBoolean(final String columnLabel) throws SQLException {
        return inner.getBoolean(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public byte getByte(final int columnIndex) throws SQLException {
        return inner.getByte(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public byte getByte(final String columnLabel) throws SQLException {
        return inner.getByte(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public byte[] getBytes(final int columnIndex) throws SQLException {
        return inner.getBytes(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public byte[] getBytes(final String columnLabel) throws SQLException {
        return inner.getBytes(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public Reader getCharacterStream(final int columnIndex) throws SQLException {
        return inner.getCharacterStream(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public Reader getCharacterStream(final String columnLabel) throws SQLException {
        return inner.getCharacterStream(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public Clob getClob(final int columnIndex) throws SQLException {
        return inner.getClob(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public Clob getClob(final String columnLabel) throws SQLException {
        return inner.getClob(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public int getConcurrency() throws SQLException {
        return inner.getConcurrency();
    }

    /** {@inheritDoc} */
    @Override
    public String getCursorName() throws SQLException {
        return inner.getCursorName();
    }

    /** {@inheritDoc} */
    @Override
    public Date getDate(final int columnIndex) throws SQLException {
        return inner.getDate(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public Date getDate(final int columnIndex, final Calendar cal) throws SQLException {
        return inner.getDate(columnIndex, cal);
    }

    /** {@inheritDoc} */
    @Override
    public Date getDate(final String columnLabel) throws SQLException {
        return inner.getDate(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public Date getDate(final String columnLabel, final Calendar cal) throws SQLException {
        return inner.getDate(columnLabel, cal);
    }

    /** {@inheritDoc} */
    @Override
    public double getDouble(final int columnIndex) throws SQLException {
        return inner.getDouble(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public double getDouble(final String columnLabel) throws SQLException {
        return inner.getDouble(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public int getFetchDirection() throws SQLException {
        return inner.getFetchDirection();
    }

    /** {@inheritDoc} */
    @Override
    public int getFetchSize() throws SQLException {
        return inner.getFetchSize();
    }

    /** {@inheritDoc} */
    @Override
    public float getFloat(final int columnIndex) throws SQLException {
        return inner.getFloat(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public float getFloat(final String columnLabel) throws SQLException {
        return inner.getFloat(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public int getHoldability() throws SQLException {
        return inner.getHoldability();
    }

    /** {@inheritDoc} */
    @Override
    public int getInt(final int columnIndex) throws SQLException {
        return inner.getInt(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public int getInt(final String columnLabel) throws SQLException {
        return inner.getInt(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public long getLong(final int columnIndex) throws SQLException {
        return inner.getLong(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public long getLong(final String columnLabel) throws SQLException {
        return inner.getLong(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        return inner.getMetaData();
    }

    /** {@inheritDoc} */
    @Override
    public Reader getNCharacterStream(final int columnIndex) throws SQLException {
        return inner.getNCharacterStream(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public Reader getNCharacterStream(final String columnLabel) throws SQLException {
        return inner.getNCharacterStream(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public NClob getNClob(final int columnIndex) throws SQLException {
        return inner.getNClob(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public NClob getNClob(final String columnLabel) throws SQLException {
        return inner.getNClob(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public String getNString(final int columnIndex) throws SQLException {
        return inner.getNString(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public String getNString(final String columnLabel) throws SQLException {
        return inner.getNString(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public Object getObject(final int columnIndex) throws SQLException {
        return inner.getObject(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public Object getObject(final int columnIndex, final Map<String, Class<?>> map) throws SQLException {
        return inner.getObject(columnIndex, map);
    }

    /** {@inheritDoc} */
    @Override
    public <T> T getObject(final int columnIndex, final Class<T> type) throws SQLException {
        return inner.getObject(columnIndex, type);
    }

    /** {@inheritDoc} */
    @Override
    public Object getObject(final String columnLabel) throws SQLException {
        return inner.getObject(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public Object getObject(final String columnLabel, final Map<String, Class<?>> map) throws SQLException {
        return inner.getObject(columnLabel, map);
    }

    /** {@inheritDoc} */
    @Override
    public <T> T getObject(final String columnLabel, final Class<T> type) throws SQLException {
        return inner.getObject(columnLabel, type);
    }

    /** {@inheritDoc} */
    @Override
    public Ref getRef(final int columnIndex) throws SQLException {
        return inner.getRef(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public Ref getRef(final String columnLabel) throws SQLException {
        return inner.getRef(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public int getRow() throws SQLException {
        return inner.getRow();
    }

    /** {@inheritDoc} */
    @Override
    public RowId getRowId(final int columnIndex) throws SQLException {
        return inner.getRowId(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public RowId getRowId(final String columnLabel) throws SQLException {
        return inner.getRowId(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public short getShort(final int columnIndex) throws SQLException {
        return inner.getShort(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public short getShort(final String columnLabel) throws SQLException {
        return inner.getShort(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public SQLXML getSQLXML(final int columnIndex) throws SQLException {
        return inner.getSQLXML(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public SQLXML getSQLXML(final String columnLabel) throws SQLException {
        return inner.getSQLXML(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public Statement getStatement() throws SQLException {
        return inner.getStatement();
    }

    /** {@inheritDoc} */
    @Override
    public String getString(final int columnIndex) throws SQLException {
        return inner.getString(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public String getString(final String columnLabel) throws SQLException {
        return inner.getString(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public Time getTime(final int columnIndex) throws SQLException {
        return inner.getTime(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public Time getTime(final int columnIndex, final Calendar cal) throws SQLException {
        return inner.getTime(columnIndex, cal);
    }

    /** {@inheritDoc} */
    @Override
    public Time getTime(final String columnLabel) throws SQLException {
        return inner.getTime(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public Time getTime(final String columnLabel, final Calendar cal) throws SQLException {
        return inner.getTime(columnLabel, cal);
    }

    /** {@inheritDoc} */
    @Override
    public Timestamp getTimestamp(final int columnIndex) throws SQLException {
        return inner.getTimestamp(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public Timestamp getTimestamp(final int columnIndex, final Calendar cal) throws SQLException {
        return inner.getTimestamp(columnIndex, cal);
    }

    /** {@inheritDoc} */
    @Override
    public Timestamp getTimestamp(final String columnLabel) throws SQLException {
        return inner.getTimestamp(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public Timestamp getTimestamp(final String columnLabel, final Calendar cal) throws SQLException {
        return inner.getTimestamp(columnLabel, cal);
    }

    /** {@inheritDoc} */
    @Override
    public int getType() throws SQLException {
        return inner.getType();
    }

    /** {@inheritDoc} */
    @Override
    @Deprecated
    public InputStream getUnicodeStream(final int columnIndex) throws SQLException {
        return inner.getUnicodeStream(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    @Deprecated
    public InputStream getUnicodeStream(final String columnLabel) throws SQLException {
        return inner.getUnicodeStream(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public URL getURL(final int columnIndex) throws SQLException {
        return inner.getURL(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public URL getURL(final String columnLabel) throws SQLException {
        return inner.getURL(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public SQLWarning getWarnings() throws SQLException {
        return inner.getWarnings();
    }

    /** {@inheritDoc} */
    @Override
    public void insertRow() throws SQLException {
        inner.insertRow();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isAfterLast() throws SQLException {
        return inner.isAfterLast();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isBeforeFirst() throws SQLException {
        return inner.isBeforeFirst();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isClosed() throws SQLException {
        return inner.isClosed();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isFirst() throws SQLException {
        return inner.isFirst();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isLast() throws SQLException {
        return inner.isLast();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isWrapperFor(final Class<?> iface) throws SQLException {
        return inner.isWrapperFor(iface);
    }

    /** {@inheritDoc} */
    @Override
    public boolean last() throws SQLException {
        return inner.last();
    }

    /** {@inheritDoc} */
    @Override
    public void moveToCurrentRow() throws SQLException {
        inner.moveToCurrentRow();
    }

    /** {@inheritDoc} */
    @Override
    public void moveToInsertRow() throws SQLException {
        inner.moveToInsertRow();
    }

    /** {@inheritDoc} */
    @Override
    public boolean next() throws SQLException {
        return inner.next();
    }

    /** {@inheritDoc} */
    @Override
    public boolean previous() throws SQLException {
        return inner.previous();
    }

    /** {@inheritDoc} */
    @Override
    public void refreshRow() throws SQLException {
        inner.refreshRow();
    }

    /** {@inheritDoc} */
    @Override
    public boolean relative(final int rows) throws SQLException {
        return inner.relative(rows);
    }

    /** {@inheritDoc} */
    @Override
    public boolean rowDeleted() throws SQLException {
        return inner.rowDeleted();
    }

    /** {@inheritDoc} */
    @Override
    public boolean rowInserted() throws SQLException {
        return inner.rowInserted();
    }

    /** {@inheritDoc} */
    @Override
    public boolean rowUpdated() throws SQLException {
        return inner.rowUpdated();
    }

    /** {@inheritDoc} */
    @Override
    public void setFetchDirection(final int direction) throws SQLException {
        inner.setFetchDirection(direction);
    }

    /** {@inheritDoc} */
    @Override
    public void setFetchSize(final int rows) throws SQLException {
        inner.setFetchSize(rows);
    }

    /** {@inheritDoc} */
    @Override
    public void updateArray(final int columnIndex, final Array x) throws SQLException {
        inner.updateArray(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateArray(final String columnLabel, final Array x) throws SQLException {
        inner.updateArray(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateAsciiStream(final int columnIndex, final InputStream x) throws SQLException {
        inner.updateAsciiStream(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateAsciiStream(final int columnIndex, final InputStream x, final int length) throws SQLException {
        inner.updateAsciiStream(columnIndex, x, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateAsciiStream(final int columnIndex, final InputStream x, final long length) throws SQLException {
        inner.updateAsciiStream(columnIndex, x, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateAsciiStream(final String columnLabel, final InputStream x) throws SQLException {
        inner.updateAsciiStream(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateAsciiStream(final String columnLabel, final InputStream x, final int length) throws SQLException {
        inner.updateAsciiStream(columnLabel, x, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateAsciiStream(final String columnLabel, final InputStream x, final long length) throws SQLException {
        inner.updateAsciiStream(columnLabel, x, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBigDecimal(final int columnIndex, final BigDecimal x) throws SQLException {
        inner.updateBigDecimal(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBigDecimal(final String columnLabel, final BigDecimal x) throws SQLException {
        inner.updateBigDecimal(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBinaryStream(final int columnIndex, final InputStream x) throws SQLException {
        inner.updateBinaryStream(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBinaryStream(final int columnIndex, final InputStream x, final int length) throws SQLException {
        inner.updateBinaryStream(columnIndex, x, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBinaryStream(final int columnIndex, final InputStream x, final long length) throws SQLException {
        inner.updateBinaryStream(columnIndex, x, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBinaryStream(final String columnLabel, final InputStream x) throws SQLException {
        inner.updateBinaryStream(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBinaryStream(final String columnLabel, final InputStream x, final int length) throws SQLException {
        inner.updateBinaryStream(columnLabel, x, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBinaryStream(final String columnLabel, final InputStream x, final long length) throws SQLException {
        inner.updateBinaryStream(columnLabel, x, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBlob(final int columnIndex, final InputStream inputStream) throws SQLException {
        inner.updateBlob(columnIndex, inputStream);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBlob(final int columnIndex, final InputStream inputStream, final long length) throws SQLException {
        inner.updateBlob(columnIndex, inputStream, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBlob(final int columnIndex, final Blob x) throws SQLException {
        inner.updateBlob(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBlob(final String columnLabel, final InputStream inputStream) throws SQLException {
        inner.updateBlob(columnLabel, inputStream);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBlob(final String columnLabel, final InputStream inputStream, final long length) throws SQLException {
        inner.updateBlob(columnLabel, inputStream, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBlob(final String columnLabel, final Blob x) throws SQLException {
        inner.updateBlob(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBoolean(final int columnIndex, final boolean x) throws SQLException {
        inner.updateBoolean(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBoolean(final String columnLabel, final boolean x) throws SQLException {
        inner.updateBoolean(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateByte(final int columnIndex, final byte x) throws SQLException {
        inner.updateByte(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateByte(final String columnLabel, final byte x) throws SQLException {
        inner.updateByte(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBytes(final int columnIndex, final byte[] x) throws SQLException {
        inner.updateBytes(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateBytes(final String columnLabel, final byte[] x) throws SQLException {
        inner.updateBytes(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateCharacterStream(final int columnIndex, final Reader x) throws SQLException {
        inner.updateCharacterStream(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateCharacterStream(final int columnIndex, final Reader x, final int length) throws SQLException {
        inner.updateCharacterStream(columnIndex, x, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateCharacterStream(final int columnIndex, final Reader x, final long length) throws SQLException {
        inner.updateCharacterStream(columnIndex, x, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateCharacterStream(final String columnLabel, final Reader reader) throws SQLException {
        inner.updateCharacterStream(columnLabel, reader);
    }

    /** {@inheritDoc} */
    @Override
    public void updateCharacterStream(final String columnLabel, final Reader reader, final int length) throws SQLException {
        inner.updateCharacterStream(columnLabel, reader, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateCharacterStream(final String columnLabel, final Reader reader, final long length) throws SQLException {
        inner.updateCharacterStream(columnLabel, reader, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateClob(final int columnIndex, final Reader reader) throws SQLException {
        inner.updateClob(columnIndex, reader);
    }

    /** {@inheritDoc} */
    @Override
    public void updateClob(final int columnIndex, final Reader reader, final long length) throws SQLException {
        inner.updateClob(columnIndex, reader, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateClob(final int columnIndex, final Clob x) throws SQLException {
        inner.updateClob(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateClob(final String columnLabel, final Reader reader) throws SQLException {
        inner.updateClob(columnLabel, reader);
    }

    /** {@inheritDoc} */
    @Override
    public void updateClob(final String columnLabel, final Reader reader, final long length) throws SQLException {
        inner.updateClob(columnLabel, reader, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateClob(final String columnLabel, final Clob x) throws SQLException {
        inner.updateClob(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateDate(final int columnIndex, final Date x) throws SQLException {
        inner.updateDate(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateDate(final String columnLabel, final Date x) throws SQLException {
        inner.updateDate(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateDouble(final int columnIndex, final double x) throws SQLException {
        inner.updateDouble(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateDouble(final String columnLabel, final double x) throws SQLException {
        inner.updateDouble(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateFloat(final int columnIndex, final float x) throws SQLException {
        inner.updateFloat(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateFloat(final String columnLabel, final float x) throws SQLException {
        inner.updateFloat(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateInt(final int columnIndex, final int x) throws SQLException {
        inner.updateInt(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateInt(final String columnLabel, final int x) throws SQLException {
        inner.updateInt(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateLong(final int columnIndex, final long x) throws SQLException {
        inner.updateLong(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateLong(final String columnLabel, final long x) throws SQLException {
        inner.updateLong(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateNCharacterStream(final int columnIndex, final Reader x) throws SQLException {
        inner.updateNCharacterStream(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateNCharacterStream(final int columnIndex, final Reader x, final long length) throws SQLException {
        inner.updateNCharacterStream(columnIndex, x, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateNCharacterStream(final String columnLabel, final Reader reader) throws SQLException {
        inner.updateNCharacterStream(columnLabel, reader);
    }

    /** {@inheritDoc} */
    @Override
    public void updateNCharacterStream(final String columnLabel, final Reader reader, final long length) throws SQLException {
        inner.updateNCharacterStream(columnLabel, reader, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateNClob(final int columnIndex, final NClob nClob) throws SQLException {
        inner.updateNClob(columnIndex, nClob);
    }

    /** {@inheritDoc} */
    @Override
    public void updateNClob(final int columnIndex, final Reader reader) throws SQLException {
        inner.updateNClob(columnIndex, reader);
    }

    /** {@inheritDoc} */
    @Override
    public void updateNClob(final int columnIndex, final Reader reader, final long length) throws SQLException {
        inner.updateNClob(columnIndex, reader, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateNClob(final String columnLabel, final NClob nClob) throws SQLException {
        inner.updateNClob(columnLabel, nClob);
    }

    /** {@inheritDoc} */
    @Override
    public void updateNClob(final String columnLabel, final Reader reader) throws SQLException {
        inner.updateNClob(columnLabel, reader);
    }

    /** {@inheritDoc} */
    @Override
    public void updateNClob(final String columnLabel, final Reader reader, final long length) throws SQLException {
        inner.updateNClob(columnLabel, reader, length);
    }

    /** {@inheritDoc} */
    @Override
    public void updateNString(final int columnIndex, final String nString) throws SQLException {
        inner.updateNString(columnIndex, nString);
    }

    /** {@inheritDoc} */
    @Override
    public void updateNString(final String columnLabel, final String nString) throws SQLException {
        inner.updateNString(columnLabel, nString);
    }

    /** {@inheritDoc} */
    @Override
    public void updateNull(final int columnIndex) throws SQLException {
        inner.updateNull(columnIndex);
    }

    /** {@inheritDoc} */
    @Override
    public void updateNull(final String columnLabel) throws SQLException {
        inner.updateNull(columnLabel);
    }

    /** {@inheritDoc} */
    @Override
    public void updateObject(final int columnIndex, final Object x) throws SQLException {
        inner.updateObject(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateObject(final int columnIndex, final Object x, final int scaleOrLength) throws SQLException {
        inner.updateObject(columnIndex, x, scaleOrLength);
    }

    /** {@inheritDoc} */
    @Override
    public void updateObject(final int columnIndex, final Object x, final SQLType targetSqlType) throws SQLException {
        inner.updateObject(columnIndex, x, targetSqlType);
    }

    /** {@inheritDoc} */
    @Override
    public void updateObject(final int columnIndex, final Object x, final SQLType targetSqlType, final int scaleOrLength) throws SQLException {
        inner.updateObject(columnIndex, x, targetSqlType, scaleOrLength);
    }

    /** {@inheritDoc} */
    @Override
    public void updateObject(final String columnLabel, final Object x) throws SQLException {
        inner.updateObject(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateObject(final String columnLabel, final Object x, final int scaleOrLength) throws SQLException {
        inner.updateObject(columnLabel, x, scaleOrLength);
    }

    /** {@inheritDoc} */
    @Override
    public void updateObject(final String columnLabel, final Object x, final SQLType targetSqlType) throws SQLException {
        inner.updateObject(columnLabel, x, targetSqlType);
    }

    /** {@inheritDoc} */
    @Override
    public void updateObject(final String columnLabel, final Object x, final SQLType targetSqlType, final int scaleOrLength) throws SQLException {
        inner.updateObject(columnLabel, x, targetSqlType, scaleOrLength);
    }

    /** {@inheritDoc} */
    @Override
    public void updateRef(final int columnIndex, final Ref x) throws SQLException {
        inner.updateRef(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateRef(final String columnLabel, final Ref x) throws SQLException {
        inner.updateRef(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateRow() throws SQLException {
        inner.updateRow();
    }

    /** {@inheritDoc} */
    @Override
    public void updateRowId(final int columnIndex, final RowId x) throws SQLException {
        inner.updateRowId(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateRowId(final String columnLabel, final RowId x) throws SQLException {
        inner.updateRowId(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateShort(final int columnIndex, final short x) throws SQLException {
        inner.updateShort(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateShort(final String columnLabel, final short x) throws SQLException {
        inner.updateShort(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateSQLXML(final int columnIndex, final SQLXML xmlObject) throws SQLException {
        inner.updateSQLXML(columnIndex, xmlObject);
    }

    /** {@inheritDoc} */
    @Override
    public void updateSQLXML(final String columnLabel, final SQLXML xmlObject) throws SQLException {
        inner.updateSQLXML(columnLabel, xmlObject);
    }

    /** {@inheritDoc} */
    @Override
    public void updateString(final int columnIndex, final String x) throws SQLException {
        inner.updateString(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateString(final String columnLabel, final String x) throws SQLException {
        inner.updateString(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateTime(final int columnIndex, final Time x) throws SQLException {
        inner.updateTime(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateTime(final String columnLabel, final Time x) throws SQLException {
        inner.updateTime(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateTimestamp(final int columnIndex, final Timestamp x) throws SQLException {
        inner.updateTimestamp(columnIndex, x);
    }

    /** {@inheritDoc} */
    @Override
    public void updateTimestamp(final String columnLabel, final Timestamp x) throws SQLException {
        inner.updateTimestamp(columnLabel, x);
    }

    /** {@inheritDoc} */
    @Override
    public <T> T unwrap(final Class<T> iface) throws SQLException {
        return inner.unwrap(iface);
    }

    /** {@inheritDoc} */
    @Override
    public boolean wasNull() throws SQLException {
        return inner.wasNull();
    }

    ResultSetExImpl(final ResultSet inner) {
        this.inner = inner;
    }

    private final ResultSet inner;
}
