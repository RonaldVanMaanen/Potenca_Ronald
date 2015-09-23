package org.openqa.selenium.example;

public class Testlogging 
{
	FileIO io = new FileIO();
	DateFunctions df= new DateFunctions();
	
	public void ToLog (String logfile, String line)
	{
		if (io.checkFileExists(logfile)==true)
		{
			io.AddStringToFile(logfile, df.buildDateTimeString()+" " +line);
		}
		else
		{
			io.WriteStringToFile(logfile, line);
		}
	}
	
	public String createLogFileName(String location, String baseName, String extension)
	{
		String logfile = location+baseName+df.buildDateTimeString()+extension;
		System.out.println(logfile);
		logfile=logfile.replace(":", "-");
		logfile=logfile.replace(" \\ ", "_");
		logfile=logfile.replace("-\\", ":\\");
		logfile=logfile.trim();
		System.out.println(logfile);
		return logfile;
	}
}
