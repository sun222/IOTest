package com.lingtong.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut {
    public static String file = "FileOutputShortcut.out";
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(
        		    new StringReader(BufferedInputFile.read("D:\\ProgramFiles\\MyEclipseWorkspace\\IOTest\\src\\com\\lingtong\\IO\\FileOutputShortcut.java")));
          
          /*简化包装*/
          PrintWriter pw = new PrintWriter(file);
          
          int lineCount = 1;
          
          String s;
          while((s = br.readLine()) != null){
        	  pw.println(lineCount++ +":" +s);
          }
          pw.close();
          System.out.println(BufferedInputFile.read(file));
	}

}
