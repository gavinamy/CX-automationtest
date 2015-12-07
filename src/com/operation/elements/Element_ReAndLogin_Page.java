package com.operation.elements;

import org.openqa.selenium.WebDriver;

import com.cx.base.ExtendWebElement;
import com.cx.base.Locator;

/**
 * 常规登录注册相关页面元素
 * @author gavin
 *
 */
public class Element_ReAndLogin_Page extends Locator {

	public Element_ReAndLogin_Page(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * 弹窗关闭按钮
	 */
	public ExtendWebElement closeBtn() {
		return getElement("//span[@class='pop-close']");
	}
	/**
	 * 主站登录按钮
	 */
	public ExtendWebElement loginBtn() {
		return getElement("//a[@class='login-bind'][contains(text(),'登录')]");
	}
	/**
	 * 主站注册按钮
	 */
	public ExtendWebElement registerBtn() {
		return getElement("//a[@class='register-bind'][contains(text(),'注册')]");
	}
	/**
	 * 常规登录
	 */
	/**
	 * 用户名输入框
	 */
	public ExtendWebElement userName() {
		return getElement("//input[@id='username']");
	}
	/**
	 * 密码输入框
	 */
	public ExtendWebElement passwd() {
		return getElement("//input[@id='passwd']");
	}
	/**
	 * 忘记密码链接
	 */
	public ExtendWebElement forgetPass() {
		return getElement("//a[@id='findpwda']");
	}
	/**
	 * 验证码输入框
	 */
	public ExtendWebElement valid() {
		return getElement("//input[@id='checkCode']");
	}
	/**
	 * 登录按钮
	 */
	public ExtendWebElement loginApply() {
		return getElement("//input[@id='submit']");
	}
	/**
	 * 主站登录成功后右上角用户头
	 */
	public ExtendWebElement userInfo() {
		return getElement("//div[@id='js-login-box']/dl/dd");
	}
	
	/**
	 * 常规注册
	 */
	/**
	 * 车享账号
	 */
	public ExtendWebElement accountNum() {
		return getElement("//input[@name='userName']");
	}
	/**
	 * 设置密码
	 */
	public ExtendWebElement setPwd() {
		return getElement("//input[@name='password']");
	}
	/**
	 * 确认密码
	 */
	public ExtendWebElement confirmPwd() {
		return getElement("//input[@name='newPassword']");
	}
	/**
	 * 图片验证码
	 */
	public ExtendWebElement imageValid() {
		return getElement("//input[@id='validCode']");
	}
	/**
	 * 验证码输入框
	 */
	public ExtendWebElement validInput() {
		return getElement("//input[@id='codeId']");
	}
	/**
	 * 获取验证码按钮
	 */
	public ExtendWebElement validBtn() {
		//return getElement("//span[@contains(text(),'获取验证码')]");
		return getElement("//span[@value='确定']");
	}
	/**
	 * 立即注册按钮
	 */
	public ExtendWebElement registerNowBtn() {
		//return getElement("//div[@class='registerbut']/input");
		return getElement("//input[@value='立即注册']");
	}
	/**
	 * 注册成功信息
	 */
	public ExtendWebElement registerSuccessInfo() {
		return getElement("//div[@class='register-infor']/h2");
	}
	
	/**
	 * CSC后台获取短信验证码页面相关元素
	 */
	/**
	 * 手机号输入框
	 */
	public ExtendWebElement iphoneNum() {
		return getElement("//input[@name='mobile']");
	}
	/**
	 * 验证码输入框
	 */
	public ExtendWebElement validCSC() {
		return getElement("//input[@name='vcode']");
	}
	/**
	 * 查询按钮
	 */
	public ExtendWebElement searchBtn() {
		return getElement("//input[@value='查询']");
	}
	
	
	/**
	 * 快速登录与注册
	 */
	/**
	 * 立即下定按钮
	 */
	public ExtendWebElement orderNowBtn() {
		return getElement("//button[@id='pc_product_order_1']");
	}
	/**
	 * 快速登录
	 */
	/**
	 * 用户名
	 */
	public ExtendWebElement quickUsername() {
		return getElement("//input[@id='userName']");
	}
	/**
	 * 密码
	 */
	public ExtendWebElement quickPassword() {
		return getElement("//input[@id='passWord']");
	}
	/**
	 * 登录按钮
	 */
	public ExtendWebElement quickLoginBtn() {
		return getElement("//input[@id='tijiaobtn']");
	}
	/**
	 * 登录成功后，右上角出现我的商城
	 */
	public ExtendWebElement quickLoginInfo() {
		return getElement("//a[@class='current']");
	}
	
	/**
	 * 快速注册
	 */
	/**
	 * 新用户快速注册tab
	 */
	public ExtendWebElement quickRegTab() {
		return getElement("//input[@id='toRegister']");
	}
	/**
	 * 用户名
	 */
	public ExtendWebElement quickRegUsername() {
		return getElement("//input[@id='mobile']");
	}
	/**
	 * 密码
	 */
	public ExtendWebElement quickRegPassword() {
		return getElement("//input[@id='passWord']");
	}
	/**
	 * 图形验证码输入框
	 */
	public ExtendWebElement quickRegImageVal() {
		return getElement("//input[@id='validCode']");
	}
	/**
	 * 验证码输入框
	 */
	public ExtendWebElement quickValidInput() {
		return getElement("//input[@id='authcode']");
	}
	/**
	 * 获取验证码按钮
	 */
	public ExtendWebElement qucikValidBtn() {
		return getElement("//input[@id='getauthcodebun']");
	}
	/**
	 * 注册按钮
	 */
	public ExtendWebElement quickRegisterBtn() {
		return getElement("//input[@id='tijiaobtn']");
	}
	/**
	 * 注册成功校验信息
	 */
	public ExtendWebElement quickRegisterSuccessInfo() {
		return getElement("//li[@id='userCenter']/a/span");
	}
	
	/**
	 * 忘记密码
	 * url:https://account.sit.com/account/findPassWord/passWordUserName.htm
	 */
	/**
	 * 账号
	 */
	public ExtendWebElement forgotAccNo() {
		return getElement("//input[@id='username']");
	}
	/**
	 * 图形验证码
	 */
	public ExtendWebElement forgotImageValid() {
		return getElement("//input[@id='indentycode']");
	}
	/**
	 * 下一步按钮
	 */
	public ExtendWebElement forgotNextStep() {
		return getElement("//input[@id='submit']");
	}
	/**
	 * 获取验证码按钮
	 */
	public ExtendWebElement getForgotValidBtn() {
		return getElement("//form[@id='findPassmobile']/ul/li[2]/span");
	}
	/**
	 * 验证码输入框
	 */
	public ExtendWebElement forgotValidInput() {
		return getElement("//input[@id='indentycode']");
	}
	/**
	 * 下一步按钮
	 */
	public ExtendWebElement forgotNextBtns() {
		return getElement("//input[@id='submit1']");
	}
	/**
	 * 新密码
	 */
	public ExtendWebElement newPsw() {
		return getElement("//input[@name='password']");
	}
	/**
	 * 再次确认
	 */
	public ExtendWebElement confirmPsw() {
		return getElement("//input[@name='newPassword']");
	}
	/**
	 * 下一步按钮
	 */
	public ExtendWebElement nextBtna() {
		return getElement("//input[@id='pwSubmit']");
	}
	/**
	 * 找回密码成功
	 * 成功信息：恭喜您！密码已为您找回咯
	 */
	public ExtendWebElement forgotSuccessInfo() {
		return getElement("//div[@class='revise']/div/strong");
	}
	
}
