package com.douineau.testspringboot.service.api;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douineau.testspringboot.dao.api.IBookDao;
import com.douineau.testspringboot.model.api.Book;
import com.douineau.testspringboot.service.IGenericService;

@Service
public class BookService implements IGenericService<Book> {
	
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
		return (List<Book>) repo.findAll();
	}

	@Override
	public String addObject(Book object) {
		repo.save(object);
		return "Objet de type : " + object.getClass().getTypeName() + " bien inséré";
	}

	@Override
	public String addObjects(Set<Book> objects) {
		repo.saveAll(objects);
		return "Objets de type : " + objects.getClass().getTypeName() + " bien insérés";
	}

}
