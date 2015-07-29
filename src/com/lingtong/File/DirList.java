package com.lingtong.File;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {

	/**
	 * @param args    过滤条件
	 */
	public static void main(String[] args) {
	   File file = new File("F:\\P4\\01宝宝在线\\9期\\01App\\03源码类\\04App_GeTui\\src\\Demo");
	  
	   String[] list;
	   if(args.length == 0){
		   list = file.list();
	   }else{
		   list = file.list(new DirFilter(args[0]));
	   }
       Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
       
       for(String fileName : list){
    	   System.out.println(fileName);
       }
	}

}

class DirFilter implements FilenameFilter{
    private Pattern pattern;
    
    public DirFilter(String regex){
    	this.pattern = Pattern.compile(regex);
    }
	
	@Override
	public boolean accept(File dir, String name) {
		
		return pattern.matcher(name).matches();
	}
	
}