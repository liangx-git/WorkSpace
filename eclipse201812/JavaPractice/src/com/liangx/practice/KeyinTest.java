package com.liangx.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyinTest {

	public static void main(String[] args) {
		
		try(
			InputStreamReader reader = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(reader);
		) {
			String read = null;
			while ((read = br.readLine()) != null) {
				if (read.equals("exit")) {
					System.out.println("退出");
					System.exit(1);
				}
				
				System.out.println("输入的内容为：" + read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
