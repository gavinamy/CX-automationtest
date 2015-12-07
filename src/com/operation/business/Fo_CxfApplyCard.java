package com.operation.business;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import com.cx.base.BasePage;
import com.cx.util.ConnectMySQL;
import com.cx.util.Log;
import com.operation.elements.Element_Fo_CxfApplyCard;

public class Fo_CxfApplyCard extends BasePage{
	public Fo_CxfApplyCard(WebDriver driver){
		super(driver);
	}
	Element_Fo_CxfApplyCard elmCard=new Element_Fo_CxfApplyCard(this.driver);
	/**
	 * 申请实名卡
	 */
	public void ApplyCard(String address,String postCode,String addrName,String addrMobile,
			String applyInfo) throws InterruptedException{
		ConnectMySQL.connect("10.32.173.250/cxfmdm", "cxfmdm", "cxfmdm");
		String sql="select apply_status from t_user_address where user_id='852018'";
		List<HashMap<String, String>> rs=ConnectMySQL.query(sql);
		if(rs.size()==0){
			String vehicleInfo=elmCard.vehicleInfo().getText();
			String realAuthInfo=elmCard.realAuthInfo().getText();
			Boolean applyBtnInfo=elmCard.applyBtn().isEnabled();
			if(vehicleInfo.contains("已认证")&&realAuthInfo.contains("已认证")&&applyBtnInfo==true){
				Log.logInfo("点击我要申请");
				elmCard.applyBtn().click();				
			}
			String addressMeg=elmCard.addressInfo().getText();
			if(addressMeg.contains(" 邮寄地址")){
				Log.logInfo("填写邮寄地址："+address);
				Thread.sleep(500);
				elmCard.addressInput().click();
				elmCard.addressInput().sendKeys(address);
				Log.logInfo("填写邮编："+postCode);
				Thread.sleep(500);
				elmCard.postCodeInput().click();
				elmCard.postCodeInput().sendKeys(postCode);
				Log.logInfo("填写收件人姓名："+addrName);
				Thread.sleep(500);
				elmCard.addrNameInput().click();
				elmCard.addrNameInput().sendKeys(addrName);
				Log.logInfo("选择性别");
				Thread.sleep(500);
				elmCard.gender().click();
				Log.logInfo("填写联系人手机："+addrMobile);
				Thread.sleep(500);
				elmCard.addrMobile().click();
				elmCard.addrMobile().sendKeys(addrMobile);
				Log.logInfo("点击提交申请");
				Thread.sleep(1000);
				elmCard.applySubmit().click();
				String applyMeg=elmCard.applySubInfo().getText();
				if(!(applyMeg.contains(applyInfo))){
					Log.logInfo("实际与期望不符：实际-"+applyMeg+"；期望-"+applyInfo);
				}
			}else{
				Log.logInfo("没能正确进入申请实名卡页面");
			}
		}
		Log.logInfo("申请实名卡成功");
	}
}
