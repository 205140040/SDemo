package com.demo.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {

	@RequestMapping("/upload")
	@ResponseBody
	public String upload(MultipartFile file) {
		/**
		 * MultipartFile
		 * 1.getBytes()获取文件数据
		 * 2.getContentType获取mime类型
		 * 3.getName获取表单中的文件name
		 * 4.getOriginalFilename获取源文件名称
		 * 5.getSize获取文件的字节大小
		 * 6.tranferTo把文件上传保存到一个目标文件中
		 * 7.isEmpty是否有上传的文件
		 */
		if (null != file && !file.isEmpty()) {
			String fileName = file.getOriginalFilename(); // 文件名称
			try {
				// 上传文件到一个目录
				file.transferTo(new File("C://Users//admin//Desktop//" + fileName));
			} catch (Exception e) {
				e.printStackTrace();
				return e.getMessage();
			}
		}
		return "success";
	}
}
