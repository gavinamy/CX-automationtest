package com.operation.testcase;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cx.base.TestBase;
import com.cx.util.Log;
import com.operation.business.ReAndLogin_Page;

public class GeneralForgotPasswordFlow extends TestBase{

	@Test(dataProvider = "providerMethod")
	public void GeneralForgotPsw(HashMap<String,String> param) {
		ReAndLogin_Page rp = new ReAndLogin_Page(this.driver);
		boolean result = rp.forgotPsw(param.get("forgotUrl"), 
				param.get("forgotAccNo"), param.get("newPsw"));
		Assert.assertEquals(result, true, "重置密码失败！");
		Log.logInfo("重置密码成功！");
	}
}
