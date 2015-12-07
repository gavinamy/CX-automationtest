package com.operation.testcase;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cx.base.TestBase;
import com.cx.util.ConnectMySQL;
import com.cx.util.Log;
import com.operation.business.Fo_CxfApplyCard;
import com.operation.business.Fo_CxfLoginPass;

public class GeneralFoCxfApplyCardFlow extends TestBase{
	
	@Test(dataProvider="providerMethod")
	public void CxfLogin(Map<String,String> param) throws InterruptedException{
		Fo_CxfLoginPass fcp=new Fo_CxfLoginPass(driver);
		Log.logInfo("step-1：登录车享付");
		fcp.LoginCxfAndVerify(param.get("cxfUrl"), param.get("userName"), 
		param.get("passWord"), param.get("checkCode"), param.get("loginInfo"));
		Thread.sleep(1000);
	}
	
	@Test(dependsOnMethods={"CxfLogin"}, dataProvider = "providerMethod")
	public void UserApplyCard(Map<String,String> param) throws InterruptedException{
		Fo_CxfApplyCard appCard=new Fo_CxfApplyCard(driver);		
		Log.logInfo("step-2：申请车享付卡");
		Thread.sleep(1000);
		appCard.ApplyCard(param.get("address"), param.get("postCode"), 
				param.get("addrName"), param.get("addrMobile"), param.get("applyInfo"));		
	}
	
	@AfterClass
	@Parameters({"DBCXFMDM_Host", "DBCXFMDM_User", "DBCXFMDM_Pwd", "ApplyCardSql"})
	public int rollBackCard(String DBCXFMDM_Host, String DBCXFMDM_User, String DBCXFMDM_Pwd, 
			String ApplyCardSql){
		Log.logInfo("step-3：回滚申请实名卡数据");
		ConnectMySQL.connect(DBCXFMDM_Host, DBCXFMDM_User, DBCXFMDM_Pwd);
		int count=ConnectMySQL.executeSql(ApplyCardSql);
		if(count>0){
			Log.logInfo("回滚申请实名卡数据成功");
		}else{
			Log.logInfo("回滚申请实名卡数据失败");
		}
		return count;
	}
}
