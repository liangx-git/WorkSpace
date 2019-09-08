package com.liangx.practice;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	public static void main(String[] args) {
		Path path = Paths.get(".");
		System.out.println(path);
		System.out.println("path中包含的路径数：" + path.getNameCount());
		System.out.println("path的根路径为：" + path.getRoot());
		Path absolutePath = path.toAbsolutePath();
		System.out.println("absolutePath = " + absolutePath);
		System.out.println("absolutePath包含的路径数：" + absolutePath.getNameCount());
		System.out.println("absolutePath的根路径：" + absolutePath.getRoot());
		Path path2 = Paths.get("g:", "public", "codes");
		System.out.println(path2);
		System.out.println("path2包含的目录数：" + path2.getNameCount());

	}

}
