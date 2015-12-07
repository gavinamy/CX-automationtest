package com.operation.testcase;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cx.base.TestBase;
import com.cx.util.Log;
import com.cx.util.Util;
import com.operation.business.CSC_LoginOutPage;
import com.operation.business.CSC_Page;

public class GeneralCSCMenuOperateFlow extends TestBase {

	@Test(dataProvider = "providerMethod")
	public void OperateCSCMenu(Map<String,String> param) {
		CSC_LoginOutPage lp = new CSC_LoginOutPage(driver);
		Log.logInfo("Step1-金融超市后台登录");
		try {
			int compareResult= lp.LoginAndVerify(param.get("loginPage_url"),param.get("username"),
					param.get("password"),param.get("loginInfo"));
			Util.sleep(3); 
			Assert.assertEquals(compareResult, 0, "登录可能失败，请详见log"); 
			Log.stepInfo("后台登录成功");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}		
		CSC_Page ep = new CSC_Page(driver);
		int compareResult1 = ep.clickSecondMenu(param.get("firstMenu"), param.get("secondMenu"));	
		Util.sleep(1);
		Assert.assertEquals(compareResult1, 0,"菜单进入可能错误，详情见log");
		Log.stepInfo("菜单进入正确！");
	}
}
