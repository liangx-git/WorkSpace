package com.liangx.practice.Array;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		int[] a = new int[] {3, 4, 5, 6};
		int[] a2 = new int[] {3, 4, 5, 6};
		System.out.println("a�����a2�����Ƿ���ȣ�" + Arrays.equals(a, a2));
		int[] b = Arrays.copyOf(a, 6);
		System.out.println("a�����b�����Ƿ���ȣ�" + Arrays.equals(a, b));
		System.out.println(Arrays.toString(b));
		Arrays.fill(b, 2, 4, 1);
		System.out.println(Arrays.toString(b));
		Arrays.sort(b);
		System.out.println(Arrays.toString(b));
	}

}
