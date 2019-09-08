package com.liangx.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {

	public static void main(String[] args) {
		
		File file = new File("src/com/liangx/practice/FileChannelTest_newFile.txt");
		try(
			FileOutputStream fos = new FileOutputStream(file);
			FileInputStream fis = new FileInputStream(file);
		){
			//拷贝文件
			copyFile("src/com/liangx/practice/FileChannelTest.java", file.getPath());
//			System.out.println("name = " + file.getName());
//			System.out.println("absolutePath = " + file.getAbsolutePath());
//			System.out.println("absoluteFile = " + file.getAbsoluteFile());
//			System.out.println("path = " + file.getPath());
			FileChannel inChannel = fis.getChannel();
			FileChannel outChannel = fos.getChannel();
			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			System.out.println("MappedByteBuffer创建");
			System.out.println("position = " + buffer.position());
			System.out.println("limit = " + buffer.limit());
			System.out.println("capacity = " + buffer.capacity());
//			buffer.flip();
//			System.out.println("执行flip之后");
//			System.out.println("position = " + buffer.position());
//			System.out.println("limit = " + buffer.limit());
//			System.out.println("capacity = " + buffer.capacity());
			outChannel.write(buffer);
			System.out.println("输出buffer后");
			System.out.println("position = " + buffer.position());
			System.out.println("limit = " + buffer.limit());
			System.out.println("capacity = " + buffer.capacity());
//			buffer.position(0);
			
			buffer.clear();
			Charset charset = Charset.forName("GBK");
			CharsetDecoder decoder = charset.newDecoder();
			CharBuffer cbuf = decoder.decode(buffer);
			System.out.println(cbuf);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private static void copyFile(String source, String destination) {
		try(
			FileInputStream fis = new FileInputStream(source);
			FileOutputStream fos = new FileOutputStream(destination);
		) {
			byte[] buf = new byte[1024];
			int hasRead = 0;
			while ((hasRead = fis.read(buf)) > 0) {
				fos.write(buf, 0, hasRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
