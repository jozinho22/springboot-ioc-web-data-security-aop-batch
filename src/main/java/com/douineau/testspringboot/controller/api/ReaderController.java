package com.douineau.testspringboot.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.model.api.Reader;

@RestController
@RequestMapping("/api/readers")
public class ReaderController extends GenericApiController<Reader> {

}
