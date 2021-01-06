package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = "configs//Configuration.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {

			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			}catch (IOException e) {
				e.printStackTrace();
			}

		}catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);

		}

	}

	public String getDriverPath() {
		//String currentDirectory = System.getProperty("user.dir");
		String driverpath = properties.getProperty("driverPath");
		if(driverpath != null) return driverpath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		

	}

	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	

	public String getName() {
		String name = properties.getProperty("name");
		if(name != null) return name;
		else throw new RuntimeException("name not specified in the Configuration.properties file.");
	}
	
	public String getcountry() {
		String country = properties.getProperty("country");
		if(country != null) return country;
		else throw new RuntimeException("country not specified in the Configuration.properties file.");
	}
	
	public String getcity() {
		String city = properties.getProperty("city");
		if(city != null) return city;
		else throw new RuntimeException("city not specified in the Configuration.properties file.");
	}
	
	public String getCartDeatils() {
		String card = properties.getProperty("card");
		if(card != null) return card;
		else throw new RuntimeException("card not specified in the Configuration.properties file.");
	}
	
	public String getMonth() {
		String month = properties.getProperty("month");
		if(month != null) return month;
		else throw new RuntimeException("month not specified in the Configuration.properties file.");
	}
	
	public String getYear() {
		String year = properties.getProperty("year");
		if(year != null) return year;
		else throw new RuntimeException("year not specified in the Configuration.properties file.");
	}
	
	
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
		else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}

	public String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		System.out.println(reportConfigPath);
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
	}
	


}