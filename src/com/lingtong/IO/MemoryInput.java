package com.lingtong.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class MemoryInput {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		StringReader sr = new StringReader(BufferedInputFile.read("D:\\a.txt"));
        int c ;
        while((c=sr.read())!=-1){             //StringRead的read方法以int返回字符  ,需要将int转为char
        	System.out.print((char)c);
        }
	}

}
