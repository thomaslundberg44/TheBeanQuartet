package com.the_bean_quartet.msc_project.jax_rs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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
	
	private Collection<BaseData> baseList;
	private ArrayList<ErrorData> errorList;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addSpreadsheetData(String path) {
		path = path.substring(1, path.length()-1);
		System.out.println("Processing file at path: "+path);
		long startTime = System.currentTimeMillis();
		
		baseList = new ArrayList<BaseData>();
		errorList = new ArrayList<ErrorData>();
		try {
			FileInputStream file = new FileInputStream(new File(path));
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			for(Row row : sheet) {
				if(row.getRowNum() > 0) // first row contains headings/null values
					processCells(row);
			}
			long endTime = System.currentTimeMillis();
			long duration = endTime - startTime;
			System.out.println("Total time to read file: "+duration/1000.0+" seconds");
			
			file.close();
			
			baseDataService.addCollectionToDataset(baseList);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void processCells(Row row) {
		try{
//			baseDataService.addToDataset(getBaseDataFromRow(row));
			baseList.add(getBaseDataFromRow(row));
		}catch(IllegalStateException e) {
//			errorService.addToErrorData(getErrorDataFromRow(row));
			errorList.add(getErrorDataFromRow(row));
		}	
	}
	
	private BaseData getBaseDataFromRow(Row row) {
		BaseData baseData = new BaseData();
		baseData.setDate(row.getCell(0).getDateCellValue());
		baseData.setEventId((int)(row.getCell(1).getNumericCellValue()));
		baseData.setFailureClass((int)(row.getCell(2).getNumericCellValue()));
		baseData.setUeType((int)(row.getCell(3).getNumericCellValue()));
		baseData.setMarket((int)(row.getCell(4).getNumericCellValue()));
		baseData.setOperator((int)(row.getCell(5).getNumericCellValue()));
		baseData.setCellId((int)(row.getCell(6).getNumericCellValue()));
		baseData.setDuration((int)(row.getCell(7).getNumericCellValue()));
		baseData.setCauseCode((int)(row.getCell(8).getNumericCellValue()));
		baseData.setNeVersion(row.getCell(9).getStringCellValue());
		baseData.setImsi((long)(row.getCell(10).getNumericCellValue()));
		baseData.setHeir3Id((long)(row.getCell(11).getNumericCellValue()));
		baseData.setHeir32Id((long)(row.getCell(12).getNumericCellValue()));
		baseData.setHeir321Id((long)(row.getCell(13).getNumericCellValue()));
		return baseData;
	}
	
	private ErrorData getErrorDataFromRow(Row row) {
		ErrorData errorData = new ErrorData();
		errorData.setDate(row.getCell(0).getDateCellValue());
		errorData.setEventId(getNumericIntegerCell(row.getCell(1)));
		errorData.setFailureClass(getNumericIntegerCell(row.getCell(2)));
		errorData.setUeType(getNumericIntegerCell(row.getCell(3)));
		errorData.setMarket(getNumericIntegerCell(row.getCell(4)));
		errorData.setOperator(getNumericIntegerCell(row.getCell(5)));
		errorData.setCellId(getNumericIntegerCell(row.getCell(6)));
		errorData.setDuration(getNumericIntegerCell(row.getCell(7)));
		errorData.setCauseCode(getNumericIntegerCell(row.getCell(8)));
		errorData.setNeVersion(row.getCell(9).getStringCellValue());
		errorData.setImsi(getNumericLongCell(row.getCell(10)));
		errorData.setHeir3Id(getNumericLongCell(row.getCell(11)));
		errorData.setHeir32Id(getNumericLongCell(row.getCell(12)));
		errorData.setHeir321Id(getNumericLongCell(row.getCell(13)));
		return errorData;
	}
	
	private Integer getNumericIntegerCell(Cell cell) {
		if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			return (int)(cell.getNumericCellValue());
		else
			return null;
	}
	
	private Long getNumericLongCell(Cell cell) {
		if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			return (long)(cell.getNumericCellValue());
		else
			return null;
	}
}
