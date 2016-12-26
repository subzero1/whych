package cn.com.pro;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class dbhelper {
	private static String Dnforname="oracle.jdbc.driver.OracleDriver";
	//private static String DbConncetionString="jdbc:oracle:thin:@132.97.188.214:1521:search";
	private static String DbConncetionString="jdbc:oracle:thin:@132.97.188.214:1521:search";
	//private static String DbConncetionString="jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS_LIST =(ADDRESS = (PROTOCOL = TCP)(HOST = RAC-SCAN.DB.163.CN)(PORT = 1521)))(CONNECT_DATA =(SID = RAC)(SERVICE_NAME = RAC)))";
	//private static String DbUser="SJSCGD";
	//private static String DbPass="SJSCGD";
	private static String DbUser="whych";
	private static String DbPass="whychpwd";
	private static Connection connect = null;
	private static DataSource dataSuorce;
	//锟斤拷锟斤拷锟斤拷菘锟�
	 public static Connection dbConn()
	    {
//	        Connection conn = null;
//	        try {
//	               Class.forName(Dnforname);
//	              
//	           } catch (ClassNotFoundException e) {
//	               e.printStackTrace();
//	           }
//	           try {
//	               conn = DriverManager.getConnection(DbConncetionString, DbUser, DbPass);
//	     
//	           } catch (SQLException e) {
//	               e.printStackTrace();
//	           }
//	           return conn;
		 
         try {
	   			Context context = new InitialContext();
	   			context = (Context)context.lookup("java:comp/env");
	   			dataSuorce = (DataSource)context.lookup("jdbc/gz_whych");
	   			connect = dataSuorce.getConnection();
	   		} catch (NamingException e) {
	   			e.printStackTrace();
	   		} catch (SQLException eq) {
	   			eq.printStackTrace();
	   		}
        return connect;
		 
		 
	    }
	//锟斤拷锟斤拷锟斤拷菘锟�
	 public static Connection dbConn(String ConnentionStr,String Cur_DbUser,String Cur_DbPass)
		    {
		        Connection conn = null;
		        
		        try {
		               Class.forName(Dnforname);
		              
		           } catch (ClassNotFoundException e) {
		               e.printStackTrace();
		           }
		           try {
		               conn = DriverManager.getConnection(ConnentionStr, Cur_DbUser, Cur_DbPass);
		     
		           } catch (SQLException e) {
		               e.printStackTrace();
		           }
		           return conn;
	}
	 //锟较匡拷锟斤拷锟斤拷
	 public static void dbClose(Connection conn)
	    {
	    	try {
	        	if(conn != null)
	        	{
	        		conn.close();
	        	}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	
	 
	 public List toList(ResultSet rs,Class cls)    
	 {    
	         List list = new ArrayList();    
	         try   
	         {                 
	             //锟斤拷取锟斤拷菘锟斤拷峁�?  
	             ResultSetMetaData meta=rs.getMetaData();    
	             Object obj=null;    
	             while(rs.next())    
	             {        
	                 obj=Class.forName(cls.getName()).newInstance(); 
	                 for(int i=1;i<=meta.getColumnCount();i++)    
	                 {    
	                     String colName=meta.getColumnName(i);    
	                    
	                     colName=colName.replace(colName.charAt(0)+"", new String(colName.charAt(0)+"").toUpperCase());   
	                     String methodName="set"+colName;   
	                     Object value=rs.getObject(i);  
	                     Method method=obj.getClass().getMethod(methodName, value.getClass());    
	                     method.invoke(obj, value);                 
	                 }    
	                 list.add(obj);    
	             }    
	         }catch(Exception ex)    
	         {    
	             ex.printStackTrace();    
	         }finally{    
	        	   try {
	        		 if(rs!=null){
		        		 rs.close();
		        		 rs=null;
			        	 }
					} catch (Exception e) {
						// TODO: handle exception
					}
	        	
	             return list;    
	         }    
	   } 

	   
}
