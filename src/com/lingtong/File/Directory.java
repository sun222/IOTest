package com.lingtong.File;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 处理目录的工具类
 * @author wly
 *
 */
public final class Directory {
   
	/**
	 * 根据正则表达式 过滤得到目录的File对象数组
	 * @param dir   要过滤的目录对象
	 * @param regex  过滤的正则表达式
	 * @return
	 */
	public static File[] local(File dir ,final String regex){
		
		return dir.listFiles(new FilenameFilter() {
			private Pattern pattern=Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				
				return pattern.matcher(new File(name).getName()).matches();
			}
		});
	}
	
	/**
	 * 根据正则表达式 过滤得到目录路径所对应的目录的File对象数组
	 * @param path 要过滤的目录对象
	 * @param regex  过滤的正则表达式
	 * @return
	 */
	public static File[] local(String path,final String regex){            //overload
		return local(new File(path), regex);
	}
	
	
	public static class TreeInfo implements Iterable<File>{
        
		private List<File> files = new ArrayList<File>();
		
		private List<File> dirs = new ArrayList<File>();
		/**
		 * 默认返回文件集合的迭代器对象
		 */
		@Override
		public Iterator<File> iterator() {
			
			return files.iterator();
		}
		
		public void addAll(TreeInfo other){
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}
		
		public String toString(){
			return "dirs: "+dirs.toString()+"\n\nfiles: "+files.toString();
		}
		
	}
	
	public static TreeInfo walk(String start,String regex){
		return  recurseDirs(new File(start) ,regex);
	}
	
	public static TreeInfo walk(File start ,String regex){
		return recurseDirs(start,regex);
	}
	
	public static TreeInfo walk(File start){
		return recurseDirs(start,".*");
	}
	
	public static TreeInfo walk(String start){
		return recurseDirs(new File(start),".*");
	}
	
	/**
	 * 过滤目录文件
	 * @param startDir
	 * @param regex
	 * @return
	 */
	static TreeInfo  recurseDirs(File startDir,String regex){
		TreeInfo result = new TreeInfo();
		for(File item : startDir.listFiles()){
			if(item.isDirectory()){      //目录文件 直接加入目录集合
				result.dirs.add(item);
			}else{                       //普通文件  将匹配正则表达式的加入文件集合
				if(item.getName().matches(regex)){
					result.files.add(item);
				}
			}
		}
		return result;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	       
		if(args.length==0){
			System.out.println(walk("."));
		}else{
			for(String arg:args){
				System.out.println(walk(arg));
			}
		}
	}

}
