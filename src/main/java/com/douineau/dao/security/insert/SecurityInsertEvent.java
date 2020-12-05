package com.douineau.dao.security.insert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.douineau.dao.security.IPermissionDao;
import com.douineau.dao.security.IRoleDao;
import com.douineau.dao.security.IUserDao;
import com.douineau.model.security.Permission;
import com.douineau.model.security.Role;
import com.douineau.model.security.User;
import com.douineau.security.enums.ApplicationPermission;
import com.douineau.security.enums.ApplicationRole;
import com.google.common.collect.Sets;

@Configuration
public class SecurityInsertEvent {
	
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IRoleDao roleDao;
	@Autowired
	private IPermissionDao permDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@EventListener(ApplicationReadyEvent.class)
	public void insert() {

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
	    	
	    	userDao.saveAll(Sets.newHashSet(userAdmin, userUser));
	    	
			// inserting the roles ADMIN, USER
			Role roleAdmin = new Role(ApplicationRole.ADMIN.name());
			Role roleUser = new Role(ApplicationRole.USER.name());
			roleDao.saveAll(Sets.newHashSet(roleAdmin, roleUser));
			
			// inserting the permissions WRITE, READ
			Permission permToWrite = new Permission(ApplicationPermission.WRITE.name());
			Permission permToRead = new Permission(ApplicationPermission.READ.name());
			permDao.saveAll(Sets.newHashSet(permToWrite, permToRead));
			
			// updating users with authorities
	    	userAdmin.setRoles(Sets.newHashSet(roleAdmin));
	    	userAdmin.setPermissions(Sets.newHashSet(permToWrite, permToRead));
	    	userUser.setRoles(Sets.newHashSet(roleUser));
	    	userUser.setPermissions(Sets.newHashSet(permToRead));
	    	userDao.saveAll(Sets.newHashSet(userAdmin, userUser));
	}

}
