package com.operation.elements;

import org.openqa.selenium.WebDriver;
import com.cx.base.ExtendWebElement;
import com.cx.base.Locator;

public class Element_Fo_CxfVehicleAuthen extends Locator{
	public Element_Fo_CxfVehicleAuthen(WebDriver driver){
		super(driver);
	}		
	
	/**
	 * 验证用户没有进行车认证：还不是车享认证会员
	 */
	public ExtendWebElement verifyVehicleInfo(){
		return getElement("//*[@id='mainForm']/div/div/div[1]/div[1]/dl/dd[4]/div/div[1]");
	}
	/**
	 * 判断’立即认证‘按钮是否存在
	 */
	public ExtendWebElement verifyVehicleBtnInfo(){
		return getElement("//*[@id='mainForm']/div/div/div[1]/div[1]/dl/dd[4]/div/span");
	}
	/**
	 * 安全中心-点击‘立即认证’按钮
	 */
	public ExtendWebElement openCertBtnClick(){
		return getElement("//*[@id=\"mainForm\"]/div/div/div[1]/div[1]/dl/dd[4]/div/span/a");
	}
	/**
	 *点击‘立即认证’按钮
	 */
	public ExtendWebElement certBtnClick(){
		return getElement("//*[@id=\"mainForm\"]/div/div/div[1]/div[1]/dl/dd[4]/div/span/a");
	}
	/**
	 * 判断是否进入页面，验证’昵称‘元素
	 */
	public ExtendWebElement verifyJumpPageInfo(){
		return getElement("//*[@id='subFileName']/div/ul/li[1]/label");
	}
	/**
	 * 输入昵称
	 */
	public ExtendWebElement nickNameInput(){
		return getElement("//*[@id=\"userName\"]");
	}
	/**
	 * 点击下一步
	 */
	public ExtendWebElement oneNextBtnClick(){
		return getElement("//*[@id=\"subFileName\"]/div/ul/li[3]/input[1]");		
	}
	/**
	 * 判断是否进入页面，验证’品牌车系‘元素
	 */
	public ExtendWebElement verifySubPageInfo(){
		return getElement("//*[@id='confiAuthe']/dl/dd[1]/div[1]/div[1]");
	}
	/**
	 * 下拉选择品牌
	 */
	public ExtendWebElement brandType(){		
		return getElement("//*[@id='brand-type-icon-container']");		
	}
	public ExtendWebElement brandSelect(){		
		return getElement("//*[@id='brand-type-ul']/li[7]");		
	}	
	/**
	 * 下拉选择车系
	 */
	public ExtendWebElement seriesType(){
		return getElement("//*[@id=\"car-type-icon-container\"]");
	}
	public ExtendWebElement seriesSelect(){
		return getElement("//*[@id=\"car-type-ul\"]/li[5]");
	}
	/**
	 * 上传选择文件
	 */
	public ExtendWebElement fileUpload(){
		return getElement("//input[@id='scfile']");
	}
	/**
	 * 输入车主姓名
	 */
	public ExtendWebElement ownerNameInput(){
		return getElement("//*[@id=\"owerName\"]");
	}
	/**
	 * 输入车牌号
	 */
	public ExtendWebElement carCodeInput(){
		return getElement("//*[@id=\"licenseCode\"]");
	}
	/**
	 * 输入VIN码
	 */
	public ExtendWebElement vinCodeInput(){
		return getElement("//*[@id=\"vinCode\"]");
	}
	/**
	 * 输入发动机号
	 */
	public ExtendWebElement engineCodeInput(){
		return getElement("//*[@id=\"engineCode\"]");
	}
	/**
	 * 选择注册日期
	 */
	public ExtendWebElement datePurchased(){
		return getElement("//*[@id=\"datePurchased\"]");
	}
	/**
	 * 点击下一步
	 */
	public ExtendWebElement nextBtnClick(){
		return getElement("//*[@id=\"subFileForm\"]");
	}
	/**
	 * 提交会员认证信息
	 */
	public ExtendWebElement verifySubInfo(){
		return getElement("/html/body/div[3]/div/p[1]");
	}
}
