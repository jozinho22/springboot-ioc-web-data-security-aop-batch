package com.douineau.dao.api.insert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.douineau.dao.api.IAuthorDao;
import com.douineau.dao.api.IBookDao;
import com.douineau.model.api.Author;
import com.douineau.model.api.Book;
import com.google.common.collect.Sets;
import org.springframework.core.env.Environment;

@Configuration
public class ApiInsertEvent {
	
	@Autowired
	private IBookDao bookDao;
	@Autowired
	private IAuthorDao authorDao;

	@Value("${spring.profiles.active}")
	private String activeProfile;
	
	@EventListener(ApplicationReadyEvent.class)
	public void insert() {

			System.out.println("Inserting the datas :");
		    System.out.println("Current profile is  : " + activeProfile);

			Author georgesOrwell = new Author("George Orwell");
			Author laoTseu = new Author("Lao Tseu");
			authorDao.saveAll(Sets.newHashSet(georgesOrwell, laoTseu));
			
			Book b1984 = new Book("1984", georgesOrwell);
			Book af = new Book("Animal's farm", georgesOrwell);
			Book ttk = new Book("Tao te king", laoTseu);
			bookDao.saveAll(Sets.newHashSet(b1984, af, ttk));
		    System.out.println("Datas inserted :");
	}

}
