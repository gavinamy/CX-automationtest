package com.operation.testcase;

import java.awt.AWTException;
import java.sql.SQLException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cx.base.TestBase;
import com.cx.util.Log;
import com.operation.business.ReAndLogin_Page;

public class GeneralCommonRegisterFlow extends TestBase {

	
	/**
	 * 常规注册
	 * @throws InterruptedException 
	 * @throws AWTException 
	 * @throws SQLException 
	 */
	@Test(dataProvider = "providerMethod")
	public void GeneralCommonRegister(HashMap<String,String> param) throws InterruptedException, AWTException, SQLException {
		ReAndLogin_Page rp = new ReAndLogin_Page(this.driver);
		boolean flag = rp.commonRegister(param.get("homePageURL"), 
				param.get("setPwd"), param.get("loginPage_url"), param.get("username"), 
				param.get("password"), param.get("loginInfo"), param.get("firstMenu"), 
				param.get("secondMenu"));
		Assert.assertEquals(flag, true,"注册可能失败，请看日志！");
		Log.stepInfo("注册成功！");		
		Log.logInfo(ReAndLogin_Page.phone);
		boolean dataResult = rp.dataClear(ReAndLogin_Page.phone);
		Assert.assertEquals(dataResult, true, "数据删除失败！");
		Log.logInfo("数据删除成功！");
	}	
}
