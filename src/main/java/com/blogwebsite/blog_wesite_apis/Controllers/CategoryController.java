package com.blogwebsite.blog_wesite_apis.Controllers;

import com.blogwebsite.blog_wesite_apis.Model.CategoryModel;
import com.blogwebsite.blog_wesite_apis.Payloads.CategoryDTO;
import com.blogwebsite.blog_wesite_apis.Services.CategoryService;
import com.blogwebsite.blog_wesite_apis.Services.CategoryServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoryApi")

public class CategoryController {

    @Autowired
    CategoryServiceImp service;

    @GetMapping("/home")
    public String home(){
        return "CATEGORY API working !";
    }

    @GetMapping("/category/{id}")
    public CategoryDTO getCategoryDTO(@PathVariable int id){

        return service.getCategoryDTO(id);
    }

    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategory(){

        return service.getAllCategory();
    }

    @PostMapping("/category")
    public CategoryDTO createCategory(@Valid @RequestBody CategoryModel categoryModel){

        return service.createCategory(categoryModel);
    }

    @PutMapping("/category/{id}")
    public CategoryDTO updateCategory(@Valid @RequestBody CategoryModel categoryModel, @PathVariable int id){

        return service.updateCategory(categoryModel, id);
    }

    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable int id){

        return service.deleteCategory(id);
    }
}
