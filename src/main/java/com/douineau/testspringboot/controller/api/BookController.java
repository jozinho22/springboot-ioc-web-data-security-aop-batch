package com.douineau.testspringboot.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.controller.IGenericApiController;
import com.douineau.testspringboot.model.api.Book;
import com.douineau.testspringboot.service.api.BookService;

@RestController
@RequestMapping("api/books")
public class BookController implements IGenericApiController<Book>  {
	
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
