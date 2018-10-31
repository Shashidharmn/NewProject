package com.shashi.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

   String[][] tabArray = null;

   try {

	   FileInputStream ExcelFile = new FileInputStream(FilePath);

	   // Access the required test data sheet

	   ExcelWBook = new XSSFWorkbook(ExcelFile);

	   ExcelWSheet = ExcelWBook.getSheet(SheetName);

	   int startRow = 1;

	   int startCol = 0;

	   int ci,cj;

	   int totalRows = ExcelWSheet.getLastRowNum();

	   // you can write a function as well to get Column count

	   int totalCols = 2;

	   tabArray=new String[totalRows][totalCols];

	   ci=0;

	   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

		  cj=0;

		   for (int j=startCol;j<totalCols;j++, cj++){

			   tabArray[ci][cj]=getCellData(i,j);

			  // System.out.println(tabArray[ci][cj]);  

				}
	   
			}

		}

	catch (Exception e){

		System.out.println("Could not read the Excel sheet");

		e.printStackTrace();

		}

	

	return(tabArray);

	}

public static String getCellData(int RowNum, int ColNum) throws Exception {

	try{
		String CellData=null;
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

		int dataType = Cell.getCellType();
		
	//	System.out.println("Type "+ dataType+" sasaa"+ Cell.getCellType());

		  switch (dataType)
          {
              case 0:
            	  CellData=String.valueOf(Cell.getNumericCellValue() );
                  break;
              case 1:
            	  CellData=Cell.getStringCellValue();
                  break;
          }
		
				return CellData;
			}catch (Exception e){
				return null;
		}

		

		

	}
}
