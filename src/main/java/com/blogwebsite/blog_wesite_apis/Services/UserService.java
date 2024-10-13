package com.blogwebsite.blog_wesite_apis.Services;

import com.blogwebsite.blog_wesite_apis.Model.UserModel;
import com.blogwebsite.blog_wesite_apis.Payloads.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO userToDTO(UserModel userModel);

    List<UserDTO> getAll();

    UserModel getUser(int id);
    UserDTO getUserDTO(int id);

    UserDTO createUser(UserModel user);

    UserDTO updateUser(UserModel user);

    String deleteUser(int id);

}
