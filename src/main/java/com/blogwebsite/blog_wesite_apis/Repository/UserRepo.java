package com.blogwebsite.blog_wesite_apis.Repository;

import com.blogwebsite.blog_wesite_apis.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Integer> {
}
