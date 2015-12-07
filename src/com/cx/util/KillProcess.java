package com.cx.util;
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class KillProcess {
	
	public static void killProcess(String processName){
		try{
			String[] cmd ={ "tasklist"};
            Process proc = Runtime.getRuntime().exec(cmd);
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));                        
            String string_Temp = in.readLine();
            while (string_Temp != null)
            {
               if(string_Temp.indexOf(processName)!=-1)
                	Runtime.getRuntime().exec("Taskkill /IM " + processName);
               string_Temp = in.readLine();           	                       
            }
           }catch (Exception e){
        	   Log.logInfo(e.getMessage());
        }			
	}

}
