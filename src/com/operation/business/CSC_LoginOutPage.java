package com.operation.business;

import org.openqa.selenium.WebDriver;

import com.cx.base.BasePage;
import com.cx.util.Log;
import com.cx.util.Util;
import com.operation.elements.Element_CSC_LoginOutPage;


public class CSC_LoginOutPage extends BasePage{
	public CSC_LoginOutPage(WebDriver driver) {
		super(driver);	
	}	
	Element_CSC_LoginOutPage  LoginEles = new Element_CSC_LoginOutPage(this.driver); 
	
	//CSC登录
	public int LoginAndVerify(String loginPage_url,String username, String password,String loginInfo) throws InterruptedException	{
		  this.driver.get(loginPage_url);
	      Util.sleep(2);	      
	      Log.stepInfo("输入登录用户名:"+username);
	      LoginEles.userNameInput().click();
	      LoginEles.userNameInput().sendKeys(username);
	      Util.sleep(2);
	      Log.stepInfo("输入登录密码:"+password);
	      LoginEles.passWordInput().click();
	      LoginEles.passWordInput().sendKeys(password);
	      LoginEles.loginBtn().click();
	      Util.sleep(3);
	      String loginMeg= LoginEles.loginInfo().getText();
	      Log.logInfo("登录完成后，页面显示信息:"+loginMeg); 
	      int compareResult=0;
	      if (!(loginMeg.contains(loginInfo))) {
	    	  compareResult++;
              Log.logInfo("页面项验证compareResult=:"+ compareResult);
              Log.logInfo("页面显示和期望不匹配:"+"实际-"+loginMeg+";期望-"+loginInfo); 
            }
          return  compareResult;	  
	      }
	
	//CSC登出
	public boolean LogoutAndVerify() {
		boolean flag = false;
		Util.sleep(1);
		LoginEles.logoutHoverMenu().moveToElement();
		Util.sleep(1);
		LoginEles.logoutLink().click();
		Util.sleep(1);
		if(this.driver.getTitle().equals("Login")) {
			flag = true;
		}
		return flag;
	}	
	
	/**
	 * 登录成功信息获取
	 * @return
	 */
	public String getLoginMeg(){
		String loginMeg= LoginEles.loginInfo().getText();
		return loginMeg;
	}	
}
