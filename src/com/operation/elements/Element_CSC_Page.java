package com.operation.elements;

import org.openqa.selenium.WebDriver;

import com.cx.base.ExtendWebElement;
import com.cx.base.Locator;

public class Element_CSC_Page extends Locator{

	public Element_CSC_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 一级菜单
	 * @param firstMenu 一级菜单名称
	 * @return
	 */
	public ExtendWebElement leftsidebarXp(String firstMenu) {
		return getElement("//ul[@class='page-sidebar-menu']//span[contains(text(),'"+firstMenu+"')]");
	}
	
	/**
	 * 二级菜单
	 * @param secondMenu 二级菜单名称
	 * @return
	 */
	public ExtendWebElement secondMenu(String secondMenu) {		
		return getElement("//ul[@class='sub-menu']//a[contains(text(),'"+secondMenu+"')]");
	}
	
	/**
	 * pageinfo
	 */
	public ExtendWebElement pageInfo() {
		return getElement("//div[@class='page-container']/div/div/div/h3");
	}

}
