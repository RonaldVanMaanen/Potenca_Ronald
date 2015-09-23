package org.openqa.selenium.example;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.Assert;

public class Tests
{
	FileIO io = new FileIO();
	Testlogging tl = new Testlogging();
	int aantalPogingen=5;
	
	int waitPeriods=5;
	int waitPeriodDuration=5;

	public boolean  waitForLinktextAndReport(String logfile, WebDriver object, String linktext)
	{
		boolean bFound=false;
		
		for (int i=0;i<aantalPogingen;i++)
        {
			object.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			tl.ToLog(logfile, "Poging="+(i+1));
        	try
        	{
        		if (object.findElement(By.linkText(linktext)).isEnabled()) 
                {
                	tl.ToLog(logfile, "Linktext ("+linktext+") gevonden -> Result=OK.");
                	object.findElement(By.linkText(linktext)).click();
                	bFound=true;
                	i=aantalPogingen;
                }
            	else
                {
            		tl.ToLog(logfile, "Linktext ("+linktext+") niet gevonden.");
                }
        	}
        	catch (Exception e)
        	{
        		
        		tl.ToLog(logfile, "Linktext ("+linktext+") niet gevonden -> Result=NOK.");
        		if (i==aantalPogingen-1)
        		{
        			tl.ToLog(logfile, e.toString());
        		}
        		
        	}
        }
		return bFound;
	}
	
	public void waitForLinktextAndClick(String logfile, WebDriver object, String linktext)
	{
		for (int i=0;i<aantalPogingen;i++)
        {
			object.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			tl.ToLog(logfile, "Poging="+(i+1));
        	try
        	{
        		if (object.findElement(By.linkText(linktext)).isEnabled()) 
                {
                	tl.ToLog(logfile, "Linktext ("+linktext+") gevonden en aangeklikt -> Result=OK.");
                	object.findElement(By.linkText(linktext)).click();
                	i=aantalPogingen;
                }
            	else
                {
            		tl.ToLog(logfile, "Linktext ("+linktext+") niet gevonden -> Result=NOK.");
                }
        	}
        	catch (Exception e)
        	{
        		tl.ToLog(logfile, "Linktext ("+linktext+") niet gevonden -> Result=NOK.");
        		if (i==aantalPogingen-1)
        		{
        			tl.ToLog(logfile, e.toString());
        		}
        		
        	}
        	
        	
        }
	}
	
	public void waitForCssAndClick(String logfile, WebDriver object, String linktext)
	{
		for (int i=0;i<aantalPogingen;i++)
        {
			object.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			tl.ToLog(logfile, "Poging="+(i+1));
        	try
        	{
        		if (object.findElement(By.cssSelector(linktext)).isEnabled()) 
                {
                	tl.ToLog(logfile, "CSS Selection ("+linktext+") gevonden en aangeklikt. -> Result=OK.");
                	object.findElement(By.cssSelector(linktext)).click();
                	i=aantalPogingen;
                }
            	else
                {
            		tl.ToLog(logfile, "CSS Selection ("+linktext+") niet gevonden.");
                }
        	}
        	catch (Exception e)
        	{
        		
        		tl.ToLog(logfile, "CSS Selection ("+linktext+") niet gevonden -> Result=NOK.");
        		if (i==aantalPogingen-1)
        		{
        			tl.ToLog(logfile, e.toString());
        		}
        	}
        	
        	
        }
	}
	
	public void waitForXpathAndClick(String logfile, WebDriver object, String xpath)
	{
		for (int i=0;i<aantalPogingen;i++)
        {
			object.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			tl.ToLog(logfile, "Poging="+(i+1));
        	try
        	{
        		if (object.findElement(By.xpath(xpath)).isEnabled()) 
                {
                	tl.ToLog(logfile, "Linktext ("+xpath+") gevonden en aangeklikt -> Result=OK.");
                	object.findElement(By.linkText(xpath)).click();
                	i=aantalPogingen;
                }
            	else
                {
            		tl.ToLog(logfile, "Linktext ("+xpath+") niet gevonden.");
                }
        	}
        	catch (Exception e)
        	{
        		tl.ToLog(logfile, "Linktext ("+xpath+") niet gevonden -> Result=NOK.");
        		if (i==aantalPogingen-1)
        		{
        			tl.ToLog(logfile, e.toString());
        		}
        	}
        	
        	
        }
	}
	
	public void waitPeriod(WebDriver object, int duration)
	{
		object.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}
	
	public void linkTextIsDisplayed(String logfile, WebDriver object, String linktext[])
	{
		
		for (int i=0 ;i<linktext.length;i++)
		{
			object.manage().timeouts().implicitlyWait(waitPeriodDuration, TimeUnit.SECONDS);
			try
			{
				if (object.findElement(By.linkText(linktext[i])).isDisplayed())
		        {
		        	tl.ToLog(logfile, linktext[i]+" --> Result=OK");
		        }
		        else
		        {
		        	tl.ToLog(logfile, linktext[i]+" --> Result=NOK");
		        }
			}
			catch (Exception e)
			{
				tl.ToLog(logfile, linktext[i]+" --> Result=NOK");
				if (i==aantalPogingen-1)
        		{
        			tl.ToLog(logfile, e.toString());
        		}
			}
		}
		
		
	}
	
	public void nameIsDisplayed(String logfile, WebDriver object, String linktext[])
	{
		for (int i=0 ;i<linktext.length;i++)
		{
			object.manage().timeouts().implicitlyWait(waitPeriodDuration, TimeUnit.SECONDS);
			try
			{
				if (object.findElement(By.name(linktext[i])).isDisplayed())
		        {
		        	tl.ToLog(logfile, linktext[i]+" --> Result=OK");
		        }
		        else
		        {
		        	tl.ToLog(logfile, linktext[i]+" --> Result=NOK");
		        }
			}
			catch (Exception e)
			{
				tl.ToLog(logfile, linktext[i]+" --> Result=NOK");
				if (i==aantalPogingen-1)
        		{
        			tl.ToLog(logfile, e.toString());
        		}
			}
		}
		
		
	}
	
	public boolean titleCheck(String logfile, WebDriver object, String linktext)
	{
		
		boolean found=false;
		object.manage().timeouts().implicitlyWait(waitPeriodDuration, TimeUnit.SECONDS);
		
		
		if (object.getTitle().equals(linktext))
        {
        	tl.ToLog(logfile, ">> Pagina ("+linktext+") --> Result=OK");
        	found=true;
        }
        else
        {
        	tl.ToLog(logfile, ">> Pagina ("+linktext+") --> Result=NOK");
        }
		
		return found;
		
	}
	
	public void clickLinkText(WebDriver object, String linktext)
	{
		object.findElement(By.linkText(linktext)).click();
	}
	
	public void checkResults(String file)
	{
		
		try {
			// Open file
			String fileContent = io.ReadFileToString(file);
			// Count "Result=NOK"
			if (fileContent.indexOf("Result=NOK")>-1)
			{
				// Add result line
				tl.ToLog(file, "Tests failed");
			}
			else
			{
				// Add result line
				tl.ToLog(file, "Tests passed");
			}
			
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void stringVergelijking(String logfile, String teChecken, String verwachteWaarde) 
	{
		tl.ToLog(logfile, ">> Controleren op de volgende waarde : " + "'"+verwachteWaarde+"'");
		tl.ToLog(logfile, ">> De te checken waarde = " + "'"+teChecken+"'");
		if (teChecken.equals(verwachteWaarde))
		{
			tl.ToLog(logfile, ">> De verwachte tekst is gevonden. --> Result=OK");
		}
		else
		{
			tl.ToLog(logfile, ">> De verwachte tekst is niet  gevonden. --> Result=NOK");
			tl.ToLog(logfile, ">> De gevonden tekst = " + "'"+verwachteWaarde+"'");
		}
		
	}

	public void waitForCssSelection(String logfile, WebDriver object, String string) 
	{
		tl.ToLog(logfile, ">> Wachten op CSS objectg : "+ string);
		int i=1;
		while (!(object.findElement(By.cssSelector(string)).isDisplayed()))
        {
			object.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			i++;
        }
		tl.ToLog(logfile, ">> Gevonden na "+i+" pogingen");
	}
}
