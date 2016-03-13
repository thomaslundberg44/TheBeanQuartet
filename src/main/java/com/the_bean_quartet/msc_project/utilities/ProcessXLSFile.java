package com.the_bean_quartet.msc_project.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.the_bean_quartet.msc_project.entities.BaseData;
import com.the_bean_quartet.msc_project.entities.ErrorData;
import com.the_bean_quartet.msc_project.entities.EventCause;
import com.the_bean_quartet.msc_project.entities.EventCauseId;
import com.the_bean_quartet.msc_project.entities.FailureClass;
import com.the_bean_quartet.msc_project.entities.MccData;
import com.the_bean_quartet.msc_project.entities.MccDataId;
import com.the_bean_quartet.msc_project.entities.UETypeClass;
import com.the_bean_quartet.msc_project.services.BaseDataService;
import com.the_bean_quartet.msc_project.services.ErrorDataService;
import com.the_bean_quartet.msc_project.services.EventCauseService;
import com.the_bean_quartet.msc_project.services.FailureDataService;
import com.the_bean_quartet.msc_project.services.MccDataService;
import com.the_bean_quartet.msc_project.services.UETypeService;

public class ProcessXLSFile {
	
	private BaseDataService baseDataService;
	private ErrorDataService errorService;
	private FailureDataService failureClassService;
	private EventCauseService eventCauseService;
	private MccDataService mccDataService;
	private UETypeService ueDataService;
	
	private Collection<BaseData> baseList;
	private Collection<ErrorData> errorList;
	private Collection<FailureClass> failureClassList;
	private Collection<EventCause> eventList;
	private Collection<MccData> mccList;
	private Collection<UETypeClass> ueList;
	
	public ProcessXLSFile(BaseDataService baseDataService, ErrorDataService errorService,
			FailureDataService failureClassService, EventCauseService eventCauseService,
			MccDataService mccDataService, UETypeService ueDataService) {
		this.baseDataService = baseDataService;
		this.eventCauseService = eventCauseService;
		this.failureClassService = failureClassService;
		this.errorService = errorService;
		this.ueDataService = ueDataService;
		this.mccDataService = mccDataService;
	}

	/**
	 * 
	 * Read an excel spreadsheet, process and persist in database
	 * 
	 * @param Takes a xls spreadsheet file
	 */
	public void processXLSSpreadsheet(File xlsFile) {
		
		try {
			FileInputStream file = new FileInputStream(xlsFile);
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
			readEventCauseDataSheet(workbook.getSheetAt(1));
			readFailureDataSheet(workbook.getSheetAt(2));
			readUEDataSheet(workbook.getSheetAt(3));
			readMccTableSheet(workbook.getSheetAt(4));
			readBaseDataSheet(workbook.getSheetAt(0));
			
			file.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readEventCauseDataSheet(HSSFSheet sheet) {
		eventList = new ArrayList<EventCause>();
		for(Row row : sheet) {
			if(row.getRowNum() > 0) // first row contains headings/null values
				processEventCauseDataCells(row);
		}
		eventCauseService.addListEventCauseDataset(eventList);
	}

	private void processEventCauseDataCells(Row row) {
		EventCause event = new EventCause();
		EventCauseId eventId = new EventCauseId();
		eventId.setCauseCode((int)(row.getCell(0).getNumericCellValue()));
		eventId.setEventId((int)(row.getCell(1).getNumericCellValue()));
		event.setId(eventId);
		event.setDescription(row.getCell(2).getStringCellValue());
		eventList.add(event);
	}

	private void readFailureDataSheet(HSSFSheet sheet) {
		failureClassList = new ArrayList<FailureClass>();
		for(Row row : sheet) {
			if(row.getRowNum() > 0) // first row contains headings/null values
				processFailureDataCells(row);
		}
		failureClassService.addListFailureDataset(failureClassList);
	}
	
	private void processFailureDataCells(Row row) {
		FailureClass failureClass = new FailureClass();
		failureClass.setFailureClass((int)row.getCell(0).getNumericCellValue());
		failureClass.setDescription(row.getCell(1).getStringCellValue());
		failureClassList.add(failureClass);
	}
	

	private void readUEDataSheet(HSSFSheet sheet) {
		ueList = new ArrayList<UETypeClass>(); 
		for(Row row : sheet) {
			if(row.getRowNum() > 0) // first row contains headings/null values
				processUETypeCells(row);
		}
		ueDataService.addListUEDataset(ueList);
	}

	private void processUETypeCells(Row row) {
		UETypeClass ueClass = new UETypeClass();
		ueClass.setTac((int)(row.getCell(0).getNumericCellValue()));
		ueClass.setMarketingName(getStringFromCell(row.getCell(1)));
		ueClass.setManufacturer(getStringFromCell(row.getCell(2)));
		ueClass.setAccessCapability(getStringFromCell(row.getCell(3)));
		ueClass.setModel(getStringFromCell(row.getCell(4)));
		ueClass.setVendorName(getStringFromCell(row.getCell(5)));
		ueClass.setUeType(getStringFromCell(row.getCell(6)));
		ueClass.setOs(getStringFromCell(row.getCell(7)));
		ueClass.setInputMode(getStringFromCell(row.getCell(8)));
		ueList.add(ueClass);
	}
	
	private String getStringFromCell(Cell cell) {
		if(cell.getCellType() == Cell.CELL_TYPE_STRING)
			return cell.getStringCellValue();
		else
			return (String)(cell.getNumericCellValue()+"");
	}
	
	private void readMccTableSheet(HSSFSheet sheet) {
		mccList = new ArrayList<MccData>();
		for(Row row : sheet) {
			if(row.getRowNum() > 0) // first row contains headings/null values
				processMccDataCells(row);
		}
		mccDataService.addListToDataset(mccList);
	}

	private void processMccDataCells(Row row) {
		MccData mccData = new MccData();
		MccDataId mccId = new MccDataId();
		mccId.setMcc((int)row.getCell(0).getNumericCellValue());
		mccId.setMnc((int)row.getCell(1).getNumericCellValue());
		mccData.setId(mccId);
		mccData.setCountry(row.getCell(2).getStringCellValue());
		mccData.setOperator(row.getCell(3).getStringCellValue());
		mccList.add(mccData);
	}

	private void readBaseDataSheet(HSSFSheet sheet) {
		baseList = new ArrayList<BaseData>();
		errorList = new ArrayList<ErrorData>();
		for(Row row : sheet) {
			if(row.getRowNum() > 0) // first row contains headings/null values
				processBaseDataCells(row);
		}
		baseDataService.addCollectionToDataset(baseList);
		errorService.addListErrorData(errorList);
	}
	
	private void processBaseDataCells(Row row) {
		try{
			baseList.add(getBaseDataFromRow(row));
		}catch(IllegalStateException e) {
			errorList.add(getErrorDataFromRow(row));
		}
	}
	
	private BaseData getBaseDataFromRow(Row row) {
		BaseData baseData = new BaseData();
		baseData.setDate(getDate(row));
		baseData.setEventCause(getEventCause(row));
		baseData.setFailureClass(getFailureClass(row));
		baseData.setUeTable(getUETable(row));
		baseData.setMccData(getMccData(row));
		baseData.setCellId((int)(row.getCell(6).getNumericCellValue()));
		baseData.setDuration((int)(row.getCell(7).getNumericCellValue()));
		baseData.setNeVersion(row.getCell(9).getStringCellValue());
		baseData.setImsi((long)(row.getCell(10).getNumericCellValue()));
		baseData.setHeir3Id((long)(row.getCell(11).getNumericCellValue()));
		baseData.setHeir32Id((long)(row.getCell(12).getNumericCellValue()));
		baseData.setHeir321Id((long)(row.getCell(13).getNumericCellValue()));
		
		BaseDataConsistencyCheck check = new BaseDataConsistencyCheck(baseData);
		check.setMccList(mccList);
		check.setEventList(eventList);
		if(check.checkBaseDataConsistency())
			return baseData;
		else
			throw new IllegalStateException();
	}

	private String getDate(Row row) {
		Cell cell = row.getCell(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			Date date = row.getCell(0).getDateCellValue();
			return sdf.format(date);
		} else {
			return cell.getStringCellValue();
		}
	}

	private EventCause getEventCause(Row row) {
		int eventId = (int)(row.getCell(1).getNumericCellValue());
		int causeCode = (int)(row.getCell(8).getNumericCellValue());
		for(EventCause event : eventList) {
			if((event.getEventId() == eventId && event.getCauseCode() == causeCode))
				return event;
		}
		return new EventCause(eventId, causeCode, null); // return empty object if not found
	}
	
	private FailureClass getFailureClass(Row row) {
		for(FailureClass failure : failureClassList) {
			if(failure.getFailureClass() == (int)(row.getCell(2).getNumericCellValue()))
				return failure;
		}
		return new FailureClass();
	}

	private UETypeClass getUETable(Row row) {
		for(UETypeClass ueClass : ueList) {
			if(ueClass.getTac() == (int)(row.getCell(3).getNumericCellValue()))
				return ueClass;
		}
		return new UETypeClass();
	}

	private MccData getMccData(Row row) {
		int mcc = (int)(row.getCell(4).getNumericCellValue());
		int mnc = (int)(row.getCell(5).getNumericCellValue());
		for(MccData mccData : mccList) {
			if(mccData.getMcc() == mcc && mccData.getMnc() == mnc)
				return mccData;
		}
		return new MccData(mcc, mnc, null, null);
	}

	private ErrorData getErrorDataFromRow(Row row) {
		ErrorData errorData = new ErrorData();
		errorData.setDate(getDate(row));
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
