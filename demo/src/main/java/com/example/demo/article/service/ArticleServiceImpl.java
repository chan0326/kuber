package com.example.demo.article.service;

import com.example.demo.article.model.ArticleDto;
import com.example.demo.article.repository.ArticleRepository;
import com.example.demo.common.component.PageRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl  implements ArticleService{
    private final ArticleRepository articleRepository ;


    @Override
    public ArticleDto save(ArticleDto dto) {
        return entityToDto(Optional.of(articleRepository.save(dtoToEntity(dto))));
    }

    @Override
    public void deleteById(Long id) {
        articleRepository.deleteById(id);

    }



    @Override
    public List<ArticleDto> findAll(PageRequestVo vo) {
//        return articleRepository.findAll(vo);
        return null;
    }


    @Override
    public Optional<ArticleDto> findById(Long id) {
        return Optional.of(entityToDto(articleRepository.findById(id)));
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
