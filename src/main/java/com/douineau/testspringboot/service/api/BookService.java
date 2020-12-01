package com.douineau.testspringboot.service.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.api.IBookDao;
import com.douineau.testspringboot.model.api.Book;
import com.douineau.testspringboot.service.IGenericApiService;

@Service
public class BookService implements IGenericApiService<Book> {
	
	@Autowired
	private IBookDao repo;

	@Override
	public Book getObject(Integer id) {
		Optional<Book> mayBe = repo.findById(id);
		if(mayBe.isPresent()) {
			return mayBe.get();
		} else {
			return null;
		}
	}
	
	@Override
	public List<Book> getAllObjects() {
		return  (List<Book>) repo.findAll();
	}

	@Override
	public String addObjects(List<Book> objects) {
		repo.saveAll(objects);
		return "Objets de type : " + objects.getClass().getTypeName() + " bien insérés";
	}

}
