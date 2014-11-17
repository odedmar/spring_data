package com.oded.spring.data.elasticsearch.entities;

public class Auther {
	
	private String name;
	
	
	public Auther(){
	}
	
	public Auther(String name){
		
		this.name = name;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//private Book books[];
	
	

}
