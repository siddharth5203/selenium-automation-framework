package com.orangehrm.comman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners(ImplIInvokedMethodListener.class)
public class BaseSelenium {
	
	
	protected static String getClassFilePath(Class<?> cls){
		System.out.println("******** getFilePath for class "+cls.getName());
		String strSourceClassName = cls.getResource(cls.getSimpleName()+".class").getPath();
		System.out.println("*************** resource path is "+strSourceClassName);
		
		return strSourceClassName.replace(".class", ".xlsx");
	}
	
	int no_ofRow=0;
	int no_ofCol=0;
	
	@AfterSuite
	public  void afterSuite() {
		ExtentReportTestFactory.flushReport();
	}

	@DataProvider(name="excelData", parallel=true)
	public String[][] getDataFromExcel(Method m) throws Exception{
		System.out.println(m.getName());
		System.out.println(m.getDeclaringClass());
		return ExcelReader.getExcelTableArray(getClassFilePath(m.getDeclaringClass()), m.getName());
	}
	
	@DataProvider(name="loginData")
	public String[][] getData(){
		String data[][] = {{"admin","admin","Welcome Admin"},{"ess","ess","Welcome Admin"}};
		
		return data;
	}
	
	@DataProvider(name="getLoginData")
	public String[][] getLoginData(){
		File file = new File("C:\\Users\\Shree\\Desktop\\LoginData.txt");
		fillRowNColmSize();
		
		String mydata[][] = new String[no_ofRow][no_ofCol];

		try {
			
			int i=0;
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			
			while((line=br.readLine())!= null) {
				
				mydata[i]=line.split(",");
				i=i+1;
				System.out.println(line);
			}
			System.out.println(mydata);
		} catch (IOException e) {
			e.printStackTrace();
		}			
		return mydata;

	}

	private void fillRowNColmSize(){
		
		
		try {
			
			
			File file = new File("C:\\Users\\Shree\\Desktop\\LoginData.txt");
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";

			while((line=br.readLine())!= null) {
				
				no_ofCol = line.split(",").length;
				no_ofRow = no_ofRow+1;
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
