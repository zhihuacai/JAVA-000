package week1.jvm;

import java.lang.reflect.Method;

public class CustomClassLoaderTest {
	
	public static void main(String [] args) {
		
		CustomClassLoader cl = new CustomClassLoader(255);
		try {
			Class <?> c = cl.loadClass("Hello");
			
			Method [] ms = c.getMethods();
			for(Method m: ms) {
				if (m.getName() == "hello"){
					m.invoke(c.newInstance(), null);
				}
			}
			
			Method m = c.getMethod("hello", null);
			m.invoke(c.newInstance(), null);
			 
		
		}catch(ClassNotFoundException ex){
			System.out.println(ex.getMessage());
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	

}
