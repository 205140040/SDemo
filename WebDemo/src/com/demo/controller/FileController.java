package com.demo.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.NameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import http.HttpClientUtils;

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
		String res = "";
		try {
			if (!file.isEmpty()) {
				// 通过httpClient实现跨域上传文件
				List<NameValuePair> params = new ArrayList<>();
				URI uri = HttpClientUtils.getUri("http", "localhost:8080", "/FileWebDemo/file/upload", params);
				res = HttpClientUtils.postMultipartFile(uri, file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
