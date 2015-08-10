package com.lingtong.NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
    private static final int BSIZE = 1024;
    
    public static void main(String[] args) throws IOException {
		FileChannel fc = new FileOutputStream("nio2.txt").getChannel();
		
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		
		fc = new FileInputStream("nio2.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		
		//Doesn't work.
		System.out.println("1--------"+buff.asCharBuffer());
		
		//Decode using this system's default Charset.
		buff.rewind();       //返回到数据开始部分
		String encoding = System.getProperty("file.encoding");    
		System.out.println("Decoded using "+encoding+":"+Charset.forName(encoding).decode(buff));
		
		//Use a CharBuffer to write through:
		fc = new FileOutputStream("nio2.txt").getChannel();
		buff = ByteBuffer.allocate(24);
		buff.asCharBuffer().put("More text");
		fc.write(buff);
		fc.close();
		
		//Read and display:
		fc = new FileInputStream("nio2.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		
		System.out.println("2-----------"+buff.asCharBuffer());
		
	}
}
