package com.expensereimbursementspring.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.expensereimbursementspring.pojo.FilePojo;
import com.expensereimbursementspring.service.FileService;

@RestController
@CrossOrigin
@RequestMapping("/api/files")
public class FileController {

	@Autowired
	FileService fileService;
	
	@PostMapping("/")
	FilePojo store(@RequestParam("file") MultipartFile file) throws IOException{
		return fileService.store(file);
	}
	
	@GetMapping("/{fid}")
	FilePojo getFile(@PathVariable int fid) {
		return fileService.getFile(fid);
	}
	
	@GetMapping("/")
	List<FilePojo> getAllFiles(){
		return fileService.getAllFiles();
	}
	
}
