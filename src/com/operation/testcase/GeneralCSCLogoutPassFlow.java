package com.operation.testcase;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cx.base.TestBase;
import com.cx.util.Log;
import com.operation.business.CSC_LoginOutPage;

public class GeneralCSCLogoutPassFlow extends TestBase {

	/**
	 * 登出
	 * @param param
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "providerMethod")
	public void GeneralAdminLogout(Map<String,String> param) 
			throws InterruptedException {
		CSC_LoginOutPage lp = new CSC_LoginOutPage(driver);		
		Log.logInfo("Step1-金融超市后台登录");
		int compareResult= lp.LoginAndVerify(param.get("loginPage_url"),param.get("username"),
				param.get("password"),param.get("loginInfo"));
		Thread.sleep(3000); 
		Assert.assertEquals(compareResult, 0, "登录可能失败，请详见log"); 
		Log.stepInfo("后台登录成功");	
		if(lp.LogoutAndVerify()) {
			Log.logInfo("登出成功！");
		}	
		else
			Log.logInfo("登出失败！");
	}
}
