package cn.com.pro;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.google.gson.*;

import java.sql.ResultSetMetaData;

import oracle.sql.CLOB;

public class ResultsetToJson {
	
	public static final JsonArray ResultSetToJsonArray(ResultSet rs) {
		
		JsonObject element = null;
		 JsonArray ja = new JsonArray();
		 ResultSetMetaData rsmd = null;
		 String columnName, columnValue = null;
		 try {
		 rsmd = rs.getMetaData();
		 while (rs.next()) {
		 element = new JsonObject();
		 for (int i = 0; i < rsmd.getColumnCount(); i++) {
		 columnName = rsmd.getColumnName(i + 1);
		 columnValue = rs.getString(columnName);
		 element.addProperty(columnName, columnValue);
		 }
		 ja.add(element);
		 }
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }
		 return ja;
		 }

		 public static final JsonObject ResultSetToJsonObject(ResultSet rs) {
		 JsonObject element = null;
		 JsonArray ja = new JsonArray();
		 JsonObject jo = new JsonObject();
		 ResultSetMetaData rsmd = null;
		 String columnName, columnValue = null;
		 try {
		 rsmd = rs.getMetaData();
		 while (rs.next()) {
		 element = new JsonObject();
		// System.out.println(rs.getString(1)+" kkk");
		 for (int i = 0; i < rsmd.getColumnCount(); i++) {
			 
			 columnName = rsmd.getColumnName(i + 1);
			 columnValue = rs.getString(columnName);
			 
			// System.out.println(columnValue);
			 
			 
			 element.addProperty(columnName, columnValue);
		 }
		 ja.add(element);
		 }
		 jo.add("conent", ja);
		 } catch (SQLException e) {
		 e.printStackTrace();
		 }finally{
			 try {
				 if(rs!=null){
					 rs.close();
					 rs=null;
				 }
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		 }
		 return jo;
		 }

		 public static final String ResultSetToJsonString(ResultSet rs) {
		 return ResultSetToJsonObject(rs).toString();
		 }
		 
		 public static final String ResultSetToJsonStringClob(ResultSet rs,String clobname) throws IOException {
			 return ResultSetToJsonObjectandclob(rs,clobname).toString();
			 }
		 
		 public static final String ResultSetToJsonString(ResultSet rs,String ClobStr) throws IOException {
			 System.out.println("执行ResultSetToJsonObject");
				return ResultSetToJsonObject(rs,ClobStr).toString();
			}
		 
		 public static final String ScaleResultSetToString(ResultSet rs,String ClobStr) throws IOException {
			 System.out.println("执行ResultSetToStringandclob");
				return ResultSetToStringandclob(rs,ClobStr);
			}
		 
		 
		 
		 
		 
		 //传入clob字段�?
		 public static final JsonObject ResultSetToJsonObjectandclob(ResultSet rs,String clobname) throws IOException{
			 JsonObject element = null;
			 JsonArray ja = new JsonArray();
			 JsonObject jo = new JsonObject();
			 ResultSetMetaData rsmd = null;
			 String columnName, columnValue = null;
			 try {
			 rsmd = rs.getMetaData();
			 while (rs.next()) {
			 element = new JsonObject();
			// System.out.println(rs.getString(1)+" kkk");
			 for (int i = 0; i < rsmd.getColumnCount(); i++) {
				
				 columnName = rsmd.getColumnName(i + 1);
				 //如果列名为clob字段�?
				 if(columnName.equals(clobname))
				 {
					 System.out.println("转换clob");
					 CLOB clobvalue=null;
					 clobvalue= (oracle.sql.CLOB)rs.getClob(columnName);
					 columnValue = ClobToString(clobvalue); 
					 System.out.println(columnValue);
				 }
				 else //否则直接读取
					 columnValue = rs.getString(columnName);
				 
				 element.addProperty(columnName, columnValue);
			 }
			 ja.add(element);
			 }
			 jo.add("conent", ja);
			 } catch (SQLException e) {
			 e.printStackTrace();
			 }finally{
				 try {
					 if(rs!=null){
						 rs.close();
						 rs=null;
					 }
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			 }
			 return jo;
			 }
		 
		 
		//传入clob字段�?
		 public static final String ResultSetToStringandclob(ResultSet rs,String clobname) throws IOException{
			
			 ResultSetMetaData rsmd = null;
			 String columnName, columnValue = null;
			 try {
				 while (rs.next()) {
							 CLOB clobvalue=null;
							 clobvalue= (oracle.sql.CLOB)rs.getClob(clobname);
							 columnValue = ClobToString(clobvalue); 
				 }
				 return columnValue;
			 	
			 } catch (SQLException e) {
			 e.printStackTrace();
			 }finally{
				 try {
					 if(rs!=null){
						 rs.close();
						 rs=null;
					 }
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			 }
			 	return "";
			 }
		 
		 
		// 将字CLOB转成STRING类型 
		    private static final String ClobToString(CLOB clob) throws SQLException, IOException { 

		    	//System.out.println("�?��转换");
		    	 System.out.println("�?��输出");
		        String reString = ""; 
		        Reader is = clob.getCharacterStream();// 得到�?
		        BufferedReader br = new BufferedReader(is); 
		        String s = br.readLine(); 
		       
		        StringBuffer sb = new StringBuffer(); 
		        while (s != null) {// 执行循环将字符串全部取出付�?给StringBuffer由StringBuffer转成STRING 
		            sb.append(s); 
		            s = br.readLine(); 
		        } 		       
		        reString = sb.toString(); 
		        System.out.println("输出"+reString);
		        return reString; 
		    } 

		  //传入Clob名，使用流方式读�?
			public static final JsonObject ResultSetToJsonObject(ResultSet rs,String ClobStr) throws IOException {
				System.out.println("执行ResultSetToJsonObject");
				JsonObject element = null;
				JsonArray ja = new JsonArray();
				JsonObject jo = new JsonObject();
				ResultSetMetaData rsmd = null;
				String columnName, columnValue = null;
				try {
					rsmd = rs.getMetaData();
					
					while (rs.next()) {
						element = new JsonObject();
						for (int i = 0; i < rsmd.getColumnCount(); i++) {
							
							columnName = rsmd.getColumnName(i + 1);
							 System.out.println(columnName);
							if(columnName.equals(ClobStr))
							{
								/*CLOB clobvalue=null;
								System.out.println("转换的字�?+columnName);
								 clobvalue= (oracle.sql.CLOB)rs.getClob(columnName);
								 */								 
								// columnValue = ClobToString(clobvalue); 
								 Clob clob = rs.getClob(columnName);//java.sql.Clob
								    String detailinfo = "";
								    if(clob != null){
								     detailinfo = clob.getSubString((long)1,(int)clob.length());
								    }
								 //columnValue =Get_Clob(rs,ClobStr);
								    columnValue=detailinfo;
							}	
							else
								columnValue = rs.getString(columnName);
							element.addProperty(columnName, columnValue);
						}
						ja.add(element);
					}
					jo.add("conent", ja);
				} catch (SQLException e) {
					System.out.println(e.toString());
					e.printStackTrace();
				}
				
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println(e.toString());
					e.printStackTrace();
				}
				
				return jo;
			}
			
			
			
			
			public static final String Get_Clob(ResultSet rs,String ClobStr)
			{
				String detailinfo="";
				try {
					Clob clob = rs.getClob(ClobStr);//java.sql.Clob
				     detailinfo = "";
				    if(clob != null){
				     detailinfo = clob.getSubString((long)1,(int)clob.length());
				    }
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				return detailinfo;
						
			}
}
