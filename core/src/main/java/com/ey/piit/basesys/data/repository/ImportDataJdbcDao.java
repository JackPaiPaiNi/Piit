package com.ey.piit.basesys.data.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.ey.piit.basesys.data.entity.ImportData;
import com.ey.piit.basesys.data.vo.ImportDataVo;
import com.ey.piit.core.dao.entity.PageFooterColumn;
import com.ey.piit.core.dao.entity.QueryPage;
import com.ey.piit.core.dao.jdbc.BaseJdbcDao;
import com.ey.piit.core.utils.StringUtils;
import com.ey.piit.core.utils.ZipUtils;

/**
 * 
 * @author Kevin-Y.Xu
 *
 */
public class ImportDataJdbcDao extends BaseJdbcDao{
	
	private Map<String, String> colMap = new HashMap<String, String>();
	
	public ImportDataJdbcDao() {
		colMap.put("id", "ID");
		colMap.put("importId", "IMPORT_ID");
		colMap.put("rowNo", "ROW_NO");
		colMap.put("isSuccess", "IS_SUCCESS");
		colMap.put("errorMessage", "ERROR_MESSAGE");
		colMap.put("excelRowId", "EXCEL_ROW_ID");
		colMap.put("excelRowCode", "EXCEL_ROW_CODE");
		colMap.put("excelData", "EXCEL_DATA");
	}

	public void batchSaveImportData(final List<ImportData> datas) {
		
		String sql = "INSERT INTO T_IMPORT_DATA (ID, IMPORT_ID, ROW_NO, IS_SUCCESS, ERROR_MESSAGE, EXCEL_ROW_ID, EXCEL_ROW_CODE, EXCEL_DATA) values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		this.getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter(){

			public int getBatchSize() {
				return datas.size();
			}

			public void setValues(PreparedStatement ps, int index)
					throws SQLException {
				
				ImportData importData = datas.get(index);
				
				ps.setString(1, UUID.randomUUID().toString());
				ps.setString(2, importData.getImportId());
				ps.setLong(3, importData.getRowNo());
				ps.setBoolean(4, importData.getIsSuccess());
				ps.setString(5, importData.getErrorMessage());
				ps.setString(6, importData.getExcelRowId());
				ps.setString(7, importData.getExcelRowCode());
				ps.setString(8, ZipUtils.compress(importData.getExcelData()));
//				ps.setNull(6, Types.CLOB);
//				ps.setNull(6, Types.VARCHAR);
			}
			
		});
        
	}

	@SuppressWarnings("unchecked")
	public List<ImportDataVo> findImportDataByPage(QueryPage queryPage,
			Map<String, String> searchFields) {
		
		logger.trace("entering dao...");
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ID, IMPORT_ID, ROW_NO, IS_SUCCESS, ERROR_MESSAGE, EXCEL_ROW_ID, EXCEL_ROW_CODE, EXCEL_DATA ");
		sql.append(" FROM T_IMPORT_DATA WHERE IMPORT_ID = ?");
		
		queryPage.addQueryCondition("importId", searchFields.get("importId"));
		if (StringUtils.isNotEmpty(searchFields.get("isSuccess"))) {
			sql.append(" and IS_SUCCESS = ?");
			queryPage.addQueryCondition("isSuccess", searchFields.get("isSuccess"));
		}
		
		queryPage.setSqlString(sql.toString());
		queryPage.setRowMapper(new ImportDataRowMapper());
//		queryPage.addPageFooterColumn(new PageFooterColumn("rowNo", "COUNT(*)"));
		queryPage.addPageFooterColumn(new PageFooterColumn("errorMessage", "concat('校验失败记录数：',sum(case when IS_SUCCESS = 0 then 1 else 0 end))"));
		
		List<ImportDataVo> datas = (List<ImportDataVo>) super.queryByPage(queryPage);

		return datas;
	}

	/**
	 * 取得实体Bean和SQL字段之间的Mapping关系
	 * 
	 * @return Map<实体Bean字段名，SQL字段名>
	 */
	protected Map<String, String> getColMap() {
		return colMap;
	}

	@SuppressWarnings("unchecked")
	public List<ImportDataVo> findImportDataList(String importId) {
		logger.trace("entering dao...");
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ID, IMPORT_ID, ROW_NO, IS_SUCCESS, ERROR_MESSAGE, EXCEL_ROW_ID, EXCEL_ROW_CODE, EXCEL_DATA ");
		sql.append(" FROM T_IMPORT_DATA WHERE IS_SUCCESS = 1 and IMPORT_ID = ?");
		
		List<Object> args = new ArrayList<Object>();
		args.add(importId);
		return this.getJdbcTemplate().query(sql.toString(), args.toArray(), new ImportDataRowMapper());
		
	}
	
	public boolean haveImportErrData(String importId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT IMPORT_ID FROM T_IMPORT_DATA WHERE IS_SUCCESS = 0 and IMPORT_ID = ? and rownum = 1 ");
		
		List<Object> args = new ArrayList<Object>();
		args.add(importId);
		List<?> list = this.getJdbcTemplate().queryForList(sql.toString(), args.toArray());
		if(list!=null && list.size()>0){
			return true;
		}
		return false;
	}
}

@SuppressWarnings("rawtypes")
class ImportDataRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ImportDataVo data = new ImportDataVo();

		data.setId(rs.getString("ID"));
		data.setImportId(rs.getString("IMPORT_ID"));
		data.setRowNo(rs.getLong("ROW_NO"));
		data.setIsSuccess(rs.getBoolean("IS_SUCCESS"));
		data.setErrorMessage(rs.getString("ERROR_MESSAGE"));
		data.setExcelRowId(rs.getString("EXCEL_ROW_ID"));
		data.setExcelRowCode(rs.getString("EXCEL_ROW_CODE"));
//		data.setExcelData(StringUtils.getStringFromClob(rs.getClob("EXCEL_DATA")));
		data.setExcelData(ZipUtils.uncompress(rs.getString("EXCEL_DATA")));

		return data;
	}

}