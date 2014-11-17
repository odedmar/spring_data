package com.oded.spring.data.elasticsearch.repository.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import javax.print.attribute.standard.PageRanges;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.oded.spring.data.elasticsearch.configuration.ApplicationConfig;
import com.oded.spring.data.elasticsearch.entities.Auther;
import com.oded.spring.data.elasticsearch.entities.Book;
import com.oded.spring.data.elasticsearch.repository.BookRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=ApplicationConfig.class)
public class BookRepositoryTest {
	
	
	@Autowired
	private BookRepository book_rep;
	
	@Autowired
	private ElasticsearchTemplate et;
	
	
	
	@Before
	public void setBooks(){
		
//		et.deleteIndex(Book.class);
//        et.createIndex(Book.class);
//        et.refresh(Book.class, true);
		book_rep.save(new Book("milchame veshalom",new Auther("oded")));
		book_rep.save(new Book("milchame aaa",new Auther("oded")));
		book_rep.save(new Book("milchame ddd",new Auther("oded")));
		book_rep.save(new Book("milchame www",new Auther("oded")));
		book_rep.save(new Book("milchame aaa",new Auther("oded")));
		
	}
	
	@Test
	public void findBookByAuthorName(){
		
		
		
		// Page<Book> bookList = book_rep.findByAutoreName("oded", new PageRequest(0, 100));
		
		Page<Book> bookList = book_rep.findAll(new PageRequest(0, 100));
		System.out.println("number of books is!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! : " + bookList.getContent().size());
		
		assertThat(new Long(bookList.getContent().size()) ,is(equalTo(book_rep.count())));
		
	}
	
	
	
	@Test
	public void findBookByName(){
	Page<Book> book =  book_rep.findByName("milchame www",new PageRequest(0, 10));
	
	for(Book book1 : book.getContent())
		System.out.println("the book name is: " + book1.getName());
	
		
	}

}
