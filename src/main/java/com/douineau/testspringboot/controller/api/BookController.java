package com.douineau.testspringboot.controller.api;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.controller.GenericApiController;
import com.douineau.testspringboot.model.api.Book;
import com.douineau.testspringboot.service.api.BookService;

@RestController
@RequestMapping("api/books")
public class BookController implements GenericApiController<Book>  {
	
	@Autowired
	private BookService service;

	@Override
	public Book getObject(Integer id) {
		return service.getObject(id);
	}
	
	@Override
	public List<Book> getAllObjects() {
		return service.getAllObjects();
	}

	@Override
	public String addObjects(List<Book> objects) {
		service.addObjects(objects);
		return "Livres insérés";
	}
	
	
}
