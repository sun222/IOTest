package com.lingtong.NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
    private static final int BSIZE = 1024;
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileChannel in = new FileInputStream("test.out").getChannel();
		
		FileChannel out = new FileOutputStream("testNIO.out").getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);

		while(in.read(buffer) != -1){
			buffer.flip();
			out.write(buffer);
			buffer.clear();     //清除缓冲器中数据  准备下一次读取
		}
	}

}
