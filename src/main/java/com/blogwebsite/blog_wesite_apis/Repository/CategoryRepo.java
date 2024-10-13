package com.blogwebsite.blog_wesite_apis.Repository;

import com.blogwebsite.blog_wesite_apis.Model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//no need for @Repository as jpa repo already takes care of it
public interface CategoryRepo extends JpaRepository<CategoryModel, Integer> {
}
