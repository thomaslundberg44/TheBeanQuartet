package com.the_bean_quartet.msc_project.jax_rs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import com.the_bean_quartet.msc_project.services.BaseDataService;
import com.the_bean_quartet.msc_project.services.ErrorDataService;
import com.the_bean_quartet.msc_project.services.EventCauseService;
import com.the_bean_quartet.msc_project.services.FailureDataService;
import com.the_bean_quartet.msc_project.services.MccDataService;
import com.the_bean_quartet.msc_project.services.UETypeService;
import com.the_bean_quartet.msc_project.utilities.ProcessXLSFile;

@Path("/xls_crud")
public class XLSFileCRUDService {
	
	//private static final String UPLOADED_FILE_PATH = "D:\\Project\\jboss-as-7.1.1.Final\\bin\\";
	private static final String UPLOADED_FILE_PATH = "/home/tommy/software/wildfly-8.2.1.Final/bin/";

	@Inject private BaseDataService baseDataService;
	@Inject private ErrorDataService errorService;
	@Inject private FailureDataService failureClassService;
	@Inject private EventCauseService eventCauseService;
	@Inject private MccDataService mccDataService;
	@Inject private UETypeService ueDataService;
	
	/**
	 * Handles an XLS spreadsheet and passes file to be processed and persisted
	 * 
	 * @param XLS file in Multipart form data input
	 * @return returns response to confirm success
	 */
	@POST
	@Path("/upload")
	@Consumes("multipart/form-data")
	public Response uploadFile(MultipartFormDataInput input) {

		String fileName = "";
		
		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		List<InputPart> inputParts = uploadForm.get("uploadedFile");

		for (InputPart inputPart : inputParts) {

			try {
				MultivaluedMap<String, String> header = inputPart.getHeaders();
				fileName = getFileName(header);

				InputStream inputStream = inputPart.getBody(InputStream.class,null);
				byte [] bytes = IOUtils.toByteArray(inputStream);
				
				float duration = startTimerAndWrite(fileName, bytes);
				System.out.println("File processed in "+duration+" seconds");
				
				String redirectScript = "<script type='text/javascript'>"
						+ "window.alert('File upload complete. Time taken: "+duration+" seconds');"
						+ "window.location.assign('http://localhost:8080/TheBeanQuartet/uploadSuccess.html');"
						+ "</script>";
				
				ResponseBuilder response = Response.ok(redirectScript);
				response.type("text/html");
				return response.build();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return Response.status(200)
				.entity("Failed to upload file name : " + fileName).build();

	}

	private float startTimerAndWrite(String fileName, byte[] bytes) throws IOException {
		long startTime = System.currentTimeMillis();
		
		writeFile(bytes,fileName);
		
		long endTime = System.currentTimeMillis();
		float duration = (endTime-startTime)/1000.0f;
		return duration;
	}

	/**
	 * Get uploaded filename
	 * 
	 * @param header from file sent using multipart form input
	 * @return file name for file
	 */
	private String getFileName(MultivaluedMap<String, String> header) {

		String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
		
		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {

				String[] name = filename.split("=");
				
				String finalFileName = name[1].trim().replaceAll("\"", "");
				return UPLOADED_FILE_PATH + finalFileName;
			}
		}
		return "unknown";
	}

	/**
	 * Save uploaded file, process spreadsheet and persist
	 * 
	 * @param byte content from file
	 * @param name of file
	 * @throws IOException
	 */
	private void writeFile(byte[] content, String filename) throws IOException {

		File file = new File(filename);

		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileOutputStream fop = new FileOutputStream(file);

		fop.write(content);
		fop.flush();
		fop.close();
		
		ProcessXLSFile processXls = new ProcessXLSFile(baseDataService, errorService, failureClassService, eventCauseService, mccDataService, ueDataService);
		processXls.processXLSSpreadsheet(file);
	}
	
}
