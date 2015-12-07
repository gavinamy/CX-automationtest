package com.operation.business;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cx.base.BasePage;
import com.cx.util.ConnectMySQL;
import com.cx.util.Log;
import com.operation.elements.Element_Fo_CxfRealAuthen;

public class Fo_CxfRealAuthen extends BasePage{
	public Fo_CxfRealAuthen(WebDriver driver){
		super(driver);
	}
	Element_Fo_CxfRealAuthen elmReal=new Element_Fo_CxfRealAuthen(this.driver);
	
	/**
	 * 车享付实名认证
	 */
	public void RealAuthen(String realName,String idNumber,String frontPath,String backPath,String authenInfo) 
			throws InterruptedException{
		File file=null;
		ConnectMySQL.connect("10.32.173.250/cxfmdm", "cxfmdm", "cxfmdm");
		String sql="select audit_status from t_user_info where user_id='852017';";	
		List<HashMap<String,String>>rs=ConnectMySQL.query(sql);
		if(rs.size()==0){
				String vehInfo=elmReal.vehiclePassInfo().getText();
				String realInfo=elmReal.verifyRealAutInfo().getText();
				Boolean authBt=elmReal.authBtn().isEnabled();
				if(vehInfo.contains("已认证")&&realInfo.contains("未完成车享付实名认证")&&authBt==true){
					Log.logInfo("点击实名立即认证");
					Thread.sleep(1000);
					elmReal.authBtn().click();
				}else{
					driver.switchTo().window("安全中心");
					elmReal.SafeAuthBtn().click();
				}
		}
		String auInfo=elmReal.authInfo().getText();
		file=new File(frontPath);		
		frontPath=file.getAbsolutePath();
		file=new File(backPath);		
		backPath=file.getAbsolutePath();
		if(auInfo.contains("真实姓名")){
			Log.logInfo("填写真实姓名："+realName);
			Thread.sleep(500);
			elmReal.realNameInput().click();
			elmReal.realNameInput().sendKeys(realName);
			Log.logInfo("填写身份证号："+idNumber);
			Thread.sleep(500);
			elmReal.idNumberInput().click();
			elmReal.idNumberInput().sendKeys(idNumber);
			Log.logInfo("上传身份证正面");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='idCardFront']")).sendKeys(frontPath);	
			Log.logInfo("上传身份证反面");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='idCardBack']")).sendKeys(backPath);
			Log.logInfo("点击下一步");
			Thread.sleep(1000);
			elmReal.nextBtn().click();
			String authInfoMeg=elmReal.submitInfo().getText();
			if(!(authInfoMeg.contains(authenInfo))){
				Log.logInfo("页面显示与期望不一致：实际-"+authInfoMeg+"；期望-"+authenInfo);
			}
		}	
		Log.logInfo("申请实名认证成功");
	}
}
