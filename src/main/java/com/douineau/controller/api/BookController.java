package com.douineau.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.model.api.Book;

@RestController
@RequestMapping("/api/books")
public class BookController extends GenericApiController<Book> {

}
