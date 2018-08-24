/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.jdbc.support.rowset;

import org.springframework.jdbc.InvalidResultSetAccessException;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The default implementation of Spring's {@link SqlRowSet} interface, wrapping a
 * {@link ResultSet}, catching any {@link SQLException}s and translating
 * them to a corresponding Spring {@link InvalidResultSetAccessException}.
 *
 * <p>The passed-in ResultSet should already be disconnected if the SqlRowSet is supposed
 * to be usable in a disconnected fashion. This means that you will usually pass in a
 * {@code javax.sql.rowset.CachedRowSet}, which implements the ResultSet interface.
 *
 * <p>Note: Since JDBC 4.0, it has been clarified that any methods using a String to identify
 * the column should be using the column label. The column label is assigned using the ALIAS
 * keyword in the SQL query string. When the query doesn't use an ALIAS, the default label is
 * the column name. Most JDBC ResultSet implementations follow this new pattern but there are
 * exceptions such as the {@code com.sun.rowset.CachedRowSetImpl} class which only uses
 * the column name, ignoring any column labels. As of Spring 3.0.5, ResultSetWrappingSqlRowSet
 * will translate column labels to the correct column index to provide better support for the
 * {@code com.sun.rowset.CachedRowSetImpl} which is the default implementation used by
 * {@link org.springframework.jdbc.core.JdbcTemplate} when working with RowSets.
 *
 * <p>Note: This class implements the {@code java.io.Serializable} marker interface
 * through the SqlRowSet interface, but is only actually serializable if the disconnected
 * ResultSet/RowSet contained in it is serializable. Most CachedRowSet implementations
 * are actually serializable, so this should usually work out.
 *
 * @author Thomas Risberg
 * @author Juergen Hoeller
 * @since 1.2
 * @see ResultSet
 * @see javax.sql.rowset.CachedRowSet
 * @see org.springframework.jdbc.core.JdbcTemplate#queryForRowSet
 */
public class ResultSetWrappingSqlRowSet implements SqlRowSet {

	/** use serialVersionUID from Spring 1.2 for interoperability */
	private static final long serialVersionUID = -4688694393146734764L;


	private final ResultSet resultSet;

	private final SqlRowSetMetaData rowSetMetaData;

	private final Map<String, Integer> columnLabelMap;


	/**
	 * Create a new ResultSetWrappingSqlRowSet for the given ResultSet.
	 * @param resultSet a disconnected ResultSet to wrap
	 * (usually a {@code javax.sql.rowset.CachedRowSet})
	 * @throws InvalidResultSetAccessException if extracting
	 * the ResultSetMetaData failed
	 * @see javax.sql.rowset.CachedRowSet
	 * @see ResultSet#getMetaData
	 * @see ResultSetWrappingSqlRowSetMetaData
	 */
	public ResultSetWrappingSqlRowSet(ResultSet resultSet) throws InvalidResultSetAccessException {
		this.resultSet = resultSet;
		try {
			this.rowSetMetaData = new ResultSetWrappingSqlRowSetMetaData(resultSet.getMetaData());
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
		try {
			ResultSetMetaData rsmd = resultSet.getMetaData();
			if (rsmd != null) {
				int columnCount = rsmd.getColumnCount();
				this.columnLabelMap = new HashMap<>(columnCount);
				for (int i = 1; i <= columnCount; i++) {
					String key = rsmd.getColumnLabel(i);
					// Make sure to preserve first matching column for any given name,
					// as defined in ResultSet's type-level javadoc (lines 81 to 83).
					if (!this.columnLabelMap.containsKey(key)) {
						this.columnLabelMap.put(key, i);
					}
				}
			}
			else {
				this.columnLabelMap = Collections.emptyMap();
			}
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}

	}


	/**
	 * Return the underlying ResultSet
	 * (usually a {@code javax.sql.rowset.CachedRowSet}).
	 * @see javax.sql.rowset.CachedRowSet
	 */
	public final ResultSet getResultSet() {
		return this.resultSet;
	}

	/**
	 * @see ResultSetMetaData#getCatalogName(int)
	 */
	@Override
	public final SqlRowSetMetaData getMetaData() {
		return this.rowSetMetaData;
	}

	/**
	 * @see ResultSet#findColumn(String)
	 */
	@Override
	public int findColumn(String columnLabel) throws InvalidResultSetAccessException {
		Integer columnIndex = this.columnLabelMap.get(columnLabel);
		if (columnIndex != null) {
			return columnIndex;
		}
		else {
			try {
				return this.resultSet.findColumn(columnLabel);
			}
			catch (SQLException se) {
				throw new InvalidResultSetAccessException(se);
			}
		}
	}


	// RowSet methods for extracting data values

	/**
	 * @see ResultSet#getBigDecimal(int)
	 */
	@Override
	public BigDecimal getBigDecimal(int columnIndex) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getBigDecimal(columnIndex);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getBigDecimal(String)
	 */
	@Override
	public BigDecimal getBigDecimal(String columnLabel) throws InvalidResultSetAccessException {
		return getBigDecimal(findColumn(columnLabel));
	}

	/**
	 * @see ResultSet#getBoolean(int)
	 */
	@Override
	public boolean getBoolean(int columnIndex) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getBoolean(columnIndex);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getBoolean(String)
	 */
	@Override
	public boolean getBoolean(String columnLabel) throws InvalidResultSetAccessException {
		return getBoolean(findColumn(columnLabel));
	}

	/**
	 * @see ResultSet#getByte(int)
	 */
	@Override
	public byte getByte(int columnIndex) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getByte(columnIndex);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getByte(String)
	 */
	@Override
	public byte getByte(String columnLabel) throws InvalidResultSetAccessException {
		return getByte(findColumn(columnLabel));
	}

	/**
	 * @see ResultSet#getDate(int)
	 */
	@Override
	public Date getDate(int columnIndex) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getDate(columnIndex);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getDate(String)
	 */
	@Override
	public Date getDate(String columnLabel) throws InvalidResultSetAccessException {
		return getDate(findColumn(columnLabel));
	}

	/**
	 * @see ResultSet#getDate(int, Calendar)
	 */
	@Override
	public Date getDate(int columnIndex, Calendar cal) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getDate(columnIndex, cal);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getDate(String, Calendar)
	 */
	@Override
	public Date getDate(String columnLabel, Calendar cal) throws InvalidResultSetAccessException {
		return getDate(findColumn(columnLabel), cal);
	}

	/**
	 * @see ResultSet#getDouble(int)
	 */
	@Override
	public double getDouble(int columnIndex) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getDouble(columnIndex);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getDouble(String)
	 */
	@Override
	public double getDouble(String columnLabel) throws InvalidResultSetAccessException {
		return getDouble(findColumn(columnLabel));
	}

	/**
	 * @see ResultSet#getFloat(int)
	 */
	@Override
	public float getFloat(int columnIndex) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getFloat(columnIndex);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getFloat(String)
	 */
	@Override
	public float getFloat(String columnLabel) throws InvalidResultSetAccessException {
		return getFloat(findColumn(columnLabel));
	}

	/**
	 * @see ResultSet#getInt(int)
	 */
	@Override
	public int getInt(int columnIndex) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getInt(columnIndex);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getInt(String)
	 */
	@Override
	public int getInt(String columnLabel) throws InvalidResultSetAccessException {
		return getInt(findColumn(columnLabel));
	}

	/**
	 * @see ResultSet#getLong(int)
	 */
	@Override
	public long getLong(int columnIndex) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getLong(columnIndex);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getLong(String)
	 */
	@Override
	public long getLong(String columnLabel) throws InvalidResultSetAccessException {
		return getLong(findColumn(columnLabel));
	}

	/**
	 * @see ResultSet#getNString(int)
	 */
	@Override
	public String getNString(int columnIndex) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getNString(columnIndex);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getNString(String)
	 */
	@Override
	public String getNString(String columnLabel) throws InvalidResultSetAccessException {
		return getNString(findColumn(columnLabel));
	}

	/**
	 * @see ResultSet#getObject(int)
	 */
	@Override
	public Object getObject(int columnIndex) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getObject(columnIndex);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getObject(String)
	 */
	@Override
	public Object getObject(String columnLabel) throws InvalidResultSetAccessException {
		return getObject(findColumn(columnLabel));
	}

	/**
	 * @see ResultSet#getObject(int, Map)
	 */
	@Override
	public Object getObject(int columnIndex, Map<String, Class<?>> map) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getObject(columnIndex, map);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getObject(String, Map)
	 */
	@Override
	public Object getObject(String columnLabel, Map<String, Class<?>> map) throws InvalidResultSetAccessException {
		return getObject(findColumn(columnLabel), map);
	}

	/**
	 * @see ResultSet#getObject(int, Class)
	 */
	@Override
	public <T> T getObject(int columnIndex, Class<T> type) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getObject(columnIndex, type);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getObject(String, Class)
	 */
	@Override
	public <T> T getObject(String columnLabel, Class<T> type) throws InvalidResultSetAccessException {
		return getObject(findColumn(columnLabel), type);
	}

	/**
	 * @see ResultSet#getShort(int)
	 */
	@Override
	public short getShort(int columnIndex) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getShort(columnIndex);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getShort(String)
	 */
	@Override
	public short getShort(String columnLabel) throws InvalidResultSetAccessException {
		return getShort(findColumn(columnLabel));
	}

	/**
	 * @see ResultSet#getString(int)
	 */
	@Override
	public String getString(int columnIndex) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getString(columnIndex);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getString(String)
	 */
	@Override
	public String getString(String columnLabel) throws InvalidResultSetAccessException {
		return getString(findColumn(columnLabel));
	}

	/**
	 * @see ResultSet#getTime(int)
	 */
	@Override
	public Time getTime(int columnIndex) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getTime(columnIndex);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getTime(String)
	 */
	@Override
	public Time getTime(String columnLabel) throws InvalidResultSetAccessException {
		return getTime(findColumn(columnLabel));
	}

	/**
	 * @see ResultSet#getTime(int, Calendar)
	 */
	@Override
	public Time getTime(int columnIndex, Calendar cal) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getTime(columnIndex, cal);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getTime(String, Calendar)
	 */
	@Override
	public Time getTime(String columnLabel, Calendar cal) throws InvalidResultSetAccessException {
		return getTime(findColumn(columnLabel), cal);
	}

	/**
	 * @see ResultSet#getTimestamp(int)
	 */
	@Override
	public Timestamp getTimestamp(int columnIndex) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getTimestamp(columnIndex);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getTimestamp(String)
	 */
	@Override
	public Timestamp getTimestamp(String columnLabel) throws InvalidResultSetAccessException {
		return getTimestamp(findColumn(columnLabel));
	}

	/**
	 * @see ResultSet#getTimestamp(int, Calendar)
	 */
	@Override
	public Timestamp getTimestamp(int columnIndex, Calendar cal) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getTimestamp(columnIndex, cal);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getTimestamp(String, Calendar)
	 */
	@Override
	public Timestamp getTimestamp(String columnLabel, Calendar cal) throws InvalidResultSetAccessException {
		return getTimestamp(findColumn(columnLabel), cal);
	}


	// RowSet navigation methods

	/**
	 * @see ResultSet#absolute(int)
	 */
	@Override
	public boolean absolute(int row) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.absolute(row);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#afterLast()
	 */
	@Override
	public void afterLast() throws InvalidResultSetAccessException {
		try {
			this.resultSet.afterLast();
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#beforeFirst()
	 */
	@Override
	public void beforeFirst() throws InvalidResultSetAccessException {
		try {
			this.resultSet.beforeFirst();
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#first()
	 */
	@Override
	public boolean first() throws InvalidResultSetAccessException {
		try {
			return this.resultSet.first();
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#getRow()
	 */
	@Override
	public int getRow() throws InvalidResultSetAccessException {
		try {
			return this.resultSet.getRow();
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#isAfterLast()
	 */
	@Override
	public boolean isAfterLast() throws InvalidResultSetAccessException {
		try {
			return this.resultSet.isAfterLast();
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#isBeforeFirst()
	 */
	@Override
	public boolean isBeforeFirst() throws InvalidResultSetAccessException {
		try {
			return this.resultSet.isBeforeFirst();
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#isFirst()
	 */
	@Override
	public boolean isFirst() throws InvalidResultSetAccessException {
		try {
			return this.resultSet.isFirst();
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#isLast()
	 */
	@Override
	public boolean isLast() throws InvalidResultSetAccessException {
		try {
			return this.resultSet.isLast();
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#last()
	 */
	@Override
	public boolean last() throws InvalidResultSetAccessException {
		try {
			return this.resultSet.last();
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#next()
	 */
	@Override
	public boolean next() throws InvalidResultSetAccessException {
		try {
			return this.resultSet.next();
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#previous()
	 */
	@Override
	public boolean previous() throws InvalidResultSetAccessException {
		try {
			return this.resultSet.previous();
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#relative(int)
	 */
	@Override
	public boolean relative(int rows) throws InvalidResultSetAccessException {
		try {
			return this.resultSet.relative(rows);
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

	/**
	 * @see ResultSet#wasNull()
	 */
	@Override
	public boolean wasNull() throws InvalidResultSetAccessException {
		try {
			return this.resultSet.wasNull();
		}
		catch (SQLException se) {
			throw new InvalidResultSetAccessException(se);
		}
	}

}
