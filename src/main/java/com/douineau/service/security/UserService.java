package com.douineau.service.security;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.douineau.dao.security.IUserDao;
import com.douineau.model.security.User;
import com.douineau.service.IGenericService;

@Service
public class UserService implements IGenericService<User> {
	
	@Autowired
	private IUserDao userRepo;
	
	@Autowired
	private PasswordEncoder passworEncoder;

	@Override
	public User getObject(Integer id) {
		Optional<User> mayBe = userRepo.findById(id);
		if(mayBe.isPresent()) {
			return mayBe.get();
		} else {
			return null;
		}
	}
	
	@Override
	public List<User> getAllObjects() {
		return  (List<User>) userRepo.findAll();
	}

	@Override
	public String addObjects(Set<User> objects) {
		
		for(User user : objects) {
			addObject(user);
		}
		
		return "Objets de type : " + objects.getClass().getName() + " bien insérés";
	}

	@Override
	public String addObject(User object) {
		
		User u = new User(
				object.getName(),
				passworEncoder.encode(object.getPassword()),
				true,
				true,
				true,
				true
				);
	
		User uToUpdateRolesAndPerms = userRepo.save(u);
		
		uToUpdateRolesAndPerms.setRoles(object.getRoles());
		uToUpdateRolesAndPerms.setPermissions(object.getPermissions());
		userRepo.save(uToUpdateRolesAndPerms);
		
		return "Objet de type : " + object.getClass().getName() + " bien inséré";
	}

}
