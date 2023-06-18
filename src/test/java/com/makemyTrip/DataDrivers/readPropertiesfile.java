package com.makemyTrip.DataDrivers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

public class readPropertiesfile {
	
	public static String readData(String propertyName) throws Exception {
		String Output = "";
		try {
			InputStream input;
			input = new FileInputStream("DataFolder/testData.properties");
			Properties prop = new Properties();
			try {
				prop.load(input);
				
				Output = prop.getProperty(propertyName);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return Output;
	}
}
