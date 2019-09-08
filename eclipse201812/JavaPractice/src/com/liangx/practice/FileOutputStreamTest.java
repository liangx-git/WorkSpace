package com.liangx.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		
		File file = new File("./src/com/liangx/practice/FileOutputStreamTest.java");
		try (
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream("./src/com/liangx/practice/FileOutputStreamTest_newFile.txt");
		){
			byte[] bbuf = new byte[32];
			int hasRead = 0;
			while ((hasRead = fis.read(bbuf)) > 0) {
				fos.write(bbuf, 0, hasRead);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
