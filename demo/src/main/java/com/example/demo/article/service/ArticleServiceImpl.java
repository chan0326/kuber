package com.example.demo.article.service;

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

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl  implements ArticleService{
    private final ArticleRepository articleRepository ;


    @Override
    public MessengerVo save(ArticleDto dto) {
         entityToDto(articleRepository.save(dtoToEntity(dto)));
         return new MessengerVo();
    }

    @Override
    public MessengerVo deleteById(Long id) {
        articleRepository.deleteById(id);
        return new MessengerVo();

    }

    @Override
    public MessengerVo modify(ArticleDto articleDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePassword'");
    }

    @Override
    public List<ArticleDto> findUsersByWriter(String Writer) {
        return null;
    }

    @Override
    public List<ArticleDto> findAll( ) {
        articleRepository.findAll();
        return new ArrayList<>();
    }


    @Override
    public Optional<ArticleDto> findById(Long id) {
//        return entityToDto(articleRepository.findById(id));
    return null;
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
