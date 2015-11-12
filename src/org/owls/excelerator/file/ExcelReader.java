package org.owls.excelerator.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.owls.excelerator.util.POITypeUtils;

//XSSFWorkbook 이나 HSSFWorkBook 이나 extends POIDocument implements Workbook 임 

public class ExcelReader {
	
	private File file;
	private String fileExtension = "";
	private final String[] EXTENSIONS = {"csv", "xls", "xlsx"};
	private Integer sheetCnt = 0;
	
	private ExcelReader(){}
	private static class LazyLoader{
		private static final ExcelReader INSTANCE = new ExcelReader();
	}
	
	public static ExcelReader getInstance (){
		return LazyLoader.INSTANCE;
	}
	
	public static ExcelReader getInstance(File file) throws Exception {
		return LazyLoader.INSTANCE.setFile(file);
	}
	
	public ExcelReader setFile(File file) throws Exception {
		this.file = file;
		if(!isReadable()) throw new Exception("Extension is not Readable");
		return this;
	}
	
	public void LoadMemory() throws IOException {
		//Data 읽어서 올리고, 수식도 읽어서 올린다.
		FileInputStream fis = new FileInputStream(this.file);
		switch(this.fileExtension){
			case "xls":
				parseXls(fis);
				break;
			case "xlsx":
				parseXlsx(fis);
				break;
			case "csv":
			default:
				break;
		}
	}
	
	
	//====================================== Internal Methods
	private boolean isReadable() {
		String extension = this.file.getName();
		extension = extension.substring(extension.lastIndexOf('.') + 1);
		for(String single : EXTENSIONS){ 
			if(extension.equals(single)){
				this.fileExtension = extension; return true;
			} 
		}
		return false;
	}
	
	
	@SuppressWarnings("resource")
	private void parseXls(FileInputStream fis) throws IOException{
		HSSFWorkbook hWorkbook = new HSSFWorkbook(fis);
		this.sheetCnt = hWorkbook.getNumberOfSheets();
		for(int i = 0; i < this.sheetCnt; i++){
			readSingleSheetH(hWorkbook.getSheetAt(i));
		}
	}
	
	@SuppressWarnings("resource")
	private void parseXlsx(FileInputStream fis) throws IOException{
		XSSFWorkbook xWorkbook = new XSSFWorkbook(fis);
		this.sheetCnt = xWorkbook.getNumberOfSheets();
		for(int i = 0; i < this.sheetCnt; i++){
			readSingleSheetX(xWorkbook.getSheetAt(i));
		}
	}
	
	private void readSingleSheetX(XSSFSheet sheet) {
		int xRowCnt = sheet.getPhysicalNumberOfRows();
		for(int i = 0; i < xRowCnt; i++){
			XSSFRow xRow = sheet.getRow(i);
			if(xRow == null) continue;
			int xColCnt = xRow.getPhysicalNumberOfCells();
			for(int j = 0; j < xColCnt; j++){
				XSSFCell xCell = xRow.getCell(j);
				if(xCell == null) continue;
				Object value = POITypeUtils.getPOITypeValue(xCell);
				System.out.println(value);
			}
		}
	}
	
	private void readSingleSheetH(HSSFSheet sheet) {
		int hRowCnt = sheet.getPhysicalNumberOfRows(); 
		for(int i = 0; i < hRowCnt; i++){
			HSSFRow hRow = sheet.getRow(i);
			if(hRow == null) continue;
			int hColCnt = hRow.getPhysicalNumberOfCells();
			for(int j = 0; j < hColCnt; j++){
				HSSFCell hCell = hRow.getCell(j);
				if(hCell == null) continue;
				Object value = POITypeUtils.getPOITypeValue(hCell);
				System.out.println(value);
			}
		}
	}
};