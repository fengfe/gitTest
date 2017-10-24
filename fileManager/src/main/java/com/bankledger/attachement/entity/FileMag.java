package com.bankledger.attachement.entity;

import java.io.Serializable;
import java.util.Date;

import com.bankledger.attachement.web.DateJsonTypeConvert;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class FileMag implements Serializable {

	private static final long serialVersionUID = -4329914344858701374L;
	private Integer id;
	/**附件标题*/
	private String title;
	/**文件真实名称*/
	private String fileName;
	/**文件内容类型*/
	private String contentType;
	/**文件在服务器上的存储地址*/
	private String filePath;
	/**文件摘要信息*/
	private String fileDisgest;
	/**附件的创建时间*/
	private Date createdTime;
	/**附件的修改时间*/
	private Date modifiedTime;
	/**附件的创建人*/
	private String createdUser;
	/**附件的修改人*/
    private String modifiedUser;
    /**附件的大小*/
    private Long size;
	public FileMag() {
	}
	
	public FileMag(Integer id, String title, String fileName, String contentType, String filePath, String fileDisgest,
			Date createdTime, Date modifiedTime, String createdUser, String modifiedUser, Long size) {
		super();
		this.id = id;
		this.title = title;
		this.fileName = fileName;
		this.contentType = contentType;
		this.filePath = filePath;
		this.fileDisgest = fileDisgest;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		this.createdUser = createdUser;
		this.modifiedUser = modifiedUser;
		this.size = size;
	}

	
	@Override
	public String toString() {
		return "FileMag [id=" + id + ", title=" + title + ", fileName=" + fileName + ", contentType=" + contentType
				+ ", filePath=" + filePath + ", fileDisgest=" + fileDisgest + ", createdTime=" + createdTime
				+ ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser + ", modifiedUser=" + modifiedUser
				+ ", size=" + size + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileMag other = (FileMag) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileDisgest() {
		return fileDisgest;
	}
	public void setFileDisgest(String fileDisgest) {
		this.fileDisgest = fileDisgest;
	}
	@JsonSerialize(using = DateJsonTypeConvert.class)
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@JsonSerialize(using=DateJsonTypeConvert.class)
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	
	
}
