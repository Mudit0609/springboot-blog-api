package com.blogwebsite.blog_wesite_apis.Services;

import com.blogwebsite.blog_wesite_apis.Exception.ResourceNotFoundException;
import com.blogwebsite.blog_wesite_apis.Model.CategoryModel;
import com.blogwebsite.blog_wesite_apis.Model.PostModel;
import com.blogwebsite.blog_wesite_apis.Model.UserModel;
import com.blogwebsite.blog_wesite_apis.Payloads.PostDTO;
import com.blogwebsite.blog_wesite_apis.Payloads.UserDTO;
import com.blogwebsite.blog_wesite_apis.Repository.CategoryRepo;
import com.blogwebsite.blog_wesite_apis.Repository.PostRepo;
import com.blogwebsite.blog_wesite_apis.Repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service

public class PostServiceImp implements PostService {

    @Autowired
    PostRepo repo;

    @Autowired
    @Lazy CategoryServiceImp categoryService;
    //As this will call categoryServ and categoryServ will call this, when beans are initialized
    //@Lazy will tell spring container to initialize this ONLY when needed

    @Autowired
    ModelMapper mapper;

    @Autowired
    @Lazy UserServiceImpl userService;


    @Override
    public PostDTO postToDTO(PostModel post) {
        return mapper.map(post, PostDTO.class);
    }

    @Override
    public PostModel getPost(int id) {

        PostModel post =  repo.findById(id).orElseThrow(
                () ->new ResourceNotFoundException("Post","PostId", id)
        );

        post.getComments().size();
        return post;
    }
    @Override
    public PostDTO getPostDTO(int id) {

        PostModel post =  repo.findById(id).orElseThrow(
                () ->new ResourceNotFoundException("Post","PostId", id)
        );

        return postToDTO(post);
    }

    @Override
    public List<PostDTO> getAllPost() {

        List<PostDTO> posts = new ArrayList<>();

        for(PostModel postModel : repo.findAll()){
            posts.add(postToDTO(postModel));
        }

        return posts;
    }

    @Override
    public PostDTO createPost(PostModel postModel,int userId, int categoryId) {

        UserModel user = userService.getUser(userId);
        CategoryModel category = categoryService.getCategoryModel(categoryId);

        postModel.setUser(user);
        postModel.setCategory(category);

        return postToDTO(repo.save(postModel));
    }

    @Override
    public PostDTO updatePost(PostModel postModel, int id) {

        PostModel oldPost = getPost(id);

        postModel.setUser(oldPost.getUser());
        postModel.setCategory(oldPost.getCategory());

        postModel.setUpdated(new Date());
        return postToDTO(repo.save(postModel));
    }

    @Override
    public String deletePost(int id) {

        if(repo.findById(id).isEmpty())
                throw new ResourceNotFoundException("Post", "PostID",id);

        repo.deleteById(id);
        return "Deleted Successfully";
    }

    @Override
    public List<PostDTO> getAllByUser(int userId) {

        UserModel user  = userService.getUser(userId);
        List<PostDTO> postsByUser = new ArrayList<>();

        for(PostModel postModel : user.getPosts()){
            postsByUser.add(postToDTO(postModel));
        }

        return postsByUser;
    }

    @Override
    public List<PostDTO> getAllByCategory(int categoryId) {

        CategoryModel category = categoryService.getCategoryModel(categoryId);
        List<PostDTO> postsByCategories = new ArrayList<>();

        for(PostModel postModel : category.getPosts()){
            postsByCategories.add(postToDTO(postModel));
        }

        return postsByCategories;
    }

    @Override
    public PostDTO updatePostCategory(int id, int categoryId) {

        CategoryModel category = categoryService.getCategoryModel(categoryId);
        PostModel newPost = getPost(id);

        newPost.setCategory(category);

        return postToDTO(repo.save(newPost));
    }

    @Override
    public void setPostCategoryNull(PostModel post) {

        post.setCategory(null);
        repo.save(post);
    }


}
