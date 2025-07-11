package com.hadasj;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		System.out.println(KamenNuzkyPapir.popisHry());

		final var hra = new KamenNuzkyPapir();
		try {
			// input from user
			var input = (char) System.in.read();
			int number = input - '0';

			hra.setUp(number);
			System.out.println(hra.eval());
		} catch (IOException e) {
			System.out.println("Necekana chyba " + e);
		}
	}
}
