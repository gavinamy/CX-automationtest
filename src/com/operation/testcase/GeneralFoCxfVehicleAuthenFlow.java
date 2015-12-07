package com.operation.testcase;

import java.sql.SQLException;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cx.base.TestBase;
import com.cx.util.ConnectMySQL;
import com.cx.util.Log;
import com.operation.business.Fo_CxfLoginPass;
import com.operation.business.Fo_CxfVehicleAuthen;

public class GeneralFoCxfVehicleAuthenFlow extends TestBase{
	Fo_CxfVehicleAuthen fcva=null;
	
	@Test(dataProvider="providerMethod")
	public void CxfLogin(Map<String,String> param) throws InterruptedException{
		Fo_CxfLoginPass fcp=new Fo_CxfLoginPass(driver);
		Log.logInfo("step-1：登录车享付");
		fcp.LoginCxfAndVerify(param.get("cxfUrl"), param.get("userName"), 
		param.get("passWord"), param.get("checkCode"), param.get("loginInfo"));
		Thread.sleep(1000);
	}
	
	@Test(dependsOnMethods={"CxfLogin"},dataProvider = "providerMethod")
	public void UserVehicleAuthen(Map<String,String> param) throws InterruptedException, SQLException{
		fcva=new Fo_CxfVehicleAuthen(driver);		
		Log.logInfo("step-2：车认证提交申请");
		fcva.VehicleAuthen(param.get("nickName"), param.get("filePath"),param.get("ownerName"), 
				param.get("carCode"), param.get("vinCode"), param.get("engineCode"), param.get("date"), 
				param.get("subInfo"));				
	}
	
	@AfterClass()
	@Parameters({"DBMDMUSER_Host","DBMDMUSER_User","DBMDMUSER_Pwd","VehicleAuthSql"})
	public int rollBackVeh(String DBCXFMDM_Host, String DBCXFMDM_User, String DBCXFMDM_Pwd,
			String VehicleAuthSql){
		Log.logInfo("step-3：回滚申请数据");	
		ConnectMySQL.connect(DBCXFMDM_Host, DBCXFMDM_User, DBCXFMDM_Pwd);
		int count=ConnectMySQL.executeSql(VehicleAuthSql);
		if(count>0){
			Log.logInfo("车认证数据回滚成功");
		}else{
			Log.logInfo("车认证数据回滚失败");
		}
		return count;		
	}
}
