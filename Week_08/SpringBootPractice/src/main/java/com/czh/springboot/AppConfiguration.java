package com.czh.springboot;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.czh.springboot.entity.Klass;
import com.czh.springboot.entity.School;
import com.czh.springboot.entity.Student;
import com.czh.springboot.multiple.source.MultiSourceV1;

@Configuration
@ConditionalOnClass(Student.class)
public class AppConfiguration {
	
	
    @Bean(name = "student123")
    @ConditionalOnMissingBean(Student.class)
    public Student student123(){
    	Student student123 = new Student();
        return student123;
    }
    
    @Bean(name = "student100")
    @ConditionalOnMissingBean(Student.class)
    public Student student100(){
    	Student student100 = new Student(100,"student100");
        return student100;
    }
    
    @Bean(name = "school")
    @ConditionalOnMissingBean(School.class)
    public School school(){
    	School school = new School();
        return school;
    }	
    
    @Bean(name = "school1")
    @ConditionalOnMissingBean(School.class)
    public School school1(){
    	School school1 = new School();
        return school1;
    }	
    
    
    @Bean(name = "class1")
    @ConditionalOnMissingBean(Klass.class)
    public Klass class1(){
    	Klass class1 = new Klass();
        return class1;
    }
    
    
    @Bean(name = "multiSource1")
    @ConditionalOnMissingBean(MultiSourceV1.class)
    public MultiSourceV1 multiSource1(){
    	MultiSourceV1 multiSource1 = new MultiSourceV1();
        return multiSource1;
    }
    
    /*
    @Bean(name = "dataSource")
    @ConditionalOnMissingBean(DataSource.class)
    public DataSource dataSource(){
    	DataSource dataSource = new DataSource();
        return dataSource;
    }
    */

}
