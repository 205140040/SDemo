package com.demo.controller;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RequestMapping("/file")
@Controller
public class FileController {

	@RequestMapping("/hello")
	public void hello() {
		System.out.println("hello");
	}

	@RequestMapping(value = "/upload")
	@ResponseBody
	public String upload(MultipartHttpServletRequest multipartRequest) {
		String res = "";
		try {
			MultipartFile file = multipartRequest.getFile("file");
			if (!file.isEmpty()) {
				// 保存文件
				System.out.println(file.getOriginalFilename());
				res = saveFile(file.getOriginalFilename(), file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	private String saveFile(String filename, MultipartFile photo) {
		String res = "";
		try {
			File file = new File("d://" + "webimage/" + filename);

			// ʹ使用 Commons-io 上传文件
			FileUtils.writeByteArrayToFile(file, photo.getBytes());//
			System.out.println("上传完成");
			res = file.getAbsolutePath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
