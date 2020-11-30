package com.douineau.testspringboot.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.api.BookDao;
import com.douineau.testspringboot.model.api.Book;
import com.douineau.testspringboot.service.IGenericApiService;

@Service
public class BookService implements IGenericApiService<Book> {
	
	@Autowired 
	private BookDao repo;

	@Override
	public Book getObject(Integer id) {
		return repo.findById(id).get();
	}
	
	@Override
	public List<Book> getAllObjects() {
		return (List<Book>) repo.findAll();
	}

	@Override
	public void addObjects(List<Book> objects) {
		repo.saveAll(objects);
	}
	
//	public List<Technique> getT {
//		return (List<Technique>) repo.findAll();
//	}
//
//	public void addLaptops(List<Technique> laptops) {
//		repo.saveAll(laptops);
//	}

}
