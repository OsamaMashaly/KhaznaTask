package utils;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToDataProvider {

	
	   
	     
	   
	   private static XSSFSheet ExcelWSheet;
	   
	   private static XSSFWorkbook ExcelWBook;
	   
	   private static XSSFCell Cell;
	   
	   private static XSSFRow Row;
	   
	   public static Object[][] getNewIssueData(String FilePath, String SheetName) throws Exception {   
	   
	      String[][] tabArray = null;
	   
	      try {
	   
	      FileInputStream ExcelFile = new FileInputStream(FilePath);
	      
	      ExcelWBook = new XSSFWorkbook(ExcelFile);
	   
	      ExcelWSheet = ExcelWBook.getSheet(SheetName);
	   
	      int startRow = 0; 
	      int startCol = 0;
	      int ci,cj;
	      int totalRows = ExcelWSheet.getLastRowNum();
	      int totalCols = 4;
	   
	      tabArray=new String[totalRows][totalCols];
	   
	      ci=0;
	   
	      for (int i=startRow;i<totalRows;i++, ci++) {              
	   
	     cj=0;
	   
	      for (int j=startCol;j<totalCols;j++, cj++){
	   
	      tabArray[ci][cj]= getCellData(i,j);
	   
	   
	   }
	   
	   }
	   
	   }
	   
	   catch (FileNotFoundException e){
	   
	   System.out.println("Could not read the Excel sheet");
	   
	   e.printStackTrace();
	   
	   }
	   
	   catch (IOException e){
	   
	   System.out.println("Could not read the Excel sheet");
	   
	   e.printStackTrace();
	   
	   }
	   


	   return tabArray;
	   
	   }
	   
	   
	   public static Object[][] getSearchIssueData(String FilePath, String SheetName) throws Exception {   
		   
		      String[][] tabArray = null;
		   
		      try {
		   
		      FileInputStream ExcelFile = new FileInputStream(FilePath);
		      
		      ExcelWBook = new XSSFWorkbook(ExcelFile);
		   
		      ExcelWSheet = ExcelWBook.getSheet(SheetName);
		   
		      int startRow = 0; 
		      int startCol = 0;
		      int ci,cj;
		      int totalRows = ExcelWSheet.getLastRowNum();
		      int totalCols = 3;
		   
		      tabArray=new String[totalRows][totalCols];
		   
		      ci=0;
		   
		      for (int i=startRow;i<totalRows;i++, ci++) {              
		   
		     cj=0;
		   
		      for (int j=startCol;j<totalCols;j++, cj++){
		   
		      tabArray[ci][cj]= getCellData(i,j);
		   
		   
		   }
		   
		   }
		   
		   }
		   
		   catch (FileNotFoundException e){
		   
		   System.out.println("Could not read the Excel sheet");
		   
		   e.printStackTrace();
		   
		   }
		   
		   catch (IOException e){
		   
		   System.out.println("Could not read the Excel sheet");
		   
		   e.printStackTrace();
		   
		   }
		   
		   return tabArray;
		   
		   }
	   
	   
	   public static String getCellData(int RowNum, int ColNum) throws Exception {
		   
		   try{
		   
		   Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		   
		   
		   String CellData = Cell.getStringCellValue();
		   
		   return CellData;
		   
		   
		   }
		   catch (Exception e){
		   
		   System.out.println(e.getMessage());
		   
		   throw (e);
		   
		   }
		   
		   
	}
}
