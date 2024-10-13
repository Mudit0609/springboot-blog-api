package com.blogwebsite.blog_wesite_apis.Repository;

import com.blogwebsite.blog_wesite_apis.Model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

//no need for @Repository as jpa repo already takes care of it
public interface PostRepo extends JpaRepository<PostModel, Integer> {
}
