package com.liangx.practice;

import java.nio.CharBuffer;

public class BufferTest {

	public static void main(String[] args) {
		
		CharBuffer cbuf = CharBuffer.allocate(64);
		System.out.println("�½�CharBuffer��postiton = " + cbuf.position());
		System.out.println("�½�CharBufer��limit = " + cbuf.limit());
		System.out.println("�½�CharBuffer��capacity = " + cbuf.capacity());
		System.out.println("�½���CharBuffer��position��limit֮��ľ���Ϊ��" + cbuf.remaining());
		cbuf.put('a');
		cbuf.put('b');
		cbuf.put('c');
		System.out.println("�����a��b��c�ַ���");
		System.out.println("CharBuffer��position = " + cbuf.position());
		System.out.println("CharBuffer��limit = " + cbuf.limit());
		System.out.println("CharBuffer��position��limit֮��ľ���Ϊ��" + cbuf.remaining());
		
		cbuf.flip();
		System.out.println("ִ��flip������:");
		System.out.println("CharBuffer��position = " + cbuf.position());
		System.out.println("CharBuffer��limit = " + cbuf.limit());
		System.out.println("����get(),�õ�һ����Ԫ��:" + cbuf.get());
		System.out.println("��ʱposition = " + cbuf.position());
		cbuf.clear();
		System.out.println("ִ��clear����֮��");
		System.out.println("CharBuffer��position = " + cbuf.position());
		System.out.println("CharBuffer��limit = " + cbuf.limit());
		System.out.println("Ϊ����ִ֤��clear����֮��buffer�е�Ԫ�ز�δ�����:");
		System.out.println("���get(0) = " + cbuf.get(0) + ", ���get(1) = " + cbuf.get(1) + ", ���get(2) = " + cbuf.get(2));

	}

}
