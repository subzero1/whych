package com.base.dao;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RowMapper {
	public static <T> List<T> getRowList(ResultSet rs, Class<?> cls) {
		List list = new ArrayList();
		try {
			ResultSetMetaData meta = rs.getMetaData();
			Object obj = null;
			while (rs.next()) {
				obj = Class.forName(cls.getName()).newInstance();
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					String colName = meta.getColumnName(i);

					colName = colName.replace(colName.charAt(0) + "",
							new String(colName.charAt(0) + "").toUpperCase());
					Object value = rs.getObject(i);
					Method[] methods=obj.getClass().getDeclaredMethods();
					for (Method method : methods) {
						if (method.getName().toUpperCase().equals("SET"+colName)) {
//							System.out.println("colName:"+colName+"  value:"+value+"  type:"+method.getParameterTypes());
							if (value instanceof BigDecimal) {
								value=Integer.parseInt(value.toString());
							}
							method.invoke(obj, value);
							break;
						}
					}
				}
				list.add(obj);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			return list;
		}
	}

	public static Object getSingleRow(ResultSet rs, Class<?> cls) {
		List list = getRowList(rs, cls);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public static List<Map<String, Object>> getRowMapList(ResultSet rs) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			ResultSetMetaData meta = rs.getMetaData();
			while (rs.next()) {
				Map<String, Object> rowMap = new LinkedHashMap<String, Object>();
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					String colName = meta.getColumnName(i);
					Object value = rs.getObject(i);
					rowMap.put(colName.toLowerCase(), value);
				}
				list.add(rowMap);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			return list;
		}
	}

	public static Map<String, Object> getSingleRowMap(ResultSet rs) {
		List<Map<String, Object>> list = getRowMapList(rs);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}
