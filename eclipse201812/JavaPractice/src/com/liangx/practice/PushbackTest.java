package com.liangx.practice;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class PushbackTest {

	public static void main(String[] args) {
		
		File file = new File("./src/com/liangx/practice/PushbackTest.java");
		try(
			FileReader fd = new FileReader(file);	//节点流
			PushbackReader pr = new PushbackReader(fd, 64);		//处理流，指定推回缓冲区长度为64
		){
			char[] bbuf = new char[32];
			String lastContent = "";
			int hasRead = 0;
			while ((hasRead = pr.read(bbuf)) > 0) {
				String content = new String(bbuf, 0, hasRead);
				int targetIndex = 0;
				if ((targetIndex = (lastContent + content).indexOf("PushbackTest.java")) > 0) {
					pr.unread((lastContent + content).toCharArray());
					int len = targetIndex > 32 ? 32 : targetIndex;
					pr.read(bbuf, 0, len);
					System.out.print(new String(bbuf, 0 , len));
					System.exit(0);
				} else {
					System.out.print(lastContent);
					lastContent= content;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
