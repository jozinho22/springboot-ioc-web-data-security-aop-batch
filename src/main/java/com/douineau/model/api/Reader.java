package com.douineau.model.api;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.douineau.model.AbstractEntity;

@Entity
public class Reader extends AbstractEntity {

	@OneToMany
	@JoinColumn(name = "reader_id")
	private List<Book> books;
	
	public Reader() {
		super();
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return super.toString() + " - [books=" + books + "]";
	}

}
