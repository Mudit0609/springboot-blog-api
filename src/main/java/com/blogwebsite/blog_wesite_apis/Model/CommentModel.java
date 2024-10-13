package com.blogwebsite.blog_wesite_apis.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CommentModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;

    @Column(length = 1000)
    String commentContent;

    @ManyToOne
    @JsonIgnoreProperties("comments")
    @JoinColumn(name = "post_id")
    PostModel post;

    @ManyToOne
    UserModel user;
}
