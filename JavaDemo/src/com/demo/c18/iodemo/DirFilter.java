package com.demo.c18.iodemo;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirFilter implements FilenameFilter{
	private Pattern pattern;
	
	

	public DirFilter() {
		super();
		// TODO Auto-generated constructor stub
	}



	public DirFilter(String regex) {
		this.pattern = Pattern.compile(regex);
	}



	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}

}
