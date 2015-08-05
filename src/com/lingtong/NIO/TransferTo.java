package com.lingtong.NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TransferTo {
    
	public static void main(String[] args) throws IOException {
		FileChannel in = new FileInputStream("test.out").getChannel();
		
		FileChannel out = new FileOutputStream("testNIO2.out").getChannel();
		
		in.transferTo(0, in.size(), out);
		//Or:
		//out.transferFrom(in,0,in.size());
		
	}
}
