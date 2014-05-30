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

package jdbcex;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;
import java.util.Optional;

/**
 *
 */
public interface ResultSetEx extends ResultSet {

    /**
     * See {@link ResultSet#getArray(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<Array> getOptionalArray(int columnIndex) throws SQLException {
        return Optional.ofNullable(getArray(columnIndex));
    }

    /**
     * See {@link ResultSet#getArray(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<Array> getOptionalArray(String columnLabel) throws SQLException {
        return Optional.ofNullable(getArray(columnLabel));
    }

    /**
     * See {@link ResultSet#getBigDecimal(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<BigDecimal> getOptionalBigDecimal(int columnIndex) throws SQLException {
        return Optional.ofNullable(getBigDecimal(columnIndex));
    }

    /**
     * See {@link ResultSet#getBigDecimal(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<BigDecimal> getOptionalBigDecimal(String columnLabel) throws SQLException {
        return Optional.ofNullable(getBigDecimal(columnLabel));
    }

    /**
     * See {@link ResultSet#getBlob(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<Blob> getOptionalBlob(int columnIndex) throws SQLException {
        return Optional.ofNullable(getBlob(columnIndex));
    }

    /**
     * See {@link ResultSet#getBlob(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<Blob> getOptionalBlob(String columnLabel) throws SQLException {
        return Optional.ofNullable(getBlob(columnLabel));
    }

    /**
     * See {@link ResultSet#getBoolean(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value returned is
     *          {@link Optional#empty() empty}.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Boolean> getOptionalBoolean(int columnIndex) throws SQLException {
        final boolean value = getBoolean(columnIndex);
        return wasNull()
                ? Optional.empty()
                : Optional.of(value);
    }

    /**
     * See {@link ResultSet#getBoolean(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Boolean> getOptionalBoolean(String columnLabel) throws SQLException {
        final boolean value = getBoolean(columnLabel);
        return wasNull()
                ? Optional.empty()
                : Optional.of(value);
    }

    /**
     * See {@link ResultSet#getByte(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value returned is
     *          {@link Optional#empty() empty}.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Byte> getOptionalByte(int columnIndex) throws SQLException {
        final byte value = getByte(columnIndex);
        return wasNull()
                ? Optional.empty()
                : Optional.of(value);
    }

    /**
     * See {@link ResultSet#getByte(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Byte> getOptionalByte(String columnLabel) throws SQLException {
        final byte value = getByte(columnLabel);
        return wasNull()
                ? Optional.empty()
                : Optional.of(value);
    }

    /**
     * See {@link ResultSet#getBytes(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value returned is
     *          {@link Optional#empty() empty}.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<byte[]> getOptionalBytes(int columnIndex) throws SQLException {
        return Optional.ofNullable(getBytes(columnIndex));
    }

    /**
     * See {@link ResultSet#getBytes(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<byte[]> getOptionalBytes(String columnLabel) throws SQLException {
        return Optional.ofNullable(getBytes(columnLabel));
    }

    /**
     * See {@link ResultSet#getClob(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<Clob> getOptionalClob(int columnIndex) throws SQLException {
        return Optional.ofNullable(getClob(columnIndex));
    }

    /**
     * See {@link ResultSet#getClob(String)} for the basics of this method.
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<Clob> getOptionalClob(String columnLabel) throws SQLException {
        return Optional.ofNullable(getClob(columnLabel));
    }

    /**
     * See {@link ResultSet#getDate(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value returned is
     *          {@link Optional#empty() empty}.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Date> getOptionalDate(int columnIndex) throws SQLException {
        return Optional.ofNullable(getDate(columnIndex));
    }

    /**
     * See {@link ResultSet#getDate(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Date> getOptionalDate(String columnLabel) throws SQLException {
        return Optional.ofNullable(getDate(columnLabel));
    }

    /**
     * See {@link ResultSet#getDate(int, java.util.Calendar)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @param cal
     *          the <code>java.util.Calendar</code> object to use in constructing the date
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Date> getOptionalDate(int columnIndex, Calendar cal)
            throws SQLException {
        return Optional.ofNullable(getDate(columnIndex, cal));
    }

    /**
     * See {@link ResultSet#getDate(String, java.util.Calendar)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @param cal
     *          the <code>java.util.Calendar</code> object to use in constructing the date
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnName is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Date> getOptionalDate(String columnLabel, Calendar cal)
            throws SQLException {
        return Optional.ofNullable(getDate(columnLabel, cal));
    }

    /**
     * See {@link ResultSet#getDouble(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value returned is
     *          {@link Optional#empty() empty}.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Double> getOptionalDouble(int columnIndex) throws SQLException {
        final double value = getDouble(columnIndex);
        return wasNull()
                ? Optional.empty()
                : Optional.of(value);
    }

    /**
     * See {@link ResultSet#getDouble(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Double> getOptionalDouble(String columnLabel) throws SQLException {
        final double value = getDouble(columnLabel);
        return wasNull()
                ? Optional.empty()
                : Optional.of(value);
    }

    /**
     * See {@link ResultSet#getFloat(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value returned is
     *          {@link Optional#empty() empty}.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Float> getOptionalFloat(int columnIndex) throws SQLException {
        final float value = getFloat(columnIndex);
        return wasNull()
                ? Optional.empty()
                : Optional.of(value);
    }

    /**
     * See {@link ResultSet#getFloat(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Float> getOptionalFloat(String columnLabel) throws SQLException {
        final float value = getFloat(columnLabel);
        return wasNull()
                ? Optional.empty()
                : Optional.of(value);
    }

    /**
     * See {@link ResultSet#getInt(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value returned is
     *          {@link Optional#empty() empty}.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Integer> getOptionalInt(int columnIndex) throws SQLException {
        final int value = getInt(columnIndex);
        return wasNull()
                ? Optional.empty()
                : Optional.of(value);
    }

    /**
     * See {@link ResultSet#getInt(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Integer> getOptionalInt(String columnLabel) throws SQLException {
        final int value = getInt(columnLabel);
        return wasNull()
                ? Optional.empty()
                : Optional.of(value);
    }

    /**
     * See {@link ResultSet#getLong(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value returned is
     *          {@link Optional#empty() empty}.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Long> getOptionalLong(int columnIndex) throws SQLException {
        final long value = getLong(columnIndex);
        return wasNull()
                ? Optional.empty()
                : Optional.of(value);
    }

    /**
     * See {@link ResultSet#getLong(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Long> getOptionalLong(String columnLabel) throws SQLException {
        final long value = getLong(columnLabel);
        return wasNull()
                ? Optional.empty()
                : Optional.of(value);
    }

    /**
     * See {@link ResultSet#getNClob(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<NClob> getOptionalNClob(int columnIndex) throws SQLException {
        return Optional.ofNullable(getNClob(columnIndex));
    }

    /**
     * See {@link ResultSet#getNClob(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnName is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<NClob> getOptionalNClob(String columnLabel) throws SQLException {
        return Optional.ofNullable(getNClob(columnLabel));
    }

    /**
     * See {@link ResultSet#getNString(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<String> getOptionalNString(int columnIndex) throws SQLException {
        return Optional.ofNullable(getNString(columnIndex));
    }

    /**
     * See {@link ResultSet#getNString(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnName is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<String> getOptionalNString(String columnLabel) throws SQLException {
        return Optional.ofNullable(getNString(columnLabel));
    }

    /**
     * See {@link ResultSet#getObject(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Object> getOptionalObject(int columnIndex) throws SQLException {
        return Optional.ofNullable(getObject(columnIndex));
    }

    /**
     * See {@link ResultSet#getObject(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Object> getOptionalObject(String columnLabel) throws SQLException {
        return Optional.ofNullable(getObject(columnLabel));
    }

    /**
     * See {@link ResultSet#getObject(int, java.util.Map)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @param map
     *          a <code>java.util.Map</code> object that contains the mapping from SQL type names
     *          to classes in the Java programming language
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<Object> getOptionalObject(int columnIndex, Map<String,Class<?>> map)
            throws SQLException {
        return Optional.ofNullable(getObject(columnIndex, map));
    }

    /**
     * See {@link ResultSet#getObject(String, java.util.Map)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @param map
     *          a <code>java.util.Map</code> object that contains the mapping from SQL type names
     *          to classes in the Java programming language
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<Object> getOptionalObject(String columnLabel, Map<String,Class<?>> map)
            throws SQLException {
        return Optional.ofNullable(getObject(columnLabel, map));
    }

    /**
     * See {@link ResultSet#getObject(int, Class)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @param type
     *          Class representing the Java data type to convert the designated
     * @param <T>
     *           the type of the class modeled by this Class object column to.
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default <T> Optional<T> getOptionalObject(int columnIndex, Class<T> type) throws SQLException {
        return Optional.ofNullable(getObject(columnIndex, type));
    }

    /**
     * See {@link ResultSet#getObject(String, Class)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @param type
     *          Class representing the Java data type to convert the designated column to.
     * @param <T>
     *          the type of the class modeled by this Class object
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnName is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default <T> Optional<T> getOptionalObject(String columnLabel, Class<T> type)
            throws SQLException {
        return Optional.ofNullable(getObject(columnLabel, type));
    }

    /**
     * See {@link ResultSet#getRef(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<Ref> getOptionalRef(int columnIndex) throws SQLException {
        return Optional.ofNullable(getRef(columnIndex));
    }

    /**
     * See {@link ResultSet#getRef(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<Ref> getOptionalRef(String columnLabel) throws SQLException {
        return Optional.ofNullable(getRef(columnLabel));
    }

    /**
     * See {@link ResultSet#getRowId(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<RowId> getOptionalRowId(int columnIndex) throws SQLException {
        return Optional.ofNullable(getRowId(columnIndex));
    }

    /**
     * See {@link ResultSet#getRowId(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnName is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<RowId> getOptionalRowId(String columnLabel) throws SQLException {
        return Optional.ofNullable(getRowId(columnLabel));
    }

    /**
     * See {@link ResultSet#getShort(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value returned is
     *          {@link Optional#empty() empty}.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Short> getOptionalShort(int columnIndex) throws SQLException {
        final short value = getShort(columnIndex);
        return wasNull()
                ? Optional.empty()
                : Optional.of(value);
    }

    /**
     * See {@link ResultSet#getShort(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Short> getOptionalShort(String columnLabel) throws SQLException {
        final short value = getShort(columnLabel);
        return wasNull()
                ? Optional.empty()
                : Optional.of(value);
    }

    /**
     * See {@link ResultSet#getSQLXML(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<SQLXML> getOptionalSQLXML(int columnIndex) throws SQLException {
        return Optional.ofNullable(getSQLXML(columnIndex));
    }

    /**
     * See {@link ResultSet#getSQLXML(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnName is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<SQLXML> getOptionalSQLXML(String columnLabel) throws SQLException {
        return Optional.ofNullable(getSQLXML(columnLabel));
    }

    /**
     * See {@link ResultSet#getString(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<String> getOptionalString(int columnIndex) throws SQLException {
        return Optional.ofNullable(getString(columnIndex));
    }

    /**
     * See {@link ResultSet#getString(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<String> getOptionalString(String columnLabel) throws SQLException {
        return Optional.ofNullable(getString(columnLabel));
    }

    /**
     * See {@link ResultSet#getTime(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Time> getOptionalTime(int columnIndex) throws SQLException {
        return Optional.ofNullable(getTime(columnIndex));
    }

    /**
     * See {@link ResultSet#getTime(String)} for the specifics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Time> getOptionalTime(String columnLabel) throws SQLException {
        return Optional.ofNullable(getTime(columnLabel));
    }

    /**
     * See {@link ResultSet#getTime(int, java.util.Calendar)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @param cal
     *          the <code>java.util.Calendar</code> object to use in constructing the time
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Time> getOptionalTime(int columnIndex, Calendar cal)
            throws SQLException {
        return Optional.ofNullable(getTime(columnIndex, cal));
    }

    /**
     * See {@link ResultSet#getTime(String, java.util.Calendar)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @param cal
     *          the <code>java.util.Calendar</code> object to use in constructing the time
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnName is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Time> getOptionalTime(String columnLabel, Calendar cal)
            throws SQLException {
        return Optional.ofNullable(getTime(columnLabel, cal));
    }

    /**
     * See {@link ResultSet#getTimestamp(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Timestamp> getOptionalTimestamp(int columnIndex) throws SQLException {
        return Optional.ofNullable(getTimestamp(columnIndex));
    }

    /**
     * See {@link ResultSet#getTimestamp(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Timestamp> getOptionalTimestamp(String columnLabel)
            throws SQLException {
        return Optional.ofNullable(getTimestamp(columnLabel));
    }

    /**
     * See {@link ResultSet#getTimestamp(int, java.util.Calendar)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @param cal
     *          the <code>java.util.Calendar</code> object to use in constructing the timestamp
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Timestamp> getOptionalTimestamp(int columnIndex, Calendar cal)
            throws SQLException {
        return Optional.ofNullable(getTimestamp(columnIndex, cal));
    }

    /**
     * See {@link ResultSet#getTimestamp(String, java.util.Calendar)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @param cal
     *          the <code>java.util.Calendar</code> object to use in constructing the timestamp
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnName is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Timestamp> getOptionalTimestamp(String columnLabel, Calendar cal)
            throws SQLException {
        return Optional.ofNullable(getTimestamp(columnLabel, cal));
    }

    /**
     * See {@link ResultSet#getURL(int)} for the basics of this method.
     *
     * @param columnIndex
     *          the first column is 1, the second is 2, ...
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnIndex is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<URL> getOptionalURL(int columnIndex) throws SQLException {
        return Optional.ofNullable(getURL(columnIndex));
    }

    /**
     * See {@link ResultSet#getURL(String)} for the basics of this method.
     *
     * @param columnLabel
     *          The label for the column specified with the SQL AS clause.  If the SQL AS clause
     *          was not specified, then the label is the name of the column
     * @return
     *          the column value; if the value is SQL <code>NULL</code>, the value
     *          {@link Optional#empty() empty} is returned.
     * @exception SQLException
     *          if the columnName is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<URL> getOptionalURL(String columnLabel) throws SQLException {
        return Optional.ofNullable(getURL(columnLabel));
    }
}
