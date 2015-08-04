package com.lingtong.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.management.RuntimeErrorException;

public class TextFile extends ArrayList<String>{
    //Read a file as a single string:
	public static String read(String fileName){
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(
					           new FileReader(new File(fileName).getAbsoluteFile()));
			String s;
			try {
				while((s=in.readLine())!=null){
					sb.append(s);
					sb.append("\n");
				}
			} finally{
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return sb.toString();
	}
	//Write a single file in one method call:
	public static void write(String fileName,String text){
		
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try{
				out.print(text);
			}finally{
				out.close();
			}
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	//Read a file ,split by any regular expression:
	public TextFile(String fileName,String splitter){
		super(Arrays.asList(read(fileName).split(splitter)));
		
		if(get(0).equals("")){
			remove(0);
		}
	}
	
	//Normally read by lines
	public TextFile(String fileName){
		this(fileName, "\n");
	}
	
	public void write(String fileName){
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try{
				for(String item : this){
					out.println(item);
				}
			}finally{
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Read
		String file = read("D:\\ProgramFiles\\MyEclipseWorkspace\\IOTest\\src\\com\\lingtong\\util\\TextFile.java");
        //Write
		write("test.txt", file);
		
		
		//Read as a list
		TextFile text = new TextFile("test.txt");
		
		//write
		text.write("test2.txt");
	}

}
