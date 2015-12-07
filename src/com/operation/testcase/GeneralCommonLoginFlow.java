package com.operation.testcase;

import java.awt.AWTException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cx.base.TestBase;
import com.cx.util.Log;
import com.operation.business.ReAndLogin_Page;

/**
 * 常规登录注册业务流程
 * @author gavin
 *
 */
public class GeneralCommonLoginFlow extends TestBase {
	
	ReAndLogin_Page cp = null;
	/**
	 * 常规登录
	 * @param param 登录所需参数容器
	 */
	@Test(dataProvider = "providerMethod")
	public void GeneralCommonLogin(HashMap<String,String> param) {
		cp = new ReAndLogin_Page(this.driver);
		boolean flag = cp.commonLogin(param.get("homePageURL"), 
				param.get("username"), param.get("password"), param.get("loginInfo"));
		Assert.assertEquals(flag, true,"登录可能失败，请看日志！");
		Log.logInfo("登录成功！");		
	}

	
}
