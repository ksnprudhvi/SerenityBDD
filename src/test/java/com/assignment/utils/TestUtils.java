package com.assignment.utils;

import java.util.Random;

public class TestUtils {
	public static String getRandomValue() {
		Random random = new Random();
		int randomInt = random.nextInt(999999999);
		return Integer.toString(randomInt);
	}
}
