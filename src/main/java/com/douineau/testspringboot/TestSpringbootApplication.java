package com.douineau.testspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestSpringbootApplication {
	
//	@Autowired
//	private RoleDao roleDao;
//	@Autowired
//	private PermissionDao permDao;
//	@Autowired
//	private UserDao userDao;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(TestSpringbootApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		
//	    return args -> {
//	    	Role roleAdmin = new Role(ApplicationRole.ADMIN.name());
//	    	Role roleUser = new Role(ApplicationRole.USER.name());
//	    	roleDao.saveAll(Sets.newHashSet(roleAdmin, roleUser));
//
//	    	Permission permToWrite = new Permission(ApplicationPermission.WRITE.name());
//	    	Permission permToRead = new Permission(ApplicationPermission.READ.name());
//	    	permDao.saveAll(Sets.newHashSet(permToWrite, permToRead));
//					 
//	    	User admin = new User(
//	    		    "admin",
//	    			passwordEncoder.encode("admin"),
//	    			true,
//	    			true,
//	    			true,
//	    			true,
//	    			Sets.newHashSet(roleAdmin),
//	    			Sets.newHashSet(ApplicationRole.ADMIN.getPermissions()
//							 .stream()
//							 	.map(p -> new Permission(p.name()))
//							 	.collect(Collectors.toSet()))	
//	    			);
//	    	
//	    	User user = new User(
//	    		    "user",
//	    			passwordEncoder.encode("user"),
//	    			true,
//	    			true,
//	    			true,
//	    			true,
//	    			Sets.newHashSet(roleUser),
//	    			Sets.newHashSet(ApplicationRole.USER.getPermissions()
//							 .stream()
//							 	.map(p -> new Permission(p.name()))
//							 	.collect(Collectors.toSet()))	
//	    			);
//	    	
//	    	userDao.saveAll(Sets.newHashSet(admin, user));
//	        
//	    };
//	}

}
