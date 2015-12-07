package com.cx.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cx.bean.Config;
import com.cx.util.Log;
import com.cx.util.ScreenShot;

public class Locator {
	
	protected WebDriver driver;
	
    ScreenShot screenshot;
	 
	public Locator(WebDriver driver) {        
        this.driver = driver;
        screenshot = new ScreenShot(this.driver);       
    }
 
    
    private By getBy(String type, String value) {
        By by = null;
        if (type.equals("id")) {
            by = By.id(value);
        }
        if (type.equals("name")) {
            by = By.name(value);
        }
        if (type.equals("xpath")) {
            by = By.xpath(value);
        }
        if (type.equals("className")) {
            by = By.className(value);
        }
        if (type.equals("linkText")) {
            by = By.linkText(value);
        }
        if(type.equals("css")){
        	by = By.cssSelector(value);
        }
        return by;
    }
	
	
    /**
	 * 判读指定元素是否存在
	 */
    public boolean isElementPresent(By by) { 
        try {
        	driver.findElement(by); 
            return true; 
        } catch (NoSuchElementException e) { 
            return false; 
        } 
    }
    
    /**
	 * 等待指定元素出现
	 */
    private boolean watiForElement(final By by) {
        int waitTime = Config.waitTime;
        boolean flag = false;
        try {
                flag = new WebDriverWait(driver, waitTime).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return isElementPresent(by);
                }
            });
        } catch (Exception e) {
            Log.logInfo(by.toString() + " is not exist until " + waitTime);
            screenshot.takeScreenshot();
        }
        return flag;
    }   
    
    /**
	 * 等待指定元素在页面显示
	 */
    private boolean waitElementToBeDisplayed(final ExtendWebElement element) {
        boolean wait = false;
        if (element == null)
            return wait;
        try {        	
            wait = new WebDriverWait(driver, Config.waitTime).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver d) {
                    return element.isDisplayed();
                }
            });
        } catch (Exception e) {        	
            Log.logInfo(element.toString() + " is not displayed");
            screenshot.takeScreenshot();
        }
        return wait;
    }
    
    /**
	 * 等待指定页面元素在页面消失 
	 */
    public boolean waitElementToBeNonDisplayed(final ExtendWebElement element) {
        boolean wait = false;
        if (element == null)
            return wait;
        try {
            wait = new WebDriverWait(driver,Config.waitTime).until(new ExpectedCondition<Boolean>() {
                        public Boolean apply(WebDriver d) {
                            return !element.isDisplayed();
                        }
                    });
        } catch (Exception e) {
            Log.logInfo(element.toString() + " is also displayed");
            screenshot.takeScreenshot();
        }
        return wait;
    }
    
    /**
	 * 获取页面元素
	 */
    private ExtendWebElement getLocator(String type,String locator,String replace, boolean wait) {
		ExtendWebElement element = null;
		if (replace != null)
             locator = this.setLocatorVariableValue(locator, replace);
         By by = this.getBy(type,locator);
         if (wait) {
        	 if(this.watiForElement(by)){
        		element = new ExtendWebElement(this.driver, by);
        		boolean flag = this.waitElementToBeDisplayed(element);                 
        		if (!flag)
                    element = null;
        	 }
             
         } else {
             try {
            	element = new ExtendWebElement(this.driver, by);
             } catch (Exception e) {
                 element = null;
                 screenshot.takeScreenshot();
             }
         }  
         return element;
}

    
    private ExtendWebElement getLocator(String locator,String replace, boolean wait) {
    	 return getLocator("xpath",locator,replace,wait);
    }
    

		
    /**
	 * 等待页面元素显示后获取页面元素
	 */
    public ExtendWebElement getElement(String by) {
        return this.getLocator(by, null, true);
    }
    
    /**
   	 * 不等待，直接获取页面元素
   	 */
    public ExtendWebElement getElementNoWait(String by) {
        return this.getLocator(by, null, false);
    }
    
    /**
   	 * 等待页面元素显示后获取页面元素，xpath中可参数化
   	 */
    public ExtendWebElement getElement(String by, String replace) {
        return this.getLocator(by, replace, true);
    }
     
    public ExtendWebElement getElementNoWait(String by, String replace) {
        return this.getLocator(by, replace, false);
    }
    
    /**
   	 * 替换变量
   	 */
    public String setLocatorVariableValue(String by, String value){
    	String newby;
    	newby = by.replaceAll("%variable%", value);
    	return newby;                     
    }    
    
 
    
    

	
}
