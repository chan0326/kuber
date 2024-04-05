package com.example.demo.board.model;

import com.example.demo.article.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Log4j2
public class BoardDto {
    private Long id;
    private String boardName;
    private String boardType;

    @Builder.Default
    private List<Article> articlesId =new ArrayList<>();


}
