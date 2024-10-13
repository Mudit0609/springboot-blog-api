package com.blogwebsite.blog_wesite_apis.Services;

import com.blogwebsite.blog_wesite_apis.Exception.ResourceNotFoundException;
import com.blogwebsite.blog_wesite_apis.Model.CategoryModel;
import com.blogwebsite.blog_wesite_apis.Model.PostModel;
import com.blogwebsite.blog_wesite_apis.Payloads.CategoryDTO;
import com.blogwebsite.blog_wesite_apis.Repository.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CategoryServiceImp implements CategoryService {

    @Autowired
    CategoryRepo repo;

    @Autowired
    ModelMapper mapper;

    @Autowired
    @Lazy PostService postService;
    //As this will call postServ and postServ will call this, when beans are initialized
    //@Lazy will tell spring container to initialize this ONLY when needed

    @Override
    public CategoryModel getCategoryModel(int id) {

        CategoryModel categoryModel = repo.findById(id).orElseThrow(
                () ->new ResourceNotFoundException("Category","CategoryId",id)
        );

        return categoryModel;
    }
    @Override
    public CategoryDTO getCategoryDTO(int id) {

        CategoryModel categoryModel = repo.findById(id).orElseThrow(
                () ->new ResourceNotFoundException("Category","CategoryId",id)
        );

        CategoryDTO category = categoryToDTO(categoryModel);

        return category;
    }

    @Override
    public CategoryDTO categoryToDTO(CategoryModel categoryModel) {
        return mapper.map(categoryModel, CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getAllCategory() {

        List<CategoryDTO> categories =  new ArrayList<>();

        for(CategoryModel categoryModel : repo.findAll()){
            categories.add(categoryToDTO(categoryModel));
        }

        return categories;
    }

    @Override
    public CategoryDTO createCategory(CategoryModel categoryModel) {


        return categoryToDTO(repo.save(categoryModel));
    }

    @Override
    public CategoryDTO updateCategory(CategoryModel categoryModel, int id) {

        if(repo.findById(id).isEmpty())
            throw new ResourceNotFoundException("Category","CategoryId",id);

        return categoryToDTO(repo.save(categoryModel));
    }

    @Override
    public String deleteCategory(int id) {

        CategoryModel category = repo.findById(id).orElseThrow(
                () ->new ResourceNotFoundException("Category","CategoryId",id)
        );

        List<PostModel> posts = category.getPosts();

        for(PostModel post : posts){
            postService.setPostCategoryNull(post);
        }

        repo.deleteById(id);
        return "Deleted Successfully";
    }


}
