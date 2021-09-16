package com.wildcodeschool.blog.payload.request;

import com.wildcodeschool.blog.entity.Comment;
import com.wildcodeschool.blog.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class CreatePostRequest {

    @NotBlank
    @Size(min = 5, max = 40)
    private String title;

    private String picture;

    @NotBlank
    @Size(min = 6, max = 100)
    private String message;

    private Date post_date;

    private List<Comment> comments;

    private User user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPost_date() {
        return post_date;
    }

    public void setPost_date(Date post_date) {
        this.post_date = post_date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
