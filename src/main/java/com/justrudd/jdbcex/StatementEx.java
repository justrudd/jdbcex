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

import java.sql.SQLException;
import java.sql.Statement;

public interface StatementEx extends Statement {

    /**
     * Executes the given SQL statement, which returns a single
     * {@code ResultSetEx} object.
     * <p>
     * <strong>Note:</strong>This method cannot be called on a {@code PreparedStatement[Ex]}
     * or {@code CallableStatement}.
     * </p>
     * @param sql
     *          a SQL statement to be sent to the database, typically a
     *          static SQL {@code SELECT} statement
     * @return a {@code ResultSetEx} object that contains the data produced
     *         by the given query; never {@code null}.
     * @exception  java.sql.SQLException
     *              if a database access error occurs
     *              if this method is called on a closed {@code StatementEx},
     *              if the given  SQL statement produces anything other than a single {@code ResultSetEx} object,
     *              if the method is called on a {@code PreparedStatement[Ex]} or a {@code CallableStatement}
     * @exception  java.sql.SQLTimeoutException
     *              when the driver has determined that the timeout value that was specified by the
     *              {@code setQueryTimeout} method has been exceeded and has at least attempted to cancel
     *              the currently running {@code StatementEx}
     * @see ResultSetEx
     */
    default ResultSetEx executeQueryEx(final String sql) throws SQLException {
        return JdbcEx.wrap(executeQuery(sql));
    }

    /**
     * Retrieves the current result as a {@code ResultSetEx} object.
     * This method should be called only once per result.
     *
     * @return the current result as a {@code ResultSetEx} object or {@code null} if the
     *         result is an update count or there are no more results
     * @exception SQLException
     *          if a database access error occurs
     *          if this method is called on a closed {@code StatementEx}
     * @see #execute
     * @see ResultSetEx
     */
    default ResultSetEx getResultSetEx() throws SQLException {
        return JdbcEx.wrap(getResultSet());
    }

    /**
     * Retrieves any auto-generated keys created as a result of executing this
     * {@code StatementEx} object. If this {@code StatementEx} object did
     * not generate any keys, an empty {@code ResultSetEx} object is returned.
     *
     * <p>
     * <strong>Note:</strong> If the columns which represent the auto-generated keys
     * were not specified, the JDBC driver implementation will determine the columns
     * which best represent the auto-generated keys.
     * </p>
     * @return a {@code ResultSetEx} object containing the auto-generated key(s)
     *         generated by the execution of this {@code StatementEx} object
     * @exception SQLException
     *              if a database access error occurs
     *              if this method is called on a closed {@code StatementEx}
     * @exception  java.sql.SQLFeatureNotSupportedException
     *              if the JDBC driver does not support this method
     * @see ResultSetEx
     */
    default ResultSetEx getGeneratedKeysEx() throws SQLException {
        return JdbcEx.wrap(getGeneratedKeys());
    }

}
