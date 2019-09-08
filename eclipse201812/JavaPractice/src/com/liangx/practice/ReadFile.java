package com.liangx.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {

	public static void main(String[] args) {
		File file = new File("src/com/liangx/practice/ReadFile.java");
		try(
			FileInputStream fis = new FileInputStream(file);
			FileChannel fcin = fis.getChannel();
		){
			ByteBuffer buffer = ByteBuffer.allocate(32);
			while (fcin.read(buffer) != -1) {
				//����buffer�հ�����ʼ��ȡ����
				buffer.flip();
				Charset charset = Charset.forName("GBK");
				CharsetDecoder decoder = charset.newDecoder();
				CharBuffer cbuf = decoder.decode(buffer);
				System.out.print(cbuf);
				
				//д������ǰִ��clear
				buffer.clear();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
