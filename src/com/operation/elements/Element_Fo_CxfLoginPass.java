package com.operation.elements;


import org.openqa.selenium.WebDriver;

import com.cx.base.ExtendWebElement;
import com.cx.base.Locator;

public class Element_Fo_CxfLoginPass extends Locator{
	public Element_Fo_CxfLoginPass(WebDriver driver){
		super(driver);
	}	
	
	/**
	 * 输入用户名
	 */
	public ExtendWebElement usernameInput(){
		return getElement("//input[@id='username']");
	}
	/**
	 * 输入密码
	 */
	public ExtendWebElement passwordInput(){
		return getElement("//input[@id='password']");
	}
	/**
	 * 输入验证码
	 */
	public ExtendWebElement checkCodeInput(){
		return getElement("//input[@id='checkCode']");
	}
	/**
	 * 点击登录
	 */
	public ExtendWebElement submitLogin(){
		return getElement("//*[@id='loginForm']/div/input[6]");
	}
	/**
	 * 验证用户正常登入,Hi，171*****052
	 */
	public ExtendWebElement verifyLogin(){
		//return getElement("//div[@class='topnav']//li[1]//a[not(@style)]/p");	
		return getElement("/html/body/div[3]/div/ul/li[4]/a/span");
	}

}
