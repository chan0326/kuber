package com.example.demo.article.service;

import com.example.demo.article.model.Article;
import com.example.demo.article.model.ArticleDto;
import com.example.demo.common.command.CommandService;
import com.example.demo.common.component.MessengerVo;
import com.example.demo.common.query.QueryService;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDto;

import java.util.*;

public interface ArticleService extends CommandService<ArticleDto>, QueryService<ArticleDto> {
    MessengerVo modify(ArticleDto articleDto);
    List<ArticleDto> findUsersByWriter(String Writer);
    default Article dtoToEntity(ArticleDto dto){
        return Article.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }

    default ArticleDto entityToDto(Article article){
        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .build();
    }


    Optional<ArticleDto> findByBoardId(Long id);
}
