package com.demo.controller;

import java.io.File;

import java.io.FileOutputStream;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.demo.entity.User;

@Controller
@RequestMapping(value="/UserController")
public class UserController {
	
	/**
	 * 只有admin可以访问
	 */
	
	@RequestMapping(value="/hello")
	@ResponseBody
	@Secured(value="ROLE_ADMIN")
	public ModelAndView hello(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/hello");
		System.out.println("HELLO  you are admin");
		return mav;
	}
	
	@RequestMapping("/world")
	public ModelAndView world(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/hello");
		System.out.println("world  you are admin");
		return mav;
	}

	@RequestMapping(value="/user")
	public ModelAndView user(@RequestParam("photo")MultipartFile photo,HttpServletRequest request){
		System.out.println("hello");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/user");
		try {
			if(!photo.isEmpty()){
				//保存文件
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
			//ʹ使用 Commons-io 上传文件
			FileUtils.writeByteArrayToFile(file, photo.getBytes());//
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
