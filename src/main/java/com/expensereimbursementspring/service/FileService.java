package com.expensereimbursementspring.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.expensereimbursementspring.pojo.FilePojo;

public interface FileService {

	FilePojo store(MultipartFile file) throws IOException;
	
	FilePojo getFile(int fileId);
	
	List<FilePojo> getAllFiles();
	
}
