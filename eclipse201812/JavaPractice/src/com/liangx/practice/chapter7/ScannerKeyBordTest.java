package com.liangx.practice.chapter7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ScannerKeyBordTest {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		sc.useDelimiter("\n");
//		while (sc.hasNext()) {
//			System.out.println("键盘输入的内容是：" + sc.next());
//		}
		try {
			Scanner fsc = new Scanner(new File("src/com/liangx/practice/chapter7/ScannerKeyBordTest.java"));
			while (fsc.hasNextLine()) {
				System.out.println(fsc.nextLine());
			}
			
			BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
			String line = "";
			while ((line = bReader.readLine()) != null) {
				System.out.println("键盘输入内容是：" + line);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
