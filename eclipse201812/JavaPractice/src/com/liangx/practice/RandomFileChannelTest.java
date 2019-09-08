package com.liangx.practice;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomFileChannelTest {

	public static void main(String[] args) {
		File file = new File("src/com/liangx/practice/FileChannelTest_newFile.txt");
		try(
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			FileChannel randomChannel = raf.getChannel();
		){
			ByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_WRITE, 0, file.length());
			randomChannel.position(file.length());
			randomChannel.write(buffer);
			
		} catch(IOException e) {
			
		}

	}

}
