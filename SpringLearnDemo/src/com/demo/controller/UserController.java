package com.demo.controller;

import java.io.File;

import java.io.FileOutputStream;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.demo.entity.User;

@Controller
@RequestMapping(value="/UserController")
public class UserController {

	@RequestMapping(value="/user",method=RequestMethod.POST)
	public ModelAndView user(@RequestParam("photo")MultipartFile photo,HttpServletRequest request){
		System.out.println("hello");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/user");
		try {
			if(!photo.isEmpty()){
				//得到源文件name
				saveFile(photo.getOriginalFilename(),photo,request);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return mav;
	}

	private void saveFile(String filename,MultipartFile photo,HttpServletRequest request) {
		// TODO Auto-generated method stub
		try {
			String contextRealPath=request.getServletContext().getRealPath("/");
			System.out.println("contextRealPath:"+contextRealPath);
			File file=new File(contextRealPath+"/image/"+filename+".jpg");
			//使用 Commons-io 写入文件
			FileUtils.writeByteArrayToFile(file, photo.getBytes());//写入文件
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
