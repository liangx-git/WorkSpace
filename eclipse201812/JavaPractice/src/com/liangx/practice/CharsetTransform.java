package com.liangx.practice;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTransform {

	public static void main(String[] args) throws CharacterCodingException {
		
		Charset cn = Charset.forName("GBK");
		CharsetDecoder cnDecoder = cn.newDecoder();
		CharsetEncoder cnEncoder = cn.newEncoder();
		
		CharBuffer cbuf = CharBuffer.allocate(64);
		cbuf.put("Ыя");
		cbuf.put("Юђ");
		cbuf.put("Пе");
		cbuf.flip();
		ByteBuffer bbuf = cnEncoder.encode(cbuf);
		for (int i = 0; i < bbuf.capacity(); ++i) {
			System.out.println(bbuf.get(i) + " ");
		}
		System.out.println(cnDecoder.decode(bbuf));
	}

}
