package com.liangx.practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		String filePath = "src/com/liangx/practice/FilesTest.java";
		String newFilePath = "src/com/liangx/practice/FilesTest_newFile.txt";
		Files.copy(Paths.get(filePath), new FileOutputStream("src/com/liangx/practice/FilesTest_newFile.txt"));
		System.out.println("FileTest.java�Ƿ��������ļ�:" + Files.isHidden(Paths.get(filePath)));
		List<String> lines = Files.readAllLines(Paths.get(filePath), Charset.forName("gbk"));
		System.out.println(lines);
		System.out.println("FilesTest.java���ļ���СΪ��" + Files.size(Paths.get(filePath)));
		List<String> poem = new ArrayList();
		poem.add("��ǰ���¹⣬");
		poem.add("���ǵ���˪��");
		poem.add("��ͷ�����£�");
		poem.add("��ͷ˼���硣");
		Files.write(Paths.get(newFilePath), poem, Charset.forName("gbk"));
	}

}
