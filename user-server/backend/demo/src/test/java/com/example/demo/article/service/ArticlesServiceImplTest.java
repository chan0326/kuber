package com.example.demo.article.service;

import com.example.demo.article.model.Article;
import com.example.demo.article.model.ArticleDto;
import com.example.demo.article.repository.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class ArticlesServiceImplTest {
//
//    private ArticleService service;
//    private static Article testEntity;
//    @Mock
//    private ArticleRepository repository;
//    @BeforeEach
//    void setup() {
//        this.service = new ArticleServiceImpl(repository);
//    }
//    @BeforeEach
//    void init(){
//    }
//
//    @Test
//    public void 게시글_제목_검색()throws Exception{
//        //given
//        repository.save(testEntity);
//        //when
//        Article article = repository.findById(1L).get();
//        //then
//        assertThat(article.getTitle()).isEqualTo("테스트제목");
//
//
//    }
//    @Test
//    public  void 게시글_전체_검색()throws Exception{
//        List<Article> articles =getlist();
//        BDDMockito.given(repository.findAll()).willReturn(articles);
//        List<ArticleDto> list =service.findAll();
//        assertThat(list.size()).isEqualTo(3);
//    }
//
//    private List<Article> getlist(){
//        return Arrays.asList(
//                Article.builder().id(1L).title("가짜데이터1-제목").content("가짜데이터의내용1 -이렇게 저렇게").build(),
//                Article.builder().id(2L).title("가짜데이터2=123").content("가짜데이터의내용2 -가나다라 마바사").build(),
//                Article.builder().id(3L).title("가짜데이터3- 가지무침").content("가짜데이터의내용3 - 내용기입").build()
//        );
//    }



}
