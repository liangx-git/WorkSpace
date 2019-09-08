package com.liangx.practice;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorTest {

	public static void main(String[] args) throws IOException {
		Files.walkFileTree(Paths.get("D:\\WorkSpace\\eclipse201812\\JavaPractice\\src"), new SimpleFileVisitor<Path>() {
			
			//�����ļ�ʱ����
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
				System.out.println("���ڷ���" + file + "�ļ�");
				if (file.endsWith("FilevisitorTest.java")) {
					System.out.println("--�ҵ�Ŀ���ļ�--");
					return FileVisitResult.TERMINATE;
				}
				return FileVisitResult.CONTINUE;
			}
			
			//��ʼ����Ŀ¼ʱ����
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				System.out.println("���ڷ��ʣ�" + dir + "·��");
				return FileVisitResult.CONTINUE;
			}
		});
	}

}
