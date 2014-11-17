package com.oded.spring.data.elasticsearch.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.oded.spring.data.elasticsearch.entities.Book;


public interface BookRepository extends ElasticsearchRepository< Book,String> {
	
	Page<Book> findByAutoreName(String name,Pageable pageable);
	
	//@Query(value="{\"match_phrase_prefix\" : { \"name\" : \"?0\" }}")
	  @Query(value="{\"filtered\" : {\"filter\" : {\"term\" : {\"name\" : \"?0\" }}}}")
	Page<Book> findByName(String name,Pageable pageable); 
	
	

}
