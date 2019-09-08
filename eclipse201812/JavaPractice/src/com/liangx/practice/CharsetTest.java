package com.liangx.practice;

import java.nio.charset.Charset;
import java.util.Map;

public class CharsetTest {

	public static void main(String[] args) {
		Map<String, Charset> map = Charset.availableCharsets();
		for (String alias : map.keySet()) {
			System.out.println(alias + "---->" + map.get(alias));
		}
	}

}
