package com.cx.base;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.cx.bean.Config;
import com.cx.bean.Global;
import com.cx.util.ParseXml;
import com.cx.util.ScreenShot;
import com.cx.util.Util;

public class TestBase {	
	
	protected static WebDriver driver;
	
	private ParseXml px;
	
	private Map<String, String> commonMap;
	
	public static ScreenShot screenShot;
	
	private void initialPx(){
		if(px==null){			
			px = new ParseXml("test-data/"+this.getClass().getSimpleName()+".xml");
		}
	}
	
	private void getCommonMap(){
		if(commonMap==null){			
			Element element = px.getElementObject("/*/common");
			commonMap = px.getChildrenInfoByElement(element);
		}
	}
	
	private Map<String, String> getMergeMapData(Map<String, String> map1, Map<String, String> map2){
		Iterator<String> it = map2.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			String value = map2.get(key);
			if(!map1.containsKey(key)){
				map1.put(key, value);
			}
		}
		return map1;
	}
	
	@DataProvider
    public Object[][] providerMethod(Method method){	
		this.initialPx();
		this.getCommonMap();
		String methodName = method.getName();
		List<Element> elements = px.getElementObjects("/*/"+methodName);
		Object[][] object = new Object[elements.size()][];
		for (int i =0; i<elements.size(); i++) {
			Map<String, String> mergeCommon = this.getMergeMapData(px.getChildrenInfoByElement(elements.get(i)), commonMap);
			Map<String, String> mergeGlobal = this.getMergeMapData(mergeCommon, Global.global);
			Object[] temp = new Object[]{mergeGlobal};
			object[i] = temp;
		}
		return object;
	}
	
	@BeforeClass
	public void initialDriver(){
		SeleniumDriver selenium = new SeleniumDriver();
		driver = selenium.getDriver();
	}
	
	@AfterClass
	public void closeDriver(){
		if(driver!=null){
			driver.close();
			driver.quit();
		}
	}
	
	public void goTo(String url){
		driver.get(url);		
		if(Config.browser.equals("chrome")){
			Util.sleep(1);
		}
	}
	
	public static String takeScreenShot(){
		screenShot = new ScreenShot(driver); 
		return screenShot.takeScreenshot();
	}
}
