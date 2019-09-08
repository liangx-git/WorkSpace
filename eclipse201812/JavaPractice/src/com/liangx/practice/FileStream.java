package com.liangx.practice;

import java.io.File;
import java.io.IOException;

public class FileStream {
	
	public static void main(String[] args) throws IOException{
		
		//以当前路径创建一个File对象，此处的"."目录对应实际的项目根目录JavaPractice
		File file = new File(".");
		
		//输出文件名
		System.out.println(file.getName());
		
		//获取相对路径的父路径
		System.out.println(file.getParent());
		
		//获取绝对路径
		System.out.println(file.getAbsoluteFile());
		
		//获取绝对路径的父路径
		System.out.println(file.getAbsoluteFile().getParent());
		
		//在当前路径下创建一个临时文件
		File tempFile = File.createTempFile("aaa", ".txt", file);
		
		//指定当JVM退出时删除该文件
		tempFile.deleteOnExit();
		
		//以当前时间作为新文件名创建一个新文件
		File newFile = new File(System.currentTimeMillis() + " ");
		System.out.println("newFile对象是否存在：" + newFile.exists());
		
		//以指定newFile对象来创建一个文件
		newFile.createNewFile();
		
		//以newFile创建一个目录，会报错，因为newFile同名文件已经存在
		newFile.mkdir();
		
		//使用list()方法列出当前路径下的所有文件和路径
		String[] fileList = file.list();
		
		System.out.println("====当前路径下所有文件和路径如下：");
		for (String fileName : fileList) {
			System.out.println(fileName);
		}
		
		File[] roots = File.listRoots();
		System.out.println("====系统所有的根目录有：");
		for (File root : roots) {
			System.out.println(root);
		}
				
		
	}
}
