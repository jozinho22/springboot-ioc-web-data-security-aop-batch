package com.douineau.dao.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.douineau.model.security.Permission;
import com.douineau.model.security.Role;
import com.douineau.model.security.User;
import com.douineau.security.enums.ApplicationPermission;
import com.douineau.security.enums.ApplicationRole;
import com.google.common.collect.Sets;

@Configuration
public class AuthoritiesInsertEvent {
	
	@Autowired
	private IUserDao userRepo;
	@Autowired
	private IRoleDao roleRepo;
	@Autowired
	private IPermissionDao permRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@EventListener(ApplicationReadyEvent.class)
	public void config() {
	    	
			// inserting the roles ADMIN, USER
			Role admin = new Role(ApplicationRole.ADMIN.name());
			Role user = new Role(ApplicationRole.USER.name());
			roleRepo.saveAll(Sets.newHashSet(admin, user));
			
			// inserting the permissions WRITE, READ
			Permission permToWrite = new Permission(ApplicationPermission.WRITE.name());
			Permission permToRead = new Permission(ApplicationPermission.READ.name());
			permRepo.saveAll(Sets.newHashSet(permToWrite, permToRead));
			
			//Retrieving the entities from database
			Role roleAdmin = roleRepo.findByName(ApplicationRole.ADMIN.name()).get();
			Role roleUser = roleRepo.findByName(ApplicationRole.USER.name()).get();

			Permission permissionToWrite = permRepo.findByName(ApplicationPermission.WRITE.name()).get();
			Permission permissionToRead = permRepo.findByName(ApplicationPermission.READ.name()).get();

	    	User userAdmin = new User(
	    		    "admin",
	    			passwordEncoder.encode("admin"),
	    			true,
	    			true,
	    			true,
	    			true
	    			);
	    	
	    	User userUser = new User(
	    		    "user",
	    			passwordEncoder.encode("user"),
	    			true,
	    			true,
	    			true,
	    			true
	    			);
	    	
	    	userRepo.saveAll(Sets.newHashSet(userAdmin, userUser));
	    	
	    	userAdmin.setRoles(Sets.newHashSet(roleAdmin));
	    	userAdmin.setPermissions(Sets.newHashSet(permissionToWrite, permissionToRead));
	    	userUser.setRoles(Sets.newHashSet(roleUser));
	    	userUser.setPermissions(Sets.newHashSet(permissionToRead));
	    	
	    	userRepo.saveAll(Sets.newHashSet(userAdmin, userUser));
	}

}
