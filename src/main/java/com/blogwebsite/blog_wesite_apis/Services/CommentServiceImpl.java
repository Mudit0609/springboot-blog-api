package com.blogwebsite.blog_wesite_apis.Services;

import com.blogwebsite.blog_wesite_apis.Model.CommentModel;
import com.blogwebsite.blog_wesite_apis.Model.PostModel;
import com.blogwebsite.blog_wesite_apis.Model.UserModel;
import com.blogwebsite.blog_wesite_apis.Payloads.CommentDTO;
import com.blogwebsite.blog_wesite_apis.Repository.CommentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo repo;

    @Autowired
    PostServiceImp postService;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ModelMapper mapper;


    @Override
    public CommentDTO createComment(CommentModel commentModel,  int userId, int postId) {

        PostModel post = postService.getPost(postId);
        UserModel user = userService.getUser(userId);

        commentModel.setPost(post);
        commentModel.setUser(user);

        repo.save(commentModel);

        CommentDTO comment = commentToDTO(commentModel);
        return comment;

    }

    @Override
    public String deleteComment(int id) {
        return "";
    }

    @Override
    public CommentDTO commentToDTO(CommentModel comment) {
        return mapper.map(comment, CommentDTO.class);
    }

}
