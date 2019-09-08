package com.liangx.practice;

import java.io.File;
import java.io.FilenameFilter;



public class FilenameFilterTest {

	public static void main(String[] args) {
		
		//list函数接收一个文件过滤器
		File file = new File("./src/com/liangx/practice");
		String[] nameList = file.list(new MyFilenameFilter());
		for (String name : nameList) {
			System.out.println(name);
		}
	}
}

//显示自己的FilenameFilter
class MyFilenameFilter implements FilenameFilter{
	
	@Override
	public boolean accept(File dir, String name) {
		
		//接收一切以java结尾文件和文件夹
		return name.endsWith(".java") || new File(name).isDirectory();
	}		
		
}