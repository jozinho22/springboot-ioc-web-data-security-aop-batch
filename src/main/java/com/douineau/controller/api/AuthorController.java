package com.douineau.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.model.api.Author;

@RestController
@RequestMapping("/api/authors")
public class AuthorController extends GenericApiController<Author> {

}
