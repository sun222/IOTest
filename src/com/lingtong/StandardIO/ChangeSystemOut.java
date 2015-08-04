package com.lingtong.StandardIO;

import java.io.PrintWriter;

public class ChangeSystemOut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out,true);
		out.println("Hello ,world");
	}

}
