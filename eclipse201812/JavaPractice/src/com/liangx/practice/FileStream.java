package com.liangx.practice;

import java.io.File;
import java.io.IOException;

public class FileStream {
	
	public static void main(String[] args) throws IOException{
		
		//�Ե�ǰ·������һ��File���󣬴˴���"."Ŀ¼��Ӧʵ�ʵ���Ŀ��Ŀ¼JavaPractice
		File file = new File(".");
		
		//����ļ���
		System.out.println(file.getName());
		
		//��ȡ���·���ĸ�·��
		System.out.println(file.getParent());
		
		//��ȡ����·��
		System.out.println(file.getAbsoluteFile());
		
		//��ȡ����·���ĸ�·��
		System.out.println(file.getAbsoluteFile().getParent());
		
		//�ڵ�ǰ·���´���һ����ʱ�ļ�
		File tempFile = File.createTempFile("aaa", ".txt", file);
		
		//ָ����JVM�˳�ʱɾ�����ļ�
		tempFile.deleteOnExit();
		
		//�Ե�ǰʱ����Ϊ���ļ�������һ�����ļ�
		File newFile = new File(System.currentTimeMillis() + " ");
		System.out.println("newFile�����Ƿ���ڣ�" + newFile.exists());
		
		//��ָ��newFile����������һ���ļ�
		newFile.createNewFile();
		
		//��newFile����һ��Ŀ¼���ᱨ����ΪnewFileͬ���ļ��Ѿ�����
		newFile.mkdir();
		
		//ʹ��list()�����г���ǰ·���µ������ļ���·��
		String[] fileList = file.list();
		
		System.out.println("====��ǰ·���������ļ���·�����£�");
		for (String fileName : fileList) {
			System.out.println(fileName);
		}
		
		File[] roots = File.listRoots();
		System.out.println("====ϵͳ���еĸ�Ŀ¼�У�");
		for (File root : roots) {
			System.out.println(root);
		}
				
		
	}
}
