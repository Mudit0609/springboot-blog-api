package com.blogwebsite.blog_wesite_apis.Model;

import com.blogwebsite.blog_wesite_apis.Payloads.CommentDTO;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "post_model")

public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer postId;

    @NotEmpty
    @Size(max = 20)
    String postTitle;

    @NotEmpty
    @Column(name = "post_content", length = 10000)
    String postContent;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date created = new Date();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updated = new Date();

    @ManyToOne
    @JoinColumn(name = "category_id") //as in table it was showing double name
    CategoryModel category;

    @ManyToOne
    UserModel user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<CommentModel> comments =new ArrayList<>();


}
