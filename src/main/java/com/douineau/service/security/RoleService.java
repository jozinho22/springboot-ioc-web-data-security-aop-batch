package com.douineau.service.security;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.dao.security.IRoleDao;
import com.douineau.model.security.Role;
import com.douineau.service.IGenericService;

@Service
public class RoleService implements IGenericService<Role> {
	
	@Autowired
	private IRoleDao dao;

	@Override
	public Role getObject(Integer id) {
		Optional<Role> mayBe = dao.findById(id);
		if(mayBe.isPresent()) {
			return mayBe.get();
		} else {
			return null;
		}
	}
	
	@Override
	public List<Role> getAllObjects() {
		return  (List<Role>) dao.findAll();
	}

	@Override
	public String addObjects(Set<Role> objects) {
		dao.saveAll(objects);
		return "Objets de type : " + objects.getClass().getTypeName() + " bien insérés";
	}

	@Override
	public String addObject(Role object) {
		dao.save(object);
		return "Objet de type : " + object.getClass().getTypeName() + " bien inséré";
	}
}
