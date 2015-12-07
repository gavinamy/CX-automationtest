package com.operation.elements;

import org.openqa.selenium.WebDriver;

import com.cx.base.ExtendWebElement;
import com.cx.base.Locator;

public class Element_Fo_CxfApplyCard  extends Locator{
	public Element_Fo_CxfApplyCard(WebDriver driver){
		super(driver);
	}
	
	/**
	 * 车认证通过：已认证
	 */
	public ExtendWebElement vehicleInfo(){
		return getElement("//*[@id='mainForm']/div/div/div[1]/div[1]/dl/dd[4]/div/div/div[1]/span");
	}
	/**
	 * 实名认证通过：已认证
	 */
	public ExtendWebElement realAuthInfo(){
		return getElement("//*[@id='mainForm']/div/div/div[1]/div[1]/dl/dd[5]/div/div/div[1]/span");
	}
	/**
	 * 点击’我要申请‘
	 */
	public ExtendWebElement applyBtn(){
		return getElement("//*[@id='apply_card']");
	}
	/**
	 * 验证正确进入申请实名卡页面，“ 邮寄地址”
	 */
	public ExtendWebElement addressInfo(){
		return getElement("//*[@id='ulregist']/li[2]/label");
	}	
	/**
	 * 填写邮寄地址
	 */
	public ExtendWebElement addressInput(){
		return getElement("//*[@id='userAddr']");
	}
	/**
	 * 填写邮编
	 */
	public ExtendWebElement postCodeInput(){
		return getElement("//*[@id='userPostalCode']");
	}
	/**
	 * 填写收件人姓名
	 */
	public ExtendWebElement addrNameInput(){
		return getElement("//*[@id='userAddrName']");
	}
	/**
	 * 选择性别
	 */
	public ExtendWebElement gender(){
		return getElement("//*[@id='ulregist']/li[5]/input[2]");
	}
	/**
	 * 填写联系人手机
	 */
	public ExtendWebElement addrMobile(){
		return getElement("//*[@id='userAddrMobile']");
	}
	/**
	 * 点击提交申请
	 */
	public ExtendWebElement applySubmit(){
		return getElement("//*[@id='ulregist']/li[8]/input[1]");
	}
	/**
	 * 验证提交后的信息
	 */
	public ExtendWebElement applySubInfo(){
		return getElement("/html/body/div[3]/div[2]/p[1]");
	}
}
