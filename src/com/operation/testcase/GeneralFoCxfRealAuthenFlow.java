package com.operation.testcase;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Configuration;
import org.testng.annotations.Test;

import com.cx.base.TestBase;
import com.cx.util.ConnectMySQL;
import com.cx.util.Log;
import com.operation.business.Fo_CxfLoginPass;
import com.operation.business.Fo_CxfRealAuthen;

public class GeneralFoCxfRealAuthenFlow extends TestBase{
	Fo_CxfRealAuthen realAu=null;
	
	@Test(dataProvider="providerMethod")
	public void CxfLogin(Map<String,String> param) throws InterruptedException{
		Fo_CxfLoginPass fcp=new Fo_CxfLoginPass(driver);
		Log.logInfo("step-1：登录车享付");
		fcp.LoginCxfAndVerify(param.get("cxfUrl"), param.get("userName"), 
		param.get("passWord"), param.get("checkCode"), param.get("loginInfo"));
		Thread.sleep(1000);
	}
	
	@Test(dependsOnMethods ={"CxfLogin"}, dataProvider = "providerMethod")	
	public void UserRealAuthen(Map<String,String> param) throws InterruptedException{
		realAu=new Fo_CxfRealAuthen(driver);	
		Log.logInfo("step-2：申请实名认证");
		realAu.RealAuthen(param.get("realName"), param.get("idNumber"),param.get("frontPath"),
				param.get("backPath"),param.get("authenInfo"));	
	}
	
	@AfterClass
	@Parameters({"DBCXFMDM_Host", "DBCXFMDM_User", "DBCXFMDM_Pwd", "RealAuthSql"})
	public int rollBackReal(String DBCXFMDM_Host, String DBCXFMDM_User,String DBCXFMDM_Pwd,
			String RealAuthSql){
		Log.logInfo("step-3：实名认证数据回滚");		
		ConnectMySQL.connect(DBCXFMDM_Host, DBCXFMDM_User, DBCXFMDM_Pwd);
		int count=ConnectMySQL.executeSql(RealAuthSql);		
		if(count>0){
			Log.logInfo("实名认证数据回滚成功");
		}else{
			Log.logInfo("实名认证数据回滚失败");
		}
		ConnectMySQL.close();
		return count;
	}
}
