package com.liangx.practice;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException{
		
		File file = new File("./src/com/liangx/practice/RandomAccessFileTest.java");
		try(
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
		){
			System.out.println("raf当前的指针位置：" + raf.getFilePointer());
			raf.seek(300);
			System.out.println("raf当前指针位置：" + raf.getFilePointer());
			
			byte[] buf = new byte[32];
			int hasRead = 0;
			while ((hasRead = raf.read(buf)) > 0) {
				System.out.println(new String(buf, 0, hasRead));
			}
			
			raf.seek(raf.length());
			System.out.println("raf当前指针位置为：" + raf.getFilePointer());
		}

	}

}
