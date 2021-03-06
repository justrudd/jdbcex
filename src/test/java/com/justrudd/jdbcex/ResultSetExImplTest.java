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
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.same;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

/*
 * We do not test delegation of all methods. We only test the new default methods of
 * the ResultSetEx interface.
 */
public class ResultSetExImplTest {

    @Before
    public void beforeEachTest() {
        mockResultSet = mock(ResultSet.class);
        resultSetEx = new ResultSetExImpl(mockResultSet);

        anyColumnIndex = RANDOM.nextInt(10) + 1;
        anyColumnName = Long.toHexString(RANDOM.nextLong());
    }

    @Test
    public void emptyCoercedBigDecimalReturnedByIndex() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedBigDecimal(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedBigDecimalReturnedByIndex() throws SQLException {
        final BigDecimal value = BigDecimal.TEN;
        when(mockResultSet.getObject(anyInt())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedBigDecimal(anyColumnIndex)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void emptyCoercedBigDecimalReturnedByName() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedBigDecimal(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedBigDecimalReturnedByName() throws SQLException {
        final BigDecimal value = BigDecimal.TEN;
        when(mockResultSet.getObject(anyString())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedBigDecimal(anyColumnName)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnName));
    }

    @Test
    public void emptyCoercedBigIntegerReturnedByIndex() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedBigInteger(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedBigIntegerReturnedByIndex() throws SQLException {
        final BigInteger value = BigInteger.TEN;
        when(mockResultSet.getObject(anyInt())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedBigInteger(anyColumnIndex)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void emptyCoercedBigIntegerReturnedByName() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedBigInteger(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedBigIntegerReturnedByName() throws SQLException {
        final BigInteger value = BigInteger.TEN;
        when(mockResultSet.getObject(anyString())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedBigInteger(anyColumnName)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnName));
    }

    @Test
    public void emptyCoercedBooleanReturnedByIndex() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedBoolean(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedBooleanReturnedByIndex() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(Boolean.FALSE);

        OptionalAssertions.assertThat(resultSetEx.getCoercedBoolean(anyColumnIndex)).isPresentAndEqualTo(Boolean.FALSE);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void emptyCoercedBooleanReturnedByName() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedBoolean(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedBooleanReturnedByName() throws SQLException {
        when(mockResultSet.getObject(anyString())).thenReturn(Boolean.TRUE);

        OptionalAssertions.assertThat(resultSetEx.getCoercedBoolean(anyColumnName)).isPresentAndEqualTo(Boolean.TRUE);

        verify(mockResultSet, only()).getObject(eq(anyColumnName));
    }

    @Test
    public void emptyCoercedByteReturnedByIndex() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedByte(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedByteReturnedByIndex() throws SQLException {
        final Byte value = (byte)128;
        when(mockResultSet.getObject(anyInt())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedByte(anyColumnIndex)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void emptyCoercedByteReturnedByName() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedByte(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedByteReturnedByName() throws SQLException {
        final Byte value = (byte)127;
        when(mockResultSet.getObject(anyString())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedByte(anyColumnName)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnName));
    }

    @Test
    public void emptyCoercedCharacterReturnedByIndex() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedCharacter(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedCharacterReturnedByIndex() throws SQLException {
        final Character value = 'j';
        when(mockResultSet.getObject(anyInt())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedCharacter(anyColumnIndex)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void emptyCoercedCharacterReturnedByName() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedCharacter(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedCharacterReturnedByName() throws SQLException {
        final Character value = 'r';
        when(mockResultSet.getObject(anyString())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedCharacter(anyColumnName)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnName));
    }

    @Test
    public void emptyCoercedDoubleReturnedByIndex() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedDouble(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedDoubleReturnedByIndex() throws SQLException {
        final Double value = Math.PI;
        when(mockResultSet.getObject(anyInt())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedDouble(anyColumnIndex)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void emptyCoercedDoubleReturnedByName() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedDouble(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedDoubleReturnedByName() throws SQLException {
        final Double value = Math.E;
        when(mockResultSet.getObject(anyString())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedDouble(anyColumnName)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnName));
    }

    @Test
    public void emptyCoercedFloatReturnedByIndex() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedFloat(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedFloatReturnedByIndex() throws SQLException {
        final Float value = (float)Math.PI;
        when(mockResultSet.getObject(anyInt())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedFloat(anyColumnIndex)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void emptyCoercedFloatReturnedByName() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedFloat(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedFloatReturnedByName() throws SQLException {
        final Float value = (float)Math.E;
        when(mockResultSet.getObject(anyString())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedFloat(anyColumnName)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnName));
    }

    @Test
    public void emptyCoercedIntegerReturnedByIndex() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedInteger(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedIntegerReturnedByIndex() throws SQLException {
        final Integer value = 1976;
        when(mockResultSet.getObject(anyInt())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedInteger(anyColumnIndex)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void emptyCoercedIntegerReturnedByName() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedInteger(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedIntegerReturnedByName() throws SQLException {
        final Integer value = 1988;
        when(mockResultSet.getObject(anyString())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedInteger(anyColumnName)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnName));
    }

    @Test
    public void emptyCoercedInstantReturnedByIndex() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedInstant(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedInstantReturnedByIndex() throws SQLException {
        final Instant value = Instant.now();
        when(mockResultSet.getObject(anyInt())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedInstant(anyColumnIndex)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void emptyCoercedInstantReturnedByName() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedInstant(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedInstantReturnedByName() throws SQLException {
        final Instant value = Instant.now();
        when(mockResultSet.getObject(anyString())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedInstant(anyColumnName)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnName));
    }

    @Test
    public void emptyCoercedLocalDateReturnedByIndex() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedLocalDate(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedLocalDateReturnedByIndex() throws SQLException {
        final LocalDate value = LocalDate.now();
        when(mockResultSet.getObject(anyInt())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedLocalDate(anyColumnIndex)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void emptyCoercedLocalDateReturnedByName() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedLocalDate(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedLocalDateReturnedByName() throws SQLException {
        final LocalDate value = LocalDate.now();
        when(mockResultSet.getObject(anyString())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedLocalDate(anyColumnName)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnName));
    }

    @Test
    public void emptyCoercedLocalDateTimeReturnedByIndex() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedLocalDateTime(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedLocalDateTimeReturnedByIndex() throws SQLException {
        final LocalDateTime value = LocalDateTime.now();
        when(mockResultSet.getObject(anyInt())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedLocalDateTime(anyColumnIndex)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void emptyCoercedLocalDateTimeReturnedByName() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedLocalDateTime(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedLocalDateTimeReturnedByName() throws SQLException {
        final LocalDateTime value = LocalDateTime.now();
        when(mockResultSet.getObject(anyString())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedLocalDateTime(anyColumnName)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnName));
    }

    @Test
    public void emptyCoercedLocalTimeReturnedByIndex() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedLocalTime(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedLocalTimeReturnedByIndex() throws SQLException {
        final LocalTime value = LocalTime.now();
        when(mockResultSet.getObject(anyInt())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedLocalTime(anyColumnIndex)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void emptyCoercedLocalTimeReturnedByName() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedLocalTime(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedLocalTimeReturnedByName() throws SQLException {
        final LocalTime value = LocalTime.now();
        when(mockResultSet.getObject(anyString())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedLocalTime(anyColumnName)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnName));
    }

    @Test
    public void emptyCoercedLongReturnedByIndex() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedLong(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedLongReturnedByIndex() throws SQLException {
        final Long value = 1976L;
        when(mockResultSet.getObject(anyInt())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedLong(anyColumnIndex)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void emptyCoercedLongReturnedByName() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedLong(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedLongReturnedByName() throws SQLException {
        final Long value = 1988L;
        when(mockResultSet.getObject(anyString())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedLong(anyColumnName)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnName));
    }

    @Test
    public void emptyCoercedShortReturnedByIndex() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedShort(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedShortReturnedByIndex() throws SQLException {
        final Short value = 1976;
        when(mockResultSet.getObject(anyInt())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedShort(anyColumnIndex)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void emptyCoercedShortReturnedByName() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getCoercedShort(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentCoercedShortReturnedByName() throws SQLException {
        final Short value = 1988;
        when(mockResultSet.getObject(anyString())).thenReturn(value);

        OptionalAssertions.assertThat(resultSetEx.getCoercedShort(anyColumnName)).isPresentAndEqualTo(value);

        verify(mockResultSet, only()).getObject(eq(anyColumnName));
    }

    @Test
    public void nullInstantReturnedByIndex() throws SQLException {
        when(mockResultSet.getTimestamp(anyInt())).thenReturn(null);

        assertThat(resultSetEx.getInstant(anyColumnIndex)).isNull();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnIndex));
    }

    @Test
    public void nullInstantReturnedByName() throws SQLException {
        when(mockResultSet.getTimestamp(anyString())).thenReturn(null);

        assertThat(resultSetEx.getInstant(anyColumnName)).isNull();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnName));
    }

    @Test
    public void nullInstantReturnedByIndexAndCal() throws SQLException {
        when(mockResultSet.getTimestamp(anyInt(), any(Calendar.class))).thenReturn(null);

        final Calendar calendar = Calendar.getInstance();
        assertThat(resultSetEx.getInstant(anyColumnIndex, calendar)).isNull();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnIndex), same(calendar));
    }

    @Test
    public void nullInstantReturnedByNameAndCal() throws SQLException {
        when(mockResultSet.getTimestamp(anyString(), any(Calendar.class))).thenReturn(null);

        final Calendar calendar = Calendar.getInstance();
        assertThat(resultSetEx.getInstant(anyColumnName, calendar)).isNull();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnName), same(calendar));
    }

    @Test
    public void nullLocalDateReturnedByIndex() throws SQLException {
        when(mockResultSet.getDate(anyInt())).thenReturn(null);

        assertThat(resultSetEx.getLocalDate(anyColumnIndex)).isNull();

        verify(mockResultSet, only()).getDate(eq(anyColumnIndex));
    }

    @Test
    public void nullLocalDateReturnedByName() throws SQLException {
        when(mockResultSet.getDate(anyString())).thenReturn(null);

        assertThat(resultSetEx.getLocalDate(anyColumnName)).isNull();

        verify(mockResultSet, only()).getDate(eq(anyColumnName));
    }

    @Test
    public void nullLocalDateReturnedByIndexAndCal() throws SQLException {
        when(mockResultSet.getDate(anyInt(), any(Calendar.class))).thenReturn(null);

        final Calendar calendar = Calendar.getInstance();
        assertThat(resultSetEx.getLocalDate(anyColumnIndex, calendar)).isNull();

        verify(mockResultSet, only()).getDate(eq(anyColumnIndex), same(calendar));
    }

    @Test
    public void nullLocalDateReturnedByNameAndCal() throws SQLException {
        when(mockResultSet.getDate(anyString(), any(Calendar.class))).thenReturn(null);

        final Calendar calendar = Calendar.getInstance();
        assertThat(resultSetEx.getLocalDate(anyColumnName, calendar)).isNull();

        verify(mockResultSet, only()).getDate(eq(anyColumnName), same(calendar));
    }

    @Test
    public void nullLocalDateTimeReturnedByIndex() throws SQLException {
        when(mockResultSet.getTimestamp(anyInt())).thenReturn(null);

        assertThat(resultSetEx.getLocalDateTime(anyColumnIndex)).isNull();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnIndex));
    }

    @Test
    public void nullLocalDateTimeReturnedByName() throws SQLException {
        when(mockResultSet.getTimestamp(anyString())).thenReturn(null);

        assertThat(resultSetEx.getLocalDateTime(anyColumnName)).isNull();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnName));
    }

    @Test
    public void nullLocalDateTimeReturnedByIndexAndCal() throws SQLException {
        when(mockResultSet.getTimestamp(anyInt(), any(Calendar.class))).thenReturn(null);

        final Calendar calendar = Calendar.getInstance();
        assertThat(resultSetEx.getLocalDateTime(anyColumnIndex, calendar)).isNull();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnIndex), same(calendar));
    }

    @Test
    public void nullLocalDateTimeReturnedByNameAndCal() throws SQLException {
        when(mockResultSet.getTimestamp(anyString(), any(Calendar.class))).thenReturn(null);

        final Calendar calendar = Calendar.getInstance();
        assertThat(resultSetEx.getLocalDateTime(anyColumnName, calendar)).isNull();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnName), same(calendar));
    }

    @Test
    public void nullLocalTimeReturnedByIndex() throws SQLException {
        when(mockResultSet.getTime(anyInt())).thenReturn(null);

        assertThat(resultSetEx.getLocalTime(anyColumnIndex)).isNull();

        verify(mockResultSet, only()).getTime(eq(anyColumnIndex));
    }

    @Test
    public void nullLocalTimeReturnedByName() throws SQLException {
        when(mockResultSet.getTime(anyString())).thenReturn(null);

        assertThat(resultSetEx.getLocalTime(anyColumnName)).isNull();

        verify(mockResultSet, only()).getTime(eq(anyColumnName));
    }

    @Test
    public void nullLocalTimeReturnedByIndexAndCal() throws SQLException {
        when(mockResultSet.getTime(anyInt(), any(Calendar.class))).thenReturn(null);

        final Calendar calendar = Calendar.getInstance();
        assertThat(resultSetEx.getLocalTime(anyColumnIndex, calendar)).isNull();

        verify(mockResultSet, only()).getTime(eq(anyColumnIndex), same(calendar));
    }

    @Test
    public void nullLocalTimeReturnedByNameAndCal() throws SQLException {
        when(mockResultSet.getTime(anyString(), any(Calendar.class))).thenReturn(null);

        final Calendar calendar = Calendar.getInstance();
        assertThat(resultSetEx.getLocalTime(anyColumnName, calendar)).isNull();

        verify(mockResultSet, only()).getTime(eq(anyColumnName), same(calendar));
    }

    @Test
    public void emptyOptionalArrayReturnedByIndex() throws SQLException {
        when(mockResultSet.getArray(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalArray(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getArray(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalArrayReturnedByName() throws SQLException {
        when(mockResultSet.getArray(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalArray(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getArray(eq(anyColumnName));
    }

    @Test
    public void presentOptionalArrayReturnedByIndex() throws SQLException {
        final Array anyArray = mock(Array.class);
        when(mockResultSet.getArray(anyInt())).thenReturn(anyArray);

        OptionalAssertions.assertThat(resultSetEx.getOptionalArray(anyColumnIndex)).isPresentAndSameAs(anyArray);

        verify(mockResultSet, only()).getArray(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalArrayReturnedByName() throws SQLException {
        final Array anyArray = mock(Array.class);
        when(mockResultSet.getArray(anyString())).thenReturn(anyArray);

        OptionalAssertions.assertThat(resultSetEx.getOptionalArray(anyColumnName)).isPresentAndSameAs(anyArray);

        verify(mockResultSet, only()).getArray(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalBigDecimalReturnedByIndex() throws SQLException {
        when(mockResultSet.getBigDecimal(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalBigDecimal(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getBigDecimal(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalBigDecimalReturnedByName() throws SQLException {
        when(mockResultSet.getBigDecimal(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalBigDecimal(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getBigDecimal(eq(anyColumnName));
    }

    @Test
    public void presentOptionalBigDecimalReturnedByIndex() throws SQLException {
        final BigDecimal anyBigDecimal = new BigDecimal(RANDOM.nextDouble());
        when(mockResultSet.getBigDecimal(anyInt())).thenReturn(anyBigDecimal);

        OptionalAssertions.assertThat(resultSetEx.getOptionalBigDecimal(anyColumnIndex))
                .isPresentAndEqualTo(anyBigDecimal);

        verify(mockResultSet, only()).getBigDecimal(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalBigDecimalReturnedByName() throws SQLException {
        final BigDecimal anyBigDecimal = new BigDecimal(RANDOM.nextDouble());
        when(mockResultSet.getBigDecimal(anyString())).thenReturn(anyBigDecimal);

        OptionalAssertions.assertThat(resultSetEx.getOptionalBigDecimal(anyColumnName))
                .isPresentAndEqualTo(anyBigDecimal);

        verify(mockResultSet, only()).getBigDecimal(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalBlobReturnedByIndex() throws SQLException {
        when(mockResultSet.getBlob(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalBlob(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getBlob(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalBlobReturnedByName() throws SQLException {
        when(mockResultSet.getBlob(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalBlob(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getBlob(eq(anyColumnName));
    }

    @Test
    public void presentOptionalBlobReturnedByIndex() throws SQLException {
        final Blob anyBlob = mock(Blob.class);
        when(mockResultSet.getBlob(anyInt())).thenReturn(anyBlob);

        OptionalAssertions.assertThat(resultSetEx.getOptionalBlob(anyColumnIndex)).isPresentAndSameAs(anyBlob);

        verify(mockResultSet, only()).getBlob(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalBlobReturnedByName() throws SQLException {
        final Blob anyBlob = mock(Blob.class);
        when(mockResultSet.getBlob(anyString())).thenReturn(anyBlob);

        OptionalAssertions.assertThat(resultSetEx.getOptionalBlob(anyColumnName)).isPresentAndSameAs(anyBlob);

        verify(mockResultSet, only()).getBlob(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalBooleanReturnedByIndex() throws SQLException {
        when(mockResultSet.getBoolean(anyInt())).thenReturn(false);
        when(mockResultSet.wasNull()).thenReturn(IS_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalBoolean(anyColumnIndex)).isEmpty();

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getBoolean(eq(anyColumnIndex));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void emptyOptionalBooleanReturnedByName() throws SQLException {
        when(mockResultSet.getBoolean(anyString())).thenReturn(false);
        when(mockResultSet.wasNull()).thenReturn(IS_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalBoolean(anyColumnName)).isEmpty();

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getBoolean(eq(anyColumnName));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void presentOptionalBooleanReturnedByIndex() throws SQLException {
        final boolean anyBoolean = RANDOM.nextBoolean();
        when(mockResultSet.getBoolean(anyInt())).thenReturn(anyBoolean);
        when(mockResultSet.wasNull()).thenReturn(IS_NOT_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalBoolean(anyColumnIndex)).isPresentAndEqualTo(anyBoolean);

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getBoolean(eq(anyColumnIndex));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void presentOptionalBooleanReturnedByName() throws SQLException {
        final boolean anyBoolean = RANDOM.nextBoolean();
        when(mockResultSet.getBoolean(anyString())).thenReturn(anyBoolean);
        when(mockResultSet.wasNull()).thenReturn(IS_NOT_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalBoolean(anyColumnName)).isPresentAndEqualTo(anyBoolean);

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getBoolean(eq(anyColumnName));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void emptyOptionalByteReturnedByIndex() throws SQLException {
        when(mockResultSet.getByte(anyInt())).thenReturn((byte)0);
        when(mockResultSet.wasNull()).thenReturn(IS_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalByte(anyColumnIndex)).isEmpty();

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getByte(eq(anyColumnIndex));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void emptyOptionalByteReturnedByName() throws SQLException {
        when(mockResultSet.getByte(anyString())).thenReturn((byte)0);
        when(mockResultSet.wasNull()).thenReturn(IS_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalByte(anyColumnName)).isEmpty();

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getByte(eq(anyColumnName));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void presentOptionalByteReturnedByIndex() throws SQLException {
        final byte anyByte = (byte)RANDOM.nextInt(Byte.MAX_VALUE);
        when(mockResultSet.getByte(anyInt())).thenReturn(anyByte);
        when(mockResultSet.wasNull()).thenReturn(IS_NOT_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalByte(anyColumnIndex)).isPresentAndEqualTo(anyByte);

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getByte(eq(anyColumnIndex));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void presentOptionalByteReturnedByName() throws SQLException {
        final byte anyByte = (byte)RANDOM.nextInt(Byte.MAX_VALUE);
        when(mockResultSet.getByte(anyString())).thenReturn(anyByte);
        when(mockResultSet.wasNull()).thenReturn(IS_NOT_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalByte(anyColumnName)).isPresentAndEqualTo(anyByte);

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getByte(eq(anyColumnName));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void emptyOptionalBytesReturnedByIndex() throws SQLException {
        when(mockResultSet.getBytes(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalBytes(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getBytes(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalBytesReturnedByName() throws SQLException {
        when(mockResultSet.getBytes(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalBytes(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getBytes(eq(anyColumnName));
    }

    @Test
    public void presentOptionalBytesReturnedByIndex() throws SQLException {
        final byte[] anyBytes = new byte[8];
        RANDOM.nextBytes(anyBytes);
        when(mockResultSet.getBytes(anyInt())).thenReturn(anyBytes);

        OptionalAssertions.assertThat(resultSetEx.getOptionalBytes(anyColumnIndex)).isPresentAndEqualTo(anyBytes);

        verify(mockResultSet, only()).getBytes(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalBytesReturnedByName() throws SQLException {
        final byte[] anyBytes = new byte[8];
        RANDOM.nextBytes(anyBytes);
        when(mockResultSet.getBytes(anyString())).thenReturn(anyBytes);

        OptionalAssertions.assertThat(resultSetEx.getOptionalBytes(anyColumnName)).isPresentAndEqualTo(anyBytes);

        verify(mockResultSet, only()).getBytes(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalClobReturnedByIndex() throws SQLException {
        when(mockResultSet.getClob(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalClob(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getClob(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalClobReturnedByName() throws SQLException {
        when(mockResultSet.getClob(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalClob(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getClob(eq(anyColumnName));
    }

    @Test
    public void presentOptionalClobReturnedByIndex() throws SQLException {
        final Clob anyClob = mock(Clob.class);
        when(mockResultSet.getClob(anyInt())).thenReturn(anyClob);

        OptionalAssertions.assertThat(resultSetEx.getOptionalClob(anyColumnIndex)).isPresentAndSameAs(anyClob);

        verify(mockResultSet, only()).getClob(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalClobReturnedByName() throws SQLException {
        final Clob anyClob = mock(Clob.class);
        when(mockResultSet.getClob(anyString())).thenReturn(anyClob);

        OptionalAssertions.assertThat(resultSetEx.getOptionalClob(anyColumnName)).isPresentAndSameAs(anyClob);

        verify(mockResultSet, only()).getClob(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalDateReturnedByIndex() throws SQLException {
        when(mockResultSet.getDate(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalDate(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getDate(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalDateReturnedByName() throws SQLException {
        when(mockResultSet.getDate(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalDate(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getDate(eq(anyColumnName));
    }

    @Test
    public void presentOptionalDateReturnedByIndex() throws SQLException {
        final Date anyDate = Date.valueOf(LocalDate.now());
        when(mockResultSet.getDate(anyInt())).thenReturn(anyDate);

        OptionalAssertions.assertThat(resultSetEx.getOptionalDate(anyColumnIndex)).isPresentAndEqualTo(anyDate);

        verify(mockResultSet, only()).getDate(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalDateReturnedByName() throws SQLException {
        final Date anyDate = Date.valueOf(LocalDate.now());
        when(mockResultSet.getDate(anyString())).thenReturn(anyDate);

        OptionalAssertions.assertThat(resultSetEx.getOptionalDate(anyColumnName)).isPresentAndSameAs(anyDate);

        verify(mockResultSet, only()).getDate(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalDateReturnedByIndexAndCal() throws SQLException {
        when(mockResultSet.getDate(anyInt(), any(Calendar.class))).thenReturn(null);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalDate(anyColumnIndex, theCalendar)).isEmpty();

        verify(mockResultSet, only()).getDate(eq(anyColumnIndex), same(theCalendar));
    }

    @Test
    public void emptyOptionalDateReturnedByNameAndCal() throws SQLException {
        when(mockResultSet.getDate(anyString(), any(Calendar.class))).thenReturn(null);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalDate(anyColumnName, theCalendar)).isEmpty();

        verify(mockResultSet, only()).getDate(eq(anyColumnName), same(theCalendar));
    }

    @Test
    public void presentOptionalDateReturnedByIndexAndCal() throws SQLException {
        final Date anyDate = Date.valueOf(LocalDate.now());
        when(mockResultSet.getDate(anyInt(), any(Calendar.class))).thenReturn(anyDate);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalDate(anyColumnIndex, theCalendar))
                .isPresentAndEqualTo(anyDate);

        verify(mockResultSet, only()).getDate(eq(anyColumnIndex), same(theCalendar));
    }

    @Test
    public void presentOptionalDateReturnedByNameAndCal() throws SQLException {
        final Date anyDate = Date.valueOf(LocalDate.now());
        when(mockResultSet.getDate(anyString(), any(Calendar.class))).thenReturn(anyDate);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalDate(anyColumnName, theCalendar))
                .isPresentAndSameAs(anyDate);

        verify(mockResultSet, only()).getDate(eq(anyColumnName), same(theCalendar));
    }

    @Test
    public void emptyOptionalDoubleReturnedByIndex() throws SQLException {
        when(mockResultSet.getDouble(anyInt())).thenReturn(0.0);
        when(mockResultSet.wasNull()).thenReturn(IS_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalDouble(anyColumnIndex)).isEmpty();

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getDouble(eq(anyColumnIndex));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void emptyOptionalDoubleReturnedByName() throws SQLException {
        when(mockResultSet.getDouble(anyString())).thenReturn(0.0);
        when(mockResultSet.wasNull()).thenReturn(IS_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalDouble(anyColumnName)).isEmpty();

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getDouble(eq(anyColumnName));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void presentOptionalDoubleReturnedByIndex() throws SQLException {
        final double anyDouble = RANDOM.nextDouble();
        when(mockResultSet.getDouble(anyInt())).thenReturn(anyDouble);
        when(mockResultSet.wasNull()).thenReturn(IS_NOT_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalDouble(anyColumnIndex)).isPresentAndEqualTo(anyDouble);

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getDouble(eq(anyColumnIndex));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void presentOptionalDoubleReturnedByName() throws SQLException {
        final double anyDouble = RANDOM.nextDouble();
        when(mockResultSet.getDouble(anyString())).thenReturn(anyDouble);
        when(mockResultSet.wasNull()).thenReturn(IS_NOT_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalDouble(anyColumnName)).isPresentAndEqualTo(anyDouble);

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getDouble(eq(anyColumnName));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void emptyOptionalFloatReturnedByIndex() throws SQLException {
        when(mockResultSet.getFloat(anyInt())).thenReturn(0.0f);
        when(mockResultSet.wasNull()).thenReturn(IS_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalFloat(anyColumnIndex)).isEmpty();

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getFloat(eq(anyColumnIndex));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void emptyOptionalFloatReturnedByName() throws SQLException {
        when(mockResultSet.getFloat(anyString())).thenReturn(0.0f);
        when(mockResultSet.wasNull()).thenReturn(IS_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalFloat(anyColumnName)).isEmpty();

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getFloat(eq(anyColumnName));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void presentOptionalFloatReturnedByIndex() throws SQLException {
        final float anyFloat = RANDOM.nextFloat();
        when(mockResultSet.getFloat(anyInt())).thenReturn(anyFloat);
        when(mockResultSet.wasNull()).thenReturn(IS_NOT_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalFloat(anyColumnIndex)).isPresentAndEqualTo(anyFloat);

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getFloat(eq(anyColumnIndex));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void presentOptionalFloatReturnedByName() throws SQLException {
        final float anyFloat = RANDOM.nextFloat();
        when(mockResultSet.getFloat(anyString())).thenReturn(anyFloat);
        when(mockResultSet.wasNull()).thenReturn(IS_NOT_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalFloat(anyColumnName)).isPresentAndEqualTo(anyFloat);

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getFloat(eq(anyColumnName));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void emptyOptionalInstantReturnedByIndex() throws SQLException {
        when(mockResultSet.getTimestamp(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalInstant(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalInstantReturnedByName() throws SQLException {
        when(mockResultSet.getTimestamp(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalInstant(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnName));
    }

    @Test
    public void presentOptionalInstantReturnedByIndex() throws SQLException {
        final Instant now = Instant.now();
        final Timestamp anyTimestamp = Timestamp.from(now);
        when(mockResultSet.getTimestamp(anyInt())).thenReturn(anyTimestamp);

        OptionalAssertions.assertThat(resultSetEx.getOptionalInstant(anyColumnIndex)).isPresentAndEqualTo(now);

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalInstantReturnedByName() throws SQLException {
        final Instant now = Instant.now();
        final Timestamp anyTimestamp = Timestamp.from(now);
        when(mockResultSet.getTimestamp(anyString())).thenReturn(anyTimestamp);

        OptionalAssertions.assertThat(resultSetEx.getOptionalInstant(anyColumnName)).isPresentAndEqualTo(now);

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalInstantReturnedByIndexAndCal() throws SQLException {
        when(mockResultSet.getTimestamp(anyInt(), any(Calendar.class))).thenReturn(null);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalInstant(anyColumnIndex, theCalendar)).isEmpty();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnIndex), same(theCalendar));
    }

    @Test
    public void emptyOptionalInstantReturnedByNameAndCal() throws SQLException {
        when(mockResultSet.getTimestamp(anyString(), any(Calendar.class))).thenReturn(null);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalInstant(anyColumnName, theCalendar)).isEmpty();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnName), same(theCalendar));
    }

    @Test
    public void presentOptionalInstantReturnedByIndexAndCal() throws SQLException {
        final Instant now = Instant.now();
        final Timestamp anyTimestamp = Timestamp.from(now);
        when(mockResultSet.getTimestamp(anyInt(), any(Calendar.class))).thenReturn(anyTimestamp);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalInstant(anyColumnIndex, theCalendar)).isPresentAndEqualTo(now);

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnIndex), same(theCalendar));
    }

    @Test
    public void presentOptionalInstantReturnedByNameAndCal() throws SQLException {
        final Instant now = Instant.now();
        final Timestamp anyTimestamp = Timestamp.from(now);
        when(mockResultSet.getTimestamp(anyString(), any(Calendar.class))).thenReturn(anyTimestamp);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalInstant(anyColumnName, theCalendar)).isPresentAndEqualTo(now);

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnName), same(theCalendar));
    }

    @Test
    public void emptyOptionalIntReturnedByIndex() throws SQLException {
        when(mockResultSet.getInt(anyInt())).thenReturn(0);
        when(mockResultSet.wasNull()).thenReturn(IS_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalInt(anyColumnIndex)).isEmpty();

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getInt(eq(anyColumnIndex));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void emptyOptionalIntReturnedByName() throws SQLException {
        when(mockResultSet.getInt(anyString())).thenReturn(0);
        when(mockResultSet.wasNull()).thenReturn(IS_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalInt(anyColumnName)).isEmpty();

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getInt(eq(anyColumnName));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void presentOptionalIntReturnedByIndex() throws SQLException {
        final int anyInt = RANDOM.nextInt();
        when(mockResultSet.getInt(anyInt())).thenReturn(anyInt);
        when(mockResultSet.wasNull()).thenReturn(IS_NOT_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalInt(anyColumnIndex)).isPresentAndEqualTo(anyInt);

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getInt(eq(anyColumnIndex));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void presentOptionalIntReturnedByName() throws SQLException {
        final int anyInt = RANDOM.nextInt();
        when(mockResultSet.getInt(anyString())).thenReturn(anyInt);
        when(mockResultSet.wasNull()).thenReturn(IS_NOT_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalInt(anyColumnName)).isPresentAndEqualTo(anyInt);

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getInt(eq(anyColumnName));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void emptyOptionalLocalDateReturnedByIndex() throws SQLException {
        when(mockResultSet.getDate(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalDate(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getDate(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalLocalDateReturnedByName() throws SQLException {
        when(mockResultSet.getDate(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalDate(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getDate(eq(anyColumnName));
    }

    @Test
    public void presentOptionalLocalDateReturnedByIndex() throws SQLException {
        final LocalDate now = LocalDate.now();
        final Date anyDate = Date.valueOf(now);
        when(mockResultSet.getDate(anyInt())).thenReturn(anyDate);

        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalDate(anyColumnIndex)).isPresentAndEqualTo(now);

        verify(mockResultSet, only()).getDate(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalLocalDateReturnedByName() throws SQLException {
        final LocalDate now = LocalDate.now();
        final Date anyDate = Date.valueOf(now);
        when(mockResultSet.getDate(anyString())).thenReturn(anyDate);

        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalDate(anyColumnName)).isPresentAndEqualTo(now);

        verify(mockResultSet, only()).getDate(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalLocalDateReturnedByIndexAndCal() throws SQLException {
        when(mockResultSet.getDate(anyInt(), any(Calendar.class))).thenReturn(null);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalDate(anyColumnIndex, theCalendar)).isEmpty();

        verify(mockResultSet, only()).getDate(eq(anyColumnIndex), same(theCalendar));
    }

    @Test
    public void emptyOptionalLocalDateReturnedByNameAndCal() throws SQLException {
        when(mockResultSet.getDate(anyString(), any(Calendar.class))).thenReturn(null);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalDate(anyColumnName, theCalendar)).isEmpty();

        verify(mockResultSet, only()).getDate(eq(anyColumnName), same(theCalendar));
    }

    @Test
    public void presentOptionalLocalDateReturnedByIndexAndCal() throws SQLException {
        final LocalDate now = LocalDate.now();
        final Date anyDate = Date.valueOf(now);
        when(mockResultSet.getDate(anyInt(), any(Calendar.class))).thenReturn(anyDate);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalDate(anyColumnIndex, theCalendar))
                .isPresentAndEqualTo(now);

        verify(mockResultSet, only()).getDate(eq(anyColumnIndex), same(theCalendar));
    }

    @Test
    public void presentOptionalLocalDateReturnedByNameAndCal() throws SQLException {
        final LocalDate now = LocalDate.now();
        final Date anyDate = Date.valueOf(now);
        when(mockResultSet.getDate(anyString(), any(Calendar.class))).thenReturn(anyDate);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalDate(anyColumnName, theCalendar))
                .isPresentAndEqualTo(now);

        verify(mockResultSet, only()).getDate(eq(anyColumnName), same(theCalendar));
    }

    @Test
    public void emptyOptionalLocalDateTimeReturnedByIndex() throws SQLException {
        when(mockResultSet.getTimestamp(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalDateTime(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalLocalDateTimeReturnedByName() throws SQLException {
        when(mockResultSet.getTimestamp(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalDateTime(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnName));
    }

    @Test
    public void presentOptionalLocalDateTimeReturnedByIndex() throws SQLException {
        final LocalDateTime now = LocalDateTime.now();
        final Timestamp anyTimestamp = Timestamp.valueOf(now);
        when(mockResultSet.getTimestamp(anyInt())).thenReturn(anyTimestamp);

        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalDateTime(anyColumnIndex)).isPresentAndEqualTo(now);

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalLocalDateTimeReturnedByName() throws SQLException {
        final LocalDateTime now = LocalDateTime.now();
        final Timestamp anyTimestamp = Timestamp.valueOf(now);
        when(mockResultSet.getTimestamp(anyString())).thenReturn(anyTimestamp);

        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalDateTime(anyColumnName)).isPresentAndEqualTo(now);

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalLocalDateTimeReturnedByIndexAndCal() throws SQLException {
        when(mockResultSet.getTimestamp(anyInt(), any(Calendar.class))).thenReturn(null);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalDateTime(anyColumnIndex, theCalendar)).isEmpty();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnIndex), same(theCalendar));
    }

    @Test
    public void emptyOptionalLocalDateTimeReturnedByNameAndCal() throws SQLException {
        when(mockResultSet.getTimestamp(anyString(), any(Calendar.class))).thenReturn(null);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalDateTime(anyColumnName, theCalendar)).isEmpty();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnName), same(theCalendar));
    }

    @Test
    public void presentOptionalLocalDateTimeReturnedByIndexAndCal() throws SQLException {
        final LocalDateTime now = LocalDateTime.now();
        final Timestamp anyTimestamp = Timestamp.valueOf(now);
        when(mockResultSet.getTimestamp(anyInt(), any(Calendar.class))).thenReturn(anyTimestamp);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalDateTime(anyColumnIndex, theCalendar)).isPresentAndEqualTo(now);

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnIndex), same(theCalendar));
    }

    @Test
    public void presentOptionalLocalDateTimeReturnedByNameAndCal() throws SQLException {
        final LocalDateTime now = LocalDateTime.now();
        final Timestamp anyTimestamp = Timestamp.valueOf(now);
        when(mockResultSet.getTimestamp(anyString(), any(Calendar.class))).thenReturn(anyTimestamp);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalDateTime(anyColumnName, theCalendar)).isPresentAndEqualTo(now);

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnName), same(theCalendar));
    }

    @Test
    public void emptyOptionalLocalTimeReturnedByIndex() throws SQLException {
        when(mockResultSet.getTime(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalTime(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getTime(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalLocalTimeReturnedByName() throws SQLException {
        when(mockResultSet.getTime(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalTime(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getTime(eq(anyColumnName));
    }

    @Test
    public void presentOptionalLocalTimeReturnedByIndex() throws SQLException {
        final LocalTime now = LocalTime.now().withNano(0);
        final Time anyTime = Time.valueOf(now);
        when(mockResultSet.getTime(anyInt())).thenReturn(anyTime);

        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalTime(anyColumnIndex)).isPresentAndEqualTo(now);

        verify(mockResultSet, only()).getTime(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalLocalTimeReturnedByName() throws SQLException {
        final LocalTime now = LocalTime.now().withNano(0);
        final Time anyTime = Time.valueOf(now);
        when(mockResultSet.getTime(anyString())).thenReturn(anyTime);

        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalTime(anyColumnName)).isPresentAndEqualTo(now);

        verify(mockResultSet, only()).getTime(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalLocalTimeReturnedByIndexAndCal() throws SQLException {
        when(mockResultSet.getTime(anyInt(), any(Calendar.class))).thenReturn(null);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalTime(anyColumnIndex, theCalendar)).isEmpty();

        verify(mockResultSet, only()).getTime(eq(anyColumnIndex), same(theCalendar));
    }

    @Test
    public void emptyOptionalLocalTimeReturnedByNameAndCal() throws SQLException {
        when(mockResultSet.getTime(anyString(), any(Calendar.class))).thenReturn(null);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalTime(anyColumnName, theCalendar)).isEmpty();

        verify(mockResultSet, only()).getTime(eq(anyColumnName), same(theCalendar));
    }

    @Test
    public void presentOptionalLocalTimeReturnedByIndexAndCal() throws SQLException {
        final LocalTime now = LocalTime.now().withNano(0);
        final Time anyTime = Time.valueOf(now);
        when(mockResultSet.getTime(anyInt(), any(Calendar.class))).thenReturn(anyTime);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalTime(anyColumnIndex, theCalendar))
                .isPresentAndEqualTo(now);

        verify(mockResultSet, only()).getTime(eq(anyColumnIndex), same(theCalendar));
    }

    @Test
    public void presentOptionalLocalTimeReturnedByNameAndCal() throws SQLException {
        final LocalTime now = LocalTime.now().withNano(0);
        final Time anyTime = Time.valueOf(now);
        when(mockResultSet.getTime(anyString(), any(Calendar.class))).thenReturn(anyTime);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalLocalTime(anyColumnName, theCalendar))
                .isPresentAndEqualTo(now);

        verify(mockResultSet, only()).getTime(eq(anyColumnName), same(theCalendar));
    }

    @Test
    public void emptyOptionalLongReturnedByIndex() throws SQLException {
        when(mockResultSet.getLong(anyInt())).thenReturn(0L);
        when(mockResultSet.wasNull()).thenReturn(IS_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalLong(anyColumnIndex)).isEmpty();

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getLong(eq(anyColumnIndex));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void emptyOptionalLongReturnedByName() throws SQLException {
        when(mockResultSet.getLong(anyString())).thenReturn(0L);
        when(mockResultSet.wasNull()).thenReturn(IS_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalLong(anyColumnName)).isEmpty();

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getLong(eq(anyColumnName));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void presentOptionalLongReturnedByIndex() throws SQLException {
        final long anyLong = RANDOM.nextLong();
        when(mockResultSet.getLong(anyInt())).thenReturn(anyLong);
        when(mockResultSet.wasNull()).thenReturn(IS_NOT_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalLong(anyColumnIndex)).isPresentAndEqualTo(anyLong);

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getLong(eq(anyColumnIndex));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void presentOptionalLongReturnedByName() throws SQLException {
        final long anyLong = RANDOM.nextLong();
        when(mockResultSet.getLong(anyString())).thenReturn(anyLong);
        when(mockResultSet.wasNull()).thenReturn(IS_NOT_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalLong(anyColumnName)).isPresentAndEqualTo(anyLong);

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getLong(eq(anyColumnName));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void emptyOptionalNClobReturnedByIndex() throws SQLException {
        when(mockResultSet.getNClob(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalNClob(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getNClob(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalNClobReturnedByName() throws SQLException {
        when(mockResultSet.getNClob(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalNClob(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getNClob(eq(anyColumnName));
    }

    @Test
    public void presentOptionalNClobReturnedByIndex() throws SQLException {
        final NClob anyNClob = mock(NClob.class);
        when(mockResultSet.getNClob(anyInt())).thenReturn(anyNClob);

        OptionalAssertions.assertThat(resultSetEx.getOptionalNClob(anyColumnIndex)).isPresentAndSameAs(anyNClob);

        verify(mockResultSet, only()).getNClob(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalNClobReturnedByName() throws SQLException {
        final NClob anyNClob = mock(NClob.class);
        when(mockResultSet.getNClob(anyString())).thenReturn(anyNClob);

        OptionalAssertions.assertThat(resultSetEx.getOptionalNClob(anyColumnName)).isPresentAndSameAs(anyNClob);

        verify(mockResultSet, only()).getNClob(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalNStringReturnedByIndex() throws SQLException {
        when(mockResultSet.getNString(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalNString(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getNString(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalNStringReturnedByName() throws SQLException {
        when(mockResultSet.getNString(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalNString(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getNString(eq(anyColumnName));
    }

    @Test
    public void presentOptionalNStringReturnedByIndex() throws SQLException {
        final String anyString = Long.toBinaryString(RANDOM.nextLong());
        when(mockResultSet.getNString(anyInt())).thenReturn(anyString);

        OptionalAssertions.assertThat(resultSetEx.getOptionalNString(anyColumnIndex)).isPresentAndEqualTo(anyString);

        verify(mockResultSet, only()).getNString(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalNStringReturnedByName() throws SQLException {
        final String anyString = Long.toBinaryString(RANDOM.nextLong());
        when(mockResultSet.getNString(anyString())).thenReturn(anyString);

        OptionalAssertions.assertThat(resultSetEx.getOptionalNString(anyColumnName)).isPresentAndEqualTo(anyString);

        verify(mockResultSet, only()).getNString(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalObjectReturnedByIndex() throws SQLException {
        when(mockResultSet.getObject(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalObject(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalObjectReturnedByName() throws SQLException {
        when(mockResultSet.getObject(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalObject(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnName));
    }

    @Test
    public void presentOptionalObjectReturnedByIndex() throws SQLException {
        final Object anyObject = new Object();
        when(mockResultSet.getObject(anyInt())).thenReturn(anyObject);

        OptionalAssertions.assertThat(resultSetEx.getOptionalObject(anyColumnIndex)).isPresentAndEqualTo(anyObject);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalObjectReturnedByName() throws SQLException {
        final Object anyObject = new Object();
        when(mockResultSet.getObject(anyString())).thenReturn(anyObject);

        OptionalAssertions.assertThat(resultSetEx.getOptionalObject(anyColumnName)).isPresentAndEqualTo(anyObject);

        verify(mockResultSet, only()).getObject(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalObjectReturnedByIndexAndMap() throws SQLException {
        when(mockResultSet.getObject(anyInt(), anyTypeNameToTypeMap())).thenReturn(null);

        final Map<String, Class<?>> anyMap = new HashMap<>();
        OptionalAssertions.assertThat(resultSetEx.getOptionalObject(anyColumnIndex, anyMap)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex), same(anyMap));
    }

    @Test
    public void emptyOptionalObjectReturnedByNameAndMap() throws SQLException {
        when(mockResultSet.getObject(anyString(), anyTypeNameToTypeMap())).thenReturn(null);

        final Map<String, Class<?>> anyMap = new HashMap<>();
        OptionalAssertions.assertThat(resultSetEx.getOptionalObject(anyColumnName, anyMap)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnName), same(anyMap));
    }

    @Test
    public void presentOptionalObjectReturnedByIndexAndMap() throws SQLException {
        final Object anyObject = new Object();
        when(mockResultSet.getObject(anyInt(), anyTypeNameToTypeMap())).thenReturn(anyObject);

        final Map<String, Class<?>> anyMap = new HashMap<>();
        OptionalAssertions.assertThat(resultSetEx.getOptionalObject(anyColumnIndex, anyMap))
                .isPresentAndEqualTo(anyObject);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex), same(anyMap));
    }

    @Test
    public void presentOptionalObjectReturnedByNameAndMap() throws SQLException {
        final Object anyObject = new Object();
        when(mockResultSet.getObject(anyString(), anyTypeNameToTypeMap())).thenReturn(anyObject);

        final Map<String, Class<?>> anyMap = new HashMap<>();
        OptionalAssertions.assertThat(resultSetEx.getOptionalObject(anyColumnName, anyMap))
                .isPresentAndEqualTo(anyObject);

        verify(mockResultSet, only()).getObject(eq(anyColumnName), same(anyMap));
    }

    @Test
    public void emptyOptionalObjectReturnedByIndexAndClass() throws SQLException {
        when(mockResultSet.getObject(anyInt(), anyObjectClass())).thenReturn(null);

        final Map<String, Class<?>> anyMap = new HashMap<>();
        OptionalAssertions.assertThat(resultSetEx.getOptionalObject(anyColumnIndex, anyMap)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex), same(anyMap));
    }

    @Test
    public void emptyOptionalObjectReturnedByNameAndClass() throws SQLException {
        when(mockResultSet.getObject(anyString(), anyObjectClass())).thenReturn(null);

        final Class<?> anyClass = String.class;
        OptionalAssertions.assertThat(resultSetEx.getOptionalObject(anyColumnName, anyClass)).isEmpty();

        verify(mockResultSet, only()).getObject(eq(anyColumnName), same(anyClass));
    }

    @Test
    public void presentOptionalObjectReturnedByIndexAndClass() throws SQLException {
        final Object anyObject = new Object();
        when(mockResultSet.getObject(anyInt(), anyObjectClass())).thenReturn(anyObject);

        final Class<?> anyClass = String.class;
        OptionalAssertions.assertThat(resultSetEx.getOptionalObject(anyColumnIndex, anyClass))
                .isPresentAndEqualTo(anyObject);

        verify(mockResultSet, only()).getObject(eq(anyColumnIndex), same(anyClass));
    }

    @Test
    public void presentOptionalObjectReturnedByNameAndClass() throws SQLException {
        final Object anyObject = new Object();
        when(mockResultSet.getObject(anyString(), anyObjectClass())).thenReturn(anyObject);

        final Class<?> anyClass = String.class;
        OptionalAssertions.assertThat(resultSetEx.getOptionalObject(anyColumnName, anyClass))
                .isPresentAndEqualTo(anyObject);

        verify(mockResultSet, only()).getObject(eq(anyColumnName), same(anyClass));
    }

    @Test
    public void emptyOptionalRefReturnedByIndex() throws SQLException {
        when(mockResultSet.getRef(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalRef(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getRef(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalRefReturnedByName() throws SQLException {
        when(mockResultSet.getRef(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalRef(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getRef(eq(anyColumnName));
    }

    @Test
    public void presentOptionalRefReturnedByIndex() throws SQLException {
        final Ref anyRef = mock(Ref.class);
        when(mockResultSet.getRef(anyInt())).thenReturn(anyRef);

        OptionalAssertions.assertThat(resultSetEx.getOptionalRef(anyColumnIndex)).isPresentAndSameAs(anyRef);

        verify(mockResultSet, only()).getRef(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalRefReturnedByName() throws SQLException {
        final Ref anyRef = mock(Ref.class);
        when(mockResultSet.getRef(anyString())).thenReturn(anyRef);

        OptionalAssertions.assertThat(resultSetEx.getOptionalRef(anyColumnName)).isPresentAndSameAs(anyRef);

        verify(mockResultSet, only()).getRef(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalRowIdReturnedByIndex() throws SQLException {
        when(mockResultSet.getRowId(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalRowId(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getRowId(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalRowIdReturnedByName() throws SQLException {
        when(mockResultSet.getRowId(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalRowId(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getRowId(eq(anyColumnName));
    }

    @Test
    public void presentOptionalRowIdReturnedByIndex() throws SQLException {
        final RowId anyRowId = mock(RowId.class);
        when(mockResultSet.getRowId(anyInt())).thenReturn(anyRowId);

        OptionalAssertions.assertThat(resultSetEx.getOptionalRowId(anyColumnIndex)).isPresentAndSameAs(anyRowId);

        verify(mockResultSet, only()).getRowId(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalRowIdReturnedByName() throws SQLException {
        final RowId anyRowId = mock(RowId.class);
        when(mockResultSet.getRowId(anyString())).thenReturn(anyRowId);

        OptionalAssertions.assertThat(resultSetEx.getOptionalRowId(anyColumnName)).isPresentAndSameAs(anyRowId);

        verify(mockResultSet, only()).getRowId(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalShortReturnedByIndex() throws SQLException {
        when(mockResultSet.getShort(anyInt())).thenReturn((short)0);
        when(mockResultSet.wasNull()).thenReturn(IS_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalShort(anyColumnIndex)).isEmpty();

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getShort(eq(anyColumnIndex));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void emptyOptionalShortReturnedByName() throws SQLException {
        when(mockResultSet.getShort(anyString())).thenReturn((short)0);
        when(mockResultSet.wasNull()).thenReturn(IS_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalShort(anyColumnName)).isEmpty();

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getShort(eq(anyColumnName));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void presentOptionalShortReturnedByIndex() throws SQLException {
        final short anyShort = (short)RANDOM.nextInt(Short.MAX_VALUE);
        when(mockResultSet.getShort(anyInt())).thenReturn(anyShort);
        when(mockResultSet.wasNull()).thenReturn(IS_NOT_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalShort(anyColumnIndex)).isPresentAndEqualTo(anyShort);

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getShort(eq(anyColumnIndex));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void presentOptionalShortReturnedByName() throws SQLException {
        final short anyShort = (short)RANDOM.nextInt(Short.MAX_VALUE);
        when(mockResultSet.getShort(anyString())).thenReturn(anyShort);
        when(mockResultSet.wasNull()).thenReturn(IS_NOT_NULL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalShort(anyColumnName)).isPresentAndEqualTo(anyShort);

        final InOrder inOrder = inOrder(mockResultSet);
        inOrder.verify(mockResultSet, times(1)).getShort(eq(anyColumnName));
        inOrder.verify(mockResultSet, times(1)).wasNull();
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void emptyOptionalSQLXMLReturnedByIndex() throws SQLException {
        when(mockResultSet.getSQLXML(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalSQLXML(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getSQLXML(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalSQLXMLReturnedByName() throws SQLException {
        when(mockResultSet.getSQLXML(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalSQLXML(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getSQLXML(eq(anyColumnName));
    }

    @Test
    public void presentOptionalSQLXMLReturnedByIndex() throws SQLException {
        final SQLXML anySQLXML = mock(SQLXML.class);
        when(mockResultSet.getSQLXML(anyInt())).thenReturn(anySQLXML);

        OptionalAssertions.assertThat(resultSetEx.getOptionalSQLXML(anyColumnIndex)).isPresentAndSameAs(anySQLXML);

        verify(mockResultSet, only()).getSQLXML(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalSQLXMLReturnedByName() throws SQLException {
        final SQLXML anySQLXML = mock(SQLXML.class);
        when(mockResultSet.getSQLXML(anyString())).thenReturn(anySQLXML);

        OptionalAssertions.assertThat(resultSetEx.getOptionalSQLXML(anyColumnName)).isPresentAndSameAs(anySQLXML);

        verify(mockResultSet, only()).getSQLXML(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalStringReturnedByIndex() throws SQLException {
        when(mockResultSet.getString(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalString(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getString(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalStringReturnedByName() throws SQLException {
        when(mockResultSet.getString(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalString(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getString(eq(anyColumnName));
    }

    @Test
    public void presentOptionalStringReturnedByIndex() throws SQLException {
        final String anyString = Long.toBinaryString(RANDOM.nextLong());
        when(mockResultSet.getString(anyInt())).thenReturn(anyString);

        OptionalAssertions.assertThat(resultSetEx.getOptionalString(anyColumnIndex)).isPresentAndEqualTo(anyString);

        verify(mockResultSet, only()).getString(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalStringReturnedByName() throws SQLException {
        final String anyString = Long.toBinaryString(RANDOM.nextLong());
        when(mockResultSet.getString(anyString())).thenReturn(anyString);

        OptionalAssertions.assertThat(resultSetEx.getOptionalString(anyColumnName)).isPresentAndEqualTo(anyString);

        verify(mockResultSet, only()).getString(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalTimeReturnedByIndex() throws SQLException {
        when(mockResultSet.getTime(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalTime(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getTime(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalTimeReturnedByName() throws SQLException {
        when(mockResultSet.getTime(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalTime(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getTime(eq(anyColumnName));
    }

    @Test
    public void presentOptionalTimeReturnedByIndex() throws SQLException {
        final Time anyTime = Time.valueOf(LocalTime.now());
        when(mockResultSet.getTime(anyInt())).thenReturn(anyTime);

        OptionalAssertions.assertThat(resultSetEx.getOptionalTime(anyColumnIndex)).isPresentAndEqualTo(anyTime);

        verify(mockResultSet, only()).getTime(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalTimeReturnedByName() throws SQLException {
        final Time anyTime = Time.valueOf(LocalTime.now());
        when(mockResultSet.getTime(anyString())).thenReturn(anyTime);

        OptionalAssertions.assertThat(resultSetEx.getOptionalTime(anyColumnName)).isPresentAndSameAs(anyTime);

        verify(mockResultSet, only()).getTime(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalTimeReturnedByIndexAndCal() throws SQLException {
        when(mockResultSet.getTime(anyInt(), any(Calendar.class))).thenReturn(null);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalTime(anyColumnIndex, theCalendar)).isEmpty();

        verify(mockResultSet, only()).getTime(eq(anyColumnIndex), same(theCalendar));
    }

    @Test
    public void emptyOptionalTimeReturnedByNameAndCal() throws SQLException {
        when(mockResultSet.getTime(anyString(), any(Calendar.class))).thenReturn(null);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalTime(anyColumnName, theCalendar)).isEmpty();

        verify(mockResultSet, only()).getTime(eq(anyColumnName), same(theCalendar));
    }

    @Test
    public void presentOptionalTimeReturnedByIndexAndCal() throws SQLException {
        final Time anyTime = Time.valueOf(LocalTime.now());
        when(mockResultSet.getTime(anyInt(), any(Calendar.class))).thenReturn(anyTime);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalTime(anyColumnIndex, theCalendar))
                .isPresentAndEqualTo(anyTime);

        verify(mockResultSet, only()).getTime(eq(anyColumnIndex), same(theCalendar));
    }

    @Test
    public void presentOptionalTimeReturnedByNameAndCal() throws SQLException {
        final Time anyTime = Time.valueOf(LocalTime.now());
        when(mockResultSet.getTime(anyString(), any(Calendar.class))).thenReturn(anyTime);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalTime(anyColumnName, theCalendar))
                .isPresentAndSameAs(anyTime);

        verify(mockResultSet, only()).getTime(eq(anyColumnName), same(theCalendar));
    }

    @Test
    public void emptyOptionalTimestampReturnedByIndex() throws SQLException {
        when(mockResultSet.getTimestamp(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalTimestamp(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalTimestampReturnedByName() throws SQLException {
        when(mockResultSet.getTimestamp(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalTimestamp(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnName));
    }

    @Test
    public void presentOptionalTimestampReturnedByIndex() throws SQLException {
        final Timestamp anyTimestamp = Timestamp.from(Instant.now());
        when(mockResultSet.getTimestamp(anyInt())).thenReturn(anyTimestamp);

        OptionalAssertions.assertThat(resultSetEx.getOptionalTimestamp(anyColumnIndex))
                .isPresentAndEqualTo(anyTimestamp);

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalTimestampReturnedByName() throws SQLException {
        final Timestamp anyTimestamp = Timestamp.from(Instant.now());
        when(mockResultSet.getTimestamp(anyString())).thenReturn(anyTimestamp);

        OptionalAssertions.assertThat(resultSetEx.getOptionalTimestamp(anyColumnName))
                .isPresentAndSameAs(anyTimestamp);

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnName));
    }

    @Test
    public void emptyOptionalTimestampReturnedByIndexAndCal() throws SQLException {
        when(mockResultSet.getTimestamp(anyInt(), any(Calendar.class))).thenReturn(null);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalTimestamp(anyColumnIndex, theCalendar)).isEmpty();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnIndex), same(theCalendar));
    }

    @Test
    public void emptyOptionalTimestampReturnedByNameAndCal() throws SQLException {
        when(mockResultSet.getTimestamp(anyString(), any(Calendar.class))).thenReturn(null);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalTimestamp(anyColumnName, theCalendar)).isEmpty();

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnName), same(theCalendar));
    }

    @Test
    public void presentOptionalTimestampReturnedByIndexAndCal() throws SQLException {
        final Timestamp anyTimestamp = Timestamp.from(Instant.now());
        when(mockResultSet.getTimestamp(anyInt(), any(Calendar.class))).thenReturn(anyTimestamp);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalTimestamp(anyColumnIndex, theCalendar))
                .isPresentAndEqualTo(anyTimestamp);

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnIndex), same(theCalendar));
    }

    @Test
    public void presentOptionalTimestampReturnedByNameAndCal() throws SQLException {
        final Timestamp anyTimestamp = Timestamp.from(Instant.now());
        when(mockResultSet.getTimestamp(anyString(), any(Calendar.class))).thenReturn(anyTimestamp);

        final Calendar theCalendar = Calendar.getInstance();
        OptionalAssertions.assertThat(resultSetEx.getOptionalTimestamp(anyColumnName, theCalendar))
                .isPresentAndSameAs(anyTimestamp);

        verify(mockResultSet, only()).getTimestamp(eq(anyColumnName), same(theCalendar));
    }

    @Test
    public void emptyOptionalURLReturnedByIndex() throws SQLException {
        when(mockResultSet.getURL(anyInt())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalURL(anyColumnIndex)).isEmpty();

        verify(mockResultSet, only()).getURL(eq(anyColumnIndex));
    }

    @Test
    public void emptyOptionalURLReturnedByName() throws SQLException {
        when(mockResultSet.getURL(anyString())).thenReturn(null);

        OptionalAssertions.assertThat(resultSetEx.getOptionalURL(anyColumnName)).isEmpty();

        verify(mockResultSet, only()).getURL(eq(anyColumnName));
    }

    @Test
    public void presentOptionalURLReturnedByIndex() throws SQLException, MalformedURLException {
        final URL anyURL = new URL("http://datasources.justrudd.io/");
        when(mockResultSet.getURL(anyInt())).thenReturn(anyURL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalURL(anyColumnIndex)).isPresentAndEqualTo(anyURL);

        verify(mockResultSet, only()).getURL(eq(anyColumnIndex));
    }

    @Test
    public void presentOptionalURLReturnedByName() throws SQLException, MalformedURLException {
        final URL anyURL = new URL("http://datasources.justrudd.io/");
        when(mockResultSet.getURL(anyString())).thenReturn(anyURL);

        OptionalAssertions.assertThat(resultSetEx.getOptionalURL(anyColumnName)).isPresentAndEqualTo(anyURL);

        verify(mockResultSet, only()).getURL(eq(anyColumnName));
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Class<?>> anyTypeNameToTypeMap() {
        return anyMap();
    }

    @SuppressWarnings("unchecked")
    private static Class<Object> anyObjectClass() {
        return any(Class.class);
    }

    private static final boolean IS_NOT_NULL = false;
    private static final boolean IS_NULL = true;
    private static final Random RANDOM = new Random();

    private int anyColumnIndex;
    private String anyColumnName;
    private ResultSet mockResultSet;
    private ResultSetExImpl resultSetEx;
}
