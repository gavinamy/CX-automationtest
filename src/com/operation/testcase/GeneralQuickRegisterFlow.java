package com.operation.testcase;

import java.awt.AWTException;
import java.sql.SQLException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cx.base.TestBase;
import com.cx.util.ConnectMySQL;
import com.cx.util.Log;
import com.operation.business.ReAndLogin_Page;

public class GeneralQuickRegisterFlow extends TestBase {

	@Test(dataProvider = "providerMethod") 
	public void GeneralQuickRegister(HashMap<String,String> param) 
			throws InterruptedException, AWTException, SQLException {
		ReAndLogin_Page rp = new ReAndLogin_Page(this.driver);
		boolean result = rp.quickRegister(param.get("quickUrl"),  
				param.get("quickRegPassword"), param.get("loginPage_url"), param.get("username"), 
				param.get("password"), param.get("loginInfo"), param.get("firstMenu"), param.get("secondMenu"));
		Assert.assertEquals(result, true, "快速注册失败！");
		Log.logInfo("快速注册成功！");
		boolean dataResult = rp.dataClear(ReAndLogin_Page.phone);
		Assert.assertEquals(dataResult, true, "数据删除失败！");
		Log.logInfo("数据删除成功！");
	}
}
