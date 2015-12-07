package com.cx.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.cx.util.Log;

public class ExtendWebElement {
	WebElement elm;
	protected WebDriver driver;
	Actions action;
	By by;
	public ExtendWebElement(WebDriver driver,By by){
		this.driver = driver;
		this.by = by;
		this.elm = this.driver.findElement(by);
		action = new Actions(this.driver);
	}
	
	public ExtendWebElement(WebElement element,By by){
		this.elm = element;
		this.elm = this.elm.findElement(by);
	}
	
   /**
	* 点击操作
	*/
	public void click(){
		Log.logInfo("click " + by.toString());
		elm.click();
	}
	
	/**
	* 通过javascript实现点击操作
	*/
	public void jsClick(){
		Log.logInfo("click " + by.toString());
		((JavascriptExecutor)driver).executeScript("$(arguments[0]).click()", elm);
	}
	
	/**
	* 清空输入框操作
	*/
	public void clear(){
		Log.logInfo("clear " + by.toString());
		elm.clear();
	}
	
	/**
	* 向输入框输入内容
	*/
	public void sendKeys(String text){
		Log.logInfo("sendKeys the content '" + text + "' to" + by.toString());
		elm.sendKeys(text);
	}
	
	/**
	* 提交表单操作
	*/
	public void submit(){
		Log.logInfo("submit" + by.toString());
		elm.submit();
	}
	
	/**
	* 获取页面元素的属性值
	*/
	public String getAttribute(String attribute){
		return elm.getAttribute(attribute);
	}
	
	/**
	* 获取页面元素的css值
	*/
	public String getCssValue(String propertyName){
		return elm.getCssValue(propertyName);
	}
	
	/**
	* 获取页面元素的坐标
	*/
	public Point getLocation(){
		return elm.getLocation();
	}
	
	/**
	* 获取页面元素在页面上的大小
	*/
	public Dimension getSize(){
		return elm.getSize();
	}
	
	/**
	* 获取页面元素的Tag名称
	*/
	public String getTagName(){
		return elm.getTagName();
	}
	
	/**
	* 获取页面元素的文本信息
	*/
	public String getText(){
		return elm.getText();
	}
	
	/**
	* 判断页面元素在页面上是否显示
	*/
	public boolean isDisplayed(){
		Log.logInfo("判断" + by.toString() + "是否显示");
		return elm.isDisplayed();	
	}
	
	/**
	* 判断页面元素是否可操作状态
	*/
	public boolean isEnabled(){
		Log.logInfo("判断" + by.toString() + "是否可操作");
		return elm.isEnabled();
	}
	
	/**
	* 判断页面元素是否被选中
	*/
	public boolean isSelected(){
		Log.logInfo("判断" + by.toString() + "是否被选中");
		return elm.isSelected();
	}
	
	/**
	* 切换到指定的iframe
	*/
	public void switchToFrame(){
		Log.logInfo("切换" + by.toString() + "是否被选中");
		this.driver.switchTo().frame(elm);
	}
	
	/**
	* 模拟按键按下
	*/
	public void keyDown(Keys key){
		Log.logInfo("按下按键： " + by.toString());
		action.keyDown(key).perform();;
	}
	
	/**
	* 模拟按键弹起
	*/
	public void keyUp(Keys key){
		Log.logInfo("按键弹起： " + by.toString());
		action.keyDown(key).perform();
	}
	

	/**
	* 鼠标左键双击
	*/
	public void doubleClick(){
		Log.logInfo("左键双击： " + by.toString());
		action.doubleClick(elm).perform();
	}
	
	/**
	* 鼠标左键点击住不放
	*/
	public void clickAndHold(){
		Log.logInfo("左键点击住不放： " + by.toString());
		action.clickAndHold(elm).perform();
	}
	
	/**
	* 鼠标左键弹起
	*/
	public void release(){
		Log.logInfo("鼠标左键弹起： " + by.toString());
		action.release(elm).perform();
	}
		
	/**
	* 鼠标移动到元素的中心点
	*/
	public void moveToElement(){
		Log.logInfo("鼠标移动到元素： " + by.toString());
		action.moveToElement(elm).perform();
	}
	
	/**
	* 鼠标右键点击
	*/
	public void contextClick(){
		Log.logInfo("鼠标右键点击： " + by.toString());
		action.contextClick(elm).perform();
	}
	
	/**
	* 拖拽
	*/
	public void dragAndDrop(WebElement targetElement){
		Log.logInfo("鼠标拖拽： " + by.toString() + "到" + targetElement);
		action.dragAndDrop(elm, targetElement).perform();
	}

	/**
	* 下拉框操作：通过下拉列表中选项的索引选中
	*/
    public void selectByIndex(int index){
    	Log.logInfo("选择下拉框  " + by.toString() + "下的第" + index + "的元素");
    	Select selectAge = new Select(elm);
    	selectAge.selectByIndex(index);
    }
     
	/**
	* 下拉框操作：通过下拉列表中的选项的value属性选择
	*/
    public void selectByValue(String value){
    	Log.logInfo("选择下拉框  " + by.toString() + "下的value属性" + value + "的元素");
    	Select selectShen = new Select(elm);
    	selectShen.selectByValue(value);
    }
     
	/**
	* 下拉框操作：通过下拉列表中选项的可见文本选 中
	*/
   public void selectByText(String text){
   	Log.logInfo("选择下拉框  " + by.toString() + "下的可见文本为：" + text + "的元素");
   	Select selectTown = new Select(elm);
   	selectTown.selectByVisibleText(text);
   }
   
     

}
