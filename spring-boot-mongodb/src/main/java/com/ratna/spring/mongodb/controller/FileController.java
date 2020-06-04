package com.ratna.spring.mongodb.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ratna.spring.mongodb.exceptions.NoFileFoundException;
import com.ratna.spring.mongodb.service.CsvProcessingService;

@RestController
public class FileController {

	@Autowired
	CsvProcessingService csvProcessingService;

	@PostMapping("/upload-file")
	public String uploadFile(@RequestParam("file") MultipartFile file) {

		if (file.isEmpty()) {
			throw new NoFileFoundException("No File available in request");
		}
		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			return csvProcessingService.saveUploadedFile(reader);
		} catch (NoFileFoundException e) {
			throw new NoFileFoundException(e.getMessage());
		} catch (IOException e1) {
			throw new NoFileFoundException(e1.getMessage());
		}
	}
	
	@PostMapping("/upload-multi-file")
	public String uploadMultiFiles(@RequestParam("files") MultipartFile[] files) {

		if (files.length==0) {
			throw new NoFileFoundException("No File available in request");
		}
		if(files.length!=2) {
			throw new NoFileFoundException("only 2 files are allowed to upload");
		}
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}
		return null;
	}
}
