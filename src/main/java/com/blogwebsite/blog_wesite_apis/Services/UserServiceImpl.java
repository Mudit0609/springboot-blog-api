package com.blogwebsite.blog_wesite_apis.Services;

import com.blogwebsite.blog_wesite_apis.Exception.ResourceNotFoundException;
import com.blogwebsite.blog_wesite_apis.Model.PostModel;
import com.blogwebsite.blog_wesite_apis.Model.UserModel;
import com.blogwebsite.blog_wesite_apis.Payloads.UserDTO;
import com.blogwebsite.blog_wesite_apis.Repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public UserDTO userToDTO(UserModel userModel) {
        return mapper.map(userModel, UserDTO.class);
    }

    @Override
    public UserModel getUser(int id) {
        UserModel userModel = repo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("USER","USER ID", id)
        );

        return userModel;
    }


    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> users = new ArrayList<>();

        for(UserModel userModel : repo.findAll() ){
            users.add(userToDTO(userModel));
        }

        return users;
    }


    @Override
    public UserDTO getUserDTO(int id) {

       UserModel userModel = getUser(id);

       return userToDTO(userModel);

    }

    @Override
    public UserDTO createUser(UserModel user) {

        return userToDTO(repo.save(user));
    }

    @Override
    public UserDTO updateUser(UserModel user) {

        if(repo.findById(user.getId()).isEmpty())
            throw new ResourceNotFoundException("USER ","USER ID",user.getId());

        return userToDTO(repo.save(user));
    }

    @Override
    public String deleteUser(int id) {

        if(repo.findById(id).isEmpty())
                throw new ResourceNotFoundException("USER","USER ID", id);

        repo.deleteById(id);
        return "Deleted Successfully";
    }


}
