package com.blogwebsite.blog_wesite_apis.Model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="user_model")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotEmpty
    String name;

    @Email(message = "Not a valid email") //Does not work on Empty String
    @NotEmpty
    String email;

    @NotEmpty
    @Column(length = 10000)
    String about;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<PostModel> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<CommentModel> comments = new ArrayList<>();
}
