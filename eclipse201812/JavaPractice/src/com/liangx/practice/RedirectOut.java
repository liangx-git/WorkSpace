package com.liangx.practice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RedirectOut {

	public static void main(String[] args) {
		File file = new File("./src/com/liangx/practice/RedirecOut_newFile.txt");
		try(
			FileOutputStream fos = new FileOutputStream(file);
			PrintStream ps = new PrintStream(fos);
		){
			System.setOut(ps);
			System.out.println("just a test\r\n");
			System.out.println("just a test 2 \r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
