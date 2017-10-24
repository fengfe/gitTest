package com.bankledger.attachement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bankledger.attachement.entity.FileMag;

public interface AttachementDao {
	List<FileMag> findObjects(@Param("fileName")String fileName,
					@Param("startIndex") int startIndex,
					@Param("pageSize") int pageSize);
	int findObjectByDisgest(String fileDisgest);
	FileMag findFileById(Integer id);
	void insertObject(FileMag fileMag);
	List<FileMag>findSomeObjects(String fileName);
	public int getRowCounts(String fileName);
}	
