package com.douineau.testspringboot.controller.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.model.security.Permission;

@RestController
@RequestMapping("/admin/permissions")
public class PermissionController extends GenericAdminController<Permission> {

}
