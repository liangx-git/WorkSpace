package com.liangx.practice;

import java.io.File;
import java.io.FilenameFilter;



public class FilenameFilterTest {

	public static void main(String[] args) {
		
		//list��������һ���ļ�������
		File file = new File("./src/com/liangx/practice");
		String[] nameList = file.list(new MyFilenameFilter());
		for (String name : nameList) {
			System.out.println(name);
		}
	}
}

//��ʾ�Լ���FilenameFilter
class MyFilenameFilter implements FilenameFilter{
	
	@Override
	public boolean accept(File dir, String name) {
		
		//����һ����java��β�ļ����ļ���
		return name.endsWith(".java") || new File(name).isDirectory();
	}		
		
}