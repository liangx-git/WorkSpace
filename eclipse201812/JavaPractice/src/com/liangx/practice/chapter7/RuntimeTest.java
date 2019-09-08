package com.liangx.practice.chapter7;

import java.io.IOException;

public class RuntimeTest {

	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();
		System.out.println("处理器个数：" + rt.availableProcessors());
		System.out.println("空闲内存数：" + rt.freeMemory());
		System.out.println("总内存数：" + rt.totalMemory());
		System.out.println("最大可用内存数：" + rt.maxMemory());
		rt.exec("notepad.exe");
	}

}
