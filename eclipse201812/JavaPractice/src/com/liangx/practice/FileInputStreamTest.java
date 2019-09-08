package com.liangx.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
	
	public static void main(String[] args) throws IOException{
		
		File file = new File("./src/com/liangx/practice/FileInputStreamTest.java");
		try (
			FileInputStream fis = new FileInputStream(file);			
		){
//			System.out.println("文件名：" + file.getName());
//			System.out.println("父目录：" + file.getParent());
//			System.out.println("文件绝对路径：" + file.getAbsolutePath());
//			File abFile = file.getAbsoluteFile();
//			System.out.println("绝对路径名：" + abFile.getName());
//			System.out.println("绝对路径父目录名：" + abFile.getParent());
//			System.out.println("绝对路径的绝对路径名：" + abFile.getAbsolutePath());
			
			//创建一个长度为1024的字节数组
			byte[] bbuf = new byte[1024];
			//实际读取的字节数
			int hasRead = 0;
			while ((hasRead = fis.read(bbuf)) > 0) {
				System.out.println(new String(bbuf, 0, hasRead));
			}
			
		} catch(IOException e) {
			System.out.println("文件输入流创建失败！！！");
		} 
	}

}
