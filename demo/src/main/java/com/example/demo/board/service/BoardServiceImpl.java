package com.example.demo.board.service;

import com.example.demo.board.model.BoardDto;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.common.component.MessengerVo;
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
    public MessengerVo save(BoardDto boardDto) {
        return null;
    }

    @Override
    public MessengerVo deleteById(Long id) {
        return null;
    }

    @Override
    public MessengerVo modify(BoardDto boardDto) {
        return null;
    }

    @Override
    public List<BoardDto> findAll() {
        return null;
    }

    @Override
    public Optional<BoardDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Long count() {
        return boardRepository.count();
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
