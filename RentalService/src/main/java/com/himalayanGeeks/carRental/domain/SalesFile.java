package com.himalayanGeeks.carRental.domain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class SalesFile {
	

	public static Date date;
	public static SalesFile fileInstance;
	private SalesFile(){
			
	}
	
	public static SalesFile getInstance(){		
		if(fileInstance.equals(null)){
			fileInstance = new SalesFile();
			return fileInstance;
		}
		else{
			return fileInstance;
		}		
	}

	public static Date getDate() {
		return date;
	}

	public static void setDate(Date date) {
		SalesFile.date = date;
	}
	
	public static void creatFileAndWrite(String content){
		File file;
		FileWriter fw;
		BufferedWriter bw;
		try {
			SimpleDateFormat dt1 = new SimpleDateFormat("EEE, MMM d, ''yy");
			System.out.println(dt1.format(date));
			  file = new File("e:\\sales"+" "+dt1.format(date)+".txt");
		      if (file.createNewFile()){
		        System.out.println("File is created!");
		      }else{
		        System.out.println("File already exists.");
		      }
		      fw = new FileWriter(file.getAbsoluteFile(),true);
		      bw = new BufferedWriter(fw);
		      bw.flush();
		      bw.write(content);		      
		      bw.close();

	    	} catch (IOException e) {
		      e.printStackTrace();
		}	
		System.out.println("Done");
		
	}
	
	
	
	
	
	
	

	
	
	
	
	
	


}
