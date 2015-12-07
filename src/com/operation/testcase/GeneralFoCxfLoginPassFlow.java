package com.operation.testcase;

import java.util.Map;

import org.testng.annotations.Test;

import com.cx.base.TestBase;
import com.cx.util.Log;
import com.operation.business.Fo_CxfLoginPass;

public class GeneralFoCxfLoginPassFlow extends TestBase{
	@Test(dataProvider="providerMethod")
	public void CxfLogin(Map<String,String> param) throws InterruptedException{
		Fo_CxfLoginPass fcp=new Fo_CxfLoginPass(driver);
		Log.logInfo("step-1：登录车享付");
		Thread.sleep(1000);
		fcp.LoginCxfAndVerify(param.get("cxfUrl"), param.get("userName"), 
		param.get("passWord"), param.get("checkCode"), param.get("loginInfo"));		
		Log.logInfo("step-2:登入车享付页面");
	}
}
