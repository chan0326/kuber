package com.example.demo.article.service;

import com.example.demo.article.model.Article;
import com.example.demo.article.model.ArticleDto;
import com.example.demo.common.command.CommandService;
import com.example.demo.common.query.QueryService;

import java.util.*;

public interface ArticleService extends CommandService<ArticleDto>, QueryService<ArticleDto> {

    default Article dtoToEntity(ArticleDto dto){
        return Article.builder().build();
    }

    default ArticleDto entityToDto(Optional<Article> optional){
        return ArticleDto.builder().build();
    }


}
