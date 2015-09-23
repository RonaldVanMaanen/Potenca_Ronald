package org.openqa.selenium.example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.Assert;

public class Test1
{	
	public static void main(String[] args) throws Exception 
	{
		StringFunctions sf = new StringFunctions();
		ClipBoardFunctions clp = new ClipBoardFunctions();
		FileIO io = new FileIO();
		DateFunctions df= new DateFunctions();
		Tests test = new Tests();
		Testlogging tl = new Testlogging();
		
		String url = "http://www.kvk.nl";
		String dataPath="G:\\Files\\Temp\\";
		String logfile = tl.createLogFileName(dataPath, "Testlog_" , ".txt");
		
		
		// The Firefox driver supports javascript 
        
    	//Internet Explorer
        //WebDriver driver = new InternetExplorerDriver();
        
        // FireFox
		WebDriver driver = new FirefoxDriver();
    	
    	// Start logging
    	tl.ToLog(logfile,"Start test");
    	tl.ToLog(logfile, "Opening URL");
    	
    	
        // Chrome
        //System.setProperty("webdriver.chrome.driver", "/Programming/Selenium webdriver");
        //WebDriver driver = new ChromeDriver();
        
        //------------------------------------
        // Go to the Google Suggest home page
        driver.get(url);
        test.waitPeriod(driver, 5);
        System.out.println(driver.getTitle());
        //test.titleCheck(logfile, driver, "NU - Het laatste nieuws het eerst op NU.nl");
        test.titleCheck(logfile, driver, "Kamer van Koophandel");
        
        // Controleren op cookie melding
        tl.ToLog(logfile, "Controleren op cookie melding");
        //test.waitForLinktextAndClick(logfile, driver, "Ja, dat mag van mij");
        test.waitForCssAndClick(logfile, driver, "button.yes");
        
        // Elementen controleren
        tl.ToLog(logfile, "Controleren op aanwezig zijn elementen.");
        //String[] array={"Net binnen","NU","NUzakelijk","NUzakelijk","NUsport"};
        //test.linkTextIsDisplayed(logfile, driver, array);)
        tl.ToLog(logfile, "Data keze uit bestand : Data1n.txt");
        tl.ToLog(logfile, "File Data1.text lezen");
        String[] array=io.ReadFileToString(dataPath, "Data1.txt").split(";");
        test.linkTextIsDisplayed(logfile, driver, array);
        tl.ToLog(logfile, "File Data2.text lezen");
        //String[] array2=io.ReadFileToString(dataPath, "Data2.txt").split(";");
        //test.nameIsDisplayed(logfile, driver, array2);
        
        // Zoeken op Cerios
        tl.ToLog(logfile, "Zoeken op : Cerios");
        driver.findElement(By.cssSelector("input.input")).sendKeys("Cerios"+Keys.ENTER);
        test.waitPeriod(driver, 5);
        // ,, Controleren op aantal verwachte resultaten.
        
        tl.ToLog(logfile, "Wachten op resultaten pagina");
        test.waitForCssSelection(logfile, driver, "div.shop > h1");
        
        tl.ToLog(logfile, "Controleren op 12 gevonden resultaten");
        String s=driver.findElement(By.cssSelector("span.results")).getText().toString();
        System.out.print("S="+s);
        test.stringVergelijking(logfile,s,"12 resultaten");
        
        //driver.findElement(By.linkText("Uittreksel")).click();
        //String[] array2={"icon-shop centered",};
        
        
        tl.ToLog(logfile,"Einde test");	
        test.checkResults(logfile);
        tl.ToLog(logfile,"-------------------------------------------");
        driver.quit();
        System.out.println("Klaar");
    }
}