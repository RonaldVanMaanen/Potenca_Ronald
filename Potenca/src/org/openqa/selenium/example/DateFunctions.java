package org.openqa.selenium.example;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class DateFunctions 
{
	ClipBoardFunctions clp = new ClipBoardFunctions();
	StringFunctions sf = new StringFunctions();
	
	public String buildDateString() 
	{
		String returnString="";
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		returnString+=sf.preZero(Integer.toString(cal.get(Calendar.YEAR)), 4)+"-";
		returnString+=sf.preZero(Integer.toString(cal.get(Calendar.MONTH)+1), 2)+"-";
		returnString+=sf.preZero(Integer.toString(cal.get(Calendar.DAY_OF_MONTH)), 2);
		//clp.setClipboard(returnString);
		return returnString;
	}
	
	public String buildDateTimeString() 
	{
		String returnString="";
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		returnString+=sf.preZero(Integer.toString(cal.get(Calendar.YEAR)), 4)+"-";
		returnString+=sf.preZero(Integer.toString(cal.get(Calendar.MONTH)+1), 2)+"-";
		returnString+=sf.preZero(Integer.toString(cal.get(Calendar.DAY_OF_MONTH)), 2)+" \\ ";
		returnString+=sf.preZero(Integer.toString(cal.get(Calendar.HOUR_OF_DAY)), 2)+":"; 
		returnString+=sf.preZero(Integer.toString(cal.get(Calendar.MINUTE)), 2)+":";
		returnString+=sf.preZero(Integer.toString(cal.get(Calendar.SECOND)), 2);
		//clp.setClipboard(returnString);
		return returnString;
	}
	
	public long CalculateDateDiff(int nYear1,int nMonth1,int nDay1,int nYear2,int nMonth2,int nDay2)
	{
		long rv=0;
		//get instance of Calendar objects
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
       
        //set two dates we want to know difference of
        cal1.set(nYear1, nMonth1, nDay1);
        cal2.set(nYear2, nMonth2, nDay2);
       
        long milis1 = cal1.getTimeInMillis();  
        long milis2 = cal2.getTimeInMillis();
       
        //difference in milliseconds
        long diff = milis2 - milis1;
       
        //difference in seconds
        long diffSeconds = diff / 1000;
       
        //difference in minutes
        long diffMinutes = diff / (60 * 1000);
       
        //difference in hours
        long diffHours = diff / (60 * 60 * 1000);
       
        //difference in days
        long diffDays = diff / (24 * 60 * 60 * 1000);
	
        rv=diffDays;
		return rv;
	}
	
	public int DetermineMaxDays(int nYear, int nMonth) 
	{
		int rv=0;
		if (nMonth==1 || nMonth==3 || nMonth==5 || nMonth==7 || nMonth==8 || nMonth==10 || nMonth==12)
		{
			rv=31;
		}
		
		if (nMonth==4 || nMonth==6 || nMonth==9 || nMonth==11)
		{
			rv=30;
		}
		
		if (nMonth==2)
		{
			if (nYear % 4==0 || nYear % 400==0)
			{
				rv=29;
			}
			else
			{
				rv=28;
			}
		}
		return rv;
	}
	
	public String GetDayName (int nYear, int nMonth, int nDay) throws ParseException 
	{
		String dayOfWeek="";
		
		// First convert to Date. This is one of the many ways.
		String dateString = String.format("%d-%d-%d", nYear, nMonth, nDay);
		Date date = new SimpleDateFormat("yyyy-M-d").parse(dateString);

		// Then get the day of week from the Date based on specific locale.
		dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
		return dayOfWeek;
	}

	public String getPreviousNextDay(int year, int month, int day, int delta) 
	{
		/**
		* @author Ronald
		* @version 1.0
		* @return Returns YYYYMMDD string
		*/
		int yearCalc=year;
		int monthCalc=month;
		int dayCalc=day;
		
		
		for (int i=0; i < Math.abs(delta);i++)
		{
			if (delta < 0)
			{
				if (dayCalc==1)
				{
					if(monthCalc>1)
					{
						monthCalc--;
						dayCalc=DetermineMaxDays(yearCalc, monthCalc);
					}
					else
					{
						yearCalc--;
						monthCalc=12;
						dayCalc=DetermineMaxDays(yearCalc, monthCalc);
					}
				}
				else
				{
					dayCalc--;
				}	
			}
			else // (delta < 0)
			{
				if (dayCalc==DetermineMaxDays(yearCalc, monthCalc))
				{
					if (monthCalc < 12)
					{
						monthCalc++;
						dayCalc=1;
					}
					else
					{
						yearCalc++;
						monthCalc=1;
						dayCalc=1;
					}
				}
				else
				{
					dayCalc++;
				}
			}
		}
		
		return sf.preZero(Integer.toString(yearCalc), 4)+sf.preZero(Integer.toString(monthCalc),2)+sf.preZero(Integer.toString(dayCalc),2);  		
	}
}

