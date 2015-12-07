package com.operation.business;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cx.base.BasePage;
import com.cx.base.ExtendWebElement;
import com.cx.util.ConnectMySQL;
import com.cx.util.Log;
import com.operation.elements.Element_Fo_CxfVehicleAuthen;

public class Fo_CxfVehicleAuthen extends BasePage{
	public Fo_CxfVehicleAuthen(WebDriver driver){
		super(driver);
	}
	Element_Fo_CxfVehicleAuthen elmVeh=new Element_Fo_CxfVehicleAuthen(this.driver);
	
	/**
	 * 申请车认证
	 */
	public void VehicleAuthen(String nickName,String filePath,String ownerName,String carCode,String vinCode,
			String engineCode,String date,String subInfo) throws InterruptedException{
		ConnectMySQL.connect("10.32.173.250/mdmuser", "mdmuser", "mdmuser");
		String sql="select verification from t_user where user_id='852016';";			
		List<HashMap<String,String>>rs=ConnectMySQL.query(sql);	
		Iterator<HashMap<String,String>> it = rs.iterator();
		String a = "";
		while(it.hasNext()) {
			a = it.next().get("verification");
			if(Integer.valueOf(a)==1) {
				String verifyVehicleInfo=elmVeh.verifyVehicleInfo().getText();	
				Boolean flag=elmVeh.verifyVehicleBtnInfo().isEnabled();
				Log.logInfo("点击'立即认证'按钮");
				if(verifyVehicleInfo.contains("还不是车享认证会员")||flag==true){
					elmVeh.certBtnClick().click();
				}else{
					driver.switchTo().window("安全中心");
					elmVeh.openCertBtnClick().click();
				}
			}
		}		
		String verifyJumpPageInfo=elmVeh.verifyJumpPageInfo().getText();		
		if(verifyJumpPageInfo.contains("昵称")&&nickName.isEmpty()){
			Log.logInfo("输入昵称："+nickName);
			elmVeh.nickNameInput().click();
			elmVeh.nickNameInput().sendKeys(nickName);
		}
			Log.logInfo("点击下一步,进入申请页面");
			elmVeh.oneNextBtnClick().click();
		String verifySubPageInfo=elmVeh.verifySubPageInfo().getText();
		File file = new File(filePath);
		filePath=file.getAbsolutePath();
		if(verifySubPageInfo.contains("品牌车系")){
			Log.logInfo("选择品牌车系");								
			Thread.sleep(2000);
			elmVeh.brandType().click();		
			elmVeh.brandSelect().click();
//			ExtendWebElement.selectOption(driver,
//					"//*[@id='brand-type-icon-container']", "//*[@id='brand-type-ul']/li", "B-宝骏");
			Thread.sleep(500);
//			ExtendWebElement.selectOption(driver,
//					"//*[@id=\"car-type-icon-container\"]", "//*[@id=\"car-type-ul\"]/li[5]", "上汽通用五菱 - 610");
			elmVeh.seriesType().click();
			elmVeh.seriesSelect().click();
			Thread.sleep(1000);
			Log.logInfo("上传行驶证");
			driver.findElement(By.xpath("//input[@id='scfile']")).sendKeys(filePath);
			Thread.sleep(1000);
			Log.logInfo("填写车主姓名："+ownerName);
			elmVeh.ownerNameInput().click();
			elmVeh.ownerNameInput().sendKeys(ownerName);
			Thread.sleep(1000);
			Log.logInfo("填写车牌号："+carCode);
			elmVeh.carCodeInput().click();
			elmVeh.carCodeInput().sendKeys(carCode);
			Log.logInfo("填写VIN码"+vinCode);
			elmVeh.vinCodeInput().click();
			elmVeh.vinCodeInput().sendKeys(vinCode);
			Log.logInfo("填写发动机号"+engineCode);
			elmVeh.engineCodeInput().click();
			elmVeh.engineCodeInput().sendKeys(engineCode);
			Log.logInfo("填写注册日期"+date);
			elmVeh.datePurchased().click();
			elmVeh.datePurchased().sendKeys(date);
			Log.logInfo("点击下一步");
			elmVeh.nextBtnClick().click();
			String subInfoMeg=elmVeh.verifySubInfo().getText();
			if(!(subInfoMeg.contains(subInfo))){
				Log.logInfo("页面显示与期望不一致："+"实际="+subInfoMeg+"；期望="+subInfo);
			}
		}else{
			Log.logInfo("没有正确进入页面");
			driver.quit();
			driver.close();
		}
	}
}
