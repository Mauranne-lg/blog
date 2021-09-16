package com.wildcodeschool.blog.controller;

import com.wildcodeschool.blog.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

}
