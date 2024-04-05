package com.example.demo.article.model;


import com.example.demo.board.model.Board;
import com.example.demo.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="articles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString(exclude = "id")
public class Article extends BaseEntity {
    @Id
    @Column(name ="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    private Long writer;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = true)
    private Board board;
}