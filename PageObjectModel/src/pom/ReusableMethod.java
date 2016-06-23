package pom;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

public class ReusableMethod {

	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;

	/* Method Name: enterText
	 * Brief Description: Enter the text value into text field
	 * Arguments: obj --> Textfield Object, textval --> value to be entered, objName --> Name of the object
	 * Creation Date: April 28 2016
	 * Last Modified: April 28 2016
	 * Created by: Team Phoenix
	 * */

	public static void enterText(WebElement obj, String textValue , String objName) throws Exception{
		if(obj.isDisplayed()){
			obj.sendKeys(textValue);
			Update_Report("Pass", "enterText", textValue+ " is entered in "+ objName);
			//System.out.println("Pass: "+textValue+ " is entered in "+ objName);
		}else{
			Driver.reportFlag = 1;
			Update_Report("Fail", "enterText", objName+ " object did not displayed ");
			//System.out.println("Fail: "+objName+ " object did not displayed ");
		}

	}

	/* Method Name: clickButton
	 * Brief Description: Click the selected button
	 * Arguments: obj --> Textfield Object, textval --> value to be entered, objName --> Name of the object
	 * Creation Date: April 28 2016
	 * Last Modified: April 28 2016
	 * Created by: Team Phoenix
	 * */
	public static void clickButton(WebElement obj, String buttonName) throws Throwable{
		if(obj.isDisplayed()){
			obj.click(); 	
			Update_Report("Pass", "clickButton", objName +  " is clicked.");
			//System.out.println("Pass: " + objName +  " is clicked.");
		}else{
			Driver.reportFlag = 1;
			Update_Report("Fail", "clickButton", objName + "object did not display please check the application.");
			//System.out.println("Fail: " + objName + "object did not display please check the application.");
		}
	}

	public static void chkBox(WebElement obj , String chkBoxName) throws Exception{
		if(obj.isDisplayed()){
			if(!obj.isSelected())
				obj.click();
			//System.out.println("Pass: " + objName + " is Selecte d");
			Update_Report("Pass", "chkBox",objName + " is Selected" );
		}else{
			Driver.reportFlag = 1;
			Update_Report("Fail", " chkBox ",objName + " did not display, please check the application" );
		}
			
	}
	public static void validateTextMsg(WebElement obj, String actualMsg , String expectedMsg) throws Exception{
		if(obj.isDisplayed()){
			actualMsg = obj.getText();
			if(expectedMsg.equals(actualMsg)){

				Update_Report("Pass : actual message " , "Validate text message ", actualMsg+" is equals to expected message ");
				//System.out.println("Pass : actual message "+actualMsg+" is equals to expected message ");
				
			}
			else{
				Driver.reportFlag = 1;
				Update_Report("Fail: actual msg ", "Validate text message ", actualMsg+" is not equal to expected msg " );
				//System.out.println("Fail: actual msg "+actualMsg+" is not equal to expected msg " );
				
			}
		}else{
			Driver.reportFlag = 1;
			Update_Report("Fail : ", "Validate text message ", actualMsg+ " object is not displayed");
			//System.out.println("Fail : "+actualMsg+ " object is not displayed");
			
		}
	}

	public static void SFDCLogin(WebDriver driver , String userName, String password) throws Throwable{

		WebElement uName = driver.findElement(By.id("username"));
		enterText(uName, userName, "UserName");

		WebElement pwd = driver.findElement(By.id("password"));
		enterText(pwd, password, "password");

		WebElement salesForceLoginButton = driver.findElement(By.id("Login"));
		clickButton(salesForceLoginButton, "Login Button");
	}

	public static String[][] readXlSheet(String src, String sheetName) throws Exception{

		File xlFile = new File(src);
		FileInputStream fis = new FileInputStream(xlFile);

		HSSFWorkbook wb = new HSSFWorkbook(fis);

		HSSFSheet sheet1 = wb.getSheet(sheetName);

		String data0 = sheet1.getRow(0).getCell(0).getStringCellValue();

		int rowCount = sheet1.getLastRowNum() + 1;

		int colCount = sheet1.getRow(0).getLastCellNum();

		System.out.println(rowCount + " " + colCount);
		String[][] xlData = new String [rowCount][colCount];

		for(int i = 0 ; i < rowCount; i++){
			for (int j = 0; j < colCount; j++) {
				xlData[i][j] = sheet1.getRow(i).getCell(j).getStringCellValue();
				System.out.print(xlData[i][j] + " ");
			}
			System.out.println();
		}
		wb.close();

		return xlData;
	}

	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";



		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#66699 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#BDBDBD WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#BDBDBD WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#BDBDBD WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


	}

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");

		} 
	}

	public static String[][] readXlSheet1(String dtTablePath, String sheetName) throws IOException{


		/*Step 1: Get the XL Path*/
		File  xlFile = new File(dtTablePath); 

		/*step2: Access the Xl File*/
		FileInputStream  xlDoc  = new FileInputStream(xlFile);

		/*Step3: Access the work book (POI jar file) */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);

		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet(sheetName);


		int iRowCount = sheet.getLastRowNum()+1;
		int iColCount = sheet.getRow(0).getLastCellNum();

		String[][] xlData = new String[iRowCount][iColCount];

		for(int i = 0; i < iRowCount; i++){

			for(int j = 0; j < iColCount; j++){
				xlData[i][j]= sheet.getRow(i).getCell(j).getStringCellValue();
			}

		}
		return xlData;
	}

	public static void writeXlResult(ITestResult result,String dtTablePath, int rowNumber , int cellNumber)
	{
	    try
	    {
	    	FileInputStream fis = new FileInputStream(dtTablePath);
	    	Workbook wb = WorkbookFactory.create(fis);
	    	Sheet sh = wb.getSheet("Sheet1");
    		Row row = sh.getRow(rowNumber);
    		Cell cell = row.createCell(cellNumber);
    		cell.setCellType(cell.CELL_TYPE_STRING);
	    	
	        if(result.getStatus() == ITestResult.SUCCESS)
	        {
	    		cell.setCellValue("Pass");
	        }
	        else if(result.getStatus() == ITestResult.FAILURE)
	        {
	        	cell.setCellValue("Fail");

	        }
	        else if(result.getStatus() == ITestResult.SKIP)
	        {
	    		cell.setCellValue("Skip");
	        }
	        
    		cell.setCellValue("Pass");
	        FileOutputStream fos = new FileOutputStream(dtTablePath);
    		wb.write(fos);
    		fos.close();
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }

	}
	
	public static void writeExelSheet(String dtTablePath, int rowNumber , int cellNumber , String status) throws Exception{
		//File  xlFile = new File(dtTablePath);
		
		FileInputStream fis = new FileInputStream(dtTablePath);

		Workbook wb = WorkbookFactory.create(fis);

		Sheet sh = wb.getSheet("Input");
		Row row = sh.getRow(rowNumber);
		Cell cell = row.createCell(cellNumber);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue(status);

		FileOutputStream fos = new FileOutputStream(dtTablePath);
		wb.write(fos);
		fos.close();
		System.out.println("Exel file written");
	}
	
	/*Method Name: writeXlSheet
	 *Brief Description: Write text value to xl sheet
	 *Arguments: dtPath --> Xl Sheet Path, sheetName --> xl Sheet Name, iRow --> row number, iCol --> column number, xlData --> text value to be entered
	 * Created By: Team Phoenix 
	 * Creation Date: April 22 2016
	 * Last modified: April 22 2016
	 * */
	public static void writeXlSheet(String dtPath, String sheetName, int iRow, int iCol, String result) throws IOException{
		/*Step 1: Get the XL Path*/
		File  xlFile = new File(dtPath);

		/*step2: Access the Xl File*/
		FileInputStream  xlDoc  = new FileInputStream(xlFile);

		/*Step3: Access the work book (POI jar file) */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);

		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet("Sheet1");

		/*Access Row*/
		HSSFRow   row = sheet.getRow(iRow);

		/*Access cell*/
		HSSFCell  cell = row.getCell(iCol);

		cell.setCellValue(HSSFCell.CELL_TYPE_STRING);
		
		if(result.equalsIgnoreCase("Pass")){
			cell.setCellValue("Pass"); 
			HSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.GREEN().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
		}else{
			cell.setCellValue("Fail"); 
			HSSFCellStyle titleStyle = wb.createCellStyle();
			titleStyle.setFillForegroundColor(new HSSFColor.RED().getIndex());
			titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cell.setCellStyle(titleStyle);
			CreationHelper createHelper = wb.getCreationHelper();
			   Hyperlink link = createHelper.createHyperlink(Hyperlink.LINK_URL);
			         link.setAddress(htmlname);
			         cell.setHyperlink(link);

		}


		FileOutputStream fout = new FileOutputStream(dtPath);
		wb.write(fout);
		fout.flush();
		fout.close();
	}
}

