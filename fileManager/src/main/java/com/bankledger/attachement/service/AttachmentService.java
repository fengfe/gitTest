package com.bankledger.attachement.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.bankledger.attachement.entity.FileMag;

public interface AttachmentService {
	Map<String,Object> findObjects(String fileName,int pageCurrent);
	void saveObject(MultipartFile mFile,String serverPath,String title);
	File findFileById(Integer id);
	List<FileMag>findSomeObjects(String title);
	File findFileByIds(String ids);
}
