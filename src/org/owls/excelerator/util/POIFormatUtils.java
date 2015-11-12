package org.owls.excelerator.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class POIFormatUtils {
	public static Object getColName(HSSFCell hCell){
		return CellReference.convertNumToColString(hCell.getColumnIndex());
	}

	public static Object getColName(XSSFCell xCell){
		return CellReference.convertNumToColString(xCell.getColumnIndex());
	}
}
