package com.liangx.practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class WriteToProcess {

	public static void main(String[] args) throws IOException{
		
		Process p = Runtime.getRuntime().exec("java ReadStandard");
		try (
			PrintStream ps = new PrintStream(p.getOutputStream());
		){
			ps.println("ÆÕÍ¨×Ö·û´®");
			ps.println(new WriteToProcess());
		}
	}
}

class ReadStandard {
	
	public static void main(String[] args) throws FileNotFoundException {
		try (
			Scanner sc = new Scanner(System.in);
			PrintStream ps = new PrintStream(new FileOutputStream("./src/com/liangx/practice/WriteToProcess_newFile.txt"));
		){
			sc.useDelimiter("\n");
			while (sc.hasNext()) {
				ps.println(sc.next());
			}
		}
	}
}
