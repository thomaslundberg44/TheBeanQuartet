package com.the_bean_quartet.msc_project.jax_rs;

import java.io.File;
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

import com.the_bean_quartet.msc_project.utilities.ProcessXLSFile;

@Path("/xls_crud")
public class XLSFileCRUDService {
	
	@Inject
	private ProcessXLSFile processXls;
	
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
						+ "window.location.assign('http://localhost:8080/TheBeanQuartet/uploadXLS.html');"
						+ "</script>";
				
				ResponseBuilder response = Response.ok(redirectScript);
				response.type("text/html");
				return response.build();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String redirectScript = "<script type='text/javascript'>"
				+ "window.alert('No file selected or invalid file');"
				+ "window.location.assign('http://localhost:8080/TheBeanQuartet/uploadXLS.html');"
				+ "</script>";
		
		ResponseBuilder response = Response.ok(redirectScript);
		response.type("text/html");
		return response.build();

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
				return finalFileName;
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
		
		processXls.processXLSSpreadsheet(file);
	}
	
}
