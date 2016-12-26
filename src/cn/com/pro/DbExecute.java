package cn.com.pro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import oracle.sql.CLOB;



public class DbExecute extends dbhelper {

	//��ѯ��ݣ�������ݼ�
		public static ResultSet _executeQuery(String SqlString)
	    {
			ResultSet ResultStr=null;
			try {
	    		Connection conn = dbConn();
	    		if(conn == null)
	    		{
	    			return ResultStr;    			
	    		}
	    		Statement statement = conn.createStatement();
	    		ResultStr = statement.executeQuery(SqlString);
	    		if (statement!=null)
	    			statement.close();
	    		
	    		dbClose(conn); 
			} catch (SQLException e) {
				return ResultStr;   
			}
			return ResultStr;   
	    }
		public static ResultSet _execute(String SqlString)
	    {
			ResultSet ResultStr=null;
			try {
	    		Connection conn = dbConn();
	    		if(conn == null)
	    		{
	    			return ResultStr;    			
	    		}
	    		Statement statement = conn.createStatement();
	    		ResultStr = statement.executeQuery(SqlString);
	    		if (statement!=null)
	    			statement.close();	    		
	    		dbClose(conn); 
			} catch (SQLException e) {
				// TODO: handle exception
				//return ResultStr;   
			}
			return ResultStr;   
	    }
		
	//��ѯ��ݣ�����json
	public static String _executeQueryToJson(String SqlString)
    {
		Connection conn = dbConn();
		Statement statement=null;
		String ResultStr="";
		try {
    		if(conn == null)
    		{
    			ResultStr= "";    			
    		}
    		statement = conn.createStatement();
    		ResultSet resultSet = statement.executeQuery(SqlString);
    		
    		ResultStr= cn.com.pro.ResultsetToJson.ResultSetToJsonString(resultSet);
    		
    		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			ResultStr="";
		}finally{
			try {
				if (statement!=null)
	    			statement.close();    		
	    		dbClose(conn); 
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		return ResultStr;
    }
	
	//传入语句和药处理的clob字段�?
	public static String _executeQueryToJson(String SqlString,String ClobStr) throws IOException {
		Connection conn = dbConn();
		Statement statement=null;
		String ResultStr="";
		try {
    		if(conn == null)
    		{
    			ResultStr= "";    			
    		}
    		statement = conn.createStatement();
    		ResultSet resultSet = statement.executeQuery(SqlString);
    		
    		ResultStr= cn.com.pro.ResultsetToJson.ResultSetToJsonString(resultSet,ClobStr);
    		System.out.println("准备获取数据");
    		
    		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			ResultStr="";
		}finally{
			try {
				if (statement!=null)
	    			statement.close();    		
	    		dbClose(conn); 
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		return ResultStr;
	}
	//��ѯ��ݣ�����json
		public static String _executeQueryToJsonClob(String SqlString,String Clobname) throws IOException
	    {
			System.out.println("�?��执行语句");
			String ResultStr="";
			Connection conn = dbConn();
			Statement statement=null;
			ResultSet resultSet=null;
			try {
	    		
	    		if(conn == null)
	    		{
	    			ResultStr= "";    			
	    		}
	    		statement = conn.createStatement();
	    		resultSet = statement.executeQuery(SqlString);
	    		ResultStr= cn.com.pro.ResultsetToJson.ResultSetToJsonStringClob(resultSet, Clobname);
	    		
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				ResultStr="";
			}finally{
				try {
					if (statement!=null)
		    			statement.close();	    		
		    		dbClose(conn); 
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
			return ResultStr;
	    }
		
		
	//��ѯ��ݣ�����json
		public static String _executeQueryToJson(String SqlString,String Connection,String DbUser,String DbPass)
	    {
			String ResultStr="";
			Connection conn = dbConn(Connection,DbUser,DbPass);
			Statement statement=null;
			try {
	    		if(conn == null)
	    		{
	    			ResultStr= "";    			
	    		}
	    		statement = conn.createStatement();
	    		ResultSet resultSet = statement.executeQuery(SqlString);
	    		ResultStr= cn.com.pro.ResultsetToJson.ResultSetToJsonString(resultSet);
	    		
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				ResultStr="";
			}finally{
				try {
					if (statement!=null)
		    			statement.close();
		    		dbClose(conn); 
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			return ResultStr;
	    }
		
		
	//ִ��sql��䣬������json 
	public static String _executeQueryToJson(String SqlString,String[] parameters)
    {	
		Connection conn = dbConn();
		PreparedStatement ps=null;
		try {
    		
    		if(conn == null)
    		{
    			dbClose(conn);
    			return "";
    		}
            ps = conn.prepareStatement(SqlString);
            if(parameters!=null)
            {
                for(int i=0;i<parameters.length;i++)
                {
                    ps.setString(i+1,parameters[i]);
                }
            }
            ResultSet resultSet =  ps.executeQuery();
           
    		
            return cn.com.pro.ResultsetToJson.ResultSetToJsonString(resultSet);
            
        }
        catch(Exception e)
        {
            return "";
        }
        finally
        {
            try {
            	dbClose(conn);
            	 if (ps!=null)
         			ps.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
        }
	
    }
	//ִ��sql��䣬����String 
	public static String _executeNon(String SqlString)
	    {
		Connection conn = dbConn();
		Statement statement=null;
			try {
	    		
	    		if(conn == null)
	    		{
	    			dbClose(conn);
	    			return "";
	    		}
	    		
	    		 statement = conn.createStatement();
	    		Integer resultint= statement.executeUpdate(SqlString);
	    		
	    		return Integer.toString(resultint);
	           
			} catch (SQLException e) {
				// TODO: handle exception
			}finally{
				try {
					if (statement!=null)
						statement.close();
		    		dbClose(conn);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			return "";
	    }
	
		//�����ִ�д洢��̣�����String 
	public static String _executeNonProToJson(String SqlString,String[] parameters,String[] parameters2)
		    {
		Connection conn = dbConn();
		CallableStatement statement=null;
				try {
		    	
		    		if(conn == null)
		    		{
		    			dbClose(conn);
		    			return "";
		    		}
		    		//��ʽ "{call FindCusts(?)}"
		    		
		    		statement = conn.prepareCall(SqlString);
		    		if(parameters!=null)
		            {
		                for(int i=0;i<parameters.length;i++)
		                {
		                	if(parameters2[i].equals("String"))
		                	{		                	
			                	statement.setString(i+1,parameters[i]);
		                	}
		                	else if(parameters2[i].equals("Int"))
		                	{		                	
			                	statement.setString(i+1,parameters[i]);
		                	}
		                	else if(parameters2[i].equals("Date"))
		                	{		                	
			                	statement.setDate(i+1,Date.valueOf(parameters[i]));
		                	}
		                }
		            }
		    		boolean ISOK= statement.execute();
		    		
		    		if (ISOK)
		    			return "成功";
		    		else
		    			return "失败";
		           
				} catch (SQLException e) {
					// TODO: handle exception
				}finally{
					try {
						if(statement!=null){
							statement.close();
						}
			    		dbClose(conn);
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				return "成功";
		    }
		
		
	//ִ��sql��䣬��һ�е�һ���ֶ�������?
	public static String _executeScale(String SqlString)
			    {
		Connection conn = dbConn();
		Statement statement=null;
		ResultSet rs=null;
					try {
			    		
			    		if(conn == null)
			    		{
			    			dbClose(conn);
			    			return "";
			    		}
			    		 statement = conn.createStatement();
			    		 rs = statement.executeQuery(SqlString);
			    		
			    		while (rs.next()){  
			    	        return rs.getString(1) ;
			    	    }  
			    		
			    		
			   		 } catch (SQLException e) {
			   			
			   			 e.printStackTrace();
			   		 }finally{
			   			try {
			   				System.out.println("statement waite close");
				    		
				    		if (rs!=null)
				    		{
				    			 System.out.println("rs close");
				    			rs.close();
				    		}
				    		if (statement!=null)
				    		{
				    			System.out.println("statement close");
				    			statement.close();
				    		}
				    		dbClose(conn);
						} catch (Exception e2) {
							// TODO: handle exception
						}
			   		 }
					
					return "";
		}
	
	public static String _executeScale(String SqlString,String ClobStr) throws IOException
    {
			Connection conn = dbConn();
			Statement statement=null;
			ResultSet rs=null;
					try {
			    		
			    		if(conn == null)
			    		{
			    			dbClose(conn);
			    			return "";
			    		}
			    		 statement = conn.createStatement();
			    		 rs = statement.executeQuery(SqlString);
			    		
			    		 
			    		return cn.com.pro.ResultsetToJson.ScaleResultSetToString(rs, ClobStr);
			    		
			    		
						
			   		 } catch (SQLException e) {
			   			
			   			 e.printStackTrace();
			   		 }finally{
			   			try {
			   				System.out.println("statement waite close");
				    		
				    		if (rs!=null)
				    		{
				    			 System.out.println("rs close");
				    			rs.close();
				    		}
				    		if (statement!=null)
				    		{
				    			System.out.println("statement close");
				    			statement.close();
				    		}
				    		dbClose(conn);
						} catch (Exception e2) {
							// TODO: handle exception
						}
			   		 }
					
					return "";
			}
	
	// 将字CLOB转成STRING类型 
    private static final String ClobToString(CLOB clob) throws SQLException, IOException { 

    	System.out.println("�?��转换");
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
        return reString; 
    } 


}
