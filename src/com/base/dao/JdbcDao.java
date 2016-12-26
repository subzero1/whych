package com.base.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcDao extends JdbcAccessor implements JdbcOperations {

	private static JdbcDao dao = new JdbcDao();

	private JdbcDao() {

	}

	@Override
	public void execute(String sql) throws Exception {

	}

	@Override
	public Map<String, Object> queryForMap(String sql) throws Exception {
		return queryForMap(sql, new Object[] {});
	}

	@Override
	public Map<String, Object> queryForMap(String sql, Object... args)
			throws Exception {
		Map<String, Object> resultMap = null;
		List<Map<String, Object>> list = queryForList(sql, new Object[] {});
		if (list != null && list.size() > 0) {
			resultMap = list.get(0);
		}
		return resultMap;
	}

	@Override
	public List<Map<String, Object>> queryForList(String sql) throws Exception {
		return queryForList(sql, new Object[] {});
	}

	public <T> List<T> queryForList(String sql, Class<T> elementType, Object... args)
			throws Exception {
		List<T> list = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			if (args != null) {
				for (int i = 1; i <= args.length; i++) {
					statement.setObject(i, args[i - 1]);
				}
			}
			rs = statement.executeQuery();
			list = RowMapper.getRowList(rs, elementType);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStatement(statement);
			closeConnection(conn);
		}
		return list;
	}
	
	public List<Map<String, Object>> queryForList(String sql, Object... args)
			throws Exception {
		List<Map<String, Object>> list = new ArrayList();
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			if (args != null) {
				for (int i = 1; i <= args.length; i++) {
					statement.setObject(i, args[i - 1]);
				}
			}
			rs = statement.executeQuery();
			list = RowMapper.getRowMapList(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeStatement(statement);
			closeConnection(conn);
		}
		return list;
	}

	@Override
	public int update(String sql) throws Exception {
		return update(sql, new Object[] {});
	}

	@Override
	public int update(String sql, Object... args) throws Exception {
		Connection conn = null;
		PreparedStatement statement = null;
		int result = 0;
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			if (args != null) {
				for (int i = 1; i <= args.length; i++) {
					statement.setObject(i, args[i - 1]);
				}
			}
			result = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(statement);
			closeConnection(conn);
		}
		return result;
	}

	@Override
	public int[] batchUpdate(List<String> sqls) throws Exception {
		return batchUpdate(sqls, null);
	}

	@Override
	public int[] batchUpdate(String sql, List<Object[]> batchArgs)
			throws Exception {
		int[] op = null;
		Connection conn = this.getConnection();
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			if (batchArgs != null && batchArgs.size() > 0) {
				try {
					for (Object[] objects : batchArgs) {

						if (objects == null) {
							continue;
						}
						if (objects != null && objects.length > 0) {
							for (int i = 1; i <= objects.length; i++) {
								statement.setObject(i, objects[i - 1]);
							}
						}
						statement.addBatch();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			op = statement.executeBatch();
			// statement.clearBatch();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(statement);
			closeConnection(conn);
		}
		return op;
	}

	@Override
	public int[] batchUpdate(List<String> sqls, List<Object[]> batchArgs)
			throws Exception {
		int[] result = null;
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			Integer size = sqls.size();
			for (int i = 0; i < size; i++) {
				statement = conn.prepareStatement(sqls.get(i));
				Object[] args = batchArgs.get(i);
				if (args != null && args.length > 0) {
					for (int j = 1; j <= args.length; j++) {
						statement.setObject(j, args[j - 1]);
					}
				}
				statement.addBatch();
			}
			result = statement.executeBatch();
			statement.clearBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeStatement(statement);
			closeConnection(conn);
		}
		return result;
	}

	public Map<Integer, Object> call(final String procedureName,
			final Object[] inParams, final int outParams[]) {
		Connection conn=null;
		CallableStatement cst = null;
		Map<Integer, Object> resultMap = new HashMap<Integer, Object>();
		try {
			conn=getConnection();
			StringBuffer sql = new StringBuffer("{call " + procedureName + "(");
			String sql1 = "";
			int inLength = 0;
			int outLength = 0;
			if (inParams != null) {
				inLength = inParams.length;
				for (int i = 0; i < inLength; i++) {
					if (sql1.equals("")) {
						sql1 = "?";
					} else {
						sql1 += ",?";
					}
				}
			}
			if (outParams != null) {
				outLength = outParams.length;
				for (int i = 0; i < outLength; i++) {
					if (sql1.equals("")) {
						sql1 = "?";
					} else {
						sql1 += ",?";
					}
				}
			}
			sql.append(sql1);
			sql.append(")}");
			cst = (CallableStatement) conn.prepareCall(sql.toString());
			for (int i = 0; i < inLength; i++) {
				cst.setObject(i + 1, inParams[i]);
			}
			for (int j = 0; j < outParams.length; j++) {
				cst.registerOutParameter((j + inLength + 1), outParams[j]);
			}
			cst.execute();
			for (int i = 0; i < outLength; i++) {
				int index = (i + 1 + inLength);
				Object object = cst.getObject(i + 1 + inLength);
				if (object instanceof ResultSet) {
					System.out.println("resultset");
					ResultSet rs = (ResultSet) object;
					object = RowMapper.getSingleRowMap(rs);
				}
				resultMap.put(index, object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeStatement(cst);
			closeConnection(conn);
		}
		return resultMap;
	}

	public static JdbcDao getInstance() {
		if (dao == null) {
			dao = new JdbcDao();
		}
		return dao;
	}
}
