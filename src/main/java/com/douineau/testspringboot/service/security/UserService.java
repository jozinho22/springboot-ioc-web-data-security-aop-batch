package com.douineau.testspringboot.service.security;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.security.IUserDao;
import com.douineau.testspringboot.model.security.User;
import com.douineau.testspringboot.service.IGenericAdminService;

@Service
public class UserService implements IGenericAdminService<User> {
	
	@Autowired
	private IUserDao repo;

	@Override
	public User getObject(Integer id) {
		Optional<User> mayBe = repo.findById(id);
		if(mayBe.isPresent()) {
			return mayBe.get();
		} else {
			return null;
		}
	}
	
	@Override
	public List<User> getAllObjects() {
		return  (List<User>) repo.findAll();
	}

	@Override
	public String addObjects(Set<User> objects) {
		repo.saveAll(objects);
		return "Objets de type : " + objects.getClass().getTypeName() + " bien insérés";
	}

}
