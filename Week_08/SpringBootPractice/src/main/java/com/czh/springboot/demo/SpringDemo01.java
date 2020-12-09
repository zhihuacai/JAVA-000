package com.czh.springboot.demo;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.czh.springboot.aop.ISchool;
import com.czh.springboot.entity.Student;
import com.czh.springboot.entity.Klass;
import com.czh.springboot.AppConfiguration;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
@SpringBootApplication
public class SpringDemo01 {
	
	private Student student100;
	private Klass class1;
	private ISchool school;
	private ISchool school1;
	@Autowired
	private Student student123;
    public static void main(String[] args) {
        
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Student student123 = context.getBean(Student.class);
        Student student1234 = context.getBean(Student.class);
        
        System.out.println(student123);
        System.out.println(student1234);
    	System.out.println(student123.toString());
    	System.out.println(student1234.toString());
    	
    	
        Klass class1 = context.getBean(Klass.class);
        
        System.out.println(class1);
        System.out.println("Klass对象AOP代理后的实际类型："+class1.getClass());
        System.out.println("Klass对象AOP代理后的实际类型是否是Klass子类："+(class1 instanceof Klass));
        
        System.out.println(class1.toString());
        
        
        ISchool school = context.getBean(ISchool.class);
        ISchool school1 = context.getBean(ISchool.class);
        


    
        
        System.out.println(school);
        System.out.println("ISchool接口的对象AOP代理后的实际类型："+school.getClass());
        
        // = context.getBean(ISchool.class);
        System.out.println(school1);
        System.out.println("ISchool接口的对象AOP代理后的实际类型："+school1.getClass());
        
        
        System.out.println(school.toString());
        System.out.println(school1.toString());
        
        
        class1.dong();
        school1.ding();
        
        
    
        //System.out.println("   context.getBeanDefinitionNames() ===>> "+ String.join(",", context.getBeanDefinitionNames()));
        

    }
}