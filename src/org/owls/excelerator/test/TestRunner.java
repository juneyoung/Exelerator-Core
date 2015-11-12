package org.owls.excelerator.test;

import java.io.File;

import org.owls.excelerator.file.ExcelReader;

public class TestRunner {
	
	private static final String fileLoc = 
			System.getProperty("user.dir") + "/resources/test/Excel_FuncList.xls";
	
	public static void main(String[] args) throws Exception {
		ExcelReader reader = ExcelReader.getInstance(new File(fileLoc));
		// reader.loadMemory(); - return ??
		reader.LoadMemory();
		//파일이 잘 읽혀지는지 확인하고.
		//뭘로 담지? Map?
	}
}