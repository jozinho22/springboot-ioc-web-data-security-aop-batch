package com.douineau.testspringboot.service.security;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.security.IRoleDao;
import com.douineau.testspringboot.model.security.Role;
import com.douineau.testspringboot.service.IGenericService;

@Service
public class RoleService implements IGenericService<Role> {
	
	@Autowired
	private IRoleDao repo;

	@Override
	public Role getObject(Integer id) {
		Optional<Role> mayBe = repo.findById(id);
		if(mayBe.isPresent()) {
			return mayBe.get();
		} else {
			return null;
		}
	}
	
	@Override
	public List<Role> getAllObjects() {
		return  (List<Role>) repo.findAll();
	}

	@Override
	public String addObjects(Set<Role> objects) {
		repo.saveAll(objects);
		return "Objets de type : " + objects.getClass().getTypeName() + " bien insérés";
	}

	@Override
	public String addObject(Role object) {
		repo.save(object);
		return "Objet de type : " + object.getClass().getTypeName() + " bien inséré";
	}
}
