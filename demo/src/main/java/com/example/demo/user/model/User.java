package com.example.demo.user.model;

import com.example.demo.article.model.Article;
import com.example.demo.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "users")
@ToString(exclude = "id")
public class User extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private Long addressId;
    @Setter
    private String username;
    @Setter
    private String password;
    @Setter
    private String name;
    @Setter
    private String phone;
    @Setter
    private String job;
    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Article> articles;
//    private Double height;
//    private Double weight;
}

