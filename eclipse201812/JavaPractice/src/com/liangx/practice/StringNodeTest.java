package com.liangx.practice;

import java.io.IOException;
import java.io.StringReader;

public class StringNodeTest {

	public static void main(String[] args) {
		
		String src = "abcdefghijklmnopqrstuvwsyzabcdefghijklmnopqrstuvwsyzabcdefghijklmnopqrstuvwsyzabcdefghijklmnopqrstuvwsyzabcdefghijklmnopqrstuvwsyz";
		
		try (
			StringReader sd = new StringReader(src);
			
		) {
			char[] cbuf = new char[32];
			int hasRead = 0;
			while ((hasRead = sd.read(cbuf)) > 0) {
				System.out.println(new String(cbuf, 0, hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
