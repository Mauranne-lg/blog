package com.wildcodeschool.blog.service;

import com.wildcodeschool.blog.entity.Post;
import com.wildcodeschool.blog.payload.request.CreatePostRequest;
import com.wildcodeschool.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public boolean register(CreatePostRequest createPostRequest) {
        /* si tout est ok, j'enregistre le post */
        Post post = new Post();
        post.setTitle(createPostRequest.getTitle());
        post.setMessage(createPostRequest.getMessage());
        post.setPicture(createPostRequest.getPicture());
        post.setPost_date(new Date());
        // TODO Aller chercher l'user connecté
        postRepository.save(post);
        return true;
    }

}
