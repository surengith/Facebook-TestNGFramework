package com.Property.org;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Configuration_Reader {
	
	public static Properties p;

	public Configuration_Reader() throws IOException {
		
		File f = new File("C:\\Users\\Surendhar\\eclipse-workspace\\SelectorHub\\src\\main\\java\\com\\Property\\org\\sel.property");
		FileInputStream fis = new FileInputStream(f);
		p = new Properties();
		p.load(fis);
		
	}
	
	public static String getBrowser() {
		String property = p.getProperty("browser");
		return property;

	}
	
	public static String getUrl() {
		String url = p.getProperty("url");
		return url;
	}
	
	public static String getEmail() {
		String email = p.getProperty("email");
		return email;
	}

	public static String getPassword() {
		String password = p.getProperty("password");
		return password;
	}
	
	public static String getcompany() {
		String company = p.getProperty("company");
		return company;
	}
	
	public static String getmobilenumber() {
		String mobilenumber = p.getProperty("mobilenumber");
		return mobilenumber;
	}
	
}
