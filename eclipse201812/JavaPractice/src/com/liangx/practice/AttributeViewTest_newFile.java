package com.liangx.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;

public class AttributeViewTest {

	public static void main(String[] args) {
		File file = new File("src/com/liangx/practice/AttributeViewTest.java");
		try (
			FileChannel fio = (new FileInputStream(file)).getChannel();
			FileChannel fos = new FileOutputStream("src/com/liangx/practice/AttributeViewTest_newFile.java").getChannel();
		) {
			ByteBuffer bbuf = ByteBuffer.allocate(10240);
			fio.read(bbuf);
			bbuf.flip();
			fos.write(bbuf);

//			ByteBuffer mbuf = fio.map(FileChannel.MapMode.READ_ONLY, 0 , file.length());
//			System.out.println("mbuf.position = " + mbuf.position());
//			System.out.println("mbuf.limit = " + mbuf.limit());
//			System.out.println("mbuf.capacity = " + mbuf.capacity());
//			String content = Charset.defaultCharset().decode(mbuf).toString();
//			System.out.println(content);
			
			Path testPath = Paths.get("src/com/liangx/practice/AttributeViewTest_newFile.java");
			BasicFileAttributeView basicView = Files.getFileAttributeView(testPath, BasicFileAttributeView.class);
			BasicFileAttributes baseFileAttributes = basicView.readAttributes();
			System.out.println("����ʱ�䣺" + baseFileAttributes.creationTime());
			System.out.println("������ʱ�䣺" + baseFileAttributes.lastAccessTime());
			System.out.println("�����޸�ʱ�䣺" + baseFileAttributes.lastModifiedTime());
			System.out.println("�ļ��Ĵ�С��" + baseFileAttributes.size());
			
			FileOwnerAttributeView fileOwnerAttributeView = Files.getFileAttributeView(testPath, FileOwnerAttributeView.class);
			System.out.println(fileOwnerAttributeView.getOwner());
//			UserPrincipal user = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("guest");
//			fileOwnerAttributeView.setOwner(user);
			
			UserDefinedFileAttributeView userDefinedFileAttributeView = Files.getFileAttributeView(testPath, UserDefinedFileAttributeView.class);
			List<String> attrNames = userDefinedFileAttributeView.list();
			for (String attr : attrNames) {
				ByteBuffer buf = ByteBuffer.allocate(userDefinedFileAttributeView.size(attr));
				userDefinedFileAttributeView.read(attr, buf);
				String value = Charset.defaultCharset().decode(buf).toString();
				System.out.println(attr + " : " + value);
			}
			
			//���һ���Զ�������
			userDefinedFileAttributeView.write("����", Charset.defaultCharset().encode("����"));
			
			//����dos���Ե�DosFileAttributeView
			DosFileAttributeView dosFileAttributeView = Files.getFileAttributeView(testPath, DosFileAttributeView.class);
			dosFileAttributeView.setHidden(true);
			dosFileAttributeView.setReadOnly(true);
			
			
	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
