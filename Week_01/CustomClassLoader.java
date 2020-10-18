package week1.jvm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomClassLoader extends ClassLoader{
	
	private int key;
	private String rootFolder="C:\\Users\\Administrator\\eclipse-workspace\\JavaLearning\\bin\\";
	

	public CustomClassLoader(int key) {
		this.key = key;
		//this.className = className;
	}
	
	protected Class<?> findClass(String className) throws ClassNotFoundException{
		
		try {
			byte[] classBytes = null; 
			classBytes = loadClassBytes(className);
			Class<?> cl = defineClass(className,classBytes,0,classBytes.length);
			if(cl == null) throw new ClassNotFoundException(); 
			return cl;
			
		}catch(IOException ex){
			throw new ClassNotFoundException();
		}
	}
	
	
	private byte[] loadClassBytes(String className) throws IOException{
		String fileName = rootFolder + className.replace(".", "\\") + ".xlass";
		//System.out.println(fileName);
		byte[] bytes = Files.readAllBytes(Paths.get(fileName)); 

		for(int i = 0; i<bytes.length; i++) {
			bytes[i] = (byte)(key - bytes[i]);
		}
		//System.out.println(bytes.length);
		return bytes;
		
	}
	
	

}
