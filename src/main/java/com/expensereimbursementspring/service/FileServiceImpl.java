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

@Service
public class FileServiceImpl implements FileService {
	
	@Autowired
	FileDao fileDao;

	@Override
	public FilePojo store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileEntity fileEntity = null;
		try {
			fileEntity = new FileEntity(fileName, file.getContentType(), file.getBytes());
		}catch(IOException e) {
			e.printStackTrace();
		}
		fileDao.saveAndFlush(fileEntity);
		
		FilePojo filePojo = new FilePojo(fileEntity.getFileId(), fileEntity.getFileName(), fileEntity.getFileType(), fileEntity.getFileData());
		return filePojo;
	}

	@Override
	public FilePojo getFile(int fileId) {
		Optional<FileEntity> optional = fileDao.findById(fileId);
		FileEntity fileEntity = null;
		if(optional.isPresent()) {
			fileEntity = optional.get();
		}
		
		FilePojo filePojo = new FilePojo(fileEntity.getFileId(), fileEntity.getFileName(), fileEntity.getFileType(), fileEntity.getFileData());
		return filePojo;
	}

	@Override
	public List<FilePojo> getAllFiles() {
		List<FilePojo> allFilePojos = new ArrayList<FilePojo>();
		List<FileEntity> allFileEntities = fileDao.findAll();
		for(FileEntity fileEntity: allFileEntities) {
			FilePojo filePojo = new FilePojo(fileEntity.getFileId(), fileEntity.getFileName(), fileEntity.getFileType(), fileEntity.getFileData());
			allFilePojos.add(filePojo);
		}
		return allFilePojos;
	}

}
