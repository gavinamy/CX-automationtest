package com.operation.business;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.cx.base.BasePage;
import com.cx.util.ConnectMySQL;
import com.cx.util.Log;
import com.cx.util.Util;
import com.operation.elements.Element_ReAndLogin_Page;

/**
 * 常规登录注册页面
 * @author gavin
 *
 */
public class ReAndLogin_Page extends BasePage {

	Element_ReAndLogin_Page ecp = new Element_ReAndLogin_Page(this.driver);
	public ReAndLogin_Page(WebDriver driver) {
		super(driver);
	}
	
	public static String phone = "";
	
	/**
	 * 常规登录
	 * @param homePageURL 主站url
	 * @param userNam 登录用户名
	 * @param pwd 登录密码
	 * @param loginInfo 登录成功后主站右上角用户信息
	 * @return 返回登录成功状态
	 */
	public boolean commonLogin(String homePageURL,String userNam,String pwd,String loginInfo) {
		boolean flag = false;
		this.goTo(homePageURL);
		Util.sleep(2);
		Log.stepInfo("点击弹窗关闭按钮");
		ecp.closeBtn().click();
		Util.sleep(1);
		Log.stepInfo("点击登录链接");
		ecp.loginBtn().click();
		Util.sleep(4);
		Log.stepInfo("输入用户名："+userNam);
		ecp.userName().click();
		ecp.userName().sendKeys(userNam);
		Log.stepInfo("输入密码："+pwd);
		ecp.passwd().click();
		ecp.passwd().sendKeys(pwd);
		Log.stepInfo("输入验证码:1111");
		ecp.valid().click();
		ecp.valid().sendKeys("1111");
		Log.stepInfo("点击登录按钮");
		ecp.loginApply().click();
		Util.sleep(4);
		try {
			if(ecp.userInfo().getText().startsWith(loginInfo))
				flag = true;
		}catch(NoSuchElementException e) {
			Log.logError("可能登录失败，请看日志！");
		}
		return flag;
	}
	
	/**
	 * 快速登录
	 * url:http://car.sit.com/product/1010001665.htm
	 */
	public boolean quickLogin(String quickUrl,String quickUsername,String quickPassword) {
		boolean flag = false;		
		this.goTo(quickUrl);
		Log.stepInfo("点击立即下定按钮");
		ecp.orderNowBtn().click();
		Util.sleep(2);
		driver.switchTo().frame("inneriframe");
		Log.stepInfo("输入用户名："+quickUsername);
		ecp.quickUsername().click();
		ecp.quickUsername().sendKeys(quickUsername);
		Log.stepInfo("输入密码："+quickPassword);
		ecp.quickPassword().click();
		ecp.quickPassword().sendKeys(quickPassword);
		Log.stepInfo("点击登录按钮");
		ecp.quickLoginBtn().click();
		Util.sleep(2);
		String topInfo = ecp.quickRegisterSuccessInfo().getText();
		if(topInfo.startsWith("user")) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 常规注册
	 * @param homePageURL 主站URL
	 * @param accountNum 注册用户名
	 * @param setPwd 注册密码
	 * @param confirmPwd 注册密码确认
	 * @param validBtn 获取验证码按钮
	 * @return 返回注册状态
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */
	public boolean commonRegister(String homePageURL,String setPwd,
			String loginPage_url, String username, 
			String password, String loginInfo, String firstMenu,String secondMenu) 
					throws InterruptedException, AWTException {
		boolean flag = false;
		this.driver.get(homePageURL);
		Log.stepInfo("获取当前窗口句柄");
		String homeWindow = this.driver.getWindowHandle();
		Log.logInfo("当前窗口句柄为："+homeWindow);		
		Util.sleep(2);
		Log.stepInfo("点击弹窗关闭按钮");
		ecp.closeBtn().click();
		Util.sleep(1);
		Log.stepInfo("点击注册链接");
		ecp.registerBtn().click();
		Util.sleep(4);
		this.phone = this.phoneNum();
		Log.stepInfo("输入车享账号："+phone);
		ecp.accountNum().click();
		ecp.accountNum().sendKeys(phone);
		Log.stepInfo("输入设置密码："+setPwd);
		ecp.setPwd().click();
		ecp.setPwd().sendKeys(setPwd);
		Log.stepInfo("输入确认密码："+setPwd);
		ecp.confirmPwd().click();
		ecp.confirmPwd().sendKeys(setPwd);
		Log.stepInfo("输入图片验证码");
		ecp.imageValid().click();
		ecp.imageValid().sendKeys("1111");
		Log.stepInfo("点击获取验证码按钮:");
		ecp.validBtn().click();
		Util.sleep(2);
		this.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		Set<String> windowHandles = this.driver.getWindowHandles();
		for(String ss:windowHandles) {
			if(!ss.equals(homeWindow)) {
				this.driver.switchTo().window(ss);
			}
		}
		String cscWindow = this.driver.getWindowHandle();
//		this.driver.get(csc_url);
//		String cscWindow = this.driver.getWindowHandle();
		String validValue = this.getValidValue(loginPage_url, username, password, 
				loginInfo, firstMenu, secondMenu, phone);
		Set<String> windowHandles1 = this.driver.getWindowHandles();
		for(String ss:windowHandles1) {
			if(!ss.equals(cscWindow)) {
				this.driver.switchTo().window(ss);
			}
		}
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		//输入获得的验证码
		Util.sleep(1);
		driver.switchTo().defaultContent();
		Log.stepInfo("输入验证码："+validValue);
		ecp.validInput().click();
		ecp.validInput().sendKeys(validValue);
		Log.stepInfo("点击立即注册按钮");
		ecp.registerNowBtn().click();
		Util.sleep(4);
		Log.stepInfo("获取成功注册后信息");
		try {
			String text = ecp.registerSuccessInfo().getText();
			Log.logInfo(text);
			if(text.equals("恭喜您成为车享会员")) {
				flag = true;
			}
		}catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 快速注册
	 * @throws InterruptedException 
	 * @throws AWTException 
	 */
	public boolean quickRegister(String quickUrl,String quickRegPassword,
			String loginPage_url, String username, String password, 
			String loginInfo, String firstMenu, String secondMenu) throws InterruptedException, AWTException {
		boolean flag = false;		
		this.goTo(quickUrl);
		String homeWindow = this.driver.getWindowHandle();
		Log.stepInfo("点击立即下定按钮");
		ecp.orderNowBtn().click();
		Util.sleep(2);
		Log.stepInfo("切换iframe");
		this.driver.switchTo().frame("inneriframe");
		Log.stepInfo("点击新用户快速注册tab");
		ecp.quickRegTab().click();
		Util.sleep(2);
		this.phone = this.phoneNum();
		Log.stepInfo("输入用户名"+phone);
		ecp.quickRegUsername().click();		
		ecp.quickRegUsername().sendKeys(phone);
		Log.stepInfo("输入设置密码");
		ecp.quickRegPassword().click();
		ecp.quickRegPassword().sendKeys(quickRegPassword);
		Log.stepInfo("输入验证码1111");
		ecp.quickRegImageVal().sendKeys("1111");
		Log.stepInfo("点击获取验证码按钮");
		ecp.qucikValidBtn().click();
		Util.sleep(1);
		this.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		Set<String> windowHandles = this.driver.getWindowHandles();
		for(String ss:windowHandles) {
			if(!ss.equals(homeWindow)) {
				this.driver.switchTo().window(ss);
			}
		}
		String cscWindow = this.driver.getWindowHandle();
//		this.driver.get(csc_url);
//		String cscWindow = this.driver.getWindowHandle();
		String validValue = this.getValidValue(loginPage_url, username, password, 
				loginInfo, firstMenu, secondMenu, phone);
		Set<String> windowHandles1 = this.driver.getWindowHandles();
		for(String ss:windowHandles1) {
			if(!ss.equals(cscWindow)) {
				this.driver.switchTo().window(ss);
			}
		}
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		//输入获得的验证码
		Util.sleep(1);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("inneriframe");
		Log.stepInfo("输入验证码："+validValue);
		ecp.quickValidInput().sendKeys(validValue);
		//点击立即注册按钮
		Util.sleep(1);
		ecp.quickRegisterBtn().click();
//		Util.sleep(1);
//		this.driver.navigate().refresh();
		Util.sleep(3);
		String topInfo = ecp.quickRegisterSuccessInfo().getText();
		Log.logInfo(topInfo);
		if(topInfo.startsWith("user")) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 获取验证码
	 * @param loginPage_url cscurl
	 * @param username csc登录用户名
	 * @param password csc登录密码
	 * @param loginInfo csc登录成功信息
	 * @param firstMenu 一级菜单名称
	 * @param secondMenu 二级菜单名称
	 * @param accountSearNum 需要查找的手机号
	 * @return 返回查询得到的验证码
	 * @throws InterruptedException
	 */
	public String getValidValue(String loginPage_url,String username,
			String password,String loginInfo,String firstMenu,String secondMenu,
			String accountSearNum) throws InterruptedException {
		String validValue = "";
		CSC_LoginOutPage cl = new CSC_LoginOutPage(this.driver);
		cl.LoginAndVerify(loginPage_url, username, password, loginInfo);
		Util.sleep(3);
		CSC_Page cp = new CSC_Page(this.driver);
		cp.clickSecondMenu(firstMenu, secondMenu);
		Util.sleep(3);
		Log.stepInfo("输入需要查询的手机号："+accountSearNum);
		ecp.iphoneNum().click();
		ecp.iphoneNum().sendKeys(accountSearNum);
		Log.stepInfo("点击查询按钮");
		ecp.searchBtn().click();
		Util.sleep(2);
		Log.stepInfo("获取验证码：");
		validValue = ecp.validCSC().getAttribute("value");	
		Log.logInfo("验证码是："+validValue);
		return validValue;
	}
	
	public boolean forgotPsw(String forgotUrl,String forgotAccNo,
			String newPsw) {
		boolean flag = false;		
		this.goTo(forgotUrl);
		String homeWindow = this.driver.getWindowHandle();
		Log.stepInfo("输入忘记密码的账号");
		ecp.forgotAccNo().click();
		ecp.forgotAccNo().sendKeys(forgotAccNo);
		Log.stepInfo("输入图形验证码");
		ecp.forgotImageValid().click();
		ecp.forgotImageValid().sendKeys("1111");
		Log.stepInfo("点击下一步按钮");
		ecp.forgotNextStep().click();
		Util.sleep(2);
		Log.stepInfo("点击获取验证码按钮");
		ecp.getForgotValidBtn().click();
		/**获取验证码*/
		String validValue = "";
		
		Log.stepInfo("输入验证码");
		ecp.forgotValidInput().click();
		ecp.forgotValidInput().sendKeys(validValue);
		Log.stepInfo("点击下一步按钮");
		ecp.forgotNextBtns().click();
		Util.sleep(2);
		Log.stepInfo("输入新密码");
		ecp.newPsw().click();
		ecp.newPsw().sendKeys(newPsw);
		Log.stepInfo("再次确认密码");
		ecp.confirmPsw().click();
		ecp.confirmPsw().sendKeys(newPsw);
		Log.stepInfo("点击下一步按钮");
		ecp.nextBtna().click();
		String successInfo = ecp.forgotSuccessInfo().getText();
		String expectedsuccessInfo = "恭喜您！密码已为您找回咯";
		if(successInfo.equals(expectedsuccessInfo)) {
			flag = true;
		}		
		return flag;
	}
	
	/**
	 * 清除注册后的数据，包括:
	 * SSO库：t_user,t_user_alias
	 * MDM库:t_phone,t_user,t_user_bind
	 * @param registerNum
	 * @return
	 * @throws SQLException
	 */
	public boolean dataClear(String registerNum) throws SQLException {
		boolean flag = false;
		String userIds = "select user_id from t_user_alias where alias_name='"+registerNum+"';";
		ConnectMySQL
        .connect("10.32.173.250/sso", "sso", "sso");
		String userId = ConnectMySQL.query(userIds).get(0).get("user_id");
		String[] sqlsSSO = new String[]{"delete from t_user_alias where user_id='"+userId+"';",
				"delete from t_user where user_id='"+userId+"';"};
		String[] sqlsMDM = new String[]{"delete from t_phone where user_id='"+userId+"';",
				"delete from t_user where user_id='"+userId+"';",
				"delete from t_user_bind where user_id='"+userId+"';",};
		ConnectMySQL
        .connect("10.32.173.250/sso", "sso", "sso");
		int[] a = ConnectMySQL.dbExecute(sqlsSSO);
		ConnectMySQL.close();
		ConnectMySQL
        .connect("10.32.173.250/mdmuser", "mdmuser", "mdmuser");
		int[] b = ConnectMySQL.dbExecute(sqlsMDM);
		if(a.length+b.length==5){
			flag = true;
		}			
		return flag;
	}
	
	/**
	 * 
	 * @param args
	 * @throws SQLException
	 */
	public String phoneNum() {
		String phone = "";
		phone = "135"+((int)(Math.random()*89999999)+10000000);
		String sql = "select * from t_user_alias where alias_name='"+phone+"';";
		ConnectMySQL
        .connect("10.32.173.250/sso", "sso", "sso");
		List<HashMap<String,String>> ll = ConnectMySQL.query(sql);
		if(!ll.isEmpty()) {
			phone = "135"+(int)(Math.random()*100000000);
		}		
		ConnectMySQL.close();
		return phone;
	}
	
	
	public static void main(String[] args) throws SQLException {
		//Log.logInfo(phoneNum());
		
	}
}
