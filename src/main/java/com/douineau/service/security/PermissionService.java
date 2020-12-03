package com.douineau.service.security;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.dao.security.IPermissionDao;
import com.douineau.model.security.Permission;
import com.douineau.service.IGenericService;

@Service
public class PermissionService implements IGenericService<Permission> {
	
	@Autowired
	private IPermissionDao repo;

	@Override
	public Permission getObject(Integer id) {
		Optional<Permission> mayBe = repo.findById(id);
		if(mayBe.isPresent()) {
			return mayBe.get();
		} else {
			return null;
		}
	}
	
	@Override
	public List<Permission> getAllObjects() {
		return  (List<Permission>) repo.findAll();
	}

	@Override
	public String addObjects(Set<Permission> objects) {
		repo.saveAll(objects);
		return "Objets de type : " + objects.getClass().getTypeName() + " bien insérés";
	}

	@Override
	public String addObject(Permission object) {
		repo.save(object);
		return "Objet de type : " + object.getClass().getTypeName() + " bien inséré";
	}

}
