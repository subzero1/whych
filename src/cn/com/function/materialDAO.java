package cn.com.function;

import cn.com.pro.DbExecute;

public class materialDAO {
	//素材管理
	public String _Class_MyList(String S_sdate,String E_sdate,String UNAME,String UVER)
	{
		String Sqlwhere="";		
		String Sql="";		
		return DbExecute._executeQueryToJson(Sql);
	}	
}
