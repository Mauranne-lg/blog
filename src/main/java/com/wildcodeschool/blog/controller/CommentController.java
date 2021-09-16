package com.wildcodeschool.blog.controller;

import com.wildcodeschool.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    public CommentRepository commentRepository;
}
