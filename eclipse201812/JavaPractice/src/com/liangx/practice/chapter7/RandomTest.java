package com.liangx.practice.chapter7;

import java.util.Arrays;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random random = new Random();
		Random random2 = new Random(System.currentTimeMillis());
		System.out.println("random.nextBoolean() = " + random.nextBoolean());
		byte[] buffer = new byte[12];
		random.nextBytes(buffer);
		System.out.println(Arrays.toString(buffer));
		System.out.println(random.nextInt(100) + " " + random.nextInt(100));
		System.out.println(random2.nextInt(100) + " " + random2.nextInt(100));
		System.out.println("random.nextFloat() = " + random.nextFloat());
		System.out.println("random2.nextFloat() = " + random2.nextFloat());
		System.out.println("random2.nextFloat() = " + random2.nextFloat());


	}

}
