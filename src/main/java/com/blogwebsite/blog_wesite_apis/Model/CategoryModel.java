package com.blogwebsite.blog_wesite_apis.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "category_model")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer categoryId;

    @NotEmpty
    @Size(max = 30)
    String categoryTitle;

    @Column(length = 10000)
    String categoryDescription;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    List<PostModel> posts = new ArrayList<>();
}
