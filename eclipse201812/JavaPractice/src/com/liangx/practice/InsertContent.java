package com.liangx.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertContent {
	
	public static void insert(String filePath, int pos, String insertedContent) throws IOException{
		
		File file = new File(filePath);
		File tempFile = File.createTempFile("temp", ".txt");
		tempFile.deleteOnExit();
		
		try(
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			FileInputStream fis = new FileInputStream(tempFile);
			FileOutputStream fos = new FileOutputStream(tempFile);
		){
			//缓冲pos之后的数据
			raf.seek(pos);
			byte[] buf = new byte[1024];
			int hasRead = 0;
			while ((hasRead = raf.read(buf)) > 0) {
				fos.write(buf, 0, hasRead);
			}
			
			//将insertedContent内容插入到pos之后
			raf.seek(pos);
			raf.write(insertedContent.getBytes());  
			while((hasRead = fis.read(buf)) > 0) {
				raf.write(buf, 0, hasRead);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		insert("./src/com/liangx/practice/FileOutputStreamTest_newFile.txt", 200, "******************插入的句子*****************");
	}
	
}
