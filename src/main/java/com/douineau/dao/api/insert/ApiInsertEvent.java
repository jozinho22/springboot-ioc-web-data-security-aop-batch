//package com.douineau.dao.api.insert;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.EventListener;
//
//import com.douineau.dao.api.IAuthorDao;
//import com.douineau.dao.api.IBookDao;
//import com.douineau.model.api.Author;
//import com.douineau.model.api.Book;
//import com.google.common.collect.Sets;
//
//@Configuration
//public class ApiInsertEvent {
//	
//	@Autowired
//	private IBookDao bookDao;
//	@Autowired
//	private IAuthorDao authorDao;
//
//	
//	@EventListener(ApplicationReadyEvent.class)
//	public void insert() {
//	    	
//			Author georgesOrwell = new Author("George Orwell");
//			Author laoTseu = new Author("Lao Tseu");
//			authorDao.saveAll(Sets.newHashSet(georgesOrwell, laoTseu));
//			
//			Book book = new Book("1984", georgesOrwell);
//			Book book2 = new Book("Tao te king", laoTseu);
//			bookDao.saveAll(Sets.newHashSet(book, book2));
//	}
//
//}
