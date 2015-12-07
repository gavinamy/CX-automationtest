package com.cx.bean;
//既然是操作数据库，我们就把数据库的字段给对象化一下，也就是持久化：在定义变量时，我们搞个约定，比如，数据库字段名为:test_login_name,
//则定义变量时为：testLoginName.
public class UserInfo {
	private int id;
	private String testName;
	private String testAge;
	private String testHeight;
	
	public int getId(){
		return id;
	}
	
	public void steId(int id){
		this.id = id;
	}
	
	public String getTestName(){
		return testName;
	}
	
	public void setTestName(String testName){
		this.testName = testName;
	}
	
	public String getTestAge(){
		return testAge;
	}
	
	public void setTestAge(String testAge){
		this.testAge = testAge;
	}
	
	public String getTestHeight(){
		return testHeight;
	}
	
	public void setTestHeight(String testHeight){
		this.testHeight = testHeight;
	}

}
