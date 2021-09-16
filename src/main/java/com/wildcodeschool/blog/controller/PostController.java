package com.wildcodeschool.blog.controller;

import com.wildcodeschool.blog.payload.request.CreatePostRequest;
import com.wildcodeschool.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("posts")
public class PostController {

    @Autowired
    PostService postService;

    // Création d'un nouveau post
    @PostMapping("/create")
    public ResponseEntity createPost(@Valid @RequestBody CreatePostRequest createPostRequest) {
        if (postService.register(createPostRequest)) {
            return ResponseEntity.status(HttpStatus.OK).body("Post bien enregistré");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Le post n'a pas été enregistré");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePost(@PathVariable("id") Long id) {
        if (postService.register(createPostRequest)) {
            return ResponseEntity.status(HttpStatus.OK).body("Post bien enregistré");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Le post n'a pas été enregistré");
    }
}
