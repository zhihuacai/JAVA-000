package com.czh.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Student implements Serializable {
    
    private int id;
    private String name;
    
    public Student(int id, String name) {
    	this.id = id;
    	this.name = name;
    	
    }
    
    public Student() {    	
    	this.id = 1;
    	this.name = "student01";
    	
    }
    
    public void init(){
        System.out.println("hello...........");
    }
    
    
    
    @Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	public Student create(){
        return new Student(101,"KK101");
    }
    
    
}

