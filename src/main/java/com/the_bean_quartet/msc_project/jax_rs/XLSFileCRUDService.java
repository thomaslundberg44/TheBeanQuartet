package com.the_bean_quartet.msc_project.jax_rs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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

@Path("/xls_input")
public class XLSFileCRUDService {
	
	@Inject private BaseDataService baseDataService;
	@Inject private ErrorDataService errorService;
	@Inject private FailureDataService failureClassService;
	@Inject private EventCauseService eventCauseService;
	@Inject private MccDataService mccDataService;
	@Inject private UETypeService ueDataService;
	
	private Collection<BaseData> baseList;
	private Collection<ErrorData> errorList;
	private Collection<FailureClass> failureClassList;
	private Collection<EventCause> eventList;
	private Collection<MccData> mccList;
	private Collection<UETypeClass> ueList;
	
//	private final String UPLOADED_FILE_PATH = "d:\\";
	
//	@POST
//	@Path("/upload")
//	@Consumes("multipart/form-data")
//	public Response uploadFile(MultipartFormDataInput input) {
//
//		String fileName = "";
//		
//		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
//		List<InputPart> inputParts = uploadForm.get("uploadedFile");
//
//		for (InputPart inputPart : inputParts) {
//
//		 try {
//
//			MultivaluedMap<String, String> header = inputPart.getHeaders();
//			fileName = getFileName(header);
//
//			//convert the uploaded file to inputstream
//			InputStream inputStream = inputPart.getBody(InputStream.class,null);
//
//			byte [] bytes = IOUtils.toByteArray(inputStream);
//				
//			//constructs upload file path
//			fileName = UPLOADED_FILE_PATH + fileName;
//				
//			writeFile(bytes,fileName);
//				
//			System.out.println("Done");
//
//		  } catch (IOException e) {
//			e.printStackTrace();
//		  }
//
//		}
//
//		return Response.status(200)
//		    .entity("uploadFile is called, Uploaded file name : " + fileName).build();
//
//	}
//	
//	@POST
//	@Path("/upload")
//	@Consumes("multipart/form-data")
//	public Response uploadFile(MultipartFormDataInput input) throws IOException {
//
//		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
//		
//		List<InputPart> inputParts = uploadForm.get("uploadFile");
//
//		for (InputPart inputPart : inputParts) {
//			try {
//				MultivaluedMap<String, String> header = inputPart.getHeaders();
//				String fileName = getFileName(header);
//				if(fileName.contains(".xls")){
//					InputStream inputStream = inputPart.getBody(InputStream.class, null);
//	
//					byte[] bytes = IOUtils.toByteArray(inputStream);
//					
//					writeFile(bytes, fileName);
//					
//					java.net.URI location = new java.net.URI("http://localhost:8080/CallFailureEnterprise/uploadComplete.html");
//					return Response.temporaryRedirect(location).build();
////					return Response.status(200).entity("Dataset uploaded: " + fileName + 
////							"<p><a href='http://localhost:8080/CallFailureEnterprise/erroneous.html'</a>View erroneous data" +
////							"<p><a href='http://localhost:8080/CallFailureEnterprise/valid.html'</a>View valid data").build();
//				}
//				else{
//					return null;
////					return Response.status(200).entity("Please return to the upload page and provide an xls file").build();
//				}
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}
//
//	/**
//	 * header sample
//	 * {
//	 * 	Content-Type=[image/png], 
//	 * 	Content-Disposition=[form-data; name="file"; filename="filename.extension"]
//	 * }
//	 **/
//	//get uploaded filename, is there a easy way in RESTEasy?
//	private String getFileName(MultivaluedMap<String, String> header) {
//
//		String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
//		
//		for (String filename : contentDisposition) {
//			if ((filename.trim().startsWith("filename"))) {
//
//				String[] name = filename.split("=");
//				
//				String finalFileName = name[1].trim().replaceAll("\"", "");
//				return finalFileName;
//			}
//		}
//		return "unknown";
//	}
//
//	//save to somewhere
//	private void writeFile(byte[] content, String filename) throws IOException {
//
//		File file = new File(filename);
//
//		if (!file.exists()) {
//			file.createNewFile();
//		}
//
//		FileOutputStream fop = new FileOutputStream(file);
//
//		fop.write(content);
//		fop.flush();
//		fop.close();
//
//	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addSpreadsheetData(String path) {
		path = path.substring(1, path.length()-1);
		System.out.println("Processing file at path: "+path);
		long startTime = System.currentTimeMillis();
		
		try {
			FileInputStream file = new FileInputStream(new File(path));
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
			readEventCauseDataSheet(workbook.getSheetAt(1));
			readFailureDataSheet(workbook.getSheetAt(2));
			readUEDataSheet(workbook.getSheetAt(3));
			readMccTableSheet(workbook.getSheetAt(4));
			readBaseDataSheet(workbook.getSheetAt(0));
			
			
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
		baseData.setDate(row.getCell(0).getDateCellValue());
		baseData.setEventCause(getEventCause(row));
		baseData.setFailureClass(getFailureClass(row));
		baseData.setUeTable(getUETable(row));
		baseData.setMccData(getMccData(row));
//		baseData.setEventId((int)(row.getCell(1).getNumericCellValue()));
//		baseData.setFailureClass((int)(row.getCell(2).getNumericCellValue()));
//		baseData.setUeType((int)(row.getCell(3).getNumericCellValue()));
//		baseData.setMarket((int)(row.getCell(4).getNumericCellValue()));
//		baseData.setOperator((int)(row.getCell(5).getNumericCellValue()));
		baseData.setCellId((int)(row.getCell(6).getNumericCellValue()));
		baseData.setDuration((int)(row.getCell(7).getNumericCellValue()));
//		baseData.setCauseCode((int)(row.getCell(8).getNumericCellValue()));
		baseData.setNeVersion(row.getCell(9).getStringCellValue());
		baseData.setImsi((long)(row.getCell(10).getNumericCellValue()));
		baseData.setHeir3Id((long)(row.getCell(11).getNumericCellValue()));
		baseData.setHeir32Id((long)(row.getCell(12).getNumericCellValue()));
		baseData.setHeir321Id((long)(row.getCell(13).getNumericCellValue()));
		return baseData;
	}

	private EventCause getEventCause(Row row) {
		for(EventCause event : eventList) {
			if((event.getEventId() == (int)(row.getCell(1).getNumericCellValue())
					&& (event.getCauseCode() == (int)(row.getCell(8).getNumericCellValue()))))
				return event;
		}
		return new EventCause(); // return empty object if not found
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
		for(MccData mccData : mccList) {
			if(mccData.getMcc() == (int)(row.getCell(4).getNumericCellValue())
					&& mccData.getMnc() == (int)(row.getCell(5).getNumericCellValue()))
				return mccData;
		}
		return new MccData();
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
