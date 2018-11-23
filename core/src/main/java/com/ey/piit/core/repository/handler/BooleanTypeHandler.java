package com.ey.piit.core.repository.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * @author java中的boolean和jdbc中的char之间转换;true-Y;false-N
 */
public class BooleanTypeHandler implements TypeHandler<Boolean> {

	@Override
	public void setParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
		String value = parameter ? "Y" : "N";
		ps.setString(i, value);
	}

	@Override
	public Boolean getResult(ResultSet rs, String columnName) throws SQLException {
		String value = rs.getString(columnName);
		Boolean rt = Boolean.FALSE;
		if ("Y".equalsIgnoreCase(value)) {
			rt = Boolean.TRUE;
		}
		return rt;
	}

	@Override
	public Boolean getResult(ResultSet rs, int columnIndex) throws SQLException {
		String value = rs.getString(columnIndex);
		Boolean rt = Boolean.FALSE;
		if ("Y".equalsIgnoreCase(value)) {
			rt = Boolean.TRUE;
		}
		return rt;
	}

	@Override
	public Boolean getResult(CallableStatement cs, int columnIndex) throws SQLException {
		String value = cs.getString(columnIndex);
		Boolean rt = Boolean.FALSE;
		if ("Y".equalsIgnoreCase(value)) {
			rt = Boolean.TRUE;
		}
		return rt;
	}

	
}