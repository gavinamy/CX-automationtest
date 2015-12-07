package com.cx.bean;

import java.util.Map;

import com.cx.util.ParseXml;

public class Global {
	
	public static Map<String, String> global;
	
	static{
		ParseXml px = new ParseXml("test-data/global.xml");
		global = px.getChildrenInfoByElement(px.getElementObject("/*"));
	}
	
}
