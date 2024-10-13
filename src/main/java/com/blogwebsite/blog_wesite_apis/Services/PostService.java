package com.blogwebsite.blog_wesite_apis.Services;

import com.blogwebsite.blog_wesite_apis.Model.PostModel;
import com.blogwebsite.blog_wesite_apis.Payloads.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO postToDTO(PostModel post);

    PostModel getPost(int id);
    PostDTO getPostDTO(int id);

    List<PostDTO> getAllPost();

    PostDTO createPost(PostModel postModel, int userId, int categoryId);

    PostDTO updatePost(PostModel postModel, int id);

    String deletePost(int id);

    List<PostDTO> getAllByUser(int userId);

    List<PostDTO> getAllByCategory(int categoryId);

    PostDTO updatePostCategory(int id, int categoryId);

    void setPostCategoryNull(PostModel post);
}

