package org.owls.excelerator.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class POITypeUtils {
	public static Object getPOITypeValue(Object poiCell){
		Object ret = null;
		String poiClassName = poiCell.getClass().getName();
		if(poiClassName.endsWith("XSSFCell")){
			//xlsx
			XSSFCell xCell = (XSSFCell) poiCell;
			switch(xCell.getCellType()){
				case XSSFCell.CELL_TYPE_STRING :
					ret = xCell.getStringCellValue();
					break;
				case XSSFCell.CELL_TYPE_NUMERIC :
					ret = xCell.getNumericCellValue();
					break;
				case XSSFCell.CELL_TYPE_BOOLEAN:
					ret = xCell.getBooleanCellValue();
					break;
				case XSSFCell.CELL_TYPE_BLANK:
					ret = xCell.getStringCellValue();
					break;
				case XSSFCell.CELL_TYPE_ERROR :
					ret = xCell.getErrorCellValue();
					break;
				case XSSFCell.CELL_TYPE_FORMULA :
					ret = xCell.getCellFormula();
					break;
				default :
					break;
			}
			
		}else if(poiClassName.endsWith("HSSFCell")){
			//xls
			HSSFCell hCell = (HSSFCell) poiCell;
			switch(hCell.getCellType()){
				case HSSFCell.CELL_TYPE_STRING :
					ret = hCell.getStringCellValue();
					break;
				case HSSFCell.CELL_TYPE_NUMERIC :
					ret = hCell.getNumericCellValue();
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:
					ret = hCell.getBooleanCellValue();
					break;
				case HSSFCell.CELL_TYPE_BLANK:
					ret = hCell.getStringCellValue();
					break;
				case HSSFCell.CELL_TYPE_ERROR :
					ret = hCell.getErrorCellValue();
					break;
				case HSSFCell.CELL_TYPE_FORMULA :
					ret = hCell.getCellFormula();
					break;
				default :
					break;
			}
		}
		return ret;
	}
}
