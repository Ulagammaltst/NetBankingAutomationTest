package com.netbanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	
	
	

	public static int getrowcount(String XLFile,String sheetName) throws IOException
	{
		fi=new FileInputStream(XLFile);					////path--->workbook--->sheet--->no.of rows using getLastRowNum()
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetName);
		
		int rowcount=sheet.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}
	
	
	public static int getcellcount(String XLFile,String sheetName,int rownum) throws IOException
	{
		fi=new FileInputStream(XLFile);      //path--->workbook--->sheet--->get the row number--->count the no.of columns or cell using getLAstCellNum()
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetName);
		
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	public static String getcelldata(String XLFile,String sheetname,int rownum,int colnum) throws IOException     //Reading data from excel
	{
		fi=new FileInputStream(XLFile);      //path--->workbook--->sheet--->get the row number--->get the cellnum of that row--->get the data using datafformatter for all types of data in string
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetname);
		
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter=new DataFormatter();   //formats all types of data into string and get the data
		String data;
		try {
		data=formatter.formatCellValue(cell);          //try-catch is used handle the exception in case if the cell choosen is empty
		}
		catch(Exception e)
		{
		data="";
		}
		wb.close();
		fi.close();
		return data;
		
	}
	
	public static void setcelldata(String XLFile,String sheetname,int rownum,int colnum,String data) throws IOException 	//Write data ito the excel sheet
	{
		fi=new FileInputStream(XLFile);      //path--->workbook--->sheet--->get the row number--->get the cell number of that row
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetname);
		
		row=sheet.getRow(rownum);		   //Get the data in the sell using setcellvalue(data)
		cell=row.getCell(colnum);
		cell.setCellValue(data);
		
		fo=new FileOutputStream(XLFile);     //using fileoutput stream write the data in the excel file
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
				
	}
	
	public static void fillgreencolor(String XLFile,String sheetname,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(XLFile);      //path--->workbook--->sheet--->get the row number--->get the cell number of that row
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetname);
		
		row=sheet.getRow(rownum);		  
		cell=row.getCell(colnum);
		
		try {
			style=wb.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());       //fill color
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			//Cell style object is used to get the cell style
		
					//fill pattern
		
		cell.setCellStyle(style);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
	
	public static void fillredcolor(String XLFile,String sheetname,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(XLFile);      //path--->workbook--->sheet--->get the row number--->get the cell number of that row
		wb=new XSSFWorkbook(fi);
		sheet=wb.getSheet(sheetname);
		
		row=sheet.getRow(rownum);		  
		cell=row.getCell(colnum);
		
		style=wb.createCellStyle();			//Cell style object is used to get the cell style
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());       //fill color
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);				//fill pattern
		
		cell.setCellStyle(style);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
}





