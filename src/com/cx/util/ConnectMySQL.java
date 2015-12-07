package com.cx.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
 


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
 
public class ConnectMySQL {
 
    public static String driver = "com.mysql.jdbc.Driver";
 
    private static String host;
 
    private static String user;
 
    private static String pwd;
 
    private static Connection conn = null;
 
    private static Statement stmt = null;
 
    public static void connect(String host, String user, String pwd) {
        ConnectMySQL.close();
        ConnectMySQL.host = host;
        ConnectMySQL.user = user;
        ConnectMySQL.pwd = pwd;
    }
 
    public static synchronized List<HashMap<String, String>> query(String sql) {
        return ConnectMySQL.result(sql);
    }
 
    public static synchronized void close() {
        try {
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    private static void connectMySQL() {
        try {
            Class.forName(driver).newInstance();
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://"
                    + host + "?useUnicode=true&characterEncoding=UTF8", user,
                    pwd);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
    }
 
    private static void statement() {
        if (conn == null) {
            ConnectMySQL.connectMySQL();
        }
        try {
            stmt = (Statement) conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    private static ResultSet resultSet(String sql) {
        ResultSet rs = null;
        if (stmt == null) {
            ConnectMySQL.statement();
        }
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
 
    private static List<HashMap<String, String>> result(String sql) {
        ResultSet rs = ConnectMySQL.resultSet(sql);
        List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        try {
            ResultSetMetaData md = rs.getMetaData();
            int cc = md.getColumnCount();
            while (rs.next()) {
                HashMap<String, String> columnMap = new HashMap<String, String>();
                for (int i = 1; i <= cc; i++) {
                    columnMap.put(md.getColumnName(i), rs.getString(i));
                }
                result.add(columnMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
	 * @Title: dbExecute
	 * @Description: 批量执行增删改
	 * @param sqls
	 * @return 
	 * @date 2015-08-03
	 */
	public static int[] dbExecute(String... sqls) throws SQLException {				
		ConnectMySQL.statement();
		int[] count = null;	
		try {
			boolean autoCommit=conn.getAutoCommit();
		    //关闭自动提交功能
		    conn.setAutoCommit(false);						
			for (String sql : sqls) {
				stmt.addBatch(sql);
			}		
			count = stmt.executeBatch();			
			//提交事务
		    conn.commit();
		    //恢复原来的提交模式
		    conn.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			System.out.println("操作失败！！！任务撤销！！！");
		    try{
		        //回滚、取消前述操作
		        conn.rollback();
		    }catch(Exception e1){
		      e1.printStackTrace();
		    }
		}
		finally {
			try{
		         if(conn!=null){
		            conn.close();
		         }
		   }catch(Exception e1){
		     e1.printStackTrace();
		    }
		}		
		return count;
	}

	 public static int  executeSql(String sql){
	    	statement();
	    	int count = 0;
	    	try {
	    		count = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	return count;
	    } 
 
    public static void main(String[] args) throws SQLException {
    	String userIds = "select user_id from t_user_alias where alias_name='13878765682';";
		ConnectMySQL
        .connect("10.32.173.250/sso", "sso", "sso");
		String userId = ConnectMySQL.query(userIds).get(0).get("user_id");
		Log.logInfo(userId);
//		ConnectMySQL.close();
		String[] sqlsSSO = new String[]{"delete from t_user_alias where user_id='"+userId+"';",
				"delete * from t_user where user_id='"+userId+"';"};
		String[] sqlsMDM = new String[]{"delete from t_phone where user_id='"+userId+"';",
				"delete from t_user where user_id='"+userId+"';",
				"delete from t_user_bind where user_id='"+userId+"';",};
		ConnectMySQL
        .connect("10.32.173.250/sso", "sso", "sso");
		int[] a = ConnectMySQL.dbExecute(sqlsSSO);
		Log.logInfo(a.length);
		for(int i=0;i<a.length;i++) {
			Log.logInfo(a[i]);
		}
		ConnectMySQL.close();
		Log.stepInfo("1");
		ConnectMySQL
        .connect("10.32.173.250/mdmuser", "mdmuser", "mdmuser");
		Log.logInfo("3");
		ConnectMySQL.dbExecute(sqlsMDM);
    }
}