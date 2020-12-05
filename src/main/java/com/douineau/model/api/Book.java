package com.douineau.model.api;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.douineau.annotation.JozinhoApi;
import com.douineau.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@JozinhoApi
@Entity
public class Book extends AbstractEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2286844585425672141L;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	@JsonManagedReference
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
