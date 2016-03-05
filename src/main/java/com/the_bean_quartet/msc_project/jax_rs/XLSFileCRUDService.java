package com.the_bean_quartet.msc_project.jax_rs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.ErrorData;
import com.the_bean_quartet.msc_project.services.BaseDataService;
import com.the_bean_quartet.msc_project.services.ErrorDataService;

@Path("/xls_input")
public class XLSFileCRUDService {
	
	@Inject
	private BaseDataService baseDataService;
	
	@Inject 
	private ErrorDataService errorService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addSpreadsheetData(String path) {
		path = path.substring(1, path.length()-1);
		System.out.println("Processing file at path: "+path);
		long startTime = System.currentTimeMillis();
		try {
			FileInputStream file = new FileInputStream(new File(path));
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			for(Row row : sheet) {
				if(row.getRowNum() > 0) // first row contains headings/null values
					processRowCells(row);
			}
			long endTime = System.currentTimeMillis();
			long duration = endTime - startTime;
			System.out.println("Total time to read file: "+duration/1000.0+" seconds");
			
			file.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void processRowCells(Row row) {
		
		boolean containsErrors = false;
		
		Date date = new Date();
		Integer[] integers = new Integer[8];
		Long[] longs = new Long[4];
		String neVersion = "";
		
		for(Cell cell : row) {
			switch(cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				handleNumericCell(cell, date, integers, longs, containsErrors);
				break;
			case Cell.CELL_TYPE_STRING:
				if(cell.getColumnIndex() == 9)
					neVersion = cell.getStringCellValue();
				else
					containsErrors = true;
				break;
			}
		}
		
		if(containsErrors)
			errorService.addToErrorData(new ErrorData(
					date, integers[0], integers[1], integers[2], integers[3], 
					integers[4], integers[5], integers[6], integers[7], 
					neVersion, longs[0], longs[1], longs[2], longs[3]));
		else
			baseDataService.addToDataset(new BaseData(
					date, integers[0], integers[1], integers[2], integers[3], 
					integers[4], integers[5], integers[6], integers[7], 
					neVersion, longs[0], longs[1], longs[2], longs[3]));
	}

	private void handleNumericCell(Cell cell, Date date, Integer[] integers, Long[] longs, boolean containsErrors) {
		if(cell.getColumnIndex() == 0) 
			date = new Date(cell.getDateCellValue().getTime());
		else if(cell.getColumnIndex() >= 10) {
			longs[cell.getColumnIndex() -10] = (long)cell.getNumericCellValue();
		}
		else {
			integers[cell.getColumnIndex()-1] = (int) cell.getNumericCellValue();
		}
	}
}
