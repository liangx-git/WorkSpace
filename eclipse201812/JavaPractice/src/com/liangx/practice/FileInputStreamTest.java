package com.liangx.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
	
	public static void main(String[] args) throws IOException{
		
		File file = new File("./src/com/liangx/practice/FileInputStreamTest.java");
		try (
			FileInputStream fis = new FileInputStream(file);			
		){
//			System.out.println("�ļ�����" + file.getName());
//			System.out.println("��Ŀ¼��" + file.getParent());
//			System.out.println("�ļ�����·����" + file.getAbsolutePath());
//			File abFile = file.getAbsoluteFile();
//			System.out.println("����·������" + abFile.getName());
//			System.out.println("����·����Ŀ¼����" + abFile.getParent());
//			System.out.println("����·���ľ���·������" + abFile.getAbsolutePath());
			
			//����һ������Ϊ1024���ֽ�����
			byte[] bbuf = new byte[1024];
			//ʵ�ʶ�ȡ���ֽ���
			int hasRead = 0;
			while ((hasRead = fis.read(bbuf)) > 0) {
				System.out.println(new String(bbuf, 0, hasRead));
			}
			
		} catch(IOException e) {
			System.out.println("�ļ�����������ʧ�ܣ�����");
		} 
	}

}
