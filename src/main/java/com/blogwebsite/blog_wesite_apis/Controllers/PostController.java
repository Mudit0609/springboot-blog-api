package com.blogwebsite.blog_wesite_apis.Controllers;

import com.blogwebsite.blog_wesite_apis.Model.PostModel;
import com.blogwebsite.blog_wesite_apis.Payloads.PostDTO;
import com.blogwebsite.blog_wesite_apis.Services.PostServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postApi")

public class PostController {

    @Autowired
    PostServiceImp service;

    @GetMapping("/home")
    public String home(){
        return "POST API working !";
    }

    @GetMapping("/post/{id}")
    public PostDTO getPostDTO(@PathVariable int id){

        return service.getPostDTO(id);
    }

    @GetMapping("/posts")
    public List<PostDTO> getAllPost(){

        return service.getAllPost();
    }

    @PostMapping("post/user/{userId}/category/{categoryId}")
    public PostDTO createPost(@Valid @RequestBody PostModel postModel,
                                @PathVariable int userId,
                                @PathVariable int categoryId){

        return service.createPost(postModel, userId, categoryId);
    }

    @PutMapping("/post/{id}")
    public PostDTO updatePost(@Valid @RequestBody PostModel postModel, @PathVariable int id){

        return service.updatePost(postModel, id);
    }

    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable int id){

        return service.deletePost(id);
    }

    @GetMapping("posts/user/{userId}")
    public List<PostDTO> getAllByUser(@PathVariable int userId) {

        return service.getAllByUser(userId);
    }

    @GetMapping("posts/category/{categoryId}")
    public List<PostDTO> getAllByCategory(@PathVariable int categoryId) {

        return service.getAllByCategory(categoryId);
    }

    @PutMapping("/post/{id}/category/{categoryId}")
    public PostDTO updateCategory(@PathVariable int id, @PathVariable int categoryId){

        return service.updatePostCategory(id, categoryId);
    }
}
