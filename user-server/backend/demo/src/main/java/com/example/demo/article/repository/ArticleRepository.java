package com.example.demo.article.repository;

import com.example.demo.article.model.Article;
import com.example.demo.article.model.ArticleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {


    Optional<ArticleDto> findByBoardId(long id);
}