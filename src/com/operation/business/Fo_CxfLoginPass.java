package com.operation.business;

import org.openqa.selenium.WebDriver;

import com.cx.base.BasePage;
import com.cx.util.Log;
import com.operation.elements.Element_Fo_CxfLoginPass;

public class Fo_CxfLoginPass extends BasePage{
	public Fo_CxfLoginPass(WebDriver driver){
		super(driver);
	}
	Element_Fo_CxfLoginPass elmLo=new Element_Fo_CxfLoginPass(this.driver);
	
	public int LoginCxfAndVerify(String cxfUrl,String userName,String passWord,String checkCode,
			String loginInfo) throws InterruptedException{
		this.goTo(cxfUrl);
		Log.logInfo("输入用户名"+userName);
		Thread.sleep(2000);		
		elmLo.usernameInput().click();
		elmLo.usernameInput().sendKeys(userName);
		Thread.sleep(1000);
		Log.logInfo("输入密码"+passWord);
		elmLo.passwordInput().click();
		elmLo.passwordInput().sendKeys(passWord);
		Thread.sleep(1000);
		Log.logInfo("输入验证码"+checkCode);
		elmLo.checkCodeInput().click();
		elmLo.checkCodeInput().sendKeys(checkCode);
		Thread.sleep(1000);
		Log.logInfo("点击登录");
		elmLo.submitLogin().click();
		//driver.get(cxfUrl);   //driver.navigate().to(cxfUrl);两个都可以用
		int logRes=0;
		String loginMes=elmLo.verifyLogin().getText();
		if(!(loginMes.contains(loginInfo))){
			logRes++;
			Log.logInfo("页面验证项logRes="+logRes);
			Log.logInfo("页面显示与实际不匹配："+"实际="+loginMes+"；预期="+loginInfo);
		}
		return logRes;
	}
	/**
	 * 登录成功页获取顶部信息
	 * @tang
	 */
	public String LogMes(){
		String logRes=elmLo.verifyLogin().getText();
		return logRes;
	}
}
