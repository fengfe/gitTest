package com.bankledger.attachement.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bankledger.attachement.dao.AttachementDao;
import com.bankledger.attachement.entity.FileMag;
import com.bankledger.attachement.web.PageObject;


@Service
public class AttachementServiceImpl implements AttachmentService{
	@Resource
	AttachementDao attachementDao;
	@Override
	public Map<String,Object> findObjects(
			String fileName,int pageCurrent) {
		int pageSize=6;
		int startIndex=(pageCurrent-1)*pageSize;
		List<FileMag> list=attachementDao.findObjects(fileName,startIndex,pageSize);
		int rowCounts=attachementDao.getRowCounts(fileName);
		int pageCounts=rowCounts/pageSize;
		if(rowCounts%pageSize!=0) {
			pageCounts++;
		}
		System.out.println("pageCounts:"+pageCounts);
		PageObject pageObject = new PageObject();
		pageObject.setRowCounts(rowCounts);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setStartIndex(startIndex);
		pageObject.setPageCounts(pageCounts);
		System.out.println("pageCounts:"+pageCounts);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		 return map;
		
	}

	/*@param mFile 上床的文件*/
	@Override
	public void saveObject(MultipartFile mFile,String serverPath,String title ) {
		//原始文件名
		String oFileName=mFile.getOriginalFilename();
		System.out.println("原始文件名为："+oFileName);
		//文件字节数组
		byte[]fileBytes;
		//存储目标的文件
		File dest;
		//文件摘要
		String fileDisgest;
		try {//获取字节数组
			fileBytes=mFile.getBytes();
			//MD5加密
			fileDisgest=DigestUtils.md5Hex(fileBytes);
			int count =attachementDao.
					findObjectByDisgest(fileDisgest);
			if(count>0)throw new RuntimeException("文件已经存在");
		//上传文件
			SimpleDateFormat sdf= 
					new SimpleDateFormat("yyyy/HH/dd");
			String dateStr = sdf.format(new Date());
			System.out.println("dateStr:"+dateStr);
			String newFileName=
					UUID.randomUUID().toString()+"."+
					FilenameUtils.getExtension(oFileName);//文件扩展名
//			System.out.println(oFileName);
//			System.out.println(UUID.randomUUID().toString());
//			System.out.println(FilenameUtils.getExtension(oFileName));
//			System.out.println("newFileName:"+newFileName);
			String path="D:/"+dateStr+"/"+newFileName;
			System.out.println("realPath:"+path);
			dest=new File(path);
			System.out.println("dest:"+dest);
			//上传
			File parent=dest.getParentFile();
			if(!parent.exists()){//a.png
				parent.mkdirs();
			}
			mFile.transferTo(dest);
					
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("upload error");
		}
		//2.保存文件信息到数据库
				FileMag t=new FileMag();
				t.setTitle(title);
				t.setFileName(oFileName);
				t.setFilePath(dest.getPath());
				t.setContentType(mFile.getContentType());
				t.setFileDisgest(fileDisgest);
				t.setCreatedUser("admin");
				t.setModifiedUser("admin");
				t.setSize(mFile.getSize());
				attachementDao.insertObject(t);
	}
	
	/**下载单个文件*/
	@Override
	public File findFileById(Integer id) {
		if(id==null)
			throw new RuntimeException("id can not be null");
			//1.根据id查找记录　	
			FileMag a=
			attachementDao.findFileById(id);
			System.out.println("FileMag:"+a);
			if(a==null)
			throw new RuntimeException("数据库中没有对应的记录信息");
			//2.获得文件的真实路径,构建文件对象关联真实路径
			File file=new File(a.getFilePath());
			System.out.println("file:"+file);
			System.out.println(a.getFilePath());
			//3.检测文件是否存在，存在则下载　
			if(!file.exists()) {
			throw new RuntimeException("文件已经不存在");}
			return file;
	}
	/**下载多个文件*/
	
	@Override
	public File findFileByIds(String checkedIds) {
		String [] ids = checkedIds.split(",");
		if(checkedIds==""||checkedIds.length()==0) {
			throw new RuntimeException("必须有选中的");
		}
		List <String> list = new ArrayList<String>();
		for(String str:ids) {
			Integer id = Integer.parseInt(str);
			FileMag a=
					attachementDao.findFileById(id);
			if(a==null)throw new RuntimeException("数据库中没有对应的信息");
			String Spath = a.getFilePath();
			list.add(Spath);
		}
		//生成的压缩地址
		String makePath = "D:\\sabc";
		File f = new File(makePath);
		if(!f.exists()) {
			f.mkdirs();
		}
		File zipFile = new File(f,"abc"+(int)(Math.random()*100)+".zip");
		ZipOutputStream zipStream = null;
		FileInputStream zipSource = null;
		BufferedInputStream bufferStream = null;
		try {//压缩包的输出流
			zipStream = new ZipOutputStream(new FileOutputStream(zipFile));
			for(String ab:list) {
				File file = new File(ab);
				//将文件格式化为输入流
				zipSource = new FileInputStream(file);
				ZipEntry zipEntry = new ZipEntry(file.getName());
				zipStream.putNextEntry(zipEntry);
				//输入缓冲流
				bufferStream = new BufferedInputStream(zipSource,1024*10);
				int read = 0;
				//创建读写缓冲区
				byte[]buf = new byte[1024*10];
				while((read=bufferStream.read(buf, 0, 1024*10))!=-1) {
					zipStream.write(buf, 0, read);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(null!=bufferStream)bufferStream.close();
				if(null!=zipStream)zipStream.close();
			}catch (IOException e) {
			}
		}
		
		return zipFile;
	}
	
	


	/*根据文件名查找文件*/
	@Override
	public List<FileMag> findSomeObjects(String fileName) {
		return  attachementDao.findSomeObjects(fileName);
		}
	}