package com.lingtong.IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutput {
    public static String file = "BasicFileOutput.out";
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(
        		  new StringReader(BufferedInputFile.read("D:\\ProgramFiles\\MyEclipseWorkspace\\IOTest\\src\\com\\lingtong\\IO\\BasicFileOutput.java")));
         
         PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
         
         int lineCount = 1;
         String s;
         while((s=br.readLine()) != null){
        	pw.println(lineCount++ + ":" +s); 
         }
         pw.close();
         System.out.println(BufferedInputFile.read(file));
	}

}
