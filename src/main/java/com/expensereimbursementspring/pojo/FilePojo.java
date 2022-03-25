package com.expensereimbursementspring.pojo;

import java.util.Arrays;

public class FilePojo {

	private int fileId;
	private String fileName;
	private String fileType;
	private byte[] fileData;
	
	public FilePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FilePojo(int fileId, String fileName, String fileType, byte[] fileData) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileData = fileData;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "FilePojo [fileId=" + fileId + ", fileName=" + fileName + ", fileType=" + fileType + ", fileData="
				+ Arrays.toString(fileData) + "]";
	}
	
	
}
