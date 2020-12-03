package com.douineau.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.model.api.Writer;

@RestController
@RequestMapping("/api/writers")
public class WriterController extends GenericApiController<Writer> {

}
