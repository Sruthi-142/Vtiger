package com.crm.ty;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Util {
	public String read_exceldata(String Sheet,int row,int cell) throws Exception, IOException
	{
		FileInputStream fisx=new FileInputStream(IAutoConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fisx);
			return wb.getSheet(Sheet).getRow(row).getCell(cell).getStringCellValue();
		
	}

}
