package com.blogwebsite.blog_wesite_apis.Payloads;

import com.blogwebsite.blog_wesite_apis.Model.PostModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class UserDTO {
    Integer id;

    String name;

    String about;

    String email;

}
