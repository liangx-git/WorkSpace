package com.liangx.practice;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {
		
		//�˴�ʹ����jdk1.7����try()����е���Դ����try�������ͷ���Դ
		File file = new File("./src/com/liangx/practice/FileReaderTest.java");
		try (
			FileReader fr = new FileReader(file);
		) {
			//�жϵ�ǰ�������Ƿ�֧��mark����
			System.out.println("��ǰ��֧��mark������" + fr.markSupported());
			
			//����һ������Ϊ32���ַ�����
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
