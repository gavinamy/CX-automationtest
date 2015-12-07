package com.operation.elements;

import org.openqa.selenium.WebDriver;

import com.cx.base.ExtendWebElement;
import com.cx.base.Locator;

public class Element_CSC_LoginOutPage extends Locator{
	public Element_CSC_LoginOutPage(WebDriver driver){
		super(driver);
	}			
	/***
	 * 登录页面
	 */
	/**
	 * 用户名输入框
	 */
	public ExtendWebElement userNameInput(){
	 return getElement("//*[@id=\"username\"]");	
}	
	/**
	 * 密码输入框
	 */
	public ExtendWebElement passWordInput(){
	 return getElement("//*[@id=\"password\"]");		 
}
	/**
	 * 登录按钮
	 */
	public ExtendWebElement loginBtn(){
	 return getElement("//*[@id=\"loginbtn\"]");
}
	/**
	 * 登录成功信息-右上角显示（CSC系统管理员）
	 */
	public ExtendWebElement  loginInfo(){
	 return getElement("/html/body/div[1]/div/ul/li/a/span");	
}	
	/**
	 * 登出悬浮菜单
	 */
	public ExtendWebElement logoutHoverMenu() {
		return getElement("//span[@class='username']");
	}
	/**
	 * 登出链接
	 */
	public ExtendWebElement logoutLink() {
		return getElement("//a[@href='http://op.sit.com/csc/logout']");
	}
	
	
}