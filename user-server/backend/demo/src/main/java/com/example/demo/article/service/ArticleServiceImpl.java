package com.example.demo.article.service;

import com.example.demo.article.model.Article;
import com.example.demo.article.model.ArticleDto;
import com.example.demo.article.repository.ArticleRepository;
import com.example.demo.common.component.MessengerVo;
import com.example.demo.common.component.PageRequestVo;
import com.example.demo.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl  implements ArticleService{
    private final ArticleRepository articleRepository ;


    @Override
    public MessengerVo save(ArticleDto dto) {
        articleRepository.save(dtoToEntity(dto));
         return MessengerVo.builder().build();

    }

    @Override
    public MessengerVo deleteById(Long id) {
        return MessengerVo.builder()
                .message(
                        Stream.of(id)
                                .filter(i->articleRepository.existsById(i))
                                .peek(i->articleRepository.deleteById(i))
                                .map(i->"SUCCESS")
                                .findAny()
                                .orElseGet(()->"FAILURE")
                )
                .build();

    }

    @Override
    public MessengerVo modify(ArticleDto articleDto) {
        Optional<Article> article = articleRepository.findById(articleDto.getId());


        return MessengerVo.builder().message(articleRepository.findById(articleDto.getId())
                        .stream()
                        .peek(i->i.setContent(articleDto.getContent() == null?article.get().getContent(): articleDto.getContent()))
                        .peek(i->i.setTitle(articleDto.getTitle()==null?article.get().getTitle():articleDto.getTitle()))
                        .map(i->articleRepository.save(i))
                        .map(i->"SUCCESS")
                        .findAny()
                        .orElseGet(()->"FAIL"))
                .build();

    }

    @Override
    public List<ArticleDto> findUsersByWriter(String Writer) {
        return null;
    }

    @Override
    public Optional<ArticleDto> findByBoardId(Long id) {
        return articleRepository.findByBoardId(id);
    }

    @Override
    public List<ArticleDto> findAll( ) {
        List<ArticleDto>articleDtoList = new ArrayList<>();
        List<Article>articles = articleRepository.findAll();

        articles.forEach(i->articleDtoList.add(entityToDto(i)));

        return articleDtoList;



    }


    @Override
    public Optional<ArticleDto> findById(Long id) {
//        return entityToDto(articleRepository.findById(id));
        return articleRepository.findById(id).map(i->entityToDto(i));
    }

    @Override
    public Long count() {
        return articleRepository.count();
    }



    @Override
    public boolean existsById(Long id) {
        return articleRepository.existsById(id);
    }



}
