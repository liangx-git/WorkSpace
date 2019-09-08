package com.liangx.practice;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {
		
		//此处使用了jdk1.7特性try()语句中的资源会在try结束后释放资源
		File file = new File("./src/com/liangx/practice/FileReaderTest.java");
		try (
			FileReader fr = new FileReader(file);
		) {
			//判断当前输入流是否支持mark操作
			System.out.println("当前流支持mark操作：" + fr.markSupported());
			
			//创建一个长度为32的字符缓冲
			char[] cbuf = new char[32];
			int hasRead = 0;
//			int index = 1;
			while ((hasRead = fr.read(cbuf)) > 0) {
//				System.out.println("---------------------" + index++ + "--------------------------");
				System.out.println(new String(cbuf, 0, hasRead));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
