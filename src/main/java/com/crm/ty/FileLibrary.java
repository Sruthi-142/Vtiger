package com.crm.ty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileLibrary {
	public String readPropertyData(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IAutoConstants.propfilepath);
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key, "Incorrectkey");
		
	}
	
	public String readPropertyData(String key, String path) throws IOException {
		FileInputStream fis=new FileInputStream(path);
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key, "Incorrectkey");
		
	}

}

