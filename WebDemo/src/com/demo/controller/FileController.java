package com.demo.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/file")
@Controller
public class FileController {

	@RequestMapping("/toFilePage")
	public String toFilePage() {
		return "file/filePage";
	}

	@RequestMapping("/hello")
	public void hello() {
		System.out.println("hello");
	}

	@RequestMapping(value = "/upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		try {
			if (!file.isEmpty()) {
				// 保存文件
				System.out.println(file.getOriginalFilename());
				saveFile(file.getOriginalFilename(), file, request);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "保存成功";
	}

	private void saveFile(String filename, MultipartFile photo, HttpServletRequest request) {
		try {
			File file = new File("d://" + "webimage/" + filename);
			// ʹ使用 Commons-io 上传文件
			FileUtils.writeByteArrayToFile(file, photo.getBytes());//
			System.out.println("上传完成");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
