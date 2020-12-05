package com.douineau.model.api;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.douineau.model.AbstractEntity;

@Entity
public class Book extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	public Book() {
		super();
	}

	public Book(String name, Author author) {
		super();
		super.name = name;
		this.author = author;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
}
