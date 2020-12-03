package com.douineau.controller.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.controller.GenericController;
import com.douineau.model.security.Role;

@RestController
@RequestMapping("/admin/roles")
public class RoleController extends GenericController<Role> {

}