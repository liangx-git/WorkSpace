package com.liangx.practice;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	public static void main(String[] args) {
		Path path = Paths.get(".");
		System.out.println(path);
		System.out.println("path�а�����·������" + path.getNameCount());
		System.out.println("path�ĸ�·��Ϊ��" + path.getRoot());
		Path absolutePath = path.toAbsolutePath();
		System.out.println("absolutePath = " + absolutePath);
		System.out.println("absolutePath������·������" + absolutePath.getNameCount());
		System.out.println("absolutePath�ĸ�·����" + absolutePath.getRoot());
		Path path2 = Paths.get("g:", "public", "codes");
		System.out.println(path2);
		System.out.println("path2������Ŀ¼����" + path2.getNameCount());

	}

}
