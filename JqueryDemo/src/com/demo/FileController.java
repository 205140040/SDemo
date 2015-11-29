package com.demo;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("/FileController")
@Controller
public class FileController {
	@RequestMapping(value="/upload")
	@ResponseBody
	public String upload(@RequestParam("Filedata") MultipartFile Filedata,HttpServletRequest request){
		System.out.println("hello");
		try {
			if(!Filedata.isEmpty()){
				//保存文件
				saveFile(Filedata.getOriginalFilename(),Filedata,request);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "保存成功";
	}

	private void saveFile(String filename,MultipartFile photo,HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			String contextRealPath=request.getServletContext().getRealPath("/");
			System.out.println("contextRealPath:"+contextRealPath);
			File file=new File(contextRealPath+"/image/"+filename+".jpg");
			//ʹ使用 Commons-io 上传文件
			FileUtils.writeByteArrayToFile(file, photo.getBytes());//
			System.out.println("上传完成");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
