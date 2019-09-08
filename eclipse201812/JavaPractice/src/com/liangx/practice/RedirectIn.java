package com.liangx.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {

	public static void main(String[] args) {
		File file = new File("./src/com/liangx/practice/RedirecOut_newFile.txt");
		try (
			FileInputStream fis = new FileInputStream(file);
		){
			System.setIn(fis);
			Scanner sc = new Scanner(System.in);
			sc.useDelimiter("\n");
			while(sc.hasNext()) {
				System.out.println(sc.next());
			}
		} catch (IOException e) {
			
		}

	}

}
