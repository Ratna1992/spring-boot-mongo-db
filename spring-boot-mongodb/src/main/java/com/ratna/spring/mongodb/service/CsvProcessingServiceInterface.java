package com.ratna.spring.mongodb.service;

import java.io.Reader;

public interface CsvProcessingServiceInterface {
	
	public String loadDataIntoDatabase();
	
	public String saveUploadedFile(Reader reader);
}
