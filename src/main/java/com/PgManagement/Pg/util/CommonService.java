package com.PgManagement.Pg.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class CommonService {
	
	private final String FOLDER_PATH="D:\\tenant_file\\";

	 public String uploadImage(MultipartFile file) throws IOException {
		 
		 	String fileName="";
			String extension="";
			String filePath="";
			int index=0;
			
			if(file.getOriginalFilename()!=null && file.getOriginalFilename()!="") {
				
				fileName = file.getOriginalFilename();
				index = fileName.lastIndexOf('.');
				extension=fileName.substring(index);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		        String safeDate = sdf.format(new Date());
		        filePath=FOLDER_PATH+safeDate+extension;
		        file.transferTo(new File(filePath));
				
			}
			
	        
			return filePath;
		 
	 }
}
