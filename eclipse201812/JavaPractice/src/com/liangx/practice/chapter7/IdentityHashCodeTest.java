package com.liangx.practice.chapter7;

public class IdentityHashCodeTest {

	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("hello");
		System.out.println(s1.hashCode() + "----" + s2.hashCode());
		System.out.println(System.identityHashCode(s1) + "----" + System.identityHashCode(s2));
		
		String s3 = "hello";
		String s4 = "hello";
		System.out.println(s3.hashCode() + "----" + s4.hashCode());
		System.out.println(System.identityHashCode(s3) + "----" + System.identityHashCode(s4));
	}

}
