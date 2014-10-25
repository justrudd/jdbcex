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

import java.math.BigDecimal;
import java.math.BigInteger;
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
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Map;
import java.util.Optional;

/**
 *
 */
public interface ResultSetEx extends ResultSet {

    default Optional<BigDecimal> getCoercedBigDecimal(final int columnIndex) throws SQLException {
        return getOptionalObject(columnIndex)
                .flatMap(Coercions::coerceToBigDecimal);
    }

    default Optional<BigDecimal> getCoercedBigDecimal(final String columnLabel) throws SQLException {
        return getOptionalObject(columnLabel)
                .flatMap(Coercions::coerceToBigDecimal);
    }

    default Optional<BigInteger> getCoercedBigInteger(final int columnIndex) throws SQLException {
        return getOptionalObject(columnIndex)
                .flatMap(Coercions::coerceToBigInteger);
    }

    default Optional<BigInteger> getCoercedBigInteger(final String columnLabel) throws SQLException {
        return getOptionalObject(columnLabel)
                .flatMap(Coercions::coerceToBigInteger);
    }

    default Optional<Boolean> getCoercedBoolean(final int columnIndex) throws SQLException {
        return getOptionalObject(columnIndex)
                .flatMap(Coercions::coerceToBoolean);
    }

    default Optional<Boolean> getCoercedBoolean(final String columnLabel) throws SQLException {
        return getOptionalObject(columnLabel)
                .flatMap(Coercions::coerceToBoolean);
    }

    default Optional<Byte> getCoercedByte(final int columnIndex) throws SQLException {
        return getOptionalObject(columnIndex)
                .flatMap(Coercions::coerceToByte);
    }

    default Optional<Byte> getCoercedByte(final String columnLabel) throws SQLException {
        return getOptionalObject(columnLabel)
                .flatMap(Coercions::coerceToByte);
    }

    default Optional<Character> getCoercedCharacter(final int columnIndex) throws SQLException {
        return getOptionalObject(columnIndex)
                .flatMap(Coercions::coerceToCharacter);
    }

    default Optional<Character> getCoercedCharacter(final String columnLabel) throws SQLException {
        return getOptionalObject(columnLabel)
                .flatMap(Coercions::coerceToCharacter);
    }

    default Optional<Double> getCoercedDouble(final int columnIndex) throws SQLException {
        return getOptionalObject(columnIndex)
                .flatMap(Coercions::coerceToDouble);
    }

    default Optional<Double> getCoercedDouble(final String columnLabel) throws SQLException {
        return getOptionalObject(columnLabel)
                .flatMap(Coercions::coerceToDouble);
    }

    default Optional<Float> getCoercedFloat(final int columnIndex) throws SQLException {
        return getOptionalObject(columnIndex)
                .flatMap(Coercions::coerceToFloat);
    }

    default Optional<Float> getCoercedFloat(final String columnLabel) throws SQLException {
        return getOptionalObject(columnLabel)
                .flatMap(Coercions::coerceToFloat);
    }

    default Optional<Integer> getCoercedInteger(final int columnIndex) throws SQLException {
        return getOptionalObject(columnIndex)
                .flatMap(Coercions::coerceToInteger);
    }

    default Optional<Integer> getCoercedInteger(final String columnLabel) throws SQLException {
        return getOptionalObject(columnLabel)
                .flatMap(Coercions::coerceToInteger);
    }

    default Optional<LocalDate> getCoercedLocalDate(final int columnIndex) throws SQLException {
        return getOptionalObject(columnIndex)
                .flatMap(Coercions::coerceToLocalDate);
    }

    default Optional<LocalDate> getCoercedLocalDate(final String columnLabel) throws SQLException {
        return getOptionalObject(columnLabel)
                .flatMap(Coercions::coerceToLocalDate);
    }

    default Optional<LocalTime> getCoercedLocalTime(final int columnIndex) throws SQLException {
        return getOptionalObject(columnIndex)
                .flatMap(Coercions::coerceToLocalTime);
    }

    default Optional<LocalTime> getCoercedLocalTime(final String columnLabel) throws SQLException {
        return getOptionalObject(columnLabel)
                .flatMap(Coercions::coerceToLocalTime);
    }

    default Optional<Long> getCoercedLong(final int columnIndex) throws SQLException {
        return getOptionalObject(columnIndex)
                .flatMap(Coercions::coerceToLong);
    }

    default Optional<Long> getCoercedLong(final String columnLabel) throws SQLException {
        return getOptionalObject(columnLabel)
                .flatMap(Coercions::coerceToLong);
    }

    default Optional<Short> getCoercedShort(final int columnIndex) throws SQLException {
        return getOptionalObject(columnIndex)
                .flatMap(Coercions::coerceToShort);
    }

    default Optional<Short> getCoercedShort(final String columnLabel) throws SQLException {
        return getOptionalObject(columnLabel)
                .flatMap(Coercions::coerceToShort);
    }

    default Instant getInstant(final int columnIndex) throws SQLException {
        // emulate normal JDBC calls which return null
        return getOptionalInstant(columnIndex).orElse(null);
    }

    default Instant getInstant(final String columnLabel) throws SQLException {
        // emulate normal JDBC calls which return null
        return getOptionalInstant(columnLabel).orElse(null);
    }

    default Instant getInstant(final int columnIndex, final Calendar cal) throws SQLException {
        // emulate normal JDBC calls which return null
        return getOptionalInstant(columnIndex, cal).orElse(null);
    }

    default Instant getInstant(final String columnLabel, final Calendar cal) throws SQLException {
        // emulate normal JDBC calls which return null
        return getOptionalInstant(columnLabel, cal).orElse(null);
    }

    default LocalDate getLocalDate(final int columnIndex) throws SQLException {
        // emulate normal JDBC calls which return null
        return getOptionalLocalDate(columnIndex).orElse(null);
    }

    default LocalDate getLocalDate(final String columName) throws SQLException {
        // emulate normal JDBC calls which return null
        return getOptionalLocalDate(columName).orElse(null);
    }

    default LocalDate getLocalDate(final int columnIndex, final Calendar cal) throws SQLException {
        // emulate normal JDBC calls which return null
        return getOptionalLocalDate(columnIndex, cal).orElse(null);
    }

    default LocalDate getLocalDate(final String columnLabel, final Calendar cal) throws SQLException {
        // emulate normal JDBC calls which return null
        return getOptionalLocalDate(columnLabel, cal).orElse(null);
    }

    default LocalDateTime getLocalDateTime(final int columnIndex) throws SQLException {
        // emulate normal JDBC calls which return null
        return getOptionalLocalDateTime(columnIndex).orElse(null);
    }

    default LocalDateTime getLocalDateTime(final String columnLabel) throws SQLException {
        // emulate normal JDBC calls which return null
        return getOptionalLocalDateTime(columnLabel).orElse(null);
    }

    default LocalDateTime getLocalDateTime(final int columnIndex, final Calendar cal) throws SQLException {
        // emulate normal JDBC calls which return null
        return getOptionalLocalDateTime(columnIndex, cal).orElse(null);
    }

    default LocalDateTime getLocalDateTime(final String columnLabel, final Calendar cal) throws SQLException {
        // emulate normal JDBC calls which return null
        return getOptionalLocalDateTime(columnLabel, cal).orElse(null);
    }

    default LocalTime getLocalTime(final int columnIndex) throws SQLException {
        // emulate normal JDBC calls which return null
        return getOptionalLocalTime(columnIndex).orElse(null);
    }

    default LocalTime getLocalTime(final String columnLabel) throws SQLException {
        // emulate normal JDBC calls which return null
        return getOptionalLocalTime(columnLabel).orElse(null);
    }

    default LocalTime getLocalTime(final int columnIndex, final Calendar cal) throws SQLException {
        // emulate normal JDBC calls which return null
        return getOptionalLocalTime(columnIndex, cal).orElse(null);
    }

    default LocalTime getLocalTime(final String columnLabel, final Calendar cal) throws SQLException {
        // emulate normal JDBC calls which return null
        return getOptionalLocalTime(columnLabel, cal).orElse(null);
    }

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
    default Optional<Array> getOptionalArray(final int columnIndex) throws SQLException {
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
    default Optional<Array> getOptionalArray(final String columnLabel) throws SQLException {
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
    default Optional<BigDecimal> getOptionalBigDecimal(final int columnIndex) throws SQLException {
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
    default Optional<BigDecimal> getOptionalBigDecimal(final String columnLabel) throws SQLException {
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
    default Optional<Blob> getOptionalBlob(final int columnIndex) throws SQLException {
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
    default Optional<Blob> getOptionalBlob(final String columnLabel) throws SQLException {
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
    default Optional<Boolean> getOptionalBoolean(final int columnIndex) throws SQLException {
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
    default Optional<Boolean> getOptionalBoolean(final String columnLabel) throws SQLException {
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
    default Optional<Byte> getOptionalByte(final int columnIndex) throws SQLException {
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
    default Optional<Byte> getOptionalByte(final String columnLabel) throws SQLException {
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
    default Optional<byte[]> getOptionalBytes(final int columnIndex) throws SQLException {
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
    default Optional<byte[]> getOptionalBytes(final String columnLabel) throws SQLException {
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
    default Optional<Clob> getOptionalClob(final int columnIndex) throws SQLException {
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
    default Optional<Clob> getOptionalClob(final String columnLabel) throws SQLException {
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
    default Optional<Date> getOptionalDate(final int columnIndex) throws SQLException {
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
    default Optional<Date> getOptionalDate(final String columnLabel) throws SQLException {
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
    default Optional<Date> getOptionalDate(final int columnIndex, final Calendar cal)
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
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Date> getOptionalDate(final String columnLabel, final Calendar cal)
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
    default Optional<Double> getOptionalDouble(final int columnIndex) throws SQLException {
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
    default Optional<Double> getOptionalDouble(final String columnLabel) throws SQLException {
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
    default Optional<Float> getOptionalFloat(final int columnIndex) throws SQLException {
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
    default Optional<Float> getOptionalFloat(final String columnLabel) throws SQLException {
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
    default Optional<Integer> getOptionalInt(final int columnIndex) throws SQLException {
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
    default Optional<Integer> getOptionalInt(final String columnLabel) throws SQLException {
        final int value = getInt(columnLabel);
        return wasNull()
                ? Optional.empty()
                : Optional.of(value);
    }

    default Optional<Instant> getOptionalInstant(final int columnIndex) throws SQLException {
        return getOptionalTimestamp(columnIndex).map(Timestamp::toInstant);
    }

    default Optional<Instant> getOptionalInstant(final String columnLabel) throws SQLException {
        return getOptionalTimestamp(columnLabel).map(Timestamp::toInstant);
    }

    default Optional<Instant> getOptionalInstant(final int columnIndex, final Calendar cal) throws SQLException {
        return getOptionalTimestamp(columnIndex, cal).map(Timestamp::toInstant);
    }

    default Optional<Instant> getOptionalInstant(final String columnLabel, final Calendar cal) throws SQLException {
        return getOptionalTimestamp(columnLabel, cal).map(Timestamp::toInstant);
    }

    default Optional<LocalDate> getOptionalLocalDate(final int columnIndex) throws SQLException {
        return getOptionalDate(columnIndex).map(Date::toLocalDate);
    }

    default Optional<LocalDate> getOptionalLocalDate(final String columnLabel) throws SQLException {
        return getOptionalDate(columnLabel).map(Date::toLocalDate);
    }

    default Optional<LocalDate> getOptionalLocalDate(final int columnIndex, final Calendar cal) throws SQLException {
        return getOptionalDate(columnIndex, cal).map(Date::toLocalDate);
    }

    default Optional<LocalDate> getOptionalLocalDate(final String columnLabel, final Calendar cal) throws SQLException {
        return getOptionalDate(columnLabel, cal).map(Date::toLocalDate);
    }

    default Optional<LocalDateTime> getOptionalLocalDateTime(final int columnIndex) throws SQLException {
        return getOptionalTimestamp(columnIndex).map(Timestamp::toLocalDateTime);
    }

    default Optional<LocalDateTime> getOptionalLocalDateTime(final String columnLabel) throws SQLException {
        return getOptionalTimestamp(columnLabel).map(Timestamp::toLocalDateTime);
    }

    default Optional<LocalDateTime> getOptionalLocalDateTime(final int columnIndex, final Calendar cal) throws SQLException {
        return getOptionalTimestamp(columnIndex, cal).map(Timestamp::toLocalDateTime);
    }

    default Optional<LocalDateTime> getOptionalLocalDateTime(final String columnLabel, final Calendar cal) throws SQLException {
        return getOptionalTimestamp(columnLabel, cal).map(Timestamp::toLocalDateTime);
    }

    default Optional<LocalTime> getOptionalLocalTime(final int columnIndex) throws SQLException {
        return getOptionalTime(columnIndex).map(Time::toLocalTime);
    }

    default Optional<LocalTime> getOptionalLocalTime(final String columnLabel) throws SQLException {
        return getOptionalTime(columnLabel).map(Time::toLocalTime);
    }

    default Optional<LocalTime> getOptionalLocalTime(final int columnIndex, final Calendar cal) throws SQLException {
        return getOptionalTime(columnIndex, cal).map(Time::toLocalTime);
    }

    default Optional<LocalTime> getOptionalLocalTime(final String columnLabel, final Calendar cal) throws SQLException {
        return getOptionalTime(columnLabel, cal).map(Time::toLocalTime);
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
    default Optional<Long> getOptionalLong(final int columnIndex) throws SQLException {
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
    default Optional<Long> getOptionalLong(final String columnLabel) throws SQLException {
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
    default Optional<NClob> getOptionalNClob(final int columnIndex) throws SQLException {
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
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<NClob> getOptionalNClob(final String columnLabel) throws SQLException {
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
    default Optional<String> getOptionalNString(final int columnIndex) throws SQLException {
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
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<String> getOptionalNString(final String columnLabel) throws SQLException {
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
    default Optional<Object> getOptionalObject(final int columnIndex) throws SQLException {
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
    default Optional<Object> getOptionalObject(final String columnLabel) throws SQLException {
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
    default Optional<Object> getOptionalObject(final int columnIndex, final Map<String,Class<?>> map)
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
    default Optional<Object> getOptionalObject(final String columnLabel, final Map<String,Class<?>> map)
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
    default <T> Optional<T> getOptionalObject(final int columnIndex, final Class<T> type) throws SQLException {
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
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default <T> Optional<T> getOptionalObject(final String columnLabel, final Class<T> type)
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
    default Optional<Ref> getOptionalRef(final int columnIndex) throws SQLException {
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
    default Optional<Ref> getOptionalRef(final String columnLabel) throws SQLException {
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
    default Optional<RowId> getOptionalRowId(final int columnIndex) throws SQLException {
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
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<RowId> getOptionalRowId(final String columnLabel) throws SQLException {
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
    default Optional<Short> getOptionalShort(final int columnIndex) throws SQLException {
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
    default Optional<Short> getOptionalShort(final String columnLabel) throws SQLException {
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
    default Optional<SQLXML> getOptionalSQLXML(final int columnIndex) throws SQLException {
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
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<SQLXML> getOptionalSQLXML(final String columnLabel) throws SQLException {
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
    default Optional<String> getOptionalString(final int columnIndex) throws SQLException {
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
    default Optional<String> getOptionalString(final String columnLabel) throws SQLException {
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
    default Optional<Time> getOptionalTime(final int columnIndex) throws SQLException {
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
    default Optional<Time> getOptionalTime(final String columnLabel) throws SQLException {
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
    default Optional<Time> getOptionalTime(final int columnIndex, final Calendar cal)
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
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Time> getOptionalTime(final String columnLabel, final Calendar cal)
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
    default Optional<Timestamp> getOptionalTimestamp(final int columnIndex) throws SQLException {
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
    default Optional<Timestamp> getOptionalTimestamp(final String columnLabel)
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
    default Optional<Timestamp> getOptionalTimestamp(final int columnIndex, final Calendar cal)
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
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     */
    default Optional<Timestamp> getOptionalTimestamp(final String columnLabel, final Calendar cal)
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
    default Optional<URL> getOptionalURL(final int columnIndex) throws SQLException {
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
     *          if the columnLabel is not valid; if a database access error occurs or this method is
     *          called on a closed result set
     * @exception java.sql.SQLFeatureNotSupportedException
     *          if the JDBC driver does not support this method
     */
    default Optional<URL> getOptionalURL(final String columnLabel) throws SQLException {
        return Optional.ofNullable(getURL(columnLabel));
    }
}
