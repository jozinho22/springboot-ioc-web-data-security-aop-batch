package com.douineau.testspringboot.service.api;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.api.IWriterDao;
import com.douineau.testspringboot.model.api.Writer;
import com.douineau.testspringboot.service.IGenericService;

@Service
public class WriterService implements IGenericService<Writer> {
	
	@Autowired
	private IWriterDao repo;

	@Override
	public Writer getObject(Integer id) {
		Optional<Writer> mayBe = repo.findById(id);
		if(mayBe.isPresent()) {
			return mayBe.get();
		} else {
			return null;
		}
	}
	
	@Override
	public List<Writer> getAllObjects() {
		return  (List<Writer>) repo.findAll();
	}

	@Override
	public String addObjects(Set<Writer> objects) {
		repo.saveAll(objects);
		return "Objets de type : " + objects.getClass().getTypeName() + " bien insérés";
	}

	@Override
	public String addObject(Writer object) {
		repo.save(object);
		return "Objet de type : " + object.getClass().getTypeName() + " bien inséré";
	}

}

