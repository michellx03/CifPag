package br.com.cifpag.uteis;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;

import org.hibernate.ejb.criteria.expression.function.LengthFunction;
import org.springframework.web.multipart.*;

public class UploadFileHelper {
	
	public static String simpleUpload(MultipartFile file, HttpServletRequest request, boolean encrypt_file_name, String upload_folder) {
		String filename = null;
		try{
			if (!file.isEmpty()) {
				String applicationPath = request.getServletContext().getRealPath("");
				if (encrypt_file_name) {
					String currentFileName = file.getOriginalFilename();
					String extension = currentFileName.substring(currentFileName.lastIndexOf("."), currentFileName.length());
					Long nameRadom = Calendar.getInstance().getTimeInMillis();
					String newfilename = nameRadom + extension;
					filename = newfilename;
				} else 
					filename = file.getOriginalFilename();
					byte[] bytes = file.getBytes();
					String rootPath = applicationPath;
					File dir = new File(rootPath + File.separator + upload_folder);
					if(!dir.exists())
						dir.mkdirs();
					File serverFile = new File(dir.getAbsolutePath() + File.separator + filename);
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					return serverFile.getAbsolutePath();
				} else {
					filename = null;
				}
			} catch (Exception e) {
				filename = null;
			}
			return filename;
	}
	
	public static List<String> multipleFileUpload(List<MultipartFile> files, HttpServletRequest request, boolean encrypt_file_name, String upload_folder) {
		List<String> filenames = new ArrayList<String>();
		try {
			if (files.size() != 0) {
				BufferedOutputStream stream = null;
				String applicationPath = request.getServletContext().getRealPath("");
				for (MultipartFile file : files) {
					String filename = "";
					if (encrypt_file_name) {
						String currentFileName = file.getOriginalFilename();
						String extension = currentFileName.substring(currentFileName.lastIndexOf(".", currentFileName.length()));
						Long nameRadom = Calendar.getInstance().getTimeInMillis();
						String newfilename = nameRadom + extension;
						filename = newfilename;
					} else
						filename = file.getOriginalFilename();
					byte[] bytes = file.getBytes();
					String rootPath = applicationPath;
					File dir = new File(rootPath + File.separator + upload_folder);
					if (!dir.exists())
						dir.mkdirs();
					File serverFile = new File(dir.getAbsolutePath() + File.separator + filename);
					stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					System.out.println(filename);
					filenames.add(filename);
				}
				stream.close();
			} else {
				filenames = null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			filenames = null;
		}
		return filenames;
	}

}
