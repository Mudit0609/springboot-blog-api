package com.blogwebsite.blog_wesite_apis.Services;

import com.blogwebsite.blog_wesite_apis.Model.CommentModel;
import com.blogwebsite.blog_wesite_apis.Model.PostModel;
import com.blogwebsite.blog_wesite_apis.Payloads.CommentDTO;

public interface CommentService {

    CommentDTO createComment(CommentModel comment, int postId, int userId);

    String deleteComment(int id);

    CommentDTO commentToDTO(CommentModel comment);



}


