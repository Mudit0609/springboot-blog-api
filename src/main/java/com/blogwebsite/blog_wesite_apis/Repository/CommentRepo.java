package com.blogwebsite.blog_wesite_apis.Repository;

import com.blogwebsite.blog_wesite_apis.Model.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<CommentModel, Integer> {
}
