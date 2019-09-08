package com.liangx.practice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {

	public static void main(String[] args) {
		
		File file = new File("./src/com/liangx/practice/PrintStreamTest_newFile.txt");
		try (
			FileOutputStream fos = new FileOutputStream(file);
			PrintStream ps = new PrintStream(fos);
		){
			ps.println("11111");
			ps.println("22222");
			ps.println(new PrintStreamTest());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
