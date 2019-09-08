package com.liangx.practice;

import java.nio.CharBuffer;

public class BufferTest {

	public static void main(String[] args) {
		
		CharBuffer cbuf = CharBuffer.allocate(64);
		System.out.println("新建CharBuffer的postiton = " + cbuf.position());
		System.out.println("新建CharBufer的limit = " + cbuf.limit());
		System.out.println("新建CharBuffer的capacity = " + cbuf.capacity());
		System.out.println("新建的CharBuffer中position和limit之间的距离为：" + cbuf.remaining());
		cbuf.put('a');
		cbuf.put('b');
		cbuf.put('c');
		System.out.println("添加了a、b、c字符后：");
		System.out.println("CharBuffer的position = " + cbuf.position());
		System.out.println("CharBuffer的limit = " + cbuf.limit());
		System.out.println("CharBuffer中position和limit之间的距离为：" + cbuf.remaining());
		
		cbuf.flip();
		System.out.println("执行flip操作后:");
		System.out.println("CharBuffer的position = " + cbuf.position());
		System.out.println("CharBuffer的limit = " + cbuf.limit());
		System.out.println("调用get(),得到一个个元素:" + cbuf.get());
		System.out.println("此时position = " + cbuf.position());
		cbuf.clear();
		System.out.println("执行clear操作之后");
		System.out.println("CharBuffer的position = " + cbuf.position());
		System.out.println("CharBuffer的limit = " + cbuf.limit());
		System.out.println("为了验证执行clear操作之后，buffer中的元素并未被清除:");
		System.out.println("输出get(0) = " + cbuf.get(0) + ", 输出get(1) = " + cbuf.get(1) + ", 输出get(2) = " + cbuf.get(2));

	}

}
