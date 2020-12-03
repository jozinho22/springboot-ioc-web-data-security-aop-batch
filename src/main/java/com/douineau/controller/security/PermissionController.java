package com.douineau.controller.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.controller.GenericController;
import com.douineau.model.security.Permission;

@RestController
@RequestMapping("/admin/permissions")
public class PermissionController extends GenericController<Permission> {

}
