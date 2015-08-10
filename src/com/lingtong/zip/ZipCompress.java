package com.lingtong.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
/**
 * 用Zip进行多文件的压缩
 * @author wly
 *
 */
public class ZipCompress {
    public static void main(String[] args) throws IOException {
    	//压缩文件
		FileOutputStream f = new FileOutputStream("test.zip");
		//第二个参数 Checksum类用来计算和检验文件的校验和
		CheckedOutputStream csum = new CheckedOutputStream(f,new Adler32());
		
		ZipOutputStream zos = new ZipOutputStream(csum);
		
		BufferedOutputStream out = new BufferedOutputStream(zos);
		zos.setComment("A test of Java Zipping");
		
		String[] files = new String[]{"nio.txt","nio2.txt","test.txt","testNIO.out"};
		
		for(String file : files){
			System.out.println("Writing file " + file);
			BufferedReader in = new BufferedReader(new FileReader(file));
			
			zos.putNextEntry(new ZipEntry(file));
			
			int c;
			while((c= in.read())!=-1){
				out.write(c);
			}
			in.close();
			out.flush();
		}
		out.close();
		
		System.out.println("Checksum: "+csum.getChecksum().getValue());
		//开始解压读取压缩包
		System.out.println("Reading file");
		FileInputStream fi = new FileInputStream("test.zip");
		CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
		
		ZipInputStream in2 = new ZipInputStream(csumi);
		BufferedInputStream bis = new BufferedInputStream(in2);
		ZipEntry ze;
		while((ze = in2.getNextEntry())!= null){
			System.out.println("\nReading file " + ze);
			int x ;
			while((x=bis.read())!=-1){
				System.out.write(x);
			}
		}
		
		bis.close();
		
	}
}
