package com.ey.piit.core.dao.jdbc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.ey.piit.core.dao.entity.PageFooterColumn;
import com.ey.piit.core.dao.entity.QueryPage;
import com.ey.piit.core.exception.DaoException;
import com.ey.piit.core.paginator.domain.PageList;
import com.ey.piit.core.paginator.domain.Paginator;

/**
 * 
 * JDBC数据操作实现,注入dataSource
 * @author Kevin-Y.Xu
 *
 */
public abstract class BaseJdbcDao extends JdbcDaoSupport {
	public static final String ASC = "ASC";
	public static final String DESC = "DESC";
	public static final String ORDER_BY = " ORDER BY ";
	public static final String COMMA = " , ";
	public static final String SPACE = " ";
	public static final String COUNT = "COUNT__";

	public List<?> queryByPage(QueryPage queryPage) throws DaoException {
		String sql = queryPage.getSqlString();
		List args = queryPage.getAllNotNullArg();
		int pageSize = queryPage.getPageSize();
		int pageIndex = queryPage.getPageIndex();//第一页下标为0
		RowMapper rowMapper = queryPage.getRowMapper();
		boolean calCount = queryPage.isCalCount();
		Map<String, String> sortMap = queryPage.getSortMap();
		
		List<PageFooterColumn> footers = new ArrayList<PageFooterColumn>();
		List<Object> params = new ArrayList<Object>();
		
		if (args != null && args.size() > 0) {
			for (Object arg : args) {
				if ( (arg instanceof PageFooterColumn) )
					footers.add((PageFooterColumn) arg);
				else
					params.add(arg);
			}
		}
		
		// 汇总
		Map<String, Object> aggregations = null;
		Integer total = pageSize;
		if (calCount) {
			aggregations = aggregate(sql, params, footers);
			total = Integer.valueOf(aggregations.get(COUNT).toString());
		}

		// 如果有排序条件，在sqlString后添加order by
		StringBuffer sbSql = new StringBuffer(sql);
		Map<String,String> colMap = this.getColMap();
		if (sortMap != null && !sortMap.isEmpty()) {
			sbSql.append(ORDER_BY);
			int i = 0;
			for (Iterator it = sortMap.keySet().iterator(); it
					.hasNext();) {
				Object o = it.next();
				String fieldName = o.toString();
				if (colMap.containsKey(o.toString())){
					fieldName = colMap.get(o.toString());
				}
				String orderType = sortMap.get(o.toString())
						.toString();

				if (i > 0) {
					sbSql.append(COMMA);
				}

				if (ASC.equalsIgnoreCase(orderType)) {
					sbSql.append(fieldName)
							.append(SPACE).append(ASC);
				} else {
					sbSql.append(fieldName)
							.append(SPACE).append(DESC);
				}
				i++;
			}
		}

		// 翻页
//		int newPageIndex = pageIndex;
//		if (calCount) {
//			// 修正翻页后无法回到最后一页问题
//			if (pageIndex < 0) {
//				newPageIndex = 0;
//			}
//			else if (total <= pageSize * (pageIndex)) {
//				if (total > 0)
//					newPageIndex = (total + pageSize - 1) / pageSize - 1;
//			}
//		}
		
//		if(null == params)
//			args = new ArrayList<Object>();

//		int firstResult = pageSize * (newPageIndex) + 1;
		int firstResult = pageSize * pageIndex;
		params.add(firstResult + 1); // FirstResult
		params.add(pageSize + firstResult); // MaxResults
//		params.add(pageSize); // pageSize

		sql = "select * from ( select TMP_RESULT.*, ROWNUM RN from (" + sbSql.toString()
				+ ") TMP_RESULT ) where RN >= ? and RN<= ? ";
//      sql = sbSql.toString()
//      + " limit ?,? ";

		Paginator paginator = new Paginator(pageIndex, pageSize, total);
		return new PageList(getJdbcTemplate().query(sql, params.toArray(), rowMapper),paginator);
	}
	
	public Map<String, Object> aggregate(String sql, List<Object> args, List<PageFooterColumn> footers) {
		StringBuilder aggSql = new StringBuilder();
		aggSql.append("select count(*) as ");
		aggSql.append(COUNT).append(SPACE);
		if (footers != null) {
			for (PageFooterColumn column : footers) {
				aggSql.append(",").append(column.getAggExpression()).append(" as ").append(column.getName());
			}
		}
		aggSql.append(" from (").append(sql).append(") ");
		
		if(logger.isDebugEnabled())
			logger.debug("aggSql:" + aggSql.toString());
		
		Map<String, Object> map = this.getJdbcTemplate().queryForMap(aggSql.toString(), args.toArray());
		if (footers != null) {
			for (PageFooterColumn column : footers) {
				String key = column.getName().toUpperCase();
				Object value = map.get(key);
				map.remove(key);
				map.put(column.getName(), value);
			}
		}
		
		return map;
	}

	/**
	 * 取得实体Bean和SQL字段之间的Mapping关系
	 * 
	 * @return Map<实体Bean字段名，SQL字段名>
	 */
	protected abstract Map<String,String> getColMap();
	
}
