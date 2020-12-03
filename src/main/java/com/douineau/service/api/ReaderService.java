package com.douineau.service.api;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.dao.api.IReaderDao;
import com.douineau.model.api.Reader;
import com.douineau.service.IGenericService;

@Service
public class ReaderService implements IGenericService<Reader> {
	
	@Autowired 
	private IReaderDao repo;

	@Override
	public Reader getObject(Integer id) {
		Optional<Reader> mayBe = repo.findById(id);
		if(mayBe.isPresent()) {
			return mayBe.get();
		} else {
			return null;
		}
	}
	
	@Override
	public List<Reader> getAllObjects() {
		return  (List<Reader>) repo.findAll();
	}

	@Override
	public String addObjects(Set<Reader> objects) {
		repo.saveAll(objects);
		return "Objets de type : " + objects.getClass().getTypeName() + " bien insérés";
	}

	@Override
	public String addObject(Reader object) {
		repo.save(object);
		return "Objet de type : " + object.getClass().getTypeName() + " bien inséré";
	}
}
