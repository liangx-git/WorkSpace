package com.liangx.practice.chapter7;

import java.util.Objects;

public class ObjectTest {

	static ObjectTest obj;
	
	public static void main(String[] args) {
		System.out.println(Objects.hashCode(obj));
		System.out.println(Objects.toString(obj));
		System.out.println(Objects.requireNonNull(obj, "obj参数不能为null"));
	}

}
