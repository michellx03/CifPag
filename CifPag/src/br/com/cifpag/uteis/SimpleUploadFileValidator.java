package br.com.cifpag.uteis;

import org.springframework.validation.*;

import br.com.cifpag.entity.SimpleUploadFile;

public class SimpleUploadFileValidator implements Validator {
	
	private int limit_size = 10240000;
	private String limit_type_file = "xml";
	
	@Override
	public boolean supports(Class<?> arg0) {
		return SimpleUploadFile.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		SimpleUploadFile file = (SimpleUploadFile) arg0;
		if (file.getFile().getSize() == 0)
			arg1.rejectValue("file", "required.fileUpload");
		else if (file.getFile().getSize() > limit_size)
			arg1.rejectValue("file", "error.filesize");
		else if (!checkFileType(file.getFile().getOriginalFilename()))
			arg1.rejectValue("file", "error.filetype");
	}

	private boolean checkFileType(String fileName) {
		if (fileName.length() > 0) {
			String[] parts = fileName.split("\\.");
			if (parts.length > 0) {
				String extention = parts[parts.length -1];
				return this.limit_type_file.contains(extention);
			}			
		}
		return false;
	}
}
