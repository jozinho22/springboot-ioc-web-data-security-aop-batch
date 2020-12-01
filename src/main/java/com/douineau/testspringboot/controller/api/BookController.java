package com.douineau.testspringboot.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.model.api.Book;

@RestController
@RequestMapping("/api/books")
public class BookController extends GenericApiController<Book> {

}
