package br.com.cifpag.entity;

import org.springframework.web.multipart.*;

public class SimpleUploadFile {
	
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
