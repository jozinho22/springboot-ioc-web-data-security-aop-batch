package com.douineau.model.api;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.douineau.model.AbstractEntity;

@Entity
public class Author extends AbstractEntity {
	
	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Book> books;
	
	public Author() {
		super();
	}

	public Author(String name) {
		super();
		super.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
