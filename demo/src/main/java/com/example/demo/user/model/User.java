package com.example.demo.user.model;

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


    private Long addressId;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String job;
//    private Double height;
//    private Double weight;
}

