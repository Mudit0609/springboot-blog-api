package com.blogwebsite.blog_wesite_apis.Controllers;


import com.blogwebsite.blog_wesite_apis.Model.CommentModel;
import com.blogwebsite.blog_wesite_apis.Payloads.CommentDTO;
import com.blogwebsite.blog_wesite_apis.Services.CommentService;
import com.blogwebsite.blog_wesite_apis.Services.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commentApi")

public class CommentController {
    @Autowired
    CommentServiceImpl service;

    @GetMapping("/home")
    public String home(){
        return "Comment API working!!!";
    }

    @PostMapping("/comment/user/{userId}/post/{postId}")
    public CommentDTO createComment(@RequestBody CommentModel comment,
                                    @PathVariable int userId,
                                    @PathVariable int postId)
    {
        return service.createComment(comment, userId, postId);
    }

}
