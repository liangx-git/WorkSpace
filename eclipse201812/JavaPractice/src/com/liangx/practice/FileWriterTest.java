package com.liangx.practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		File file = new File("./src/com/liangx/practice/FileWriter_newFile.txt");
		try (
			FileWriter fw = new FileWriter(file);
		){
			fw.write("111111111111\r\n");
			fw.write("222222222222\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
