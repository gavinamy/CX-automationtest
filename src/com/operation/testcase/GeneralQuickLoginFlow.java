package com.operation.testcase;

import java.awt.AWTException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cx.base.TestBase;
import com.cx.util.Log;
import com.operation.business.ReAndLogin_Page;

public class GeneralQuickLoginFlow extends TestBase {

	@Test(dataProvider = "providerMethod")
	public void GeneralQuickLogin(HashMap<String,String> param) 
			throws InterruptedException, AWTException {
		ReAndLogin_Page rp = new ReAndLogin_Page(this.driver);
		boolean result = rp.quickLogin(param.get("quickUrl"), 
				param.get("quickUsername"), param.get("quickPassword"));
		Assert.assertEquals(result, true, "快速登录失败！");
		Log.logInfo("快速登录成功！");
	}
}
