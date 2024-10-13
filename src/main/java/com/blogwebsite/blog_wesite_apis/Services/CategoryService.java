package com.blogwebsite.blog_wesite_apis.Services;

import com.blogwebsite.blog_wesite_apis.Model.CategoryModel;
import com.blogwebsite.blog_wesite_apis.Payloads.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO categoryToDTO(CategoryModel categoryModel);

    CategoryModel getCategoryModel(int id);
    CategoryDTO getCategoryDTO(int id);

    List<CategoryDTO> getAllCategory();

    CategoryDTO createCategory(CategoryModel categoryModel);

    CategoryDTO updateCategory(CategoryModel categoryModel, int id);

    String deleteCategory(int id);


}



