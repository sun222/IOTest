package com.lingtong.IO;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		try{
			DataInputStream ds = new DataInputStream(new ByteArrayInputStream
		            (BufferedInputFile.read("D:\\a.txt").getBytes()));

            while(true){
	           System.out.print((char)ds.readByte());
            }
		}catch (EOFException e) {
			System.err.println("End of stream.");
		}
		
	}

}
