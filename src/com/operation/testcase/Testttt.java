package com.operation.testcase;

import java.sql.*;



public class Testttt{

    public static void main(String args[]){

    Connection conn=null;

    try{

       Class.forName("com.mysql.jdbc.Driver");

       String url="jdbc:mysql://10.32.173.250:3306/sso";

       conn=DriverManager.getConnection(url,"sso","sso");

       boolean autoCommit=conn.getAutoCommit();

       //关闭自动提交功能

       conn.setAutoCommit(false);

       Statement stmt=conn.createStatement();

       stmt.executeUpdate("update t_user_alias a set alias_type='1' where a.user_id='858018';");

       stmt.executeUpdate("delete from t_user a set status='1' where a.user_id='85801811';");

//       ResultSet rs=stmt.executeQuery("select * from sun");
//
//       while(rs.next()){
//
//            System.out.print("DeptNo:"+rs.getInt(1));
//
//            System.out.print("\tDeptName:"+rs.getString(2));
//
//            System.out.println("\tLOC:"+rs.getString(3));
//
//}   

//提交事务

    conn.commit();

//恢复原来的提交模式

    conn.setAutoCommit(autoCommit);

    stmt.close();

}catch(Exception e){

    System.out.println("操作失败！！！任务撤销！！！");

    try{

        //回滚、取消前述操作

        conn.rollback();

    }catch(Exception e1){

      e1.printStackTrace();

    }

}finally{

   try{

         if(conn!=null){

            conn.close();

         }

   }catch(Exception e1){

     e1.printStackTrace();

    }

   }

    }

}
