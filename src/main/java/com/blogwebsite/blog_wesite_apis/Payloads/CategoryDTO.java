package com.blogwebsite.blog_wesite_apis.Payloads;

import com.blogwebsite.blog_wesite_apis.Model.PostModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class CategoryDTO {

    Integer categoryId;

    String categoryTitle;

    String  categoryDescription;


}
