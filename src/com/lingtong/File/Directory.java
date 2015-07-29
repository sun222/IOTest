package com.lingtong.File;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class Directory {
   
	public static File[] local(File dir ,final String regex){
		
		return dir.listFiles(new FilenameFilter() {
			private Pattern pattern=Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				
				return pattern.matcher(new File(name).getName()).matches();
			}
		});
	}
	
	public static File[] local(String path,final String regex){
		return local(new File(path), regex);
	}
	
	
	public static class TreeInfo implements Iterable<File>{
        
		private List<File> files = new ArrayList<File>();
		
		private List<File> dirs = new ArrayList<File>();
		@Override
		public Iterator<File> iterator() {
			
			return files.iterator();
		}
		
		public void addAll(TreeInfo other){
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}
		
		public String toString(){
			
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	

	}

}
