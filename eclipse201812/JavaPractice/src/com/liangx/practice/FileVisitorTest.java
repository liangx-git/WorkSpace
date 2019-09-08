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
			
			//访问文件时触发
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
				System.out.println("正在访问" + file + "文件");
				if (file.endsWith("FilevisitorTest.java")) {
					System.out.println("--找到目标文件--");
					return FileVisitResult.TERMINATE;
				}
				return FileVisitResult.CONTINUE;
			}
			
			//开始访问目录时触发
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				System.out.println("正在访问：" + dir + "路径");
				return FileVisitResult.CONTINUE;
			}
		});
	}

}
