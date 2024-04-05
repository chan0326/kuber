package com.example.demo.board.service;

import com.example.demo.board.model.BoardDto;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.common.component.PageRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public BoardDto save(BoardDto boardDto) {
        return entityToDto(Optional.of(boardRepository.save(dtoToEntity(boardDto))));
    }

    @Override
    public void deleteById(Long id) {
        boardRepository.deleteById(id);

    }



    @Override
    public List<BoardDto> findAll(PageRequestVo vo) {
//        return BoardRepository.findAll(vo);
        return null;
    }


    @Override
    public Optional<BoardDto> findById(Long id) {
        return Optional.of(entityToDto(boardRepository.findById(id)));
    }

    @Override
    public Long count() {
        return boardRepository.count();
    }



    @Override
    public boolean existsById(Long id) {
        return boardRepository.existsById(id);
    }
}
