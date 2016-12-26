package com.base.dao;

import java.util.List;
import java.util.Map;


public interface JdbcOperations {

	void execute(String sql) throws Exception;

	Map<String, Object> queryForMap(String sql) throws Exception;

	Map<String, Object> queryForMap(String sql, Object... args) throws Exception;

	List<Map<String, Object>> queryForList(String sql) throws Exception;

	List<Map<String, Object>> queryForList(String sql, Object... args) throws Exception;

	int update(String sql) throws Exception;

	int update(String sql, Object... args) throws Exception;

	int[] batchUpdate(List<String> sqls) throws Exception;

	public int[] batchUpdate(String sql, List<Object[]> batchArgs) throws Exception;
	
	public int[] batchUpdate(List<String> sqls, List<Object[]> batchArgs) throws Exception;

}
