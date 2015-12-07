package com.operation.elements;


import org.openqa.selenium.WebDriver;

import com.cx.base.ExtendWebElement;
import com.cx.base.Locator;

public class Element_CSC_HomePage extends Locator{
	public Element_CSC_HomePage(WebDriver driver){
		super(driver);
	}			
	/***
	 * 运营平台-首页
	 */
	/**
	 * 登录成功信息-右上角显示（CSC系统管理员）
	 */
	public ExtendWebElement  loginInfo(){
	 return getElement("/html/body/div[1]/div/ul/li/a/span");	
}
}