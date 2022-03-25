package com.expensereimbursementspring.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.expensereimbursementspring.dao.FileDao;
import com.expensereimbursementspring.entities.FileEntity;
import com.expensereimbursementspring.pojo.FilePojo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileServiceImpl implements FileService {
	
	@Autowired
	FileDao fileDao;

	@Override
	public FilePojo store(MultipartFile file) throws IOException {
		log.info("Entered store of FileService");
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileEntity fileEntity = null;
		try {
			fileEntity = new FileEntity(fileName, file.getContentType(), file.getBytes());
		}catch(IOException e) {
			e.printStackTrace();
		}
		fileDao.saveAndFlush(fileEntity);
		
		FilePojo filePojo = new FilePojo(fileEntity.getFileId(), fileEntity.getFileName(), fileEntity.getFileType(), fileEntity.getFileData());
		log.info("Exited store of FileService");
		return filePojo;
	}

	@Override
	public FilePojo getFile(int fileId) {
		log.info("Entered getFile of FileService");
		Optional<FileEntity> optional = fileDao.findById(fileId);
		FileEntity fileEntity = null;
		if(optional.isPresent()) {
			fileEntity = optional.get();
		}
		
		FilePojo filePojo = new FilePojo(fileEntity.getFileId(), fileEntity.getFileName(), fileEntity.getFileType(), fileEntity.getFileData());
		log.info("Exited getFile of FileService");
		return filePojo;
	}

	@Override
	public List<FilePojo> getAllFiles() {
		log.info("Entered getAllFiles of FileService");
		List<FilePojo> allFilePojos = new ArrayList<FilePojo>();
		List<FileEntity> allFileEntities = fileDao.findAll();
		for(FileEntity fileEntity: allFileEntities) {
			FilePojo filePojo = new FilePojo(fileEntity.getFileId(), fileEntity.getFileName(), fileEntity.getFileType(), fileEntity.getFileData());
			allFilePojos.add(filePojo);
		}
		log.info("Exited getAllFiles of FileService");
		return allFilePojos;
	}

}
