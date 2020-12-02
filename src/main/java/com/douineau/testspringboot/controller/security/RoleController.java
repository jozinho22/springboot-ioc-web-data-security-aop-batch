package com.douineau.testspringboot.controller.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.controller.GenericController;
import com.douineau.testspringboot.model.security.Role;

@RestController
@RequestMapping("/admin/roles")
public class RoleController extends GenericController<Role> {

}