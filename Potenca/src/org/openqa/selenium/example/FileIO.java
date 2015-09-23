package org.openqa.selenium.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;

import javax.swing.JOptionPane;


public class FileIO
{
	
	public void WriteStringToFile(String file, String content)
	{
	  FileOutputStream fout;
	  try
	  {
		  fout = new FileOutputStream (file);
		  new PrintStream(fout).println (content);
		  fout.close();
	  }
	  catch (Exception e)
	  {//Catch exception if any
		System.err.println("Error: " + e.getMessage());
	  }
	}
	
	public void AddStringToFile(String file, String content)
	{
		try
		{
			Writer output;
			output = new BufferedWriter(new FileWriter(file, true));
			output.append(content+"\r\n");
			output.close();
		}
		catch (Exception e)
		{//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public String ReadFileToString(String location, String filename) throws java.io.IOException
	{
	    StringBuffer fileData = new StringBuffer(1000000);
	    BufferedReader reader = null;
	    try
	    {
	    	System.out.println(location+filename);
	    	
	    	reader = new BufferedReader(new FileReader(location+filename));
	    	char[] buf = new char[1024];
		    int numRead=0;
		    while((numRead=reader.read(buf)) != -1)
	        {
		        String readData = String.valueOf(buf, 0, numRead);
		        fileData.append(readData);
		        buf = new char[1024];
		    }
		    reader.close();
	    }
	    catch (Exception e1)
        {
            System.err.println("Error during reading of file: " + e1.getMessage());
        }
	    
	    return fileData.toString();
    }
	
	public String ReadFileToString(String filename) throws java.io.IOException
	{
	    StringBuffer fileData = new StringBuffer(1000000);
	    BufferedReader reader = null;
	    try
	    {
	    	reader = new BufferedReader(new FileReader(filename));
	    	char[] buf = new char[1024];
		    int numRead=0;
		    while((numRead=reader.read(buf)) != -1)
	        {
		        String readData = String.valueOf(buf, 0, numRead);
		        fileData.append(readData);
		        buf = new char[1024];
		    }
		    reader.close();
	    }
	    catch (Exception e1)
        {
            System.err.println("Error during reading of file: " + e1.getMessage());
        }
	    
	    return fileData.toString();
    }
	
	public boolean checkFileExists(String sFileName)
	{
	 	boolean bResult=false;
		File f = new File(sFileName);

	 	if(f.exists())
		{
	 		bResult=true;
		}
		else
		{
			bResult=false;
	  	}
	 	return bResult;
	}
	
	public static void copyfile(String srFile, String dtFile)
	{
		try
		{
			File f1 = new File(srFile);
			File f2 = new File(dtFile);
			InputStream in = new FileInputStream(f1);
			
			  //For Append the file.
			//  OutputStream out = new FileOutputStream(f2,true);

			//For Overwrite the file.
			OutputStream out = new FileOutputStream(f2);
			
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0)
			{
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
			//System.out.println("File copied.");
		}
		catch(FileNotFoundException ex)
		{
			System.out.println(ex.getMessage() + " in the specified directory.");
			System.exit(0);
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());  
		}
	}
	
	public void renameFile(String sPathOld,String sNewName) 
	{			
		File file= new File(sPathOld);
		// File (or directory) with old name
		String sTemp=file.toString();
		int nPos=sTemp.lastIndexOf("\\");
		sTemp=sTemp.substring(0,nPos+1)+sNewName;
		// Check if extension is missing
		if (sTemp.lastIndexOf(".")==-1)
		{
			sTemp=sTemp+".txt";
		}
		
		// File (or directory) with new name
		File file2 = new File(sTemp);

		// Rename file (or directory)
		boolean success = file.renameTo(file2);
		if (!success) 
		{
		   JOptionPane.showMessageDialog(null, "Renaming failed");
		}
	}
		
	
}
