package com.lingtong.File;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * 运用策略模式   来实现
 * @author wly
 *
 */
public class ProcessFiles {
    
	/**
	 * 策略接口  
	 * @author wly
	 *
	 */
	public interface Strategy{
		/**
		 * 策略接口   具体的策略由实现类去实现
		 * @param file
		 */
		void process(File file);
	}
	
	private Strategy strategy;
	
	private String ext;
	
	public ProcessFiles(Strategy strategy,String ext){
		this.strategy = strategy;
		this.ext = ext;
	}
	
	public void start(String[] args){
		try{
			if(args.length == 0){
				processDirectoryTree(new File("."));
			}else{
			    for(String arg:args){
			    	File fileArg = new File(arg);
			    	if(fileArg.isDirectory()){
			    		processDirectoryTree(fileArg);
			    	}else{
			    		if(!arg.endsWith("."+ext)){
			    			arg += "."+ext;
			    		}
			    		strategy.process(new File(arg).getCanonicalFile());
			    	}
			    }
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void processDirectoryTree(File root) throws IOException{
		for(File file:Directory.walk(root.getAbsolutePath(), ".*\\."+ext)){   //Directory.walk()方法返回TreeInfo对象，该对象已经
			                                                                  //实现Iterable接口  所以可以进行迭代
			strategy.process(file.getCanonicalFile());
		}
	}
	public static void main(String[] args) {
		final List<String>  filePartNameList = new ArrayList<String>();
		new ProcessFiles(new ProcessFiles.Strategy() {
			@Override
			public void process(File file) {
			  filePartNameList.add(file.getName().substring(0, file.getName().lastIndexOf(".")));
			}
		}, "html").start(args);
		
		System.out.println(filePartNameList);
	}
}
