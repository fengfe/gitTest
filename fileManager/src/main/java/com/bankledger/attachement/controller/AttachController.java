package com.bankledger.attachement.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bankledger.attachement.entity.FileMag;
import com.bankledger.attachement.service.AttachementServiceImpl;
import com.bankledger.attachement.service.AttachmentService;
import com.bankledger.attachement.web.JsonResult;


@Controller
public class AttachController {
	
	@Resource
	AttachmentService attachmentService;
	
	@RequestMapping("/uploadUI")
	public String uploadUI() {
		return "attachement";
	};
	/**上传文件*/
	@RequestMapping("/doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject( MultipartFile mFile, 
			String title,HttpServletRequest request){
		//项目路径
		String serverPath=
				request.getSession()
					   .getServletContext()
				       .getRealPath("upload");
		System.out.println("realPath="+serverPath);
		attachmentService.saveObject(
				mFile, 
				serverPath, 
				title);
		return new JsonResult();
	}
	/**查询所有文件*/
	@RequestMapping("/doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(
			String fileName,
			int pageCurrent){
		/*System.out.println("pageCurrent:"+pageCurrent);*/
		Map<String,Object>map=
				attachmentService.findObjects(fileName,pageCurrent);
		return new JsonResult(map);
	}
	@RequestMapping("/doSomeDown")
	@ResponseBody
	public byte[] doSomeDown(String ids,HttpServletResponse response) throws IOException {
		File file =
				attachmentService.findFileByIds(ids);
		response.setContentType(
				"appliction/octet-stream");
				response.setHeader(
				"Content-disposition",
				"attachment;filename="+file.getName());
				//根据文件真实路径构建一个Path对象　
				Path path=Paths.get(file.getPath());
				//将文件的字节返回(spring mvc 会自动将这字节写入到文件)
		        return Files.readAllBytes(path);
				//return file;
		
	}
	
	/**文件下载*/
	@RequestMapping("/doDownload")
	@ResponseBody
	public byte[] doDownload(Integer id,
		HttpServletResponse response)throws IOException{
		File file=
		attachmentService.findFileById(id);
		//设置响应消息头(下载时的固定写法)
		response.setContentType(
		"appliction/octet-stream");
		response.setHeader(
		"Content-disposition",
		"attachment;filename="+file.getName());
		//根据文件真实路径构建一个Path对象　
		Path path=Paths.get(file.getPath());
		//将文件的字节返回(spring mvc 会自动将这字节写入到文件)
        return Files.readAllBytes(path);
		//return file;
	}
	
	@RequestMapping("/doFindSomeObjects")
	@ResponseBody
	public JsonResult doFindSomeObjects(String title){
		List<FileMag> list = attachmentService.findSomeObjects(title);
		return new JsonResult(list);
	}
}
