package com.blogwebsite.blog_wesite_apis.Payloads;

import com.blogwebsite.blog_wesite_apis.Model.CategoryModel;
import com.blogwebsite.blog_wesite_apis.Model.UserModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostDTO {

    Integer postId;

    String postTitle;

    String postContent;

    UserDTO user;

    CategoryDTO category;

    List<CommentDTO> comments = new ArrayList<>();



}
