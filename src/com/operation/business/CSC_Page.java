package com.operation.business;

import org.openqa.selenium.WebDriver;

import com.cx.base.BasePage;
import com.cx.util.Log;
import com.cx.util.Util;
import com.operation.elements.Element_CSC_Page;

public class CSC_Page extends BasePage{

	Element_CSC_Page ep;
	
	public CSC_Page(WebDriver driver) {
		super(driver);
		ep = new Element_CSC_Page(driver);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 二层子菜单
	 * @param firstMenu 一级菜单名称
	 * @param secondMenu 二级菜单名称
	 */
	public int clickSecondMenu(String firstMenu,String secondMenu) {
		int compareResult = 0;
		Log.logInfo("点击一级菜单："+firstMenu);
		ep.leftsidebarXp(firstMenu).click();
		Util.sleep(1);
		Log.logInfo("点击二级子菜单："+secondMenu);
		ep.secondMenu(secondMenu).click();
		Util.sleep(4);
	    Log.logInfo("登录完成后，页面显示信息:"+pageInfo()); 
	    if (!(pageInfo().contains("退还记录"))) {
	    	compareResult++;
            Log.logInfo("页面项验证compareResult=:"+ compareResult);
            Log.logInfo("页面显示和期望不匹配:"+"实际-"+pageInfo()+";期望-退还记录"); 
        }
		return compareResult;
	}
	
	public String pageInfo() {
		String text = "";
		text = ep.pageInfo().getText();		
		return text;
	}

}
