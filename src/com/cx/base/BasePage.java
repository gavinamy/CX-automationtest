package com.cx.base;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cx.util.Log;

public class BasePage {
	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {		
		this.driver = driver;		
	}
	/**
	 * 最大化浏览器
	 */
	public void maximize(){
		this.driver.manage().window().maximize();
	}
	
	/**
	 * 页面跳转到指定url
	 */
	public void goTo(String url){
		Log.logInfo("页面跳转到：" + url);
		//deleteCookies();
		try{
			this.driver.get(url);
		}catch(TimeoutException e){
			Log.logInfo(e.getMessage());
		}								
	}
	
	/**
	 * 获得当前页面的url
	 */
	public String getcurrentUrl(){
		Log.logInfo("获取当前页面的url" );
		return this.driver.getCurrentUrl();
	}
	
	/**
	 * 获得当前页面的标题
	 */
    public String getTitle(){
    	Log.logInfo("获取当前页面的标题" );
    	return this.driver.getTitle();
    }
    
	/**
	 * 关闭浏览器 
	 */
    public void close(){
    	Log.logInfo("关闭当前页面" );
    	this.driver.close();
    }
    
	/**
	 * 刷新页面
	 */
    public void refresh(){
    	Log.logInfo("刷新当前页面" );
    	try{
			this.driver.navigate().refresh();
		}catch(TimeoutException e){
			Log.logInfo(e.getMessage());
			
		}
    }
    
	/**
	 * 获得cookies
	 */
    public Set<Cookie> getCookies(){
    	return this.driver.manage().getCookies();
    }
    
    public Cookie getCookie(String name){
    	Log.logInfo("获取cookie" );
    	return this.driver.manage().getCookieNamed(name);
    }
	/**
	 * 删除cookies
	 */
    public void deleteCookies(){
    	Log.logInfo("删除cookie" );
    	this.driver.manage().deleteAllCookies();
    }
    
	/**
	 * 删除指定cookies
	 */
    public void deleteCookie(String name){
    	Log.logInfo("删除name为：" + name + "cookie");
    	this.driver.manage().deleteCookieNamed(name);
    }
    
    /**
	 * 添加cookies
	 */
    public void addCookie(Cookie cookie){
    	Log.logInfo("添加cookie" );
    	this.driver.manage().addCookie(cookie);
    }
    
//    切换到新开窗口,仅支持两个窗口切换
    public void switchWindow(){
    	Log.logInfo("切换到新开窗口" );
    	String nowHandle = this.driver.getWindowHandle();
    	Set<String> handles = this.driver.getWindowHandles();
    	for(String handle : handles){
    		if(handle != nowHandle){
    			this.driver.switchTo().window(handle);
    		}
    	}
    }
    /**
	 * 切换到指定handle窗口
	 */
    public void swithcWindow(String handle){
    	Log.logInfo("切换到handle为：" + handle + "的窗口" );
    	this.driver.switchTo().window(handle);
    } 
    
    /**
	 * 页面前进
	 */
    public void forward(){
    	Log.logInfo("操作浏览器前进按钮" );
    	this.driver.navigate().forward();
    }
    
    /**
	 * 页面后退
	 */
    public void back(){
    	Log.logInfo("操作浏览器后退按钮" );
    	this.driver.navigate().back();
    }
    
    /**
	 * 页面滚动到指定元素的位置
	 */
    public void scrollTo(ExtendWebElement element){
    	Log.logInfo("将页面滚动到指定元素的位置");
    	((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();",element);
    }
    
    /**
	 * alert框中点击“确定”按钮
	 */
    public void acceptAlert(){
    	Log.logInfo("确定alert框" );
    	Alert alert = this.driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
    }
    
    /**
	 * alert框中点击“取消”按钮
	 */
    public void dismissAlert(){
    	Log.logInfo("取消alert框" );
    	Alert alert = this.driver.switchTo().alert();
        alert.dismiss();
        driver.switchTo().defaultContent();
    }
    
    /**
	 * 从frame中切换回来
	 */
    public void frameBack(){
        driver.switchTo().defaultContent();
    }
    
}
