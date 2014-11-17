package com.oded.spring.data.elasticsearch.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "books",type="book")
public class Book {
	
	
	@Id
	private String id;
	
	@Field(type=FieldType.String,index=FieldIndex.not_analyzed)
	private String name;
	
	@Field(type=FieldType.Nested)
	private Auther autore;
	
	
	
	
	public Book(){}
	
    public Book(String name,Auther auther){
    	this.name = name;
    	//this.id = id;
        this.autore = auther;
    	
    }
    
	
	
	public String getName() {
		return name;
	}
	
		
	public void setName(String name) {
		this.name = name;
	}







	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Auther getAutore() {
		return autore;
	}



	public void setAutore(Auther autore) {
		this.autore = autore;
	}


	
	

}
