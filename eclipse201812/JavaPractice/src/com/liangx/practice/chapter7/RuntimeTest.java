package com.liangx.practice.chapter7;

import java.io.IOException;

public class RuntimeTest {

	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();
		System.out.println("������������" + rt.availableProcessors());
		System.out.println("�����ڴ�����" + rt.freeMemory());
		System.out.println("���ڴ�����" + rt.totalMemory());
		System.out.println("�������ڴ�����" + rt.maxMemory());
		rt.exec("notepad.exe");
	}

}
