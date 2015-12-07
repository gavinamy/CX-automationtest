package com.operation.elements;

import org.openqa.selenium.WebDriver;

import com.cx.base.ExtendWebElement;
import com.cx.base.Locator;

public class Element_Fo_CxfRealAuthen  extends Locator{
	public Element_Fo_CxfRealAuthen(WebDriver driver){
		super(driver);
	}
	
	/**
	 * 验证用户车认证通过：已认证
	 */
	public ExtendWebElement vehiclePassInfo(){
		return getElement("//*[@id='mainForm']/div/div/div[1]/div[1]/dl/dd[4]/div/div/div[1]/span");
	}
	/**
	 * 验证用户没有实名认证：未完成车享付实名认证
	 */
	public ExtendWebElement verifyRealAutInfo(){
		return getElement("//*[@id='mainForm']/div/div/div[1]/div[1]/dl/dd[5]/div/div[1]/span");
	}
	/**
	 * 实名认证，点击立即认证
	 */
	public ExtendWebElement authBtn(){
		return getElement("//*[@id='mainForm']/div/div/div[1]/div[1]/dl/dd[5]/div/span/a");
	}
	/**
	 * 安全中心-实名立即认证
	 */
	public ExtendWebElement SafeAuthBtn(){
		return getElement("/html/body/div[5]/div/div[2]/div[3]/a");
	}
	/**
	 * 验证进入实名认证页面，’真实姓名‘元素
	 */
	public ExtendWebElement authInfo(){
		return getElement("//*[@id='uploadFileForm']/div/div[2]/dl/dd/ul/li[2]/label");
	}
	/**
	 * 填写真实姓名
	 */
	public ExtendWebElement realNameInput(){
		return getElement("//input[@id='userName']");
	}
	/**
	 *填写身份证号
	 */
	public ExtendWebElement idNumberInput(){
		return getElement("//input[@id='idNumber']");
	}
	/**
	 * 上传身份证，个人信息所在面
	 */
	public ExtendWebElement idCardFront(){
		return getElement("//*[@id='idCardFront']");
	}
	/**
	 * 上传身份证，国徽所在面
	 */
	public ExtendWebElement idCardBack(){
		return getElement("//*[@id='idCardBack']");
	}
	/**
	 * 点击下一步
	 */
	public ExtendWebElement nextBtn(){
		return getElement("//*[@id='uploadFileForm']/div/div[2]/dl/dd/ul/li[11]/input[6]");
	}
	/**
	 * 申请实名认证提交后验证，申请已提交
	 */
	public ExtendWebElement submitInfo(){
		return getElement("/html/body/div[3]/div/p[1]");
	}
}
