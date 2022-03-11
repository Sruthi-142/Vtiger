package practice_testNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.ty.IAutoConstants;

public class DataProviderFromExcel{
	@Test(dataProvider="read")
	public void readDatafromExcel(Object UN ,Object PWD,Object OTP) 
	{
		System.out.println(UN+" "+PWD+" "+OTP);
	}
	@DataProvider
	public Object[][]  read() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IAutoConstants.excelpath);
		Workbook workbook=WorkbookFactory.create(fis);
		int lastrow=workbook.getSheet("Sheet2").getLastRowNum();
		short lastcell=workbook.getSheet("Sheet2").getRow(1).getLastCellNum();
	 Object arr[] []=new Object[lastrow][3];
	 for(int i=0;i<lastrow;i++) 
	 {
		 arr[i] [0]=workbook.getSheet("Sheet2").getRow(i).getCell(0).getStringCellValue();
		 arr[i] [1]=workbook.getSheet("Sheet2").getRow(i).getCell(1).getStringCellValue();
		 arr[i] [2]=workbook.getSheet("Sheet2").getRow(i).getCell(2).getStringCellValue();
	 }
	return arr;
	}

}
