package com.douineau.testspringboot.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.model.api.Writer;

@RestController
@RequestMapping("generic-api/writers")
public class WriterController extends GenericApiController<Writer> {

}
